import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

public class Entity {

	public double x,y;
	public double vx,vy;
	public double size = 5.0;
	private boolean isHuman = false;
	public int life;
	public StateEntity state = null;

	public Entity(double x, double y, double vx, double vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	
	
	
	public boolean isSeeing(Entity e, double range) {
		double distx = x - e.x;
		double disty = y - e.y;
		double radiusSum = e.size + range/2.0;
		return distx * distx + disty * disty <= radiusSum * radiusSum;
	}
	
	public boolean isIn(Entity e) {
		Rectangle2D r1 = new Rectangle2D.Double(x,y,size,size);
		Rectangle2D r2 = new Rectangle2D.Double(e.x,e.y,e.size,e.size);
		return r1.intersects(r2);
	}
	
	public void moove(LinkedList<Entity> e) {
		this.state.smartMoove(e);
	}
	
	public void setHuman() {
		this.state = new StateHumain(this);
		isHuman = true;
	}
	public void setZombie() {
		this.state = new StateZombie(this);
		isHuman = false;
	}
	public boolean isHuman() {
		return this.isHuman;
	}
}
