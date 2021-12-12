package cs5004;

import java.util.ArrayList;

import cs5004.Shapes.Shape;

public interface IController {
  void start(int speed);
  
  ArrayList<Shape> getShapes(double t);
  
  String getTextOutput();
  
  String getSVGTextOutput();
  
  int getEndTime();
}
