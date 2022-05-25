package main;

import javax.swing.JOptionPane;
import mod.Overseer;

/**
 * Class runs the program itself. 
 * @author Sophia Nuñez
 *
 */

public class Main {
  private static int win = 0;
  
  public static void main(String[] args0) {
    String name = JOptionPane.showInputDialog("Enter a Name.");
    Overseer o = new Overseer(win++, name), o1 = null;
    if (!o.getDefeat())
      o1 = new Overseer(win++, name); 
    Object Overseer;
	if (!o.getDefeat() && !o1.getDefeat())
       Overseer = new Overseer(win, name); 
  }
}