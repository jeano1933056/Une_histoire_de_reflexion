import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static final int LARGEUR_ECRAN = 600;
    static final int HAUTEUR_ECRAN = 600;
    static final int GROSSEUR_UNITE = 30;
    static final int NOMBRE_BLOCS_X = (LARGEUR_ECRAN/GROSSEUR_UNITE);
    static final int BORDER_NUMBER_X = ((NOMBRE_BLOCS_X - 1) * GROSSEUR_UNITE) - 1;
    static final int NOMBRE_BLOCS_Y = (HAUTEUR_ECRAN/GROSSEUR_UNITE);
    static final int BORDER_NUMBER_Y = ((NOMBRE_BLOCS_Y - 1) * GROSSEUR_UNITE) - 1;
    static final int GAME_UNITS = (LARGEUR_ECRAN * HAUTEUR_ECRAN)/GROSSEUR_UNITE;
    int x = GAME_UNITS;
    int y = GAME_UNITS;
    int proies;
    public static int positionX;
    public static int positionY;
    public static int playerX = GROSSEUR_UNITE;
    public static int playerY = GROSSEUR_UNITE;
    public static int porteX = LARGEUR_ECRAN - GROSSEUR_UNITE;
    public static int porteY = LARGEUR_ECRAN - GROSSEUR_UNITE;
    public static char direction = 'R';
    int[][] mur = new int[LARGEUR_ECRAN][HAUTEUR_ECRAN];
    public static boolean mursL = false;
    public static boolean mursR = false;
    public static boolean mursU = false;
    public static boolean mursD = false;
    public static int blocX = 16 * GROSSEUR_UNITE;
    public static int blocY = 12 * GROSSEUR_UNITE;
    public static enum STATE{
        GAME,
        MENU
    }
    public static enum NIVEAU{
        M,
        N1,
        N2,
        N3,
        N4,
        N5,
        N6,
        N7
    }
    public static STATE state = STATE.MENU;
    public static NIVEAU niveau = NIVEAU.M;
    Niveau1 niveau1;
    Niveau2 niveau2;

    MainMenu menu;

    static final int DELAY = 50;
    Random random;
    static boolean gameOn = false;
    public static Timer timer;


    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);


    boolean ouvert = false;

    JLabel label = new JLabel("PAUSE");



    GamePanel() {
        random = new Random();
        menu = new MainMenu();
        niveau1 = new Niveau1();
        niveau2 = new Niveau2();
        this.setPreferredSize(new Dimension(LARGEUR_ECRAN, HAUTEUR_ECRAN));
        this.setBackground(new Color(244, 202, 224));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.setCursor(cursor);
        this.add(label);
        label.setVisible(false);
        start();
    }

    public void start() {
        ouvert = true;
        nouvelleProie();
        timer = new Timer(DELAY, this);
    }

    public void menu(){

        state = STATE.MENU;
        niveau = NIVEAU.M;
        //timer.stop();
    }

    public void niveau1(){
        state = STATE.GAME;
        niveau = NIVEAU.N1;
        timer.start();
    }

    public void niveau2(){
        state = STATE.GAME;
        niveau = NIVEAU.N2;
        timer.start();
    }

    public void niveau3(){
        state = STATE.GAME;
        niveau = NIVEAU.N3;
        timer.start();
    }

    public static void gameOver(){
        playerX = GROSSEUR_UNITE;
        playerY = GROSSEUR_UNITE;
    }

    public void finNiveau(){
        if (playerX == porteX && playerY == porteY) {
            menu();
            playerX = GROSSEUR_UNITE;
            playerY = GROSSEUR_UNITE;
        }

    }

    public void pause() {
        label.setFont(new Font("Ink Free", Font.BOLD, 40));
        label.setVisible(true);
        gameOn = true;
        timer.stop();
    }

    public void resume() {
        label.setVisible(false);
        gameOn = false;
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessiner(g);
    }

    public void dessiner(Graphics g) {

        if(state == STATE.GAME) {
            if (ouvert) {
                g.setColor(new Color(100, 166, 189));
                g.fillRect(playerX, playerY, GROSSEUR_UNITE, GROSSEUR_UNITE);
            }
            for (int i = 0; i < (HAUTEUR_ECRAN / GROSSEUR_UNITE); i++) {
                g.setColor(new Color(173, 167, 201));
                g.drawLine(i * GROSSEUR_UNITE, 0, i * GROSSEUR_UNITE, HAUTEUR_ECRAN);
                g.drawLine(0, i * GROSSEUR_UNITE, LARGEUR_ECRAN, i * GROSSEUR_UNITE);
            }

            if (niveau == NIVEAU.N1) {
                niveau1.rendu(g);
            }

            if(niveau == NIVEAU.N2){
                niveau2.rendu(g);
            }

        }
        else if (state == STATE.MENU) {
           menu.rendu(g);
        }

    }

    public void nouvelleProie(){
        positionX = random.nextInt((int)(LARGEUR_ECRAN/GROSSEUR_UNITE)) * GROSSEUR_UNITE;
        positionY = random.nextInt((int)(HAUTEUR_ECRAN/GROSSEUR_UNITE)) * GROSSEUR_UNITE;
    }

    public void verifierCollision() {

        if(niveau == NIVEAU.N1) {
            niveau1.collision();
        }
    }

    public void mouvement(){

        switch (direction){
            case 'U' :
                playerY = playerY - GROSSEUR_UNITE;
                break;
            case 'D' :
                if (playerX <= BORDER_NUMBER_X && timer.isRunning()) {
                    playerX = playerX + GROSSEUR_UNITE;
                }
                break;
            case 'L' :
                playerX = playerX - GROSSEUR_UNITE;
                break;
            case 'R' :
                playerX = playerX + GROSSEUR_UNITE;
                break;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ouvert) {
            verifierCollision();
            finNiveau();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if (playerX > 0 && timer.isRunning() && state == STATE.GAME) {
                        if(!mursL) {
                            playerX = playerX - GROSSEUR_UNITE;
                        }
                        else
                            mursL = false;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (playerX <= BORDER_NUMBER_X && timer.isRunning() && state == STATE.GAME) {
                        if(!mursR)
                            playerX = playerX + GROSSEUR_UNITE;
                        else
                            mursR = false;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (playerY > 0 && timer.isRunning() && state == STATE.GAME) {
                        if(!mursU)
                            playerY = playerY - GROSSEUR_UNITE;
                        else
                            mursU = false;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (playerY <= BORDER_NUMBER_Y && timer.isRunning() && state == STATE.GAME) {
                        if(!mursD)
                            playerY = playerY + GROSSEUR_UNITE;
                        else
                            mursD = false;
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (GamePanel.gameOn) {
                        resume();
                    }
                    else {
                        pause();
                    }
                    break;
                case KeyEvent.VK_1 :
                    if(state == STATE.MENU) {
                        niveau1();
                    }
                case KeyEvent.VK_2 :
                    if(state == STATE.MENU) {
                        niveau2();
                    }
                    break;
            }
        }
    }
}