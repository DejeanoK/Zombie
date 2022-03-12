import java.util.LinkedList;

public class StateHumain extends StateEntity{
	
	public StateHumain(Entity e) {
		super(e);
		this.vision = 50;
		this.v = 1.6;
		e.life = 100;
	}

	@Override
	public void smartMoove(LinkedList<Entity> entities) {
		double distX = 0, distY = 0;
		int nb = 0;
		for(Entity e : entities) {
			if(!e.isHuman()) {
				if(ent.isSeeing(e, vision)) {
					++nb;
					distX += ent.x - e.x;
					distY += ent.y - e.y;
				}
				else if(arme != null) {
					if(ent.isSeeing(e,arme.range)) {
						arme.shoot(e);
					}
				};
			}
		}
		double angle = Math.atan2(distY/nb, distX/nb);
		if(!(nb == 0)) {
			ent.vx = v * Math.cos(angle);
			ent.vy = v * Math.sin(angle);
		}
		super.moove();
	}
}
