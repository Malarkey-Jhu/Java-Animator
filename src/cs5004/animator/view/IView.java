package cs5004.animator.view;

import cs5004.IController;
import cs5004.IModel;

public interface IView {

  void display(int speed);
  
  void addController(IController c);
  
}
