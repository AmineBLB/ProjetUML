package simpledraw;

import enregistrement.enregistrementVisitor;

import java.awt.*;

/**
 * A circle
 **/

public class Circle
	extends Shape {
	private Point myCenter;
	private int myRadius;

	public Point getMyCenter() {
		return myCenter;
	}

	public int getMyRadius() {
		return myRadius;
	}

	/**
	 * Construct a simpledraw.Circle

	 * @param center        The center of the circle
	 * @param radius        The radius of the circle
	 **/
	public Circle(Point center, int radius) {
		myCenter = center;
		myRadius = radius;
	}


	public void draw(Graphics2D g) {
		g.setColor(
			isSelected() ?
			Color.red :
			Color.black
			);
		g.drawOval(myCenter.x - myRadius,
			   myCenter.y - myRadius,
			   myRadius * 2,
			   myRadius * 2
			);
	}

	public void translateBy(int dx, int dy) {
		myCenter.translate(dx, dy);
	}

	public boolean isPickedBy(Point p) {
		return (Math.abs(myCenter.distance(p) - myRadius) <= 2);
	}



	public void setMyCenter(Point myCenter) {
		this.myCenter = myCenter;
	}

	public void setMyRadius(int myRadius) {
		this.myRadius = myRadius;
	}

	public void accept(enregistrementVisitor v) {
		v.visit(this);
	}
}