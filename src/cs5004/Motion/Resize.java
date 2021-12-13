package cs5004.motion;

import cs5004.shapes.Shape;

/**
 * Resize Motion.
 */
public class Resize extends AbstractMotion implements IMotion {
  private int w1;
  private int h1;
  private int w2;
  private int h2;
  
  /**
   * initialize Resize Motion.
   * @param t1 t1
   * @param t2 t2
   * @param w1 w1
   * @param h1 h1
   * @param w2 w2
   * @param h2 h2
   */
  public Resize(int t1, int t2, int w1, int h1, int w2, int h2) {
    super(t1, t2);
    this.w1 = w1;
    this.w2 = w2;
    this.h1 = h1;
    this.h2 = h2;
  }
  
  @Override
  public void setDeltaBytime(Shape s, double t) {
    int w = tween(t, startTime, endTime, w1, w2);
    int h = tween(t, startTime, endTime, h1, h2);
    
    s.setW(w);
    s.setH(h);
  }
  
  @Override
  public void setShape(Shape s) {
    this.shape = s;
    
    if (this.startTime <= this.shape.getAppearsAt()) {
      this.shape.setAppearsAt(this.startTime);
      this.shape.setW(w1);
      this.shape.setH(h1);
    }
    
    if (this.endTime > this.shape.getDisappearsAt()) {
      this.shape.setDisappearsAt(this.endTime);
    }
  }
  
  @Override
  public String toString() {
    return String.format("Shape %s resizes from (width, height): "
        + "(%d, %d) to (width, height): (%d, %d) from time %d to time %d", 
      this.shape.getName(), 
      this.w1, this.h1,
      this.w2, this.h2,
      this.startTime, this.endTime);
  }

  @Override
  public String toSVGString() {
    String ws  = String.format("<animate attributeType='xml' begin='%dms' "
        + "dur='%dms' attributeName='%s' from='%d' to='%d' fill='freeze' />", 
        this.startTime * 1000,
        (this.endTime - this.startTime) * 1000,
        this.shape.getType().equals("Rect") ? "width" : "rx",
        this.w1,
        this.w2
     );
    
    String hs = String.format("<animate attributeType='xml' begin='%dms' "
        + "dur='%dms' attributeName='%s' from='%d' to='%d' fill='freeze' />", 
        this.startTime * 1000,
        (this.endTime - this.startTime) * 1000,
        this.shape.getType().equals("Rect") ? "height" : "ry",
        this.h1,
        this.h2
     );
      
    return ws + "\n" + hs;
  }
}
