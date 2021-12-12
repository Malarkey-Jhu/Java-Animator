package cs5004.Motion;

import cs5004.Shapes.Shape;

public abstract class AbstractMotion {

  int startTime;
  int endTime;
  Shape shape;
  
  public static int tween(double curT, int t1, int t2, int startVal, int endVal) {
    int totalTime = t2 - t1;
    return (int) ((int) startVal * ((t2-curT) / totalTime) + endVal * ((curT-t1) / totalTime));
  }
  
  public AbstractMotion(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
  public Shape getShape() {
    return this.shape.clone();
  }

  public int getStartTime() {
    return this.startTime;
  }
  
  public int getEndTime() {
    return this.endTime;
  }
}
