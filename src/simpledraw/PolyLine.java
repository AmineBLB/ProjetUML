package simpledraw;

import enregistrement.enregistrementVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PolyLine
	extends Shape {
	/**
	 * The points of this simpledraw.PolyLine
	 */
	private final List<Point> myPoints;

	public PolyLine(Collection<Point> points) {
		if (points.size() < 2) {
			throw new IllegalArgumentException(
				"A simpledraw.PolyLine needs at least 2 Points");
		}
		myPoints = new ArrayList<Point>(points);
	}

	public List<Point> getMyPoints() {
		return myPoints;
	}

	public void accept(enregistrementVisitor v) {
		v.visit(this);
	}



	public void translateBy(int dx, int dy) {
		Iterator i = myPoints.iterator();
		while (i.hasNext()) {
			Point p = (Point) i.next();
			p.translate(dx, dy);
		}
	}


	public void draw(Graphics2D g) {
		g.setColor(
			isSelected() ?
			Color.red :
			Color.black
			);

		Iterator<Point> points = myPoints.iterator();
		// A polyline has at least two points
		Point last = points.next();
		do {
			Point current = points.next();
			g.drawLine(last.x, last.y, current.x, current.y);
			last = current;
		}
		while (points.hasNext());
	}

	public boolean isPickedBy(Point p) {
		boolean result = false;
		Iterator<Point> points = myPoints.iterator();
		// A polyline has at least two points
		Point last = points.next();
		do {
			Point current = points.next();
			if (Line.segmentIsPickedBy(last, current, p)) {
				result = true;
				break;
			}
			last = current;
		}
		while (points.hasNext());

		return result;
	}



}
