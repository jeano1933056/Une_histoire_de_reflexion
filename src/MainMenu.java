import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu{

    private static final int LARGEUR_ECRAN = 600;


    public void rendu (Graphics g){
        if(GamePanel.state == GamePanel.STATE.MENU) {
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            g.drawString("Une histoire de reflexion", (GamePanel.LARGEUR_ECRAN - metrics.stringWidth("Une histoire de reflexion")) / 2, g.getFont().getSize());

            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Ink Free", Font.BOLD, 25));
            FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
            Rectangle niveau1 = new Rectangle((LARGEUR_ECRAN/2) - 75, 125, 150, 60 );
            Rectangle niveau2 = new Rectangle((LARGEUR_ECRAN/2) - 75, 250, 150, 60 );
            Rectangle niveau3 = new Rectangle((LARGEUR_ECRAN/2) - 75, 375, 150, 60 );

            g2d.drawString("Niveau 1", ((LARGEUR_ECRAN/2) - metrics2.stringWidth("Niveau 1") / 2), niveau1.y + (int) niveau1.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 2", ((LARGEUR_ECRAN/2) - metrics2.stringWidth("Niveau 2") / 2), niveau2.y + (int) niveau2.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 3", ((LARGEUR_ECRAN/2) - metrics2.stringWidth("Niveau 3") / 2), niveau3.y + (int) niveau3.getHeight() - g2d.getFont().getSize());
            g2d.draw(niveau1);
            g2d.draw(niveau2);
            g2d.draw(niveau3);
        }
    }
}
