package animation;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class BouncingBall implements MoveableShape {
	private int x;
	private int y;
	private int radius;
	
	public BouncingBall(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		Ellipse2D.Double ball = new Ellipse2D.Double(x, y, radius, radius);
		g2.draw(ball);
	}

	@Override
	public void move() {
		y++;
	}


}
