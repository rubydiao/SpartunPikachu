package sp;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class nidoran {
	Image img;
	public int x = 1120;
	public int y= 570;
	public int count = 0;
	nidoran(){
                String imageLocation = "nidono.gif";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		ca.start();
	}
	Thread ca = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x -= 3;
                    if(x == 0){
			img = null;
			ca = null;
			x = 1120;
			y = 550;
                    }
                    try{
			ca.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,80,80));
	}
}
