import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    static final int LARGEUR_ECRAN = 600;
    static final int HAUTEUR_ECRAN = 600;
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    JLabel titre = new JLabel("Une histoire de réflexion");
    JButton goToGamePanel = new JButton("Niveau 1");


    MainMenu() {
        this.setPreferredSize(new Dimension(LARGEUR_ECRAN, HAUTEUR_ECRAN));
        this.setBackground(new Color(144, 168, 195));
        this.setFocusable(true);
        this.setCursor(cursor);
        this.add(titre);
        titre.setFont(new Font("Ink Free", Font.PLAIN, 40));
        this.add(goToGamePanel);
        goToGamePanel.setLocation(250, 300);

    }
}
