package cs5004.shapes;

/**
 * Color.
 */
public class Color {
  
  private int r;
  private int g;
  private int b;
  
  /**
   * initialize Color.
   * @param r r
   * @param g g
   * @param b b
   */
  public Color(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  /**
   * clone color.
   */
  public Color clone() {
    return new Color(r,g,b);
  }
  
  /**
   * change color.
   * @param c colot
   */
  public void changeColor(Color c) {
    this.r = c.getR();
    this.g = c.getG();
    this.b = c.getB();
  }
  
  /**
   * get R.
   * @return R.
   */
  public int getR() {
    return this.r;
  }
  
  /**
   * get G.
   * @return G.
   */
  public int getG() {
    return this.g;
  }
  
  /**
   * get B.
   * @return B.
   */
  public int getB() {
    return this.b;
  }
  
  @Override
  public String toString() {
    return "rgb(" + r + ", " + g + ", " + b + ")";
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    
    if (!(obj instanceof Color)) {
      return false;
    }
    
    Color c = (Color) obj;
    
    return r == c.getR() && g == c.getG() && b == c.getB(); 
  }
}
