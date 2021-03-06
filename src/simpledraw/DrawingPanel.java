package simpledraw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * A Panel that displays a simpledraw.Drawing, and maintains a current simpledraw.DrawingTool<BR>
 * Uses the "State" design pattern
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Drawing
 * @see simpledraw.DrawingTool
 */

public class DrawingPanel extends JPanel {
    DrawingTool myCurrentTool;
    Drawing myDrawing = new Drawing();

	public DrawingPanel() {
		super();
		setBackground(java.awt.Color.white);
		myCurrentTool = new SelectionTool(this);
		activate(myCurrentTool);
		//mvc
		myDrawing.addObserver(this);
	}

	void activateSelectionTool() {
		terminate(myCurrentTool);
		myCurrentTool = new SelectionTool(this);
		activate(myCurrentTool);
	}

	void activateCircleTool() {
		terminate(myCurrentTool);
		myCurrentTool = new CircleTool(this);
		activate(myCurrentTool);
		myDrawing.clearSelection();
		repaint();
	}

    void activateLineTool() {
        terminate(myCurrentTool);
        myCurrentTool = new LineTool(this);
        activate(myCurrentTool);
        myDrawing.clearSelection();
        repaint();
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(qualityHints);
		myDrawing.draw(g2);
		myCurrentTool.draw(g2);
	}

	private void terminate(DrawingTool t) {
		removeKeyListener(t);
		removeMouseListener(t);
		removeMouseMotionListener(t);
	}

	private void activate(DrawingTool t) {
		addKeyListener(t);
		addMouseListener(t);
		addMouseMotionListener(t);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
