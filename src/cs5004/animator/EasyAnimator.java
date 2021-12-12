package cs5004.animator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import cs5004.Controller;
import cs5004.IController;
import cs5004.IModel;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ViewGUI;
import cs5004.animator.view.ViewText;

public class EasyAnimator {
  
  public static void main(String[] args) {
    String intput = "";
    String output = "output.svg";
    String view= "text";
    int speed = 1;
    
    String s = String.join(" ", args);
    
    Scanner sc = new Scanner(s).useDelimiter("\\s");
   
    while (sc.hasNext()) {
      String cmd = sc.next();
      switch(cmd) {
      case "-in":
        intput = sc.next();
        break;
      case "-out":
        output = sc.next();
        break;
      case "-view":
        view = sc.next();
        break;
      case "-speed":
        speed = sc.nextInt();
        break;
      default:
      }
    }
    
    sc.close();
    
    System.out.println(intput + ": intput");
    System.out.println(output + ": output");
    System.out.println(view + ": view");
    System.out.println(speed + ": speed");
    
    try {
      IModel m = AnimationReader.parseFile(new BufferedReader(new FileReader(intput)), new AnimationBuilderImpl());
      IController c = new Controller(m, new ViewText(System.out));
      
      switch(view) {
        case "svg":
          File myFile = new File(output);
          c = new Controller(m, new ViewText(new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(output), "utf-8"))));
          break;
        case "text":
          c = new Controller(m, new ViewText(System.out));
          break;
        case "visual":
          c = new Controller(m, new ViewGUI());
      }
      c.start(speed);
    } catch (IOException e) {
      e.printStackTrace();
    }
  
  }
}
