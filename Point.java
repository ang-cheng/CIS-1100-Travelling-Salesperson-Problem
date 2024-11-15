/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 * Taken from section 3.2, An Introduction to Programming (in Java) by Robert
 * Sedgewick and Kevin Wayne
 *
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *
 *  Immutable data type for 2D points.
 *
 *************************************************************************/

/**
 * A point class
 */
public class Point { 
    public final double x;   // Cartesian
    public final double y;   // coordinates
   
    /**
     * create and initialize a point with given (x, y)
     * @param x x-coordinate of point
     * @param y y-coordinate of point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns Euclidean distance to point p
     * @param  p target point
     * @return Euclidean distance from this point to point p
     * @throws NullPointerException if p is null
     */
    public double distanceTo(Point p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * draws this point using standard draw
     */
    public void draw() {
        PennDraw.point(x, y);
    }

    /**
     * draws the line from this point to point p
     * @param p end-point of line
     * @throws NullPointerException if p is null
     */
    public void drawTo(Point p) {
        PennDraw.line(x, y, p.x, p.y);
    }

    /**
     * returns string representation of this point
     * @return string representation of this point
     */
    public String toString() {
        return "(" + x + ", " + y + ")\n";
    }

    // test client
    public static void main(String[] args) {
        // get dimensions
        In inStream = new In(args[0]);
        int w = inStream.readInt();
        int h = inStream.readInt();
        PennDraw.setCanvasSize(w, h);
        PennDraw.setXscale(0, w);
        PennDraw.setYscale(0, h);
        PennDraw.setPenRadius(.005);

        // read in and plot points one at at time
        while (!inStream.isEmpty()) {
            double x = inStream.readDouble();
            double y = inStream.readDouble();
            Point p = new Point(x, y);
            p.draw();
        }
    }
}
