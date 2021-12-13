package cs5004;

import java.util.ArrayList;

import cs5004.motion.IMotion;
import cs5004.shapes.Shape;

/**
 * Model.
 */
public interface IModel {

  /**
   * add Shapes to Model.
   * @param name name of shape
   * @param type rectangle or ellipse
   */
  void addShape(String name, String type);

  /**
   * add Motion to Model.
   * @param name name of motion
   * @param m Motion Class 
   */
  void addMotion(String name, IMotion m);
  
  /**
   * set Canvas properties.
   * @param x x coord
   * @param y y coord
   * @param w width
   * @param h height
   */
  void setCanvas(int x, int y, int w, int h);
  
  /**
   * get x coord (leftmost pos) of canvas.
   * @return
   */
  int getX();
  
  /**
   * get y coord (topmost pos) of canvas.
   * @return
   */
  int getY();
  
  /**
   * get width of canvas.
   * @return
   */
  int getW();
  
  /**
   * get height of canvas.
   * @return
   */
  int getH();
  
  /**
   * get different shapes need to rendered on canvas in given time. 
   * @param time time
   * @return array of shapes
   */
  ArrayList<Shape> getShapeInfoBytime(double time);
  
  /**
   * get SVG output in string format.
   * @return
   */
  String toSVGString();
  
  /**
   * get end time of animation.
   * @return end time
   */
  int getEndTime();
}
