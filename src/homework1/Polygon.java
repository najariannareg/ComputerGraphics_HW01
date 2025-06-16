package homework1;

import library.ScanConversion;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Polygon {

    private ArrayList<Point> points = new ArrayList<>();
    private int[] color = {255, 255, 255};


    public Polygon(){}


    public int[] getColor(){
        return color;
    }

    public void setColor(int[] color){
        for(int i = 0; i < 3; i++)
            this.color[i] = color[i];
    }

    public int size(){
        return points.size();
    }


    public void addPoint(Point p){
        points.add(p);
    }

    public void clearPoints(){
        points.clear();
    }


    public void drawOpen(BufferedImage image){
        if(points.size() == 1){
            Point p = points.get(0);
            image.getRaster().setPixel(p.getX(), p.getY(), color);
        }
        for(int i=0; i<points.size()-1; i++){
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            ScanConversion.bresenhamLine(p1.getX(), p1.getY(), p2.getX(), p2.getY(), image, color);
        }
    }

    public void drawClosed(BufferedImage image){
        drawOpen(image);
        if(points.size() >= 3){
            Point p1 = points.get(0);
            Point p2 = points.get(points.size()-1);
            ScanConversion.bresenhamLine(p1.getX(), p1.getY(), p2.getX(), p2.getY(), image, color);
        }
    }


    public Point centroid(){
        int x = 0, y = 0;
        for(Point p: points){
            x += p.getX();
            y += p.getY();
        }
        x /= points.size();
        y /= points.size();
        return new Point(x, y);
    }


    public void translate(int tx, int ty) {
        for(Point p: points){
            p.translate(tx, ty);
        }
    }

    public void rotate(float angle) {
        Point c = centroid();
        for(Point p: points){
            p.rotate(c.getX(), c.getY(), angle);
        }
    }

    public void scale(float sx, float sy) {
        Point c = centroid();
        for(Point p: points){
            p.scale(c.getX(), c.getY(), sx, sy);
        }
    }


    public void printPoints(){
        System.out.print("{");
        for(int i=0; i<points.size(); i++) {
            points.get(i).printPoint();
            System.out.print(i<points.size()-1? ", ": "}");
        }
        System.out.println();
    }

}
