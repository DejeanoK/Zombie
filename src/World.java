import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

import javax.swing.JPanel;

public class World extends JPanel{
	private LinkedList<Entity> entities;
	private LinkedList<Projectile> projectiles;
	public World(LinkedList<Entity> ent, LinkedList<Projectile> p) {
		this.setPreferredSize(new Dimension(Constant.width,Constant.height));
		this.entities = ent;
		this.projectiles = p;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.green);
		for(Entity ent : entities) {
			if(ent.isHuman()) {
				g2d.setColor(Color.blue);
			}
			else {
				g2d.setColor(Color.green);
				
			}
			g2d.fill(new Rectangle2D.Double(ent.x, ent.y, ent.size, ent.size));
			//g2d.draw(new Ellipse2D.Double(ent.x - ent.state.vision/2.0  +ent.size/2.0, ent.y - ent.state.vision/2.0 +ent.size/2.0, ent.state.vision, ent.state.vision));
		}
		g2d.setColor(Color.red);
		LinkedList<Projectile> tmp = new LinkedList<>(projectiles);
		for(Projectile p : tmp) {
			g2d.fill(new Rectangle2D.Double(p.x,p.y,p.width,p.height));
		}
		
	}
}
