package cs5004;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import cs5004.motion.IMotion;
import cs5004.shapes.Ellipse;
import cs5004.shapes.Rect;
import cs5004.shapes.Shape;

/**
 * Model.
 */
public class Model implements IModel {
  
  // canvas bounding box
  private int x = 0;
  private int y = 0;
  private int width = 1000;
  private int height = 600;
  
  private int endTime = 0;
  
  private HashMap<String, Shape> allShapes = new HashMap<String, Shape>();
  protected List<IMotion> allMotions = new ArrayList<IMotion>();
  
  @Override
  public void setCanvas(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.width = w;
    this.height = h;
  }
  
  @Override
  public int getX() {
    return x;
  }
  
  @Override
  public int getY() {
    return y;
  }
  
  @Override
  public int getW() {
    return width;
  }
  
  @Override
  public int getH() {
    return height;
  }
  
  @Override
  public ArrayList<Shape> getShapeInfoBytime(double time) {
    LinkedHashMap<String, Shape> mp = new LinkedHashMap<String, Shape>();
    
    for (int i = 0; i < this.allMotions.size(); i++) { 
      IMotion curMotion = this.allMotions.get(i);
      if (curMotion.getEndTime() < time) {
        continue;
      }
      if (curMotion.getStartTime() > time) {
        break;
      }
      String name = curMotion.getShape().getName();
      if (mp.get(name) == null) {
        mp.put(name, curMotion.getShape().clone());
      }
      Shape sp = mp.get(name);
      // calculate delta (mutation on the cloned shape)
      curMotion.setDeltaBytime(sp, time);
    }
    Collection<Shape> values = mp.values();
    
    return new ArrayList<Shape>(values);
  }
  
  @Override
  public void addShape(String name, String type) {
    switch (type) {
      case "rectangle":
        this.allShapes.put(name, new Rect(name));
        break;
      case "ellipse":
        this.allShapes.put(name, new Ellipse(name));
        break;
      default:
    }
  }

  @Override
  public void addMotion(String name, IMotion m) {
    Shape s = this.allShapes.get(name);
    if (s == null) {
      throw new IllegalArgumentException("there is no shape with name" + name);
    }
    
    m.setShape(s);
    
    if (m.getEndTime() > this.endTime) {
      this.endTime = m.getEndTime();
    }
    
    int low = 0;
    int high = this.allMotions.size() - 1;
    
    while (low <= high) {
      int mid = (low + high) / 2;
      IMotion midM = this.allMotions.get(mid);
      if (midM.getStartTime() == m.getStartTime()) {
        low = mid;
        break;
      } else if (midM.getStartTime() < m.getStartTime()) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    this.allMotions.add(low, m);
  }

  /**
   * get Motion by shape
   * @param s shape
   * @return motions that the shape has
   */
  private List<IMotion> getMotionByShape(Shape s) {
    return this.allMotions.stream()
        .filter(m -> m.getShape().getName() == s.getName())
        .collect(Collectors.toList());
  }
  
  @Override
  public String toSVGString() {
    String res = "";
    res += "<svg width=\"" + width + "\" height=\"" + height + "\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\">\n";
    
    HashMap<String, Shape> mb = new HashMap<String, Shape>();
    String shapeTag = "";
    for (int i = 0; i < this.allMotions.size(); i++) {
      IMotion m = this.allMotions.get(i);
      Shape sp = m.getShape();
      
      if (mb.get(sp.getName()) != null) {
        continue;
      }
      mb.put(sp.getName(), sp);
      
      String spStr = sp.toSVGString();
      List<IMotion> motionOfShapes = this.getMotionByShape(sp);
      
      String motionStr = motionOfShapes.stream()
          .map(mm -> mm.toSVGString())
          .reduce("", (a, b) -> a + "\n" + b);
      
      shapeTag += spStr.replace("***", motionStr);
      shapeTag += "\n\n";
    }
    
    res += shapeTag;
    res += "</svg>";
    return res;
  }
  
  @Override
  public String toString() {
    String shapesInfo = "";
    String motionsInfo = "";
    
    for (Shape sp: allShapes.values()) {
      shapesInfo += sp.toString() + "\n\n";
    }
    
    for (int i = 0; i < this.allMotions.size(); i++) {
      String ms = this.allMotions.get(i).toString();
      motionsInfo += ms + "\n";
    }
    
    return shapesInfo + motionsInfo;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }
}


/**
 * Comparator compare by start time
 * @author alan_pc
 *
 */
class SortByStartTime implements Comparator<IMotion> {
  @Override
  public int compare(IMotion a, IMotion b)
  {
      return a.getStartTime() - b.getStartTime();
  }
}


