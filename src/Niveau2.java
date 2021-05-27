import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Niveau2 {

    private int GROSSEUR_UNITE;
    private int LARGEUR_ECRAN;

    private int positionX1;
    private int positionX2;
    private int positionX3;
    private int positionX4;
    private int positionX5;

    private int positionY1;
    private int positionY2;
    private int positionY3;
    private int positionY4;
    private int positionY5;

    private int porteX;
    private int porteY;

    public Niveau2() {
        GROSSEUR_UNITE = GamePanel.GROSSEUR_UNITE;
        LARGEUR_ECRAN = GamePanel.LARGEUR_ECRAN;
        positionX1 = GROSSEUR_UNITE;
        positionX2 = 4 * GROSSEUR_UNITE;
        positionX3 = 8 * GROSSEUR_UNITE;
        positionX4 = 12 * GROSSEUR_UNITE;
        positionX5 = 18 * GROSSEUR_UNITE;

        positionY1 = 7 * GROSSEUR_UNITE;
        positionY2 = 17 * GROSSEUR_UNITE;
        positionY3 = 10 * GROSSEUR_UNITE;
        positionY4 = 4 * GROSSEUR_UNITE;
        positionY5 = 2 * GROSSEUR_UNITE;

        GamePanel.blocX = 8 * GROSSEUR_UNITE;
        GamePanel.blocY = 10 * GROSSEUR_UNITE;
        porteX = LARGEUR_ECRAN - (GROSSEUR_UNITE * 2);
        porteY = GROSSEUR_UNITE;
    }

    public void rendu(Graphics g){

        for (int i = 0; i < GROSSEUR_UNITE * 17; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(GROSSEUR_UNITE * 2, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
            g.fillRect(GROSSEUR_UNITE * 3, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = LARGEUR_ECRAN; i > 14 * GROSSEUR_UNITE; i--) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE * 3, GROSSEUR_UNITE, GROSSEUR_UNITE);
            g.fillRect(i, GROSSEUR_UNITE * 4, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }

        for (int i = 3 * GROSSEUR_UNITE; i < LARGEUR_ECRAN; i++){
            if(i < GamePanel.blocX && GamePanel.blocY == 16 * GROSSEUR_UNITE) {
                g.drawRect(i, 16 * GROSSEUR_UNITE, 2, 2);
                g.setColor(Color.RED);
                if(GamePanel.blocX > 3 * GROSSEUR_UNITE) {
                    for (int j = GamePanel.blocY; j > 0; j--) {
                        g.drawRect(GamePanel.blocX, j,2, 2);
                        g.setColor(Color.RED);
                    }
                }
            }
            else if (GamePanel.blocY != 16 * GROSSEUR_UNITE){
                g.drawRect(i,16 * GROSSEUR_UNITE, 2, 2);
                g.setColor(Color.RED);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(porteX, porteY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.setColor(Color.YELLOW);
        g.fillRect(GamePanel.blocX, GamePanel.blocY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.setColor(Color.BLUE);
        g.fillOval(positionX1, positionY1, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX2, positionY2, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX3, positionY3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX4, positionY4, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX5, positionY5, GROSSEUR_UNITE, GROSSEUR_UNITE);
    }

    public void collision(){
        for (int z = 0; z <= GROSSEUR_UNITE * 9; z++) {
            if (GamePanel.playerX == GROSSEUR_UNITE * 5 && GamePanel.playerY == z - 1) {
                GamePanel.mursL = true;
            } else if (GamePanel.playerX == GROSSEUR_UNITE * 2 && GamePanel.playerY == z - 1) {
                GamePanel.mursR = true;
            } else if ((GamePanel.playerX == GROSSEUR_UNITE * 3 || GamePanel.playerX == GROSSEUR_UNITE * 4) &&
                    GamePanel.playerY == z + 1) {
                GamePanel.mursU = true;
            }
        }
        for (int i = GROSSEUR_UNITE * 5; i < LARGEUR_ECRAN; i++) {
            if (GamePanel.playerY == GROSSEUR_UNITE * 13 && GamePanel.playerX == i + 1) {
                GamePanel.mursD = true;
            } else if (GamePanel.playerY == GROSSEUR_UNITE * 16 && GamePanel.playerX == i + 1) {
                GamePanel.mursU = true;
            } else if ((GamePanel.playerY == GROSSEUR_UNITE * 14 || GamePanel.playerY == GROSSEUR_UNITE * 15) &&
                    GamePanel.playerX == i - 1) {
                GamePanel.mursR = true;
            }
        }

        if (GamePanel.blocY < GROSSEUR_UNITE * 13 && GamePanel.blocX == GROSSEUR_UNITE * 16) {
            for (int i = 0; i < GamePanel.blocY; i++) {
                if (GamePanel.playerX == GROSSEUR_UNITE * 15 && GamePanel.playerY == i - 1) {
                    GamePanel.mursR = true;
                    GamePanel.gameOver();
                }
                else if (GamePanel.playerX == GROSSEUR_UNITE * 16 && GamePanel.playerY == i - 1){
                    GamePanel.mursL = true;
                    GamePanel.gameOver();
                }
            }
            for (int j = GamePanel.blocX; j < LARGEUR_ECRAN; j++) {
                if (GamePanel.playerY == GamePanel.blocY && GamePanel.playerX == j - 1){
                    GamePanel.mursU = true;
                    GamePanel.gameOver();
                }
                else if (GamePanel.playerY == GamePanel.blocY - 1 && GamePanel.playerX == j - 1){
                    GamePanel.mursD = true;
                    GamePanel.gameOver();
                }
            }
        }
        else {
            for (int i = 0; i < GROSSEUR_UNITE * 14; i++) {
                if (GamePanel. playerX == GROSSEUR_UNITE * 15 && GamePanel.playerY == i - 1) {
                    GamePanel.mursR = true;
                    GamePanel.gameOver();
                }
                else if (GamePanel.playerX == GROSSEUR_UNITE * 16 && GamePanel.playerY == i - 1){
                    GamePanel.mursL = true;
                    GamePanel.gameOver();
                }
            }
        }
    }



    public void checkProies(){
        if((GamePanel.playerX == positionX1) && (GamePanel.playerY == positionY1)){
            GamePanel.proies++;
            System.out.println(GamePanel.proies);
            positionX1 = -1 * GROSSEUR_UNITE;
            positionY1 = -1 * GROSSEUR_UNITE;
        }
        else if((GamePanel.playerX == positionX2) && (GamePanel.playerY == positionY2)){
            GamePanel.proies++;
            System.out.println(GamePanel.proies);
            positionX2 = -1 * GROSSEUR_UNITE;
            positionY2 = -1 * GROSSEUR_UNITE;
        }
        else if((GamePanel.playerX == positionX3) && (GamePanel.playerY == positionY3)){
            GamePanel.proies++;
            System.out.println(GamePanel.proies);
            positionX3 = -1 * GROSSEUR_UNITE;
            positionY3 = -1 * GROSSEUR_UNITE;
        } else if((GamePanel.playerX == positionX4) && (GamePanel.playerY == positionY4)){
            GamePanel.proies++;
            System.out.println(GamePanel.proies);
            positionX4 = -1 * GROSSEUR_UNITE;
            positionY4 = -1 * GROSSEUR_UNITE;
        } else if((GamePanel.playerX == positionX5) && (GamePanel.playerY == positionY5)){
            GamePanel.proies++;
            System.out.println(GamePanel.proies);
            positionX5 = -1 * GROSSEUR_UNITE;
            positionY5 = -1 * GROSSEUR_UNITE;
        }
    }

    public void finNiveau(){
        if (GamePanel.playerY == porteY && GamePanel.playerX == porteX) {
            GamePanel.menu();
            GamePanel.playerX = GROSSEUR_UNITE;
            GamePanel.playerY = GROSSEUR_UNITE;
        }
    }

    public void storyline(){
        if (GamePanel.playerY == porteY && GamePanel.playerX == porteX) {
            GamePanel.storyline = true;
        }
    }
}