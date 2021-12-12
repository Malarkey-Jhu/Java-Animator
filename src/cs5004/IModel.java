package cs5004;

import java.util.ArrayList;

import cs5004.Motion.IMotion;
import cs5004.Shapes.Shape;

public interface IModel {

  void addShape(String name, String type);

  void addMotion(String name, IMotion m);
  
  void setCanvas(int x, int y, int w, int h);
  
  int getX();
  int getY();
  int getW();
  int getH();
  
  ArrayList<Shape> getShapeInfoBytime(double time);
  
  String toSVGString();
  
  int getEndTime();
}
