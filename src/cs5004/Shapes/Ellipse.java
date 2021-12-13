package cs5004.shapes;

/**
 * Ellipse Shape.
 */
public class Ellipse extends AbstractShape implements Shape {
  
  /**
   * initialize Ellipse Shape.
   * @param name name.
   */
  public Ellipse(String name) {
    super(name);
  }
  
  /**
   * initialize Ellipse Shape.
   * @param reference reference
   * @param color color
   * @param visible visible
   * @param name name
   * @param appearsAt appearsAt
   * @param disappearsAt disappearsAt
   * @param w w
   * @param h h
   */
  public Ellipse(Pos reference, Color color, boolean visible, String name, int appearsAt, 
      int disappearsAt, int w, int h) {
    super(name);
    this.setPos(reference);
    this.setW(w);
    this.setH(h);
    this.setAppearsAt(appearsAt);
    this.setDisappearsAt(disappearsAt);
    this.setColor(color);
  }
  
  @Override
  public String getType() {
    return "Ellipse";
  }
  
  @Override
  public Ellipse clone() {
    return new Ellipse(this.reference.clone(), this.color.clone(), 
        this.visible, this.name, this.appearsAt, this.disappearsAt, this.w, this.h);
  }
  
  @Override
  public String toSVGString() {
    if (this.reference == null || this.color == null) {
      return "there is no reference or color in this shape";
    }
    
    return String.format("<ellipse id='%s' cx='%d' cy='%d' rx='%d' "
        + "ry='%d' fill='%s' visibility='visible' >***</ellipse>", this.name, this.getPos().getX(), this.getPos().getY(), this.w, this.h, this.color.toString());
  }
  
  @Override
  public String toString() {
    if (this.reference == null || this.color == null) {
      return "there is no reference or color in this shape";
    }
    
    return "Name: " + this.name + "\n"
        + "Type: ellipse \n"
        + "Center: " + this.reference.toString() + ", " 
        + "Width: " + this.w + ", " 
        + "Height: " + this.h + ", "
        + "Color: " + this.color.toString() + "\n"
        + "Appears at t=" + this.getAppearsAt() + "\n"
        + "Disappears at t=" + this.getDisappearsAt();
  }
}
