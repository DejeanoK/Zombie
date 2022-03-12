import java.util.LinkedList;

public class StateZombie extends StateEntity{
	public StateZombie(Entity e) {
		super(e);
		e.life = 100;
		this.vision = 50;
		this.v = 0.8;
	}

	@Override
	public void smartMoove(LinkedList<Entity> entities) {
		double distX = 0, distY = 0;
		for(Entity e : entities) {
			if(e.isHuman()) {
				if(e.isIn(ent)) {
					e.setZombie();
				}
				else if(ent.isSeeing(e, vision)) {
					distX = ent.x - e.x;
					distY = ent.y - e.y;
					double angle = Math.atan2(distY, distX);
					ent.vx = -v * Math.cos(angle);
					ent.vy = -v * Math.sin(angle);
					break;
				}
			}
		}

		super.moove();
	}
	
}
