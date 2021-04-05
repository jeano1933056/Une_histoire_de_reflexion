import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu{

    private static final int LARGEUR_ECRAN = 600;
    private static final int HAUTEUR_ECRAN = 600;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private Button goToGamePanel = new Button("Niveau 1");

    public Rectangle niveau1 = new Rectangle(180 - 75, 125, 150, 60 );
    public Rectangle niveau2 = new Rectangle(180 - 75, 250, 150, 60 );
    public Rectangle niveau3 = new Rectangle(180 - 75, 375, 150, 60 );
    public Rectangle niveau4 = new Rectangle(180 - 75, 500, 150, 60 );
    public Rectangle niveau5 = new Rectangle(420 - 75, 150, 150, 60 );
    public Rectangle niveau6 = new Rectangle(420 - 75, 300, 150, 60 );
    public Rectangle niveau7 = new Rectangle(420 - 75, 450, 150, 60 );

    public void rendu (Graphics g){
        if(GamePanel.state == GamePanel.STATE.MENU) {
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            g.drawString("Une histoire de reflexion", (GamePanel.LARGEUR_ECRAN - metrics.stringWidth("Une histoire de reflexion")) / 2, g.getFont().getSize());

            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Ink Free", Font.BOLD, 25));
            FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
            g2d.drawString("Niveau 1", (niveau1.x + metrics2.stringWidth("Niveau 1") / 2) - 15, niveau1.y + (int) niveau1.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 2", (niveau2.x + metrics2.stringWidth("Niveau 2") / 2) - 15, niveau2.y + (int) niveau2.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 3", (niveau3.x + metrics2.stringWidth("Niveau 3") / 2) - 15, niveau3.y + (int) niveau3.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 4", (niveau4.x + metrics2.stringWidth("Niveau 4") / 2) - 15, niveau4.y + (int) niveau4.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 5", (niveau5.x + metrics2.stringWidth("Niveau 5") / 2) - 15, niveau5.y + (int) niveau5.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 6", (niveau6.x + metrics2.stringWidth("Niveau 6") / 2) - 15, niveau6.y + (int) niveau6.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 7", (niveau7.x + metrics2.stringWidth("Niveau 7") / 2) - 15, niveau7.y + (int) niveau7.getHeight() - g2d.getFont().getSize());
            g2d.draw(niveau1);
            g2d.draw(niveau2);
            g2d.draw(niveau3);
            g2d.draw(niveau4);
            g2d.draw(niveau5);
            g2d.draw(niveau6);
            g2d.draw(niveau7);
        }
    }
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER :
            if(GamePanel.state == GamePanel.STATE.MENU)
                GamePanel.state = GamePanel.STATE.GAME;
            else if (GamePanel.state == GamePanel.STATE.GAME)
                GamePanel.state = GamePanel.STATE.MENU;
        }
        }
    }
}
