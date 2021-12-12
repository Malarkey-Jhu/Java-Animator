package cs5004.Shapes;

public class Rect extends AbstractShape implements Shape {
  public Rect(String name) {
    super(name);
  }
  
  public Rect(Pos reference, Color color, boolean visible, String name, int appearsAt,
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
    return "Rect";
  }
  
  @Override
  public String toSVGString() {
    if (this.reference == null || this.color == null) {
      return "there is no reference or color in this shape";
    }
    
    return String.format("<rect id='%s' x='%d' y='%d' width='%d' height='%d' fill='%s' visibility='visible'>***</rect>", this.name, this.getPos().getX(), this.getPos().getY(), this.w, this.h, this.color.toString());
  }
  
  @Override
  public Rect clone() {
    return new Rect(this.reference.clone(), this.color.clone(), this.visible, this.name, this.appearsAt, this.disappearsAt, this.w, this.h);
  }
  
  @Override
  public String toString() {
    if (this.reference == null || this.color == null) {
      return "there is no reference or color in this shape";
    }
    
    return "Name: " + this.name + "\n"
        + "Type: rectangle \n"
        + "Center: " + this.reference.toString() + ", " 
        + "X radius: " + this.w + ", " 
        + "Y radius: " + this.h + ", "
        + "Color: " + this.color.toString() + "\n"
        + "Appears at t=" + this.getAppearsAt() + "\n"
        + "Disappears at t=" + this.getDisappearsAt();
  }
}
