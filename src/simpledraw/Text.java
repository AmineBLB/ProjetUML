package simpledraw;

/**
 * simpledraw.Drawing, a collection of Shapes
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Shape
 */

import java.util.*;

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JLabel;

public class Text extends Observable {
	/**
	 * A drawing is a collection of shapes
	 */
	private List<String> myText = new LinkedList<String>();

	public Text() {
	}

	/**
	 * Displays the drawing
	 * 
	 * @param g
	 *            The Graphics to display on
	 **/
	public void draw() {
		for (String s : myText)
			System.out.println(" ");
	}

	/**
	 * Add a shape to the simpledraw.Drawing
	 * 
	 * @param s
	 *            The simpledraw.Shape to add
	 **/
	public void addShape(String s) {
		myText.add(s);

		// mvc
		setChanged();
		notifyObservers();
	}

	/**
	 * Delete a shape from the simpledraw.Drawing
	 * 
	 * @param s
	 *            The simpledraw.Shape to delete
	 **/
	public void deleteShape(String s) {
		myText.remove(s);
	}

	/**
	 * Determines whether the given Point lies whithin a simpledraw.Shape
	 * 
	 * @param p
	 *            The Point to test
	 * @return A simpledraw.Shape selected by this Point or null if no
	 *         simpledraw.Shape is there
	 **/
	public Shape pickShapeAt(Point p) {
		/*
		 * String result = null; for (String s : myText) if (s.isPickedBy(p)) {
		 * result = s; break; } return result;
		 */
		return null;
	}

	/**
	 * Ensures that no simpledraw.Shape is currently selected
	 */
	public void clearSelection() {
		/*
		 * for (String s : myShapes) s.setSelected(false);
		 */
		myText.clear();
	}
}
