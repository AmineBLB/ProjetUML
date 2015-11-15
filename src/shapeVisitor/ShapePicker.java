package shapeVisitor;


import simpledraw.*;

import java.awt.Point;
import java.util.Iterator;

/**
 *
 * @author John Doe
 */
public class ShapePicker implements ShapeVisitor{
    
    private Point p;
    private boolean picked;
    
    public boolean isPicked(){
        return picked;
    }
    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public ShapePicker(Point p) {
        this.p = p;
    }
    
    
    public void visit(Circle c) {
        picked = (Math.abs(c.getMyCenter().distance(p) - c.getMyRadius()) <= 2);
    }

    public void visit(Line l) {
        picked = Line.segmentIsPickedBy(l.getMyStart(), l.getMyEnd(), p);
    }

    public void visit(PolyLine pl) {
        
        boolean result = false;
		Iterator<Point> points = pl.getMyPoints().iterator();
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
        
        picked = result;
    }
    
}
