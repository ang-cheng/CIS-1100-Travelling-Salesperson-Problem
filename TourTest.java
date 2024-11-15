/**
 * Execution: N/A - JUnit testing
 *
 * Description: will test the methods written in Tour.java
**/
import org.junit.Test;
import static org.junit.Assert.*;

public class TourTest {
    
    // Do not change this!
    // Use DELTA as the tolerance for your assertEquals statements.
    public static final double DELTA = 1e-2;
    
    /*
    * REQUIRED TESTS
    */
    
    // toString tests
    @Test
    public void testToStringEmpty() {
        // Check that toString outputs correctly on an empty tour
        Tour t = new Tour();
        String result = t.toString();
        String expected = "";
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringOnePoint() {
        // Check that toString outputs correctly on a tour with 1 point
        Tour t = new Tour();
        Point p = new Point(0.0, 0.0);
        t.insertInOrder(p);
        String result = t.toString();
        String expected = "(0.0, 0.0)\n(0.0, 0.0)\n";
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringSquare() {
        /* Check that toString outputs correctly
        * on a tour of a 1x1 square as stated in the writeup
        */
        Tour t = new Tour();
        Point a = new Point(0.0, 0.0);
        Point b = new Point(1.0, 0.0);
        Point c = new Point(1.0, 1.0);
        Point d = new Point(0.0, 1.0);
        t.insertInOrder(a);
        t.insertInOrder(b);
        t.insertInOrder(c);
        t.insertInOrder(d);
        String result = t.toString();
        String expected = 
            "(0.0, 0.0)\n(1.0, 0.0)\n(1.0, 1.0)\n(0.0, 1.0)\n(0.0, 0.0)\n";
        assertEquals(expected, result);
    }
    
    // Distance tests
    @Test
    public void testDistanceEmpty() {
        // Check that distance outputs correctly on an empty tour
        Tour t = new Tour();
        double result = t.distance();
        double expected = 0.0;
        assertEquals(expected, result, DELTA);
    }
    
    @Test
    public void testDistanceSquare() {
        /* Check that distance() outputs correctly
        * on a tour of a 1x1 square as stated in the writeup
        */
        Tour t = new Tour();
        Point a = new Point(0.0, 0.0);
        Point b = new Point(1.0, 0.0);
        Point c = new Point(1.0, 1.0);
        Point d = new Point(0.0, 1.0);
        t.insertInOrder(a);
        t.insertInOrder(b);
        t.insertInOrder(c);
        t.insertInOrder(d);
        double result = t.distance();
        double expected = 4.0;
        assertEquals(expected, result, DELTA);
    }
    
    // Size tests
    @Test
    public void testSizeEmpty() {
        // Check that size is correct on an empty tour
        Tour t = new Tour();
        int result = t.size();
        int expected = 0;
        assertEquals(expected, result);
    }
    
    @Test
    public void testSizeSquare() {
        /* Check that size() outputs correctly
        * on a tour of a 1x1 square as stated in the writeup
        */
        Tour t = new Tour();
        Point a = new Point(0.0, 0.0);
        Point b = new Point(1.0, 0.0);
        Point c = new Point(1.0, 1.0);
        Point d = new Point(0.0, 1.0);
        t.insertInOrder(a);
        t.insertInOrder(b);
        t.insertInOrder(c);
        t.insertInOrder(d);
        int result = t.size();
        int expected = 4;
        assertEquals(expected, result);
    }
    
    // insertInOrder tests
    @Test
    public void testInsertInOrderTSP4CorrectSize() {
        // Check that the size is correct for these 4 points
        // These are the points contained in the file "tsp4.txt".
        Tour t = new Tour();
        
        Point a = new Point(200, 400);
        Point b = new Point(300, 100);
        Point c = new Point(100, 100);
        Point d = new Point(300, 200);
        Point[] toInsert = { a, b, c, d };
        
        for (int i = 0; i < toInsert.length; i++) {
            t.insertInOrder(toInsert[i]);
        }

        int result = t.size();
        int expected = 4;

        assertEquals(expected, result);
    }
    
    @Test
    public void testInsertInOrderTSP0Through4CorrectDistance() {
        Tour t = new Tour();
        
        Point a = new Point(200, 400);
        Point b = new Point(300, 100);
        Point c = new Point(100, 100);
        Point d = new Point(300, 200);
        
        /*
        * Study this test. It is completed for you.
        * We use two parallel arrays and a for loop to insert points a through e using
        * Tour.insertInOrder(). After each insertion, we check that the distance of the
        * tour was computed correctly. These are the points contained in the file
        * "tsp4.txt".
        */
        Point[] toInsert = { a, b, c, d };
        double[] distanceAfterInsert = { 0, 632.46, 832.46, 963.44 };
        
        for (int i = 0; i < toInsert.length; i++) {
            t.insertInOrder(toInsert[i]);
            double expected = distanceAfterInsert[i];
            double actual = t.distance();
            assertEquals("mismatch after calling insertInOrder on point at index " + i,
            expected, actual, DELTA);
        }
    }
    
    // insertNearest tests
    @Test
    public void testInsertNearestTSP4CorrectSize() {
        Tour t = new Tour();
        
        Point a = new Point(200, 400);
        Point b = new Point(300, 100);
        Point c = new Point(100, 100);
        Point d = new Point(300, 200);
        
        // Insert points a through d using Tour.insertNearest()
        // These are the points contained in the file "tsp4.txt".
        t.insertNearest(a);
        t.insertNearest(b);
        t.insertNearest(c);
        t.insertNearest(d);

        // Check that the size is correct for these 4 points
        int result = t.size();
        int expected = 4;
        assertEquals(expected, result);
    }
    
    @Test
    public void testInsertNearestTSP0Through4CorrectDistance() {
        Tour t = new Tour();
        
        Point a = new Point(200, 400);
        Point b = new Point(300, 100);
        Point c = new Point(100, 100);
        Point d = new Point(300, 200);
        
        /*
        * Insert points a through d using Tour.insertNearest()
        * After each insertion, check that the distance of the tour was
        * computed correctly.
        * These are the points contained in the file "tsp4.txt".
        */
        t.insertNearest(a);
        double result = t.distance();
        double expected = 0.00;
        assertEquals(expected, result, DELTA);

        t.insertNearest(b);
        result = t.distance();
        expected = 632.46;
        assertEquals(expected, result, DELTA);

        t.insertNearest(c);
        result = t.distance();
        expected = 832.46;
        assertEquals(expected, result, DELTA);

        t.insertNearest(d);
        result = t.distance();
        expected = 956.06;
        assertEquals(expected, result, DELTA);
    }
    
    // insertSmallest tests
    @Test
    public void testInsertSmallestTSP4CorrectSize() {
        Tour t = new Tour();
        
        Point a = new Point(200, 400);
        Point b = new Point(300, 100);
        Point c = new Point(100, 100);
        Point d = new Point(300, 200);
        
        // Insert points a through d using Tour.insertSmallest()
        // These are the points contained in the file "tsp4.txt".
        t.insertSmallest(a);
        t.insertSmallest(b);
        t.insertSmallest(c);
        t.insertSmallest(d);

        // Check that the size is correct for these 4 points
        int result = t.size();
        int expected = 4;
        assertEquals(expected, result);
    }
    
    @Test
    public void testInsertSmallestTSP0Through4CorrectDistance() {
        Tour t = new Tour();
        
        Point a = new Point(200, 400);
        Point b = new Point(300, 100);
        Point c = new Point(100, 100);
        Point d = new Point(300, 200);
        
        /*
        * Insert points a through d using Tour.insertSmallest()
        * After each insertion, check that the distance of the tour was
        * computed correctly.
        * These are the points contained in the file "tsp4.txt".
        */
        t.insertSmallest(a);
        double result = t.distance();
        double expected = 0.0;
        assertEquals(expected, result, DELTA);

        t.insertSmallest(b);
        result = t.distance();
        expected = 632.46;
        assertEquals(expected, result, DELTA);

        t.insertSmallest(c);
        result = t.distance();
        expected = 832.46;
        assertEquals(expected, result, DELTA);

        t.insertSmallest(d);
        result = t.distance();
        expected = 839.83;
        assertEquals(expected, result, DELTA);
    }
    
    /*
    * You should feel free to write more tests than the ones required.
    * Please keep them below this line.
    */
    
}
