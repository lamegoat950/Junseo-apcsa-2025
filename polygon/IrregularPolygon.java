package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        return 3.14;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        int n = myPolygon.size();
        if(n>2) {
                for(int i =0; i < n; i++) {
                    Point2D.Double p1 = myPolygon.get(i);
                    Point2D.Double p2 = myPolygon.get((i+1)%n);
                    area += (p1.getX() * p2.getY() - p2.getX() * p1.getY());
                }
                area = Math.abs(area/2.0);
        }
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
