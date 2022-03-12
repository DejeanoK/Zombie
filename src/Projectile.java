import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public abstract class Projectile {
	double x,y;
	double vx,vy;
	double force;
	double width, height;
	int damage;
	Line2D trajectoire;
	public Projectile(Entity shooter, Entity target, int dmg) {
		this.x = shooter.x;
		this.y = shooter.y;
		double distX = shooter.x - (target.x + target.vx);
		double distY = shooter.y - (target.y + target.vy);
		double angle = Math.atan2(distY, distX);
		this.vx = -10 * Math.cos(angle);
		this.vy = -10 * Math.sin(angle);
		this.damage = dmg;
	}
	
	public void moove() {
		this.trajectoire = new Line2D.Double(x,y,x+vx, y+vy);
		this.x += vx;
		this.y += vy;
	}
	
	public void hit(Entity target) {
		target.life -= damage;
	}
	
	public boolean hasHit(Entity target) {
		Rectangle2D r1 = new Rectangle2D.Double(target.x,target.y,target.size,target.size);
		return trajectoire.intersects(r1);
	}
}
