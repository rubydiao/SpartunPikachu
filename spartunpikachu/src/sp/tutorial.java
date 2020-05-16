package sp;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class tutorial extends JPanel {

    private ImageIcon f = new ImageIcon(this.getClass().getResource("tutorial.jpg"));
    private ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
    public JButton Bback = new JButton(back);

    tutorial() {
        setLayout(null);
        Bback.setBounds(500, 600, 200, 90);
        Bback.setRolloverIcon(new ImageIcon(this.getClass().getResource("back1.png")));
        Bback.setOpaque(false);
        Bback.setBorderPainted(false);
        Bback.setContentAreaFilled(false);
        add(Bback);

    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(f.getImage(), 0, 0, 1290, 790, this);

    }
 
}
