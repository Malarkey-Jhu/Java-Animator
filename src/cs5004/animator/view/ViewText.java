package cs5004.animator.view;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import cs5004.IController;

/**
 * Text view.
 */
public class ViewText implements IView {
  OutputType type;
  Appendable output;
  IController c;
  
  /**
   * Initialize Text View.
   * @param v Appendable output source.
   */
  public ViewText(Appendable v) {
    this.output = v;
    this.type = OutputType.TEXT;
  }
  
  /**
   * Initialize Text View.
   * @param v Writer output source.
   */
  public ViewText(Writer v) {
    this.output = v;
    this.type = OutputType.SVG;
  }
  
  /**
   * display text in terminal.
   * @param speed speed.
   */
  private void textDisplay(int speed) {
    Scanner sc = new Scanner(this.c.getTextOutput()).useDelimiter("\n");
    
    while (sc.hasNext()) {
      try {
        int interval = 1000 / speed;
        Thread.sleep(interval);
        this.output.append(sc.next() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    sc.close();
  }
  
  /**
   * write svg tags to a file.
   */
  private void svgDisplay() {
    Writer writer = (Writer) output;
    try {
      String res = this.c.getSVGTextOutput();
      writer.write(res);
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  @Override
  public void display(int speed) {
    if (this.type == OutputType.TEXT) {
      textDisplay(speed);
    } else {
      svgDisplay();
    }
  }

  @Override
  public void addController(IController c) {
    this.c = c;
  }

}
