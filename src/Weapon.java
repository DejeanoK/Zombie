import java.time.Instant;
import java.util.LinkedList;

public abstract class Weapon {
	public int damage;
	public int ammo;
	public int range;
	public Instant reloading;
	public LinkedList<Projectile> projs;

	public Weapon(int d, int a, int r, LinkedList<Projectile> p) {
		this.damage = d;
		this.ammo = a;
		this.range = r;
		this.projs = p;
		this.reloading = Instant.now();
	}
	
	public abstract void shoot(Entity e);
}
