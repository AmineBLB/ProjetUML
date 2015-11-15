package simpledraw;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author boulbamo
 */
public class GroupingTool extends DrawingTool {
    private boolean iAmActive = false;
    private Shape mySelectedShape = null;
    private Point myLastPoint;
    
    public GroupingTool(DrawingPanel panel) {
        super(panel);
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
        if (!iAmActive) {
			// First point
			iAmActive = true;
			
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.
				MOVE_CURSOR));
			myPanel.repaint();
		} else {
			// Second point
			iAmActive = false;
			
			myPanel.setCursor(Cursor.getDefaultCursor());
			myPanel.repaint();
		}
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
            
    @Override
    void draw(Graphics2D g) {
  
    }
    
}
