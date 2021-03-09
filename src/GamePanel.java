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
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int proies;
    int positionX = 7;
    int positionY = 13;
    int playerX = positionX * GROSSEUR_UNITE;
    int playerY = positionY * GROSSEUR_UNITE;

    static final int DELAY = 75;
    Random random;
    static boolean gameOn = false;
    Timer timer;

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);


    char direction;
    boolean ouvert = false;

    JLabel label = new JLabel("PAUSE");



    GamePanel() {
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
        //nouvelleProie();
        ouvert = true;
        timer = new Timer(DELAY, this);
        timer.start();
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
        if (ouvert) {
            for (int i = 0; i < (HAUTEUR_ECRAN/GROSSEUR_UNITE); i++) {
                g.setColor(new Color(173, 167, 201));
                g.drawLine(i * GROSSEUR_UNITE, 0, i * GROSSEUR_UNITE, HAUTEUR_ECRAN);
                g.drawLine(0, i * GROSSEUR_UNITE, LARGEUR_ECRAN, i * GROSSEUR_UNITE);
            }

            g.setColor(new Color(100, 166, 189));
            g.fillRect(playerX, playerY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        } else {
            //gameover(g)
        }

    }

    public void nouvelleProie(){
        //positionX = random.nextInt((int)(LARGEUR_ECRAN/GROSSEUR_UNITE)) * GROSSEUR_UNITE;
        //positionY = random.nextInt((int)(HAUTEUR_ECRAN/GROSSEUR_UNITE)) * GROSSEUR_UNITE;
    }

    public void verifierCollision() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ouvert) {
            //verifierCollision();
            //mouvement();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if (playerX > 0 && timer.isRunning()) {
                        playerX = playerX - GROSSEUR_UNITE;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (playerX <= BORDER_NUMBER_X && timer.isRunning()) {
                        playerX = playerX + GROSSEUR_UNITE;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (playerY > 0 && timer.isRunning()) {
                        playerY = playerY - GROSSEUR_UNITE;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (playerY <= BORDER_NUMBER_Y && timer.isRunning()) {
                        playerY = playerY + GROSSEUR_UNITE;
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
            }
        }
    }
}