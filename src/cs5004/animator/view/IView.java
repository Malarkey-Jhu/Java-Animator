package cs5004.animator.view;

import cs5004.IController;

/**
 * View Interface.
 */
public interface IView {

  /**
   * display animation.
   * @param speed speed of animation.
   */
  void display(int speed);
  
  /**
   * let view has access to controller.
   * @param c controller.
   */
  void addController(IController c);
  
}
