import java.awt.*;

public class Niveau2 {

    private int GROSSEUR_UNITE;
    private int LARGEUR_ECRAN;

    public Niveau2() {
        GROSSEUR_UNITE = GamePanel.GROSSEUR_UNITE;
        LARGEUR_ECRAN = GamePanel.LARGEUR_ECRAN;
    }

    public void rendu(Graphics g){
        for (int i = GROSSEUR_UNITE; i < GROSSEUR_UNITE * 9; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = GROSSEUR_UNITE * 13; i < LARGEUR_ECRAN; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = GROSSEUR_UNITE * 3; i < GROSSEUR_UNITE * 7; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE * 3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = GROSSEUR_UNITE * 9; i < GROSSEUR_UNITE * 13; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE * 3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = LARGEUR_ECRAN; i > (LARGEUR_ECRAN - GROSSEUR_UNITE * 3); i--) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE * 3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }
        for (int i = GROSSEUR_UNITE * 3; i < GROSSEUR_UNITE * 7; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(i, GROSSEUR_UNITE * 3, GROSSEUR_UNITE, GROSSEUR_UNITE);
        }


        //GamePanel.porteX = LARGEUR_ECRAN - (GROSSEUR_UNITE * 2);
        //GamePanel.porteY = GROSSEUR_UNITE;
        g.setColor(Color.RED);
        //g.fillRect(GamePanel.porteX, GamePanel.porteY, GROSSEUR_UNITE, GROSSEUR_UNITE);

        g.setColor(Color.BLUE);
        //g.fillOval(GamePanel.positionX1, GamePanel.positionY1, GROSSEUR_UNITE, GROSSEUR_UNITE);
    }
}
