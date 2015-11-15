package shapeVisitor;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Iterator;

/**
 *
 * @author John Doe
 */
public class ShapeDrawer implements ShapeVisitor{
    
    private Graphics2D g;

    public Graphics2D getG() {
        return g;
    }

    public void setG(Graphics2D g) {
        this.g = g;
    }
    
    public ShapeDrawer(Graphics2D g){
        this.g  = g;
    }

    public void visit(Circle c) {
        g.setColor(
			c.isSelected() ?
			Color.red :
			Color.black
			);
		g.drawOval( c.getMyCenter().x - c.getMyRadius(),
			   c.getMyCenter().y - c.getMyRadius(),
			   c.getMyRadius() * 2,
			   c.getMyRadius() * 2
			);
    }

    public void visit(Line l) {
        g.setColor(
			l.isSelected() ?
			Color.red :
			Color.black
			);
		g.drawLine( l.getMyStart().x, l.getMyStart().y, l.getMyEnd().x, l.getMyEnd().y);
    }

    public void visit(PolyLine pl) {
        g.setColor(
			pl.isSelected() ?
			Color.red :
			Color.black
			);

		Iterator<Point> points = pl.getMyPoints().iterator();
		// A polyline has at least two points
		Point last = points.next();
		do {
			Point current = points.next();
			g.drawLine(last.x, last.y, current.x, current.y);
			last = current;
		}
		while (points.hasNext());
    }
    
    
}
