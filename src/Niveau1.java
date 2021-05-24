import javax.swing.*;
import java.awt.*;

public class Niveau1 {

    private int GROSSEUR_UNITE;
    private int LARGEUR_ECRAN;
    private int HAUTEUR_ECRAN;
    private boolean check;

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

    private int blocX;
    private int blocY;
    private int porteX;
    private int porteY;
    private int checkX;
    private int checkY;


    public Niveau1() {
        GROSSEUR_UNITE = GamePanel.GROSSEUR_UNITE;
        LARGEUR_ECRAN = GamePanel.LARGEUR_ECRAN;
        HAUTEUR_ECRAN = GamePanel.HAUTEUR_ECRAN;
        check = false;

        positionX1 = 0;
        positionX2 = 0;
        positionX3 = 0;
        positionX4 = 0;
        positionX5 = 0;

        positionY1 = 4 * GROSSEUR_UNITE;
        positionY2 = 5 * GROSSEUR_UNITE;
        positionY3 = 6 * GROSSEUR_UNITE;
        positionY4 = 7 * GROSSEUR_UNITE;
        positionY5 = 8 * GROSSEUR_UNITE;

        blocX = 4 * GROSSEUR_UNITE;
        blocY = 12 * GROSSEUR_UNITE;
        porteX = LARGEUR_ECRAN - (GROSSEUR_UNITE * 2);
        porteY = GROSSEUR_UNITE;
        checkX = 3 * GROSSEUR_UNITE;
        checkY = 16 * GROSSEUR_UNITE;

        Popup pop = new Popup();
    }

    public void rendu(Graphics g){
        for (int i = 0; i < GROSSEUR_UNITE * 6; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i,GROSSEUR_UNITE * 2, GROSSEUR_UNITE, GROSSEUR_UNITE);
            g.fillRect(i,GROSSEUR_UNITE * 3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = GROSSEUR_UNITE * 2; i < HAUTEUR_ECRAN; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(GROSSEUR_UNITE * 14, i,  GROSSEUR_UNITE, GROSSEUR_UNITE);
            g.fillRect(GROSSEUR_UNITE * 15, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }

        for (int i = 4 * GROSSEUR_UNITE; i < HAUTEUR_ECRAN; i++){
            if(i < blocY && blocX == 4 * GROSSEUR_UNITE) {
                g.drawRect(4 * GROSSEUR_UNITE, i, 2, 2);
                g.setColor(Color.RED);
                if(blocY > 4 * GROSSEUR_UNITE) {
                    for (int j = LARGEUR_ECRAN; j < blocX; j++) {
                        g.drawRect(j, blocY, 2, 2);
                        g.setColor(Color.RED);
                    }
                    for(int j = 0; j < blocX; j++){
                        g.drawRect(j, blocY, 2, 2);
                    }
                }
            }
            else if (blocX != 4 * GROSSEUR_UNITE){
                g.drawRect(4 * GROSSEUR_UNITE, i, 2, 2);
                g.setColor(Color.RED);
            }
        }
        porteX = LARGEUR_ECRAN - (GROSSEUR_UNITE * 2);
        porteY = GROSSEUR_UNITE;
        if (check) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(porteX, porteY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.fillRect(checkX, checkY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.setColor(Color.YELLOW);
        g.fillRect(blocX, blocY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.setColor(Color.BLUE);
        g.fillOval(positionX1, positionY1, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX2, positionY2, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX3, positionY3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX4, positionY4, GROSSEUR_UNITE, GROSSEUR_UNITE);
        g.fillOval(positionX5, positionY5, GROSSEUR_UNITE, GROSSEUR_UNITE);
    }

    public void collision(){
        for (int z = 0; z <= GROSSEUR_UNITE * 7; z++) {
            if (GamePanel.playerY == GROSSEUR_UNITE * 4 && GamePanel.playerX == z - 1) {
                GamePanel.mursU = true;
            } else if (GamePanel.playerY == GROSSEUR_UNITE && GamePanel.playerX == z - 1) {
                GamePanel.mursD = true;
            } else if ((GamePanel.playerY == GROSSEUR_UNITE * 2 || GamePanel.playerY == GROSSEUR_UNITE * 3) &&
                    GamePanel.playerX == z + 1) {
                GamePanel.mursL = true;
            }
        }
        for (int z = 2 * GROSSEUR_UNITE; z <= LARGEUR_ECRAN; z++) {
            if (GamePanel.playerX == GROSSEUR_UNITE * 13 && GamePanel.playerY == z) {
                GamePanel.mursR = true;
            } else if (GamePanel.playerX == GROSSEUR_UNITE * 16 && GamePanel.playerY == z) {
                GamePanel.mursL = true;
            } else if ((GamePanel.playerX == GROSSEUR_UNITE * 14 || GamePanel.playerX == GROSSEUR_UNITE * 15) &&
                    GamePanel.playerY == z - GROSSEUR_UNITE) {
                GamePanel.mursD = true;
            }
        }

        if (blocY > GROSSEUR_UNITE * 3 && blocX == GROSSEUR_UNITE * 4) {
            for (int i = 3 * GROSSEUR_UNITE; i < blocY; i++) {
                if (GamePanel.playerX == GROSSEUR_UNITE * 3 && GamePanel.playerY == i - 1) {
                    GamePanel.mursR = true;
                    GamePanel.gameOver();
                }
                else if (GamePanel.playerX == GROSSEUR_UNITE * 4 && GamePanel.playerY == i - 1){
                    GamePanel.mursL = true;
                    GamePanel.gameOver();
                }
            }
            for (int j = 0; j < blocX; j++) {
                if (GamePanel.playerY == blocY && GamePanel.playerX == j - 1){
                    GamePanel.mursU = true;
                    GamePanel.gameOver();
                }
                else if (GamePanel.playerY == blocY - GROSSEUR_UNITE && GamePanel.playerX == j - 1){
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
        if((GamePanel.playerX == checkX) && (GamePanel.playerY == checkY)){
            check = true;
        }
    }

    public void finNiveau(){
        if (GamePanel.playerY == porteY && GamePanel.playerX == porteX) {
            GamePanel.menu();
        }
    }

    public void storyline(){
    }
}
