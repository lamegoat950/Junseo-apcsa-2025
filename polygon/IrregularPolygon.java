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
        double perimeter = 0.0;
        int n = myPolygon.size();

        if(n>1) {
            for(int i = 0; i < n; i++) {
                Point2D.Double p1 = myPolygon.get(i); 
                Point2D.Double p2 = myPolygon.get((i + 1) % n);
                             perimeter += p1.distance(p2);
            }
        }
        return perimeter;
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
            // source: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            int i = myPolygon.size();
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));


            myDrawingTool.up();
            myDrawingTool.move(myDrawingTool.getXPos() - 100, myDrawingTool.getYPos());
            myDrawingTool.down();
            for(int n = 0; n < i; n++) {
                Point2D.Double p = myPolygon.get(i);


                myDrawingTool.move(myDrawingTool.getXPos() + p.getX(), myDrawingTool.getXPos() + p.getY());
                    
            }
            myDrawingTool.up();
            myDrawingTool.move(myDrawingTool.getXPos() + 50, myDrawingTool.getYPos());
            myDrawingTool.down();

        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
