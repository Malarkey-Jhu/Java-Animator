package cs5004.motion;

import cs5004.shapes.Pos;
import cs5004.shapes.Shape;

/**
 * Move Motion.
 */
public class Move extends AbstractMotion implements IMotion {
  Pos start;
  Pos end;
  
  /**
   * initialize Move Motion.
   * @param t1 t1 
   * @param t2 t2
   * @param x1 x1
   * @param y1 y1
   * @param x2 x2
   * @param y2 y2
   */
  public Move(int t1, int t2, int x1, int y1, int x2, int y2) {
    super(t1, t2);
    this.start = new Pos(x1, y1);
    this.end = new Pos(x2, y2);
  }
  
  @Override
  public void setDeltaBytime(Shape s, double t) {
    int x = tween(t, startTime, endTime, start.getX(), end.getX());
    int y = tween(t, startTime, endTime, start.getY(), end.getY());
    
    s.setPos(new Pos(x, y));
  }
  
  @Override
  public void setShape(Shape s) {
    this.shape = s;
    
    if (this.startTime <= this.shape.getAppearsAt()) {
      this.shape.setAppearsAt(this.startTime);
      this.shape.setPos(this.start);
    }
    
    if (this.endTime > this.shape.getDisappearsAt()) {
      this.shape.setDisappearsAt(this.endTime);
    }
  }
  
  @Override
  public String toString() {
    return String.format("Shape %s moves from %s to %s from "
        + "time %d to time %d", this.shape.getName(), this.start.toString(),
        this.end.toString(), this.startTime, this.endTime);
  }
  
  @Override
  public String toSVGString() {
    String xs  = String.format("<animate attributeType='xml' begin='%dms' "
        + "dur='%dms' attributeName='%s' from='%d' to='%d' fill='freeze' />", 
        this.startTime * 1000,
        (this.endTime - this.startTime) * 1000,
        this.shape.getType().equals("Rect")  ? "x" : "cx",
        this.start.getX(),
        this.end.getX()
    );
    
    String ys = String.format("<animate attributeType='xml' begin='%dms' "
        + "dur='%dms' attributeName='%s' from='%d' to='%d' fill='freeze' />", 
        this.startTime * 1000,
        (this.endTime - this.startTime) * 1000,
        this.shape.getType().equals("Rect") ? "y" : "cy",
        this.start.getY(),
        this.end.getY()
    );
    
    return xs + "\n" + ys;
  }

}
