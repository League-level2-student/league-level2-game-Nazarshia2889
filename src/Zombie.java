import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Zombie extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Zombie(int x, int y, int width, int height){
		super(x, y, width, height);
		speed = 1;
		if (needImage) {
		    loadImage ("zombie.gif");
		}
	}
	
	void update() {
		super.update();
		if(Player.inBush == false) {
			if(x < Player.px) {
				x += speed;
			}
			if(x > Player.px) {
				x -= speed;
			}
			if(y < Player.py) {
				y += speed;
			}
			if(y > Player.py){
				y -= speed;
			}
		}
		else if(Player.inBush == true){
			y += speed;
		}
	}
	
	 void draw(Graphics g) {
	     if (gotImage) {
	    		g.drawImage(image, x, y, width, height, null);
	    	} else {
	    		g.setColor(Color.YELLOW);
	    		g.fillRect(x, y, width, height);
	    	}
	 }
	 
	 
	 void loadImage(String imageFile) {
		    if (needImage) {
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			    gotImage = true;
		        } catch (Exception e) {
		            
		        }
		        needImage = false;
		    }
		}
		
	
	
}
