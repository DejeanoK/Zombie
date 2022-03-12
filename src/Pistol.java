import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class Pistol extends Weapon{
	private Entity owner;
	private LinkedList<Projectile> proj;
	public Pistol(LinkedList<Projectile> p, Entity o) {
		/*
		 * dmg -> 100
		 * ammo -> 12
		 * range -> 60
		 */
		super(100, 12, 60, p);
		this.owner = o;
		this.proj = p;
	}

	@Override
	public void shoot(Entity e) {
		if(Duration.between(reloading, Instant.now()).getSeconds() > 1) {
			proj.add(new Bullet(owner,e,damage));
			reloading = Instant.now();
			--ammo;
		}
	}

}
