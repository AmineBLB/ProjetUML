package simpledraw;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The tool to select, move and delete Shapes in the simpledraw.Drawing
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class SelectionTool
        extends DrawingTool {

    private Shape mySelectedShape = null;
    private ShapeGroup pickedShapeGroup = new ShapeGroup();

    private Point myLastPoint;

    public SelectionTool(DrawingPanel panel) {
        super(panel);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            if (mySelectedShape != null) {
                myDrawing.deleteShape(mySelectedShape);
                myPanel.repaint();
            }

            if (pickedShapeGroup != null) {
                myDrawing.deleteShape(pickedShapeGroup);
                myPanel.repaint();
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (!e.isShiftDown()) {
           
              //  pickedShapeGroup.removeAll();
            //pickedShapeGroup.setSelected(false);
            Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
            myLastPoint = e.getPoint();
            if (mySelectedShape != null) {
                mySelectedShape.setSelected(false);
            }
            mySelectedShape = pickedShape;
            if (mySelectedShape != null) {
                mySelectedShape.setSelected(true);
                myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }else{  pickedShapeGroup.setSelected(false);pickedShapeGroup.removeAll();
            }
            myPanel.repaint();
        } else {
            Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
            if (pickedShape != null) {
                if (!pickedShapeGroup.Contains(pickedShape)) {
                    pickedShapeGroup.group(pickedShape);
                    myLastPoint = e.getPoint();
                    pickedShapeGroup.setSelected(true);
                    myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                    myPanel.repaint();
                } else {
                    pickedShapeGroup.setSelected(false);
                    pickedShapeGroup.deGroup(pickedShape);
                    pickedShapeGroup.setSelected(true);
                    myLastPoint = e.getPoint();
                    myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                    myPanel.repaint();

                }
            } else {
                pickedShapeGroup.setSelected(false);
                pickedShapeGroup.removeAll();
            }

        }

    }

    public void mouseReleased(MouseEvent e) {
        mouseMoved(e);
    }

    public void mouseMoved(MouseEvent e) {
        Shape pickedShape = myPanel.myDrawing.pickShapeAt(e.getPoint());
        if (pickedShape != null) {
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            myPanel.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void mouseDragged(MouseEvent e) {

        if (pickedShapeGroup.isSelected()) {

            pickedShapeGroup.translateBy(
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
            myPanel.repaint();
        } else if (mySelectedShape != null) {
            mySelectedShape.translateBy(
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
            myPanel.repaint();
        }

    }

    void draw(Graphics2D g) {
    }

}
