package cs5004.shapes;

public class Color {
  private int r;
  private int g;
  private int b;
  
  public Color(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  public Color clone() {
    return new Color(r,g,b);
  }
  
  public void changeColor(Color c) {
    this.r = c.getR();
    this.g = c.getG();
    this.b = c.getB();
  }
  
  public int getR() {
    return this.r;
  }
  
  public int getG() {
    return this.g;
  }
  
  public int getB() {
    return this.b;
  }
  
  @Override
  public String toString() {
    return "rgb(" + r + ", " + g + ", " + b + ")";
  }
  
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
