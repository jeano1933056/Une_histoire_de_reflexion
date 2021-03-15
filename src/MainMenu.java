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

    public Rectangle niveau1 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 100, 150, 50 );
    public Rectangle niveau2 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 200, 150, 50 );
    public Rectangle niveau3 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 300, 150, 50 );

    public void rendu (Graphics g){
        if(GamePanel.state == GamePanel.STATE.MENU) {
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            g.drawString("Une histoire de reflexion", (GamePanel.LARGEUR_ECRAN - metrics.stringWidth("Une histoire de reflexion")) / 2, g.getFont().getSize());

            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Ink Free", Font.BOLD, 20));
            FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
            g2d.drawString("Niveau 1", (niveau1.x + metrics2.stringWidth("Niveau 1") / 2), niveau1.y + (int) niveau1.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 2", (niveau2.x + metrics2.stringWidth("Niveau 2") / 2), niveau2.y + (int) niveau2.getHeight() - g2d.getFont().getSize());
            g2d.drawString("Niveau 3", (niveau3.x + metrics2.stringWidth("Niveau 3") / 2), niveau3.y + (int) niveau3.getHeight() - g2d.getFont().getSize());
            g2d.draw(niveau1);
            g2d.draw(niveau2);
            g2d.draw(niveau3);
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


    public void choisirPanel() {

    }
}
