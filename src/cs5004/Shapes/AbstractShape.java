package cs5004.shapes;

/**
 * AbstractShape.
 */
public abstract class AbstractShape implements Shape {
  protected Pos reference;
  protected Color color;
  protected boolean visible = false;
  protected String name;
  protected int appearsAt = Integer.MAX_VALUE;
  protected int disappearsAt = Integer.MIN_VALUE;
  
  protected int w;
  protected int h;
  
  /**
   * initialize AbstractShape.
   * @param name name of the shape.
   */
  public AbstractShape(String name) {
    this.name = name;
  }
  
  @Override
  public void setAppearsAt(int a) {
    this.appearsAt = a;
  }
  
  @Override
  public void setDisappearsAt(int a) {
    this.disappearsAt = a;
  }
  
  @Override
  public void setPos(Pos p) {
    this.reference = p;
  }
  
  @Override
  public void setColor(Color c) {
    this.color = c;
  }
  
  public void show() {
    this.visible = true;
  }
  
  public void hide() {
    this.visible = false;
  }  
  
  public void setInitPos(int x, int y, int r, int g, int b) {
    this.reference = new Pos(x, y);
    this.color = new Color(r, g, b);
  }
  
  @Override
  public int getAppearsAt() {
    return appearsAt;
  }
  
  @Override
  public int getDisappearsAt() {
    return disappearsAt;
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public int getW() {
    return this.w;
  }
  
  @Override
  public int getH() {
    return this.h;
  }
  
  @Override
  public void move(Pos to) {
    this.reference.setX(to.getX());
    this.reference.setY(to.getY());
  }
  
  @Override
  public Pos getPos() {
    return this.reference;
  }
  
  @Override
  public Color getColor() {
    return this.color;
  }
  
  @Override
  public void changeColor(Color color) {
    this.color.changeColor(color);
  }
  
  @Override
  public void setW(int w) {
    this.w = w;
  }
  
  @Override
  public void setH(int h) {
    this.h = h;
  }
  
  public Shape clone() {
    return null;
  }
}
