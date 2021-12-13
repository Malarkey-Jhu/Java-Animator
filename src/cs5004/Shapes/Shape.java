package cs5004.shapes;

/**
 * Shape Interface.
 */
public interface Shape {
  
  /**
   * get Pos.
   * @return Pos class.
   */
  Pos getPos();
  
  /**
   * get Color.
   * @return Color class.
   */
  Color getColor();
  
  /**
   * get name of the shape.
   * @return name.
   */
  String getName();
  
  /**
   * get type of the shape.
   * @return Rect or Ellipse.
   */
  String getType();
  
  /**
   * get svg in text format. 
   * @return svg string.
   */
  String toSVGString();
  
  /**
   * get width.
   * @return width.
   */
  int getW();
  
  /**
   * get height.
   * @return height.
   */
  int getH();
  
  /**
   * clone shape.
   * @return cloned shape.
   */
  Shape clone();
  
  /**
   * set appears at.
   * @param a appears at.
   */
  void setAppearsAt(int a);
  
  /**
   * set disappears at.
   * @param a disappears at.
   */
  void setDisappearsAt(int a);
  
  /**
   * get appears at.
   * @return appears at.
   */
  int getAppearsAt();
  
  /**
   * get disappears at.
   * @return disappears at.
   */
  int getDisappearsAt();
  
  /**
   * move to given pos.
   * @param to pos.
   */
  void move(Pos to);
  
  /**
   * change color. 
   * @param color color.
   */
  void changeColor(Color color);
  
  /**
   * set pos.
   * @param p pos.
   */
  void setPos(Pos p);
  
  /**
   * set color.
   * @param c color.
   */
  void setColor(Color c);
  
  /**
   * set width.
   * @param w width.
   */
  void setW(int w);
  
  /**
   * set height.
   * @param h height.
   */
  void setH(int h);
  
}
