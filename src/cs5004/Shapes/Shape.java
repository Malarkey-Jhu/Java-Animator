package cs5004.Shapes;

public interface Shape {
  
  Pos getPos();
  
  Color getColor();
  
  String getName();
  
  String getType();
  
  String toSVGString();
  
  int getW();
  
  int getH();
  
  Shape clone();
  
  void setAppearsAt(int a);
  
  void setDisappearsAt(int a);
  
  int getAppearsAt();
  
  int getDisappearsAt();
  
  void move(Pos to);
  
  void changeColor(Color color);
  
  void setPos(Pos p);
  
  void setColor(Color c);
  
  void setW(int w);
  
  void setH(int w);
  
}
