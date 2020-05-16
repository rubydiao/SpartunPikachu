package sp;

import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

public class electroball2 extends JPanel {

    public ImageIcon ET = new ImageIcon(this.getClass().getResource("ball1.png"));
    public int y;
    public int x;
    public int count=0;
     electroball2(int x,int y){
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.y-=7;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,50,50));
    }

}
