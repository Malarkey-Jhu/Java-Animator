package cs5004.motion;

import cs5004.shapes.Shape;

/**
 * AbstractMotion.
 */
public abstract class AbstractMotion {

  int startTime;
  int endTime;
  Shape shape;
  
  /**
   * tween formula.
   * @param curT cuurrent time.
   * @param t1 start time.
   * @param t2 end time.
   * @param startVal start value.
   * @param endVal end value.
   * @return delta value.
   */
  public static int tween(double curT, int t1, int t2, int startVal, int endVal) {
    int totalTime = t2 - t1;
    return (int) ((int) startVal * ((t2 - curT) / totalTime) + endVal * ((curT - t1) / totalTime));
  }
  
  /**
   * initialization.
   * @param startTime start time
   * @param endTime end time
   */
  public AbstractMotion(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
  /**
   * get shape.
   * @return shape.
   */
  public Shape getShape() {
    return this.shape.clone();
  }

  /**
   * get start time.
   * @return start time.
   */
  public int getStartTime() {
    return this.startTime;
  }
  
  /**
   * get end time.
   * @return end time.
   */
  public int getEndTime() {
    return this.endTime;
  }
}
