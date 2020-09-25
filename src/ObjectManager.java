import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Player player;
	ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	ArrayList<Bush> bushes = new ArrayList<Bush>();
	Random random = new Random();
	Vaccine vaccine;
	
	ObjectManager(Player player){
		this.player = player;
	}
	
	void addBushLevelOne() {
		bushes.add(new Bush(5, 100, 350, 200));
		bushes.add(new Bush(5, 400, 350, 200));
		bushes.add(new Bush(400, 100, 350, 200));
		bushes.add(new Bush(400, 400, 350, 200));
	}
	void addBushLevelTwo() {
		bushes.add(new Bush(200, 250, 350, 200));
		bushes.add(new Bush(600, 250, 350, 200));
		bushes.add(new Bush(400, 500, 350, 200));
			
	}
		
	void addBushLevelThree() {
		bushes.add(new Bush(200, 800, 350, 200));
		bushes.add(new Bush(600, 200, 350, 200));
	}
		
	void addBushLevelFour() {
		bushes.add(new Bush(200, 500, 350, 200));
		bushes.add(new Bush(600, 500, 350, 200));
	}
	
	void addBushLevelFive() {
		bushes.add(new Bush(400, 500, 350, 200));
	}
	
	
	void addZombie() {
		zombies.add(new Zombie((random.nextInt(Cure.WIDTH)), 0, 100, 100));
	}
	
	void update() {
		checkCollision();
		purgeObjects();
		for(int i = 0;i<zombies.size();i++){
			Zombie s = zombies.get(i);
			s.update();
			if(s.y > Cure.HEIGHT) {
				s.isActive = false;
			}
		}
		for(int i = 0;i<bushes.size();i++){
			Bush s = bushes.get(i);
			s.update();
			if(s.y > Cure.HEIGHT) {
				s.isActive = false;
			}
		}
	}
	
	void draw(Graphics g) {
		player.draw(g);
		
		for(int i = 0;i<zombies.size();i++) {
			Zombie s = zombies.get(i);
			s.draw(g);
		}
		
		for(int i = 0;i<bushes.size();i++) {
			Bush s = bushes.get(i);
			s.draw(g);
		}
	}
	
	void purgeObjects() {
		for(int i = 0;i<zombies.size();i++) {
			Zombie s = zombies.get(i);
			if(s.isActive == false) {
				zombies.remove(s);
			}
		}
		
		for(int i = 0;i<bushes.size();i++) {
			Bush s = bushes.get(i);
			if(s.isActive == false) {
				bushes.remove(s);
			}
		}
	}
	
	void resetPlayer() {
		player = null;
	}
	
	void checkCollision() {
		for(int i = 0;i<zombies.size();i++) {
			Zombie s = zombies.get(i);
			if(s.collisionBox.intersects(player.collisionBox)) {
				player.isActive = false;
				s.isActive = false;
			}		
		}
		boolean isInBush = false;
		
		for(int i = 0;i<bushes.size();i++) {
			Bush s = bushes.get(i);
			if(player.collisionBox.intersects(s.collisionBox)) {
				isInBush = true;
				break;
			}
		}
		player.inBush = isInBush;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addZombie();
	}
	
}
