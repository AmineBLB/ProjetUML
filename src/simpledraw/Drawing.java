package simpledraw; /**
 * simpledraw.Drawing, a collection of Shapes
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Shape
 */

import java.util.*;

import java.awt.Graphics2D;
import java.awt.Point;

public class Drawing {

	/**
	 * A drawing is a collection of shapes
	 */
	private static List<Shape> myShapes = new LinkedList<Shape>();

	public Drawing() {
	}


	public static List<Shape> getMyShapes() {
		return myShapes;
	}


	/**
	 * Displays the drawing
	 * @param g     The Graphics to display on
	 **/

	public void draw(Graphics2D g) {
		for(Shape s : myShapes)
			s.draw(g);
	}

	/**
	 * Add a shape to the simpledraw.Drawing
	 * @param s     The simpledraw.Shape to add
	 **/
	public void addShape(Shape s) {
		myShapes.add(s);
	}

	/**
	 * Delete a shape from the simpledraw.Drawing
	 * @param s     The simpledraw.Shape to delete
	 **/
	public void deleteShape(Shape s) {
		myShapes.remove(s);
	}

	/**
	 * Determines whether the given Point lies whithin a simpledraw.Shape
	 * @param p     The Point to test
	 * @return      A simpledraw.Shape selected by this Point or null if no simpledraw.Shape is there
	 **/
	public Shape pickShapeAt(Point p) {
		Shape result = null;
		for (Shape s : myShapes)
			if (s.isPickedBy(p)) {
				result = s;
				break;
			}
		return result;
	}

	/**
	 * Ensures that no simpledraw.Shape is currently selected
	 */
	public void clearSelection() {
		for (Shape s : myShapes)
			s.setSelected(false);
	}
}
