import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame{

    public Rectangle niveau1 = new Rectangle(GamePanel.LARGEUR_ECRAN/2 - 75, 100, 150, 50 );
    private JButton play = new JButton("Play");
    GameFrame(){

      /*  if(GamePanel.state == GamePanel.STATE.MENU) {
            play.setBounds(niveau1);
            this.add(play);
            play.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    GamePanel.state = GamePanel.STATE.GAME;
                    GamePanel.timer.start();
                }
            });
        }
        */

        this.add(new GamePanel());
        this.setTitle("Chats");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

   /* public class MyKeyAdapter extends KeyAdapter {
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
    }*/
    public void choisirPanel() {

    }
}

