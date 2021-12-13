package cs5004.shapes;

/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x,y).
 */
public class Pos {
  
  private int x;
  private int y;

  /**
   * Construct a 2d point with the given coordinates.
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Pos(int x, int y) {
    
    this.x = x;
    this.y = y;
  }
  
  /**
   * clone this pos.
   */
  public Pos clone() {
    return new Pos(x, y);
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin.
   * @return the euclidean distance
   */
  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }
  
  /**
   * set X.
   * @param x x
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * set Y.
   * @param y y
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point
   */
  public int getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point
   */
  public int getY() {
    return y;
  }
  
  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    
    if (!(obj instanceof Pos)) {
      return false;
    }
    
    Pos p = (Pos) obj;
    
    return this.x == p.getX() && this.y == p.getY();
  }
}
