import java.awt.*;

public class Niveau1 {

    private int GROSSEUR_UNITE;
    private int LARGEUR_ECRAN;

    public Niveau1() {
        GROSSEUR_UNITE = GamePanel.GROSSEUR_UNITE;
        LARGEUR_ECRAN = GamePanel.LARGEUR_ECRAN;
    }

    public void rendu(Graphics g){
        for (int i = 0; i < GROSSEUR_UNITE * 8; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(GROSSEUR_UNITE * 3, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
            g.fillRect(GROSSEUR_UNITE * 4, i, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = GROSSEUR_UNITE * 6; i < LARGEUR_ECRAN; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE * 14, GROSSEUR_UNITE, GROSSEUR_UNITE);
            g.fillRect(i, GROSSEUR_UNITE * 15, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }


        for (int i = 0; i < 14 * GROSSEUR_UNITE; i++){
            if(i < GamePanel.blocY && GamePanel.blocX == 16 * GROSSEUR_UNITE) {
                g.drawRect(16 * GROSSEUR_UNITE, i, 2, 2);
                g.setColor(Color.RED);
                if(GamePanel.blocY < 14 * GROSSEUR_UNITE) {
                    for (int j = GamePanel.blocX; j < LARGEUR_ECRAN; j++) {
                        g.drawRect(j, GamePanel.blocY, 2, 2);
                        g.setColor(Color.RED);
                    }
                }
            }
            else if (GamePanel.blocX != 16 * GROSSEUR_UNITE){
                g.drawRect(16 * GROSSEUR_UNITE, i, 2, 2);
                g.setColor(Color.RED);
            }
        }
        GamePanel.porteX = LARGEUR_ECRAN - (GROSSEUR_UNITE * 2);
        GamePanel.porteY = GROSSEUR_UNITE;
        g.setColor(Color.RED);
        g.fillRect(GamePanel.porteX, GamePanel.porteY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.setColor(Color.BLUE);
        g.fillOval(GamePanel.positionX, GamePanel.positionY, GROSSEUR_UNITE, GROSSEUR_UNITE);
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
            if (GamePanel.playerY == GROSSEUR_UNITE * 13 && GamePanel.playerX == i - 1) {
                GamePanel.mursD = true;
            } else if (GamePanel.playerY == GROSSEUR_UNITE * 16 && GamePanel.playerX == i - 1) {
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
                if (GamePanel.playerX == GROSSEUR_UNITE * 15 && GamePanel.playerY == i - 1) {
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
}