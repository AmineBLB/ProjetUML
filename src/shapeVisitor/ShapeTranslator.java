package shapeVisitor;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Point;
import java.util.Iterator;

/**
 *
 * @author John Doe
 */
public class ShapeTranslator implements ShapeVisitor{

    private int dx;
    private int dy;

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public ShapeTranslator(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    
    public void visit(Circle c) {
       c.getMyCenter().translate(dx, dy);
    }

    public void visit(Line l) {
        l.getMyStart().translate(dx, dy);
        l.getMyEnd().translate(dx, dy);
    }

    public void visit(PolyLine pl) {
        Iterator i = pl.getMyPoints().iterator();
		while (i.hasNext()) {
			Point p = (Point) i.next();
			p.translate(dx, dy);
		}
    }
    
}
