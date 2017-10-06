package chap34;

import java.util.ArrayList;

public class Triangle {
    private ArrayList<Point> coordinates = new ArrayList<Point>();

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Point point3 = new Point(x3, y3);
        coordinates.add(point1);
        coordinates.add(point2);
        coordinates.add(point3);
    }

    public double getSide1Length(){
        return coordinates.get(0).calcDistance(coordinates.get(1));
    }

    public double getSide2Length(){
        return coordinates.get(2).calcDistance(coordinates.get(0));
    }

    public double getSide3Length(){
        return coordinates.get(1).calcDistance(coordinates.get(2));
    }

    public double getPerimeter(){
        return getSide1Length()+getSide2Length()+getSide3Length();
    }

    public double getArea(){
        double semiPerimeter = getPerimeter()/2;
        return Math.sqrt(semiPerimeter*(semiPerimeter-getSide1Length())*(semiPerimeter-getSide2Length())*(semiPerimeter-getSide3Length()));
    }

    public double getAngle3(){
        double s1 = getSide1Length();
        double s2 = getSide2Length();
        double s3 = getSide3Length();
        double cosine = (s3*s3+s1*s1-s2*s2)/(2*s3*s1);
        return Math.toDegrees(Math.acos(cosine));
    }

    public double getAngle2(){
        double s1 = getSide1Length();
        double s2 = getSide2Length();
        double s3 = getSide3Length();
        double cosine = (s2*s2+s3*s3-s1*s1)/(2*s2*s3);
        return Math.toDegrees(Math.acos(cosine));
    }

    public double getAngle1(){
        double s1 = getSide1Length();
        double s2 = getSide2Length();
        double s3 = getSide3Length();
        double cosine = (s1*s1+s2*s2-s3*s3)/(2*s1*s2);
        return Math.toDegrees(Math.acos(cosine));
    }

    public Point getCircumcenter(){
        double x0 = coordinates.get(0).getX();
        double y0 = coordinates.get(0).getY();
        double y1 = coordinates.get(1).getY();
        double x1 = coordinates.get(1).getX();
        double x2 = coordinates.get(2).getX();
        double y2 = coordinates.get(2).getY();
        double a = (x1-x0)/(y1-y0);
        double b = 1;
        double c = (x1*x1-x0*x0)/(2*(y1-y0))+(y0+y1)/2;
        double d = (x2-x1)/(y2-y1);
        double e = 1;
        double f = (x2*x2-x1*x1)/(2*(y2-y1))+(y1+y2)/2;

        double xCoord = (f*b-e*c)/(b*d-e*a);
        double yCoord = (c-a*xCoord)/b;
        return new Point(xCoord, yCoord);
    }

    public Point getCentroid(){
        double xAvg = (coordinates.get(0).getX()+coordinates.get(1).getX()+coordinates.get(2).getX())/3;
        double yAvg = (coordinates.get(0).getY()+coordinates.get(1).getY()+coordinates.get(2).getY())/3;
        return new Point(xAvg, yAvg);
    }
}
