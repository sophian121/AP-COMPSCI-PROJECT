package CW;

import javax.swing.JOptionPane;

/**
 * This class is the words;hints;updates board; messages to display
 * @author sophianunez
 *
 */

public class Viewcon {
  private Maze board = new Maze();
  
  private String names = new String("names");
  
  private int tries = 0;
  
  private String blanks = this.board.CrossString();
  
  //Word List
  private String[] words = new String[] { "Bandaid", "Beautiful", "Laces", "Ciao", "Band", "Calm", "Stainless", "Self", "Helpfull" };
  
  private boolean[] solve = new boolean[] { false, false, false, false, false, false, false, false, false, true };
  
  //Hints for Words
  private String[] hints = new String[] { "Sticky and put on a boo-boo", "Used to describe a person or thing that is pleaasting to the eye.", "On shoes used to tie them", "Hello and Goodbye in Italian", "A group of musicians. ex. The Beatles", "Trnquil  ", "unmarked by or resistant to stains or discoloration.", "a person's essential being that distinguishes them from others, especially considered as the object of introspection or reflexive action. or One's S _ _ F", 
      "Giving or ready to recieve help" };
 
  //Pick which word to guess
  private int C() {
    while (true) {
      String c = JOptionPane.showInputDialog(String.valueOf(this.blanks) + "\n" + "Select a number:" + "\n");
      if (Integer.valueOf(c).intValue() >= 1 && Integer.valueOf(c).intValue() <= 9)
        return Integer.valueOf(c).intValue(); 
    } 
  
  }
  
  //Display what is solved if Rico show
  private void solved() {
    int cc = C();
    String message = new String("Word:");
    if (this.names.equalsIgnoreCase("rico")) {
      message = "Answer " + this.words[cc - 1];
      this.tries = 0;
    } 
    String s = JOptionPane.showInputDialog(String.valueOf(this.hints[cc - 1]) + "\n" + message + "\n");
    if (s.equalsIgnoreCase(this.words[cc - 1])) {
      this.solve[cc - 1] = true;
      JOptionPane.showMessageDialog(null, "Correctomundo!");
    } else if (s.equalsIgnoreCase("rico")) {
      this.names = "rico";
      JOptionPane.showMessageDialog(null, "Hello!");
    } else {
      this.tries++;
      String z = new String("Incorrect! #:  ");
      z = String.valueOf(z) + (6 - this.tries);
      z = String.valueOf(z) + " tries left";
      JOptionPane.showMessageDialog(null, z);
    } 
  }
  //Update crossword frame
  public void blanksUpdate() {
    while (true) {
      solved();
      boolean wins = true;
      this.blanks = "";
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++)
          this.blanks = String.valueOf(this.blanks) + this.board.Crossword()[i][j]; 
        this.blanks = String.valueOf(this.blanks) + "\n";
        if (!this.solve[i])
          wins = false; 
      } 
      if (this.tries > 5) {
        JOptionPane.showMessageDialog(null, "You Lost");
        break;
      } 
      if (wins) {
        JOptionPane.showMessageDialog(null, "Win!!");
        break;
      } 
    } 
  }
  
  public Viewcon() {
    blanksUpdate();
  }
}
