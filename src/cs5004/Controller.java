package cs5004;

import java.util.ArrayList;

import cs5004.animator.view.IView;
import cs5004.animator.view.ViewGUI;
import cs5004.shapes.Shape;

/**
 * Controller.
 */
public class Controller implements IController {

  private IView view;
  private IModel model;
  
  /**
   * Initialize Controller.
   * @param m Model
   * @param v View
   */
  public Controller(IModel m, IView v) {
    this.model = m;
    this.view = v;
    this.view.addController(this);
  }
  
  @Override
  public void start(int speed) {
    if (view instanceof ViewGUI) {
      ((ViewGUI) view).setCanvas(this.model.getX(), this.model.getY(), 
          this.model.getW(), this.model.getH());
    }
    view.display(speed);
  }
  
  @Override
  public ArrayList<Shape> getShapes(double t) {
    return this.model.getShapeInfoBytime(t);
  }

  @Override
  public String getTextOutput() {
    return this.model.toString();
  }

  @Override
  public String getSVGTextOutput() {
    return this.model.toSVGString();
  }

  @Override
  public int getEndTime() {
    return this.model.getEndTime();
  }
  
}
