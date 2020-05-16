package sp;

import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

public class electroball extends JPanel {

    public ImageIcon ET = new ImageIcon(this.getClass().getResource("ball1.png"));
    public int y;
    public int x;
    public int count = 0;

    electroball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        this.x += 7;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 80, 80));
    }

}
