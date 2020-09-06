import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Player player;
	ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	ArrayList<Bush> bushes = new ArrayList<Bush>();
	Random random = new Random();
	Vaccine vaccine;
	
	ObjectManager(Player player){
		this.player = player;
	}
	
	void addBush(Bush bush) {
		if(GamePanel.currentState == 1) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
		}
		if(GamePanel.currentState == 2) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
		}
		if(GamePanel.currentState == 3) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
		}
		if(GamePanel.currentState == 4) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
		}
		if(GamePanel.currentState == 5) {
			bushes.add(new Bush(random.nextInt(Cure.WIDTH), random.nextInt((1000-200) + 1) + 200, 75, 75));
		}
	}
	
	void addZombie(Zombie zombie) {
		zombies.add(new Zombie((random.nextInt(Cure.WIDTH)), 0, 50, 50));
	}
}
