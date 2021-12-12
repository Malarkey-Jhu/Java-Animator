package cs5004.Motion;

import cs5004.Shapes.Shape;

public interface IMotion {
  int getStartTime(); 
  
  int getEndTime(); 
  
  void setShape(Shape s);
  
  Shape getShape();
  
  String toSVGString();
  
  void setDeltaBytime(Shape s, double t);
}
