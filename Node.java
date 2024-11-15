/*************************************************************************
  *  YOU DO NOT NEED TO MODIFY THIS FILE
  *
  *  Compilation:  javac Node.java
  *  Dependencies: Point.java
  *
  *  A simple Node class to be used in a linked list by the Tour class.
  *  Each Node refers to the next Node in the list and a Point in the Tour.
  *
  *************************************************************************/

public class Node {
    public Node next;
    public Point point;
    
    public Node(Point p) {
        next = null;
        point = p;
    }
    
    public Node(Node n, Point p) {
        next = n;
        point = p;
    }
}