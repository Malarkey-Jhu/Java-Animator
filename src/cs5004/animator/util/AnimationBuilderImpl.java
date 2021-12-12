package cs5004.animator.util;

import cs5004.IModel;
import cs5004.Model;
import cs5004.Motion.ChangeColor;
import cs5004.Motion.Move;
import cs5004.Motion.Resize;

public class AnimationBuilderImpl implements AnimationBuilder<IModel> {
  IModel m = new Model();
  
  @Override
  public IModel build() {
    return m;
  }

  @Override
  public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
    this.m.setCanvas(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> declareShape(String name, String type) {
    this.m.addShape(name, type);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
      int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    
      this.m.addMotion(name, new ChangeColor(t1, t2, r1, g1, b1, r2, g2, b2));
      this.m.addMotion(name, new Move(t1, t2, x1, y1, x2, y2));
      this.m.addMotion(name, new Resize(t1, t2, w1, h1, w2, h2));
    return this;
  }

}
