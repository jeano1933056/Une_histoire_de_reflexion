import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame{

    GameFrame(){

        this.add(new GamePanel());
        this.setTitle("Chats");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

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

