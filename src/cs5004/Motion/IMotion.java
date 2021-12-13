package cs5004.motion;

import cs5004.shapes.Shape;

/**
 * Motion Interface.
 */
public interface IMotion {
  
  /**
   * get start time.
   * @return start time.
   */
  int getStartTime(); 
  
  /**
   * get end time.
   * @return end time.
   */
  int getEndTime(); 
  
  /**
   * set shape.
   * @param s shape.
   */
  void setShape(Shape s);
  
  /**
   * get shape.
   * @return shape.
   */
  Shape getShape();
  
  /**
   * svg text format.
   * @return svg text format.
   */
  String toSVGString();
  
  /**
   * set delta value of a shape by time.
   * @param s shape. 
   * @param t time.
   */
  void setDeltaBytime(Shape s, double t);
}
