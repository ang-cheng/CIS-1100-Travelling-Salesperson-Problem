/**
 * Name: Angelina Cheng
 * Pennkey: angcheng
 * Execution: java Tour
 *
 * Description: will print the points a, b, c, and d in String form, and draw the
 * points out, highlighting the edges connected to point a
**/

public class Tour implements TourInterface {

    // head and lastNode are different instances but store the SAME Point object
    // two different Nodes in memory, each containing a reference to the same Point
    private Node head; // first Node in Tour
    private Node lastNode; // last Node in Tour - when appending a Node, it will go
                          // BEFORE this Node; lastNode is always last in the Tour

    
    // constructor that creates an empty Tour
    public void Tour() {
        head = null;
        lastNode = null;
    }

    /*
    * Description: create a String representation of the Tour
    *
    * Input: N/A
    *
    * Output: String representation of the Tour
    */
    public String toString() {
        String rep = "";
        if (head == null && lastNode == null) {
            return rep;
        } else {
            // add all Nodes to String, except lastNode
            Node curr = head;
            while (curr != lastNode) {
                Point currPoint = curr.point;
                String currString = "(";
                currString += Double.toString(currPoint.x) + ", ";
                currString += Double.toString(currPoint.y) + ")\n"; 
                rep = rep + currString; 
                curr = curr.next;
            }
        }
        // add lastNode to the String
        Point lastNodePoint = lastNode.point;
        rep += "(" + Double.toString(lastNodePoint.x) + ", ";
        rep += Double.toString(lastNodePoint.y) + ")\n"; 
        return rep;
    }

    /*
    * Description: draw the Tour using PennDraw; any edge starting or ending at p
    * should be in a distinct color
    *
    * Input: a Point p
    *
    * Output: N/A
    */
    public void draw(Point p) {
        if (head == null && lastNode == null) {
            return;
        } else {
            Node curr = head;
            while (curr != lastNode) {
                // draw line between points
                Point thisPoint = curr.point;
                Point nextPoint = curr.next.point;
                PennDraw.setPenColor(PennDraw.BLACK);
                if (thisPoint == p || nextPoint == p) {
                        PennDraw.setPenColor(PennDraw.RED);
                        thisPoint.drawTo(nextPoint);
                } else {
                    thisPoint.drawTo(nextPoint);
                }
                // advance curr
                curr = curr.next;
            }
        }
    }

    /*
    * Description: returns the number of points in this Tour
    *
    * Input: N/A
    *
    * Output: an integer of the number of points in this Tour
    */
    public int size() {
        int count = 0;
        if (head == null && lastNode == null) {
            return count;
        } else {
            // for each Node increment count integer
            Node curr = head;
            while (curr != lastNode) {
                count++;
                curr = curr.next;
            }
            return count;
        }
    }

    /*
    * Description: returns the total distance of this Tour
    *
    * Input: N/A
    *
    * Output: a double containing the total distance of this Tour
    */
    public double distance() {
        double tourDistance = 0.0;
        if (head == null && lastNode == null) {
            return tourDistance;
        } else {
            // add distances to total distance
            Node curr = head;
            while (curr != lastNode) {
                Point thisPoint = curr.point;
                Point nextPoint = curr.next.point;
                tourDistance += thisPoint.distanceTo(nextPoint);
                curr = curr.next;
            }
            return tourDistance;
        }
    }

    /*
    * Description: insert a Point p at the end of this Tour
    *
    * Input: a Point p
    *
    * Output: N/A
    */
    public void insertInOrder(Point p) {
        if (head == null && lastNode == null) {
            lastNode = new Node(p);
            head = new Node(lastNode, p);
        } else {
            // iterate to second to last Node, then insert new Node
            Node curr = head;
            while (curr.next != lastNode) {
                curr = curr.next;
            }
            Node newNode = new Node(lastNode, p);
            curr.next = newNode;
        }
    }

    /*
    * Description: insert a Point p using the nearest neighbor heuristic
    *
    * Input: a Point p
    *
    * Output: N/A
    */
    public void insertNearest(Point p) {
        if (head == null && lastNode == null) {
            lastNode = new Node(p);
            head = new Node(lastNode, p);
        } else {
            // calculate leastDistance
            double leastDistance = Double.MAX_VALUE;
            Node curr = head;
            while (curr != lastNode) {
                Point thisPoint = curr.point;
                double thisDistance = thisPoint.distanceTo(p);
                if (thisDistance < leastDistance) {
                    leastDistance = thisDistance;
                }
                curr = curr.next;
            }
            // insert Node at the first position where distance is equal to the
            // least distance
            curr = head;
            while (curr != lastNode) {
                Point thisPoint = curr.point;
                double thisDistance = thisPoint.distanceTo(p);
                if (thisDistance == leastDistance) {
                    Node newNode = new Node(curr.next, p);
                    curr.next = newNode;
                    return;
                }
                curr = curr.next;
            }
        }
    }

    /*
    * Description: insert a Point p using the smallest-increase heuristic
    *
    * Input: a Point p
    *
    * Output: N/A
    */
    public void insertSmallest(Point p) {
        if (head == null && lastNode == null) {
            lastNode = new Node(p);
            head = new Node(lastNode, p);
        } else {
            // find the least incremental distance
            double leastDistance = Double.MAX_VALUE;
            Node curr = head;
            while (curr != lastNode) {
                Point thisPoint = curr.point;
                Point nextPoint = curr.next.point;
                double original = thisPoint.distanceTo(nextPoint);
                double sp = thisPoint.distanceTo(p);
                double pt = p.distanceTo(nextPoint);
                double incremental = sp + pt - original;
                if (incremental < leastDistance) {
                    leastDistance = incremental;
                }
                curr = curr.next;
            }
            // insert Node at the first position where the incremental distance is
            // equal to the least incremental distance
            curr = head;
            while (curr != lastNode) {
                Point thisPoint = curr.point;
                Point nextPoint = curr.next.point;
                double original = thisPoint.distanceTo(nextPoint);
                double sp = thisPoint.distanceTo(p);
                double pt = p.distanceTo(nextPoint);
                double incremental = sp + pt - original;
                if (incremental == leastDistance) {
                    Node newNode = new Node(curr.next, p);
                    curr.next = newNode;
                    return;
                }
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        // required testing as described in the write-up
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);
        Tour newTour = new Tour();
        newTour.insertInOrder(a);
        newTour.insertInOrder(b);
        newTour.insertInOrder(c);
        newTour.insertInOrder(d);
        System.out.println(newTour.toString());
        newTour.draw(a);
    }
}