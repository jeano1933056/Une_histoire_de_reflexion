import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    class Popup extends JFrame {

        // java frame
        static JFrame f;

        // popup menu
        static JPopupMenu pm;

        // default constructor
        Popup()
        {
        }

        // main class
        public static void main(String[] args)
        {
            // create a frame
            f = new JFrame("Popup");

            // set the size of the frame
            f.setSize(400, 400);

            // close the frame when close button is pressed
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // create anew panel
            JPanel p = new JPanel();

            // create an object of mouse class
            Popup pop = new Popup();

            // addActionListener
            f.add(p);
            f.show();

            pm = new JPopupMenu("Message");

            // create a label
            JLabel l = new JLabel("this is the popup menu");

            // add the label to the popup
            pm.add(l);

            // add the popup to the frame
            pm.show(f, 100, 100);
        }
    }