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
	
	void addBush() {
		if(GamePanel.currentState == 1) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
		}
		if(GamePanel.currentState == 2) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
		}
		if(GamePanel.currentState == 3) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
		}
		if(GamePanel.currentState == 4) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
		}
		if(GamePanel.currentState == 5) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt(Cure.HEIGHT), 350, 200));
		}
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
	
	void checkCollision() {
		for(int i = 0;i<zombies.size();i++) {
			Zombie s = zombies.get(i);
			if(s.collisionBox.intersects(player.collisionBox)) {
				player.isActive = false;
				s.isActive = false;
			}		
		}
		for(int i = 0;i<bushes.size();i++) {
			Bush s = bushes.get(i);
			if(player.collisionBox.intersects(s.collisionBox)) {
				player.inBush = true;
			}
			else {
				player.inBush = false;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addZombie();
	}
	
}
