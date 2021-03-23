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
    int positionX;
    int positionY;
    int playerX = GROSSEUR_UNITE;
    int playerY = GROSSEUR_UNITE;
    char direction = 'R';
    int[][] mur = new int[LARGEUR_ECRAN][HAUTEUR_ECRAN];
    boolean mursL = false;
    boolean mursR = false;
    boolean mursU = false;
    boolean mursD = false;
    public static enum STATE{
        GAME,
        MENU
    }
    public static STATE state = STATE.GAME;
    MainMenu menu;

    static final int DELAY = 50;
    Random random;
    static boolean gameOn = false;
    Timer timer;

    public Rectangle niveau1 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 100, 150, 50 );
    public Rectangle niveau2 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 200, 150, 50 );
    public Rectangle niveau3 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 300, 150, 50 );

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);


    boolean ouvert = false;

    JLabel label = new JLabel("PAUSE");



    GamePanel() {
        random = new Random();
        menu = new MainMenu();
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
        if(state == STATE.GAME) {
            nouvelleProie();
            timer = new Timer(DELAY, this);
            timer.start();
        }

    }

    public void pause() {
        label.setFont(new Font("Ink Free", Font.BOLD, 40));
        label.setVisible(true);
        GamePanel.gameOn = true;
        timer.stop();
    }

    public void resume() {
        label.setVisible(false);
        GamePanel.gameOn = false;
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

                g.setColor(Color.BLUE);
                g.fillOval(positionX, positionY, GROSSEUR_UNITE, GROSSEUR_UNITE);

                for(int i = 0; i < GROSSEUR_UNITE * 8; i++){
                    mur[GROSSEUR_UNITE * 3][i] = 1;
                    mur[GROSSEUR_UNITE * 4][i] = 1;
                    g.setColor(Color.GRAY);
                    g.fillRect(GROSSEUR_UNITE * 3, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
                    g.fillRect(GROSSEUR_UNITE * 4, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
                }
                for(int i = GROSSEUR_UNITE * 6; i < LARGEUR_ECRAN; i++){
                    mur[i][GROSSEUR_UNITE * 14] = 1;
                    mur[i][GROSSEUR_UNITE * 15] = 1;
                    g.setColor(Color.GRAY);
                    g.fillRect(i, GROSSEUR_UNITE * 14, GROSSEUR_UNITE, GROSSEUR_UNITE);
                    g.fillRect(i, GROSSEUR_UNITE * 15, GROSSEUR_UNITE, GROSSEUR_UNITE);
                }


        }
        if(state == STATE.MENU) {
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            g.drawString("Une histoire de reflexion", (GamePanel.LARGEUR_ECRAN - metrics.stringWidth("Une histoire de reflexion")) / 2, g.getFont().getSize());
        }

    }

    public void nouvelleProie(){
        positionX = random.nextInt((int)(LARGEUR_ECRAN/GROSSEUR_UNITE)) * GROSSEUR_UNITE;
        positionY = random.nextInt((int)(HAUTEUR_ECRAN/GROSSEUR_UNITE)) * GROSSEUR_UNITE;
    }

    public void verifierCollision() {

        for(int z = 0; z <= GROSSEUR_UNITE * 9; z++) {
            if (playerX == GROSSEUR_UNITE * 5 && playerY == z - 1) {
                mursL = true;
            } else if (playerX == GROSSEUR_UNITE * 2 && playerY == z - 1) {
                mursR = true;
            } else if ((playerX == GROSSEUR_UNITE * 3 || playerX == GROSSEUR_UNITE * 4) && playerY == z + 1) {
                mursU = true;
            }
        }
        for(int i = GROSSEUR_UNITE * 5; i < LARGEUR_ECRAN; i++) {
            if (playerY == GROSSEUR_UNITE * 13 && playerX == i - 1) {
                mursD = true;
            } else if (playerY == GROSSEUR_UNITE * 16 && playerX == i - 1) {
                mursU = true;
            } else if ((playerY == GROSSEUR_UNITE * 14 || playerY == GROSSEUR_UNITE * 15 )&& playerX == i - 1) {
                mursR = true;
            }
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
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
          /*  switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT :
                    direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT :
                    direction = 'R';
                    break;
                case KeyEvent.VK_UP :
                    direction = 'U';
                    break;
                case KeyEvent.VK_DOWN :
                    direction = 'D';
                    break;
                case KeyEvent.VK_ENTER:
                    if(state == STATE.GAME){
                        state = STATE.MENU;
                    }
                    else if(state == STATE.MENU)
                        state = STATE.GAME;
            } */

            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if (playerX > 0 && timer.isRunning()) {
                        if(!mursL) {
                            playerX = playerX - GROSSEUR_UNITE;
                        }
                        else
                            mursL = false;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (playerX <= BORDER_NUMBER_X && timer.isRunning()) {
                        if(!mursR)
                            playerX = playerX + GROSSEUR_UNITE;
                        else
                            mursR = false;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (playerY > 0 && timer.isRunning()) {
                        if(!mursU)
                            playerY = playerY - GROSSEUR_UNITE;
                        else
                            mursU = false;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (playerY <= BORDER_NUMBER_Y && timer.isRunning()) {
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
                case KeyEvent.VK_ENTER :
                    if(state == STATE.MENU)
                        state = STATE.GAME;
                    else if (state == STATE.GAME)
                        state = STATE.MENU;
                    break;
            }
        }
    }
}