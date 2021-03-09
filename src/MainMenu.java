import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    static final int LARGEUR_ECRAN = 600;
    static final int HAUTEUR_ECRAN = 600;
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    JLabel titre = new JLabel("Une histoire de réflexion");
    JButton goToGamePanel = new JButton("Niveau 1");



    MainMenu() {
        this.add(new GamePanel());
        this.setPreferredSize(new Dimension(LARGEUR_ECRAN, HAUTEUR_ECRAN));
        this.setBackground(new Color(144, 168, 195));
        this.setFocusable(true);
        this.setCursor(cursor);
        this.add(titre);
        this.add(goToGamePanel);
        titre.setFont(new Font("Ink Free", Font.PLAIN, 40));
        goToGamePanel.setLocation(250, 300);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            }
        };
        goToGamePanel.setActionCommand("FirstButton");
        goToGamePanel.addActionListener(actionListener);
        JOptionPane.showMessageDialog(null, goToGamePanel);
    }

    public void choisirPanel() {

    }
}
