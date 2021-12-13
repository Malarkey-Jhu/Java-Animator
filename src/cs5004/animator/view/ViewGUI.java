package cs5004.animator.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cs5004.IController;

/**
 * GUI View.
 */
public class ViewGUI extends JFrame  implements IView, ActionListener {
  
  private int x = 0;
  private int y = 0;
  private int width = 1000;
  private int height = 600;
  private JMenuBar menuBar;
  private JMenu file;
  private JMenuItem exit;
  private IController c;
  
  /**
   * Initialize the View.
   */
  public ViewGUI() {
    super("Animation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  /**
   * set canvas size.
   * @param x x
   * @param y y
   * @param w width
   * @param h height
   */
  public void setCanvas(int x, int y, int w, int h) {
    this.setSize(w, h);
    this.setLocation(x, y);
  }
  
  @Override
  public void addController(IController c) {
    this.c = c;
  }
  
  @Override
  public void display(int speed) {
    this.menuBar = new JMenuBar();
    this.setJMenuBar(this.menuBar);
    this.file = new JMenu("File");
    this.menuBar.add(this.file);
    this.exit = new JMenuItem("Exit");
    this.exit.setName("Quit");
    this.exit.addActionListener(this);
    this.file.add(this.exit);
    Component apanel = new APanel(c, x, y, width, height, speed);
    this.add(apanel);
    apanel.repaint();
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("Quit")) {
      System.exit(0);
    }
  }


}
