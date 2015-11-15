/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simpledraw;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author John Doe
 */
public class DrawingModel extends  Drawing{

    private Set<DrawingView> myViews = new HashSet<DrawingView>();
    
    public void addView(DrawingView view){
        myViews.add(view);
        view.notify(this);
    }
    
    public void removeView(DrawingView view){
        myViews.remove(view);
    }
    
    protected void notifyViews(){
        if(null != myViews){
            for(DrawingView view : myViews){
                view.notify(this);
            }
        }
    }
    
    public DrawingModel() {
        super();
    }
    
    
    /**
    * Displays the drawing
    * @param g     The Graphics to display on
    **/
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        notifyViews();
    }
        
    /**
     * Add a shape to the Drawing
     * @param s     The Shape to add
     **/
    @Override
    public void addShape(Shape s) {
            super.addShape(s);
            notifyViews();
    }
        
    /**
     * Delete a shape from the Drawing
     * @param s     The Shape to delete
     **/
    @Override
    public void deleteShape(Shape s) {
            super.deleteShape(s);
            notifyViews();
    }
        
        
    /**
     * Determines whether the given Point lies whithin a Shape
     * @param p     The Point to test
     * @return      A Shape selected by this Point or null if no Shape is there
     **/
    @Override
    public Shape pickShapeAt(Point p) {
            Shape s = super.pickShapeAt(p);
            notifyViews();
            return s;
    }
        
    /**
     * Ensures that no Shape is currently selected
     */
    @Override
    public void clearSelection() {
        super.clearSelection();
        notifyViews();
    }
}
