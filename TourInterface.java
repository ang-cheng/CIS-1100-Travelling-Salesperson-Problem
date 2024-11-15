/**
 * DO NOT MODIFY THIS FILE
 * Interface for Tour
 */
public interface TourInterface
{
    /**
     * Return a string representation of points in the tour, in order
     * @return string representation of points in the tour, in order
     */
    public String toString();

    /**
     * Draws the tour
     * @param p draws any edge whose start or end point is p in a different color
     */
    public void draw(Point p);

    /**
     * Returns the number of points in the tour
     * @return the number of points in the tour
     */
    public int size();

    /**
     * Returns the total length of the tour
     * @return the total length of the tour
     */
    public double distance();

    /**
     * Insert p at the end of the tour; does nothing if p is null
     * @param p the point to add to the tour
     */
    public void insertInOrder(Point p);
	
    /**
     * Insert p after the point to which it is closest; does nothing if p is null
     * @param p the point to add to the tour
     */
    public void insertNearest(Point p);

    /**
     * Insert p where it will cause the shortest detour; does nothing if p is null
     * @param p the point to add to the tour
     */
    public void insertSmallest(Point p);
}
