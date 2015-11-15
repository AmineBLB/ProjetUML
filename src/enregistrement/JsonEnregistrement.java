package enregistrement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.ShapeGroup;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Amine on 15/11/2015.
 */
public class JsonEnregistrement implements enregistrementVisitor {

    static JSONObject document = new JSONObject();
    JSONArray lineArray = new JSONArray();
    JSONArray circleArray = new JSONArray();
    JSONArray polylineArray = new JSONArray();

    static int cN;
    static int lN;
    static int pN;


    public JsonEnregistrement() {

        try {
            document.put("Line", lineArray);
            document.put("Circle", circleArray);
            document.put("Polyline", polylineArray);
        } catch (JSONException e) {
        }

    }


    @Override
    public void visit(Circle c) {
        cN++;
        circleArray.put("Circle" + cN + " Radius=" + c.getMyRadius() + " , Center :" + c.getMyCenter());
    }

    @Override
    public void visit(Line l) {
        lN++;
        lineArray.put("Line" + lN + " " + l.getMyEnd() + " - " + l.getMyStart());

    }

    @Override
    public void visit(PolyLine p) {

    }

    @Override
    public void visit(ShapeGroup g) {

    }

    public static void export() {
        // try-with-resources statement based on post comment below :)
        try {
            FileWriter file = new FileWriter("./JSONexport");
            file.write(document.toString());
            System.out.print(document);
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + document);

            file.flush();
            file.close();

        } catch (IOException e) {

        }


    }
}
