package cs5004.motion;

import cs5004.shapes.Color;
import cs5004.shapes.Shape;

/**
 * Change color.
 */
public class ChangeColor extends AbstractMotion implements IMotion {
  
  Color start;
  Color end;
  
  /**
   * initialization.
   * @param t1 t1
   * @param t2 t2 
   * @param r1 r1
   * @param g1 g1 
   * @param b1 b1
   * @param r2 r2
   * @param g2 g2 
   * @param b2 b2
   */
  public ChangeColor(int t1, int t2, int r1, int g1, int b1, int r2, int g2, int b2) {
    super(t1, t2);
    this.start = new Color(r1, g1, b1);
    this.end = new Color(r2, g2, b2);
  }
  
 
  @Override
  public void setDeltaBytime(Shape s, double t) {
    int r = tween(t, startTime, endTime, start.getR(), end.getR());
    int g = tween(t, startTime, endTime, start.getG(), end.getG());
    int b = tween(t, startTime, endTime, start.getB(), end.getB());
    
    s.setColor(new Color(r, g, b));
  }
  
  @Override
  public void setShape(Shape s) {
    this.shape = s;
    
    if (this.startTime <= this.shape.getAppearsAt()) {
      this.shape.setAppearsAt(this.startTime);
      this.shape.setColor(this.start);
    }
    
    if (this.endTime > this.shape.getDisappearsAt()) {
      this.shape.setDisappearsAt(this.endTime);
    }
  }
  
  @Override
  public String toString() {
    return String.format("Shape %s changes color from %s to %s from time %d to time %d", 
        this.shape.getName() ,this.start.toString(),
        this.end.toString(), this.startTime, this.endTime);
  }

  @Override
  public String toSVGString() {
    return String.format("<animate attributeType='xml' begin='%dms' dur='%dms' "
        + "attributeName='fill' from='%s' to='%s' fill='freeze' />", 
        this.startTime * 1000,
        (this.endTime - this.startTime) * 1000,
        this.start.toString(),
        this.end.toString()
     );
  }
  
}
