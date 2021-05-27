import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.File;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static final int LARGEUR_ECRAN = 600;
    static final int HAUTEUR_ECRAN = 600;
    static final int GROSSEUR_UNITE = 30;
    static final int NOMBRE_BLOCS_X = (LARGEUR_ECRAN/GROSSEUR_UNITE);
    static final int BORDER_NUMBER_X = ((NOMBRE_BLOCS_X - 1) * GROSSEUR_UNITE) - 1;
    static final int NOMBRE_BLOCS_Y = (HAUTEUR_ECRAN/GROSSEUR_UNITE);
    static final int BORDER_NUMBER_Y = ((NOMBRE_BLOCS_Y - 1) * GROSSEUR_UNITE) - 1;
    public static int proies;
    public static int playerX = GROSSEUR_UNITE;
    public static int playerY = GROSSEUR_UNITE;

    public static boolean mursL = false;
    public static boolean mursR = false;
    public static boolean mursU = false;
    public static boolean mursD = false;
    public static boolean instruction = true;
    public static boolean storyline = false;
    public boolean compteurMusique = true;

    public static int blocX;
    public static int blocY;
    public static enum STATE{
        GAME,
        MENU
    }
    public static enum NIVEAU{
        M,
        N1,
        N2,
        N3,
    }

    public static STATE state = STATE.MENU;
    public static NIVEAU niveau = NIVEAU.M;
    Niveau1 niveau1;
    Niveau2 niveau2;
    Niveau3 niveau3;
    Instruction instruction2;
    Histoire histoire;
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
        niveau3 = new Niveau3();
        instruction2 = new Instruction();
        histoire = new Histoire();

        this.setPreferredSize(new Dimension(LARGEUR_ECRAN, HAUTEUR_ECRAN));
        this.setBackground(new Color(244, 202, 224));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        this.setCursor(cursor);
        this.add(label);
        label.setVisible(false);
        start();
    }


    public void start(){
        ouvert = true;
        timer = new Timer(DELAY, this);
    }

    public static void menu(){
        state = STATE.MENU;
        niveau = NIVEAU.M;
    }

    public void niveau1(){
        state = STATE.GAME;
        niveau = NIVEAU.N1;
        GamePanel.blocX = 16 * GROSSEUR_UNITE;
        GamePanel.blocY = 17 * GROSSEUR_UNITE;
        timer.start();
    }

    public void niveau2(){
        state = STATE.GAME;
        niveau = NIVEAU.N2;
        GamePanel.blocX = 12 * GROSSEUR_UNITE;
        GamePanel.blocY = 18 * GROSSEUR_UNITE;
        timer.start();
    }

    public void niveau3(){
        state = STATE.GAME;
        niveau = NIVEAU.N3;
        GamePanel.blocX = 16 * GROSSEUR_UNITE;
        GamePanel.blocY = 12 * GROSSEUR_UNITE;
        timer.start();
    }

    public void finNiveau(){
        if(niveau == NIVEAU.N1){
            niveau1.storyline();
        }
        else if(niveau == NIVEAU.N2){
            niveau2.storyline();
        }
        else if(niveau == NIVEAU.N3){
            niveau3.storyline();
        }
    }

    public void callStoryline(){
        if(storyline){
            storyline = false;
            if(niveau == NIVEAU.N1) {
                niveau1.finNiveau();
            }
            else if(niveau == NIVEAU.N2) {
                niveau2.finNiveau();
            }
            else if(niveau == NIVEAU.N3) {
                niveau3.finNiveau();
            }
        }
    }

    public void callInstruction(){
        if (instruction){
            instruction = false;
            timer.start();
        }
        else {
            instruction = true;
        }
    }

    public void pause(){
        label.setFont(new Font("Ink Free", Font.BOLD, 40));
        label.setVisible(true);
        gameOn = true;
        timer.stop();
    }

    public void resume(){
        label.setFont(new Font("Ink Free", Font.BOLD, 40));
        label.setVisible(false);
        gameOn = false;
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dessiner(g);
    }

    public void dessiner(Graphics g) {
        if(state == STATE.GAME) {
            if(!storyline) {
                if (ouvert) {
                g.setColor(new Color(100, 166, 189));
                g.fillRect(playerX, playerY, GROSSEUR_UNITE, GROSSEUR_UNITE);
            }

                for (int i = 0; i < (HAUTEUR_ECRAN / GROSSEUR_UNITE); i++) {
                    g.setColor(new Color(173, 167, 201));
                    g.drawLine(i * GROSSEUR_UNITE, 0, i * GROSSEUR_UNITE, HAUTEUR_ECRAN);
                    g.drawLine(0, i * GROSSEUR_UNITE, LARGEUR_ECRAN, i * GROSSEUR_UNITE);
                }
            }

            if(niveau == NIVEAU.N1){
                if(!storyline){
                    niveau1.rendu(g);
                }
                else{
                    histoire.renduN1(g);
                }
            }

            if(niveau == NIVEAU.N2){
                if(!storyline){
                    niveau2.rendu(g);
                }
                else{
                    histoire.renduN2(g);
                }
            }

            if (niveau == NIVEAU.N3) {
                if(!storyline){
                    niveau3.rendu(g);
                }
                else{
                    histoire.renduN3(g);
                }
            }
        }
        else if (state == STATE.MENU) {
            if(!instruction) {
                menu.rendu(g);
            }
            else{
                instruction2.rendu(g);
            }
        }

    }

    public void checkProies(){
        if(niveau == NIVEAU.N1){
            niveau1.checkProies();
        }
        else if(niveau == NIVEAU.N2){
            niveau2.checkProies();
        }
        else if(niveau == NIVEAU.N3){
            niveau3.checkProies();
        }
    }

    public void verifierCollision() {
        if (niveau == NIVEAU.N1){
            niveau1.collision();
        }
        else if (niveau == NIVEAU.N2) {
            niveau2.collision();
        }
        else if (niveau == NIVEAU.N3) {
            niveau3.collision();
        }
    }

    public void playMusic(){
        musicStuff musicObject = new musicStuff();
        if (niveau == NIVEAU.N1 && compteurMusique){
            String filepath = "src/Cats.level1.wav";
            musicObject.playMusic(filepath);
            compteurMusique = false;

        } else if (niveau == NIVEAU.N2 && compteurMusique) {
            String filepath = "src/mkanddk3.wav";
            musicObject.playMusic(filepath);
            compteurMusique = false;

        } else if (niveau == NIVEAU.N3 && compteurMusique){
            String filepath = "src/lust.music.wav";
            musicObject.playMusic(filepath);
            compteurMusique = false;

        } else if(niveau == NIVEAU.M && !compteurMusique) {
            compteurMusique = false;
        }
    }

    public class musicStuff{
        void playMusic(String musicLocation){
            try {
                File musicPath = new File(musicLocation);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    if(compteurMusique){
                        clip.start();
                    }
                    else{
                        clip.stop();
                    }
                    clip.loop(Clip.LOOP_CONTINUOUSLY);

                } else {
                    System.out.println("ce clip n'existe pas");
                }

            } catch (Exception ex){
                ex.printStackTrace();

            }
        }
    }

    public static void gameOver(){
       if(niveau == NIVEAU.N1){
           playerX = 0;
           playerY = 0;
           blocX = 16 * GROSSEUR_UNITE;
           blocY = 17 * GROSSEUR_UNITE;
       }
       else if(niveau == NIVEAU.N2){
           playerX = 0;
           playerY = 0;
           blocX = 12 * GROSSEUR_UNITE;
           blocY = 18 * GROSSEUR_UNITE;
       }
       else if(niveau == NIVEAU.N3){
           playerX = 0;
           playerY = 0;
           blocX = 5 * GROSSEUR_UNITE;
           blocY = 12 * GROSSEUR_UNITE;
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ouvert) {
            verifierCollision();
            checkProies();
            finNiveau();
            if(state == STATE.GAME){
                playMusic();
            }
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(playerX == blocX + GROSSEUR_UNITE && playerY == blocY){
                        blocX = blocX - GROSSEUR_UNITE;
                    }
                    if (playerX > 0 && timer.isRunning() && state == STATE.GAME && !storyline) {
                        if(!mursL) {
                            playerX = playerX - GROSSEUR_UNITE;
                        }
                        else
                            mursL = false;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(playerX == blocX - GROSSEUR_UNITE && playerY == blocY){
                        blocX = blocX + GROSSEUR_UNITE;
                    }
                    if (playerX <= BORDER_NUMBER_X && timer.isRunning() && state == STATE.GAME && !storyline) {
                        if(!mursR)
                            playerX = playerX + GROSSEUR_UNITE;
                        else
                            mursR = false;
                    }

                    break;
                case KeyEvent.VK_UP:
                    if(playerX == blocX && playerY == blocY + GROSSEUR_UNITE){
                        blocY = blocY - GROSSEUR_UNITE;
                    }
                    if (playerY > 0 && timer.isRunning() && state == STATE.GAME && !storyline) {
                        if(!mursU)
                            playerY = playerY - GROSSEUR_UNITE;
                        else
                            mursU = false;
                    }
                    break;


                case KeyEvent.VK_DOWN:
                    if(playerX == blocX  && playerY == blocY - GROSSEUR_UNITE){
                        blocY = blocY + GROSSEUR_UNITE;
                    }
                    if (playerY <= BORDER_NUMBER_Y && timer.isRunning() && state == STATE.GAME && !storyline) {
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
                    if(state == STATE.MENU && !instruction) {
                        niveau1();
                    }
                    break;

                case KeyEvent.VK_2 :
                    if(state == STATE.MENU && !instruction) {
                        niveau2();
                    }
                    break;

                case KeyEvent.VK_3 :
                    if(state == STATE.MENU && !instruction) {
                        niveau3();
                    }
                    break;

                case KeyEvent.VK_F :
                    if(state == STATE.MENU){
                       callInstruction();
                    }
                    break;

                case KeyEvent.VK_D :
                    if(state == STATE.GAME) {
                        callStoryline();
                    }
                    break;
            }
        }
    }
}