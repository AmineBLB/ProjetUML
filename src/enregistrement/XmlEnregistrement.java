package enregistrement;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.ShapeGroup;

import java.io.FileOutputStream;


public class XmlEnregistrement implements enregistrementVisitor {
    //Nous allons commencer notre arborescence en créant la racine XML
    //qui sera ici "personnes".
    static Element racine = new Element("Shapes");

    static Element lineNode = new Element("Line");
    static Element circleNode = new Element("Circle");
    static Element polylineNode = new Element("Polyline");

    static int cN;
    static int lN;
    static int pN;

    //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
    static Document document = new Document(racine);


    public XmlEnregistrement() {
        racine.addContent(lineNode);
        racine.addContent(circleNode);
        racine.addContent(polylineNode);
    }

    @Override
    public void visit(Circle c) {
        cN++;

        Element circle = new Element("Circle");
        circle.setAttribute("Center", c.getMyCenter().toString());
        circle.setAttribute("Radius", c.getMyRadius() + "");

        circleNode.addContent(circle);
    }

    @Override
    public void visit(Line l) {
        lN++;

        Element line = new Element("Line");
        line.setAttribute("Center", l.getMyEnd().toString());
        line.setAttribute("Radius", l.getMyStart() + "");

        lineNode.addContent(line);

    }

    @Override
    public void visit(PolyLine p) {
        //pN++;
        // p.getMyPoints();
    }

    @Override
    public void visit(ShapeGroup g) {

    }

    public static void export() {
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, System.out);
            sortie.output(document, new FileOutputStream("Fichier.xml"));

        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
