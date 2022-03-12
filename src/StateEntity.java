import java.util.LinkedList;

public abstract class StateEntity {
	
	public int vision;
	public double v;
	public Weapon arme;
	public Entity ent;
	
	public StateEntity(Entity e) {
		this.ent = e;
	}
	public void moove() {
		if(!(ent.x + ent.vx < Constant.width && ent.x + ent.vx > 0)) {
			this.ent.vx *= -1;
		}
		
		if(!(ent.y + ent.vy < Constant.width && ent.y + ent.vy > 0)) {
			this.ent.vy *= -1;
		}
		this.ent.x = ent.x + ent.vx;
		this.ent.y = ent.y + ent.vy;
	}
	public abstract void smartMoove(LinkedList<Entity> entities);
	
	public void addWeapon(Weapon w) {
		this.arme = w;
	}
}
