import java.util.LinkedList;

import javax.swing.JPanel;

public class Simulation {
	LinkedList<Entity> entities;
	LinkedList<Projectile> projectiles;
	JPanel pan;
	public Simulation(LinkedList<Entity> ent,LinkedList<Projectile> proj, JPanel p) {
		this.entities = ent;
		this.projectiles = proj;
		this.pan = p;
	}
	public void launch() {
		while(true) {
			sleep();
			LinkedList<Entity> tmp = new LinkedList<>(entities);
			for(Entity ent : tmp) {
				ent.moove(entities);
				if(ent.life <= 0) {
					entities.remove(ent);
				}
			}
			LinkedList<Projectile> ptmp = new LinkedList<>(projectiles);
			for(Projectile p : ptmp) {
				double distance = Integer.MAX_VALUE;
				Entity target = null;
				p.moove();
				for(Entity e : entities) {
					if(p.hasHit(e) && !e.isHuman()) {
						double temp = Math.abs(e.x - p.x) + Math.abs(e.y - p.y);
						if(temp < distance) {
							distance = temp; 
							target = e;
						}
					}
				}
				if(target != null) {
					p.hit(target);
					projectiles.remove(p);
				}
				if(p.x > Constant.width || p.x < 0 || p.y > Constant.height || p.y < 0) {
					projectiles.remove(p);
				}
			}
			pan.repaint();
		}
	}
	public void sleep() {
		try {
			Thread.sleep(1000/Constant.refresh_per_sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
