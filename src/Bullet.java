
public class Bullet extends Projectile{

	public Bullet(Entity shooter, Entity target, int dmg) {
		super(shooter, target, dmg);
		this.width = 3;
		this.height = 3;
	}

}
