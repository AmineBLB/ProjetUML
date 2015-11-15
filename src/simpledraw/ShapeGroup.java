package simpledraw;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import enregistrement.enregistrementVisitor;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author boulbamo
 */
public class ShapeGroup extends Shape {

    public ArrayList<Shape> getLshape() {
        return lshape;
    }

    private ArrayList<Shape> lshape = new ArrayList<Shape>();

    // Composite design pattern ////////////////////////////////////////////////
    public void group(Shape shape) {
        lshape.add(shape);
    }

    public void deGroup(Shape shape) {
        lshape.remove(shape);

    }

    public Boolean Contains(Shape shape) {
        return lshape.contains(shape);
    }
    ////////////////////////////////////////////////////////////////////////////

    @Override
    public void setSelected(boolean selected) {
        for (Shape shape : lshape) {
            if (shape != null) {
                shape.setSelected(selected);
            }
        }
    }

    @Override
    public boolean isSelected() {
        boolean bool = true;
        boolean enter = false;
        for (Shape shape : lshape) {
            enter = true;
            bool = bool && shape.isSelected();

        }

        if (enter) {
            return bool;
        } else {
            return false;
        }
    }

    /**
     * Le dessin du groupe se fera par des dessins individuels
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {

        for (Shape shape : lshape) {
            shape.draw(g);
        }
    }

    /**
     * La translation du groupe se fera par des translations individuelles
     *
     * @param dx abcisse
     * @param dy ordonnées
     */
    @Override
    public void translateBy(int dx, int dy) {
        for (Shape shape : lshape) {
            shape.translateBy(dx, dy);
        }
    }

    /**
     * Vérification séquentielle des shape
     *
     * @param p
     * @return
     */
    @Override
    public boolean isPickedBy(Point p) {
        for (Shape shape : lshape) {
            if (shape.isPickedBy(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void accept(enregistrementVisitor v) {
        v.visit(this);
    }


    public void removeAll(){
    lshape.clear();}

}
