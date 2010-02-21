import java.awt.*;
import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    
    //public int compare(Point a, Point b) throws InvalidPointException {
    public int compare(Point a, Point b) {
        double ax = a.getX();
        double bx = b.getX();
        if (ax > bx)
            return 1;
        if (ax == bx)
            return 0;
        if (ax < bx)
            return -1;
        //throw new InvalidPointException();
        //This should never, ever happen
        //Throw an exception here?
        return -1000;
    }

    public boolean equals(Point p) {
        return false;
    }
}
