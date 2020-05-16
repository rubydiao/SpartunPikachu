package sp;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class ghost {
	Image img;
	public int x = (int) ((Math.random()*1000)+10);
	public int y= 60;
	public int count = 0;
	ghost(){
                String imageLocation = "ghost.gif";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		sb.start();
	}
	Thread sb = new Thread(new Runnable() {
            public void run() {
		while(true){
                    y += 2;
                    if(y >= 540){
			img = null;
			sb = null;
			x = 0;
			y = 60;
                    }
                    try{
			sb.sleep(10);
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
    	    return (new Rectangle2D.Double(x,y,150,150));
	}
}

