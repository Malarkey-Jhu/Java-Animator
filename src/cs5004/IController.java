package cs5004;

import java.util.ArrayList;

import cs5004.shapes.Shape;

/**
 * Controller.
 */
public interface IController {
  
  /**
   * start animation with given speed.
   * @param speed speed
   */
  void start(int speed);
  
  /**
   * get Shapes from Model at specific timestamp.
   * @param t timestamp
   * @return an array of shapes
   */
  ArrayList<Shape> getShapes(double t);
  
  /**
   * get text description of animation from Model.
   * @return text desc
   */
  String getTextOutput();
  
  /**
   * get svg text format from Model.
   * @return svg output in text format
   */
  String getSVGTextOutput();
  
  /**
   * get the end time of animation.
   * @return end time
   */
  int getEndTime();
}
