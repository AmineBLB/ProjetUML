package enregistrement;

import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.ShapeGroup;

/**
 * Created by Amine on 15/11/2015.
 */
public interface enregistrementVisitor {

    public void visit(Circle c);
    public void visit(Line l);
    public void visit(PolyLine p);
    public void visit(ShapeGroup g);

}
