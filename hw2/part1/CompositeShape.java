import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class CompositeShape implements Shape{
	private ArrayList<Shape> shapes;
	
	public CompositeShape() {
		shapes = new ArrayList<Shape>();
	}

	@Override
	public Rectangle getBounds() {
		if (shapes.size() == 0) { // no shapes in this array
			return new Rectangle(); // return rectangle 0 by 0
		}else {
			Rectangle rect = new Rectangle();
			for (Shape shape : shapes) {
				rect.union(shape.getBounds());
			}
			return rect;
		}
	}

	@Override
	public Rectangle2D getBounds2D() {
		if (shapes.size() == 0) {
			return new Rectangle2D.Double();
		}else {
			Rectangle2D rect2d = shapes.get(0).getBounds2D();
			for (int i = 1; i < shapes.size(); i++) {
				Rectangle2D.union(rect2d, shapes.get(i).getBounds(), rect2d);
			}
			return rect2d;
		}
	}

	@Override
	public boolean contains(double x, double y) {
		for (Shape shape : shapes) {
			if (shape.contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(Point2D p) {
		for (Shape shape : shapes) {
			if (shape.contains(p)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		for (Shape shape : shapes) {
			if (shape.intersects(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		for (Shape shape : shapes) {
			if (shape.intersects(r)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		for (Shape shape : shapes) {
			if (shape.contains(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(Rectangle2D r) {
		for (Shape shape : shapes) {
			if (shape.contains(r)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		CompositePathIterator compIter = new CompositePathIterator();
		for (Shape shape : shapes) {
			compIter.add(shape.getPathIterator(at));
		}
		return compIter;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		CompositePathIterator compIter = new CompositePathIterator();
		for (Shape shape : shapes) {
			compIter.add(shape.getPathIterator(at, flatness));
		}
		return compIter;
	}
	
	class CompositePathIterator implements PathIterator{
		ArrayList<PathIterator> iterators;
		
		public CompositePathIterator() {
			iterators = new ArrayList<PathIterator>();
		}
		
		public void add(PathIterator path) {
			iterators.add(path);
		}
		
		public int getWindingRule() {
			if (isDone()) {
				return 0;
			}else {
				PathIterator current = iterators.get(0);
				return current.getWindingRule();
			}
		}
		
		public boolean isDone() {
			return iterators.size() == 0;
		}
		
		public void next() {
			PathIterator currentIter = iterators.get(0);
			currentIter.next();
			
			if (currentIter.isDone()) {
				iterators.remove(0);
			}
		}
		
		public int currentSegment(float[] coords) {
			PathIterator currentIter = iterators.get(0);
			return currentIter.currentSegment(coords);
		}
		
		public int currentSegment(double[] coords) {
			PathIterator currentIter = iterators.get(0);
			return currentIter.currentSegment(coords);
		}
	}
	
	
	/**
	 * 
	 * @param shape
	 */
	public void add(Shape shape) {
		shapes.add(shape);
	}

}
