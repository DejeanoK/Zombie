import java.util.LinkedList;
import java.util.Random;

public class App {
	public static final int nb_zombie = Constant.nb_zombie;
	public static final int nb_human = Constant.nb_human;
	
	public static void main(String[] args) {
		Random rand = new Random();
		LinkedList<Entity> lent = new LinkedList<>();
		LinkedList<Projectile> proj = new LinkedList<>();
		for(int i = 0; i < nb_zombie; ++i) {
			Entity e = new Entity(rand.nextDouble()*Constant.width, rand.nextDouble()*Constant.height, rand.nextDouble()*0.8, rand.nextDouble()*0.8);
			e.setZombie();
			lent.add(e);
		}
		for(int i = 0; i < nb_human; ++i) {
			Entity e = new Entity(rand.nextDouble()*Constant.width, rand.nextDouble()*Constant.height, rand.nextDouble()*1.6, rand.nextDouble()*1.6);
			e.setHuman();
			e.state.addWeapon(new Pistol(proj,e));
			lent.add(e);
		}
		Window win = new Window(Constant.width, Constant.height);
		World w = new World(lent, proj);
		win.add(w);
		win.pack();
		Simulation sim = new Simulation(lent,proj, w);
		sim.launch();

	}
}

