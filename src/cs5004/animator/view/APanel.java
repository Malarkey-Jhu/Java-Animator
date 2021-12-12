package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import cs5004.Controller;
import cs5004.IController;

import javax.swing.JPanel;

public class APanel extends JPanel implements ActionListener {

  Timer timer;
  double time = 0;
  IController c;
  int delay = 1000;
  double deltaTime = 1;
  
  public APanel(IController c, int x, int y, int w, int h, int speed) {
    super(true);
    this.setBackground(Color.white);
    this.setSize(w, h);
    this.setLocation(x, y);
    this.c = c;
    
    this.delay = 1000 / speed;
    this.deltaTime = (double) (this.delay) / 1000;
    timer = new Timer(this.delay, this);
    timer.setInitialDelay(0);
    timer.start(); 
  }
  
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    ArrayList<cs5004.Shapes.Shape> shapes = c.getShapes(time);
    
    for (int i = 0; i < shapes.size(); i++) {
      cs5004.Shapes.Shape s = shapes.get(i);
      if (s.getType() == "Rect") {
        g.setColor(new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB()));
        g.fillRect(s.getPos().getX(), s.getPos().getY(), s.getW(), s.getH());
      } else {
        g.setColor(new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB()));
        g.fillOval(s.getPos().getX(), s.getPos().getY(), s.getW(), s.getH());
      }
    }
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(time);
    if (time > this.c.getEndTime()) {
      timer.stop();
    }
    this.repaint();
    this.time+=this.deltaTime;
  }
  
}
