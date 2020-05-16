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

public class index extends JPanel {

    private ImageIcon feild = new ImageIcon(this.getClass().getResource("coverreal.jpg"));
    private ImageIcon tutorial = new ImageIcon(this.getClass().getResource("tutorial.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("start1!.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));

    public JButton BStart = new JButton(starts);
    public JButton Btutorial = new JButton(tutorial);
    public JButton Bexit = new JButton(exit);

    index() {
        setLayout(null);
        Btutorial.setBounds(800, 600, 300, 90);
        Btutorial.setRolloverIcon(new ImageIcon(this.getClass().getResource("tutorial1.png")));
        Btutorial.setOpaque(false);
        Btutorial.setBorderPainted(false);
        Btutorial.setContentAreaFilled(false);
        add(Btutorial);
        BStart.setBounds(500, 600, 200, 90);
        BStart.setRolloverIcon(new ImageIcon(this.getClass().getResource("start!.png")));
        BStart.setOpaque(false);
        BStart.setBorderPainted(false);
        BStart.setContentAreaFilled(false);
        add(BStart);
        Bexit.setBounds(250, 600, 150, 90);
        Bexit.setRolloverIcon(new ImageIcon(this.getClass().getResource("exit1.png")));
        Bexit.setOpaque(false);
        Bexit.setBorderPainted(false);
        Bexit.setContentAreaFilled(false);
        add(Bexit);

    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(feild.getImage(), 0, 0, 1290, 780, this);

    }

}
