package CW;

/**
 * Cretes the Pannel for the Crossword Itself
 * @author sophianunez
 *
 */
public class Maze {
  private boolean[][] blackSquares = new boolean[][] { { false, false, false, true }, { false, true, true, true }, { false, true, true, true, true, true, true }, { true, true, true, true, true, true }, { false, true, true, true, true }, { true, true, true, true, true, true, true, true, true }, { false, true, true, true, true }, { false, true, true }, { false, true, true, true, true, true, true, true, true }, { false, true } };
  
  private boolean toBeLabeled(int r, int c) {
    return (this.blackSquares[r][c] && (r == 0 || c == 0 || (!this.blackSquares[r - 1][c] && this.blackSquares[r + 1][c]) || (!this.blackSquares[r - 1][c] && !this.blackSquares[r][c - 1])));
  }
  
  //Blocked and unblocked spaces
  public String[][] Crossword() {
    int x = 1;
    String[][] Map = new String[10][10];
    for (int i = 0; i < this.blackSquares.length; i++) {
      for (int j = 0; j < this.blackSquares.length; j++) {
        String xx = new String("");
        xx = String.valueOf(xx) + x;
        if (toBeLabeled(i, j)) {
          Map[i][j] = String.valueOf(xx) + "     ";
          x++;
        } else if (this.blackSquares[i][j]) {
          Map[i][j] = "O     ";
        } else {
          Map[i][j] = "X     ";
        } 
      } 
    } 
    return Map;
  }
  
  //Turns guess to the string
  public String CrossString() {
    String blank = new String("");
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++)
        blank = String.valueOf(blank) + Crossword()[i][j]; 
      blank = String.valueOf(blank) + "\n";
    } 
    return blank;
  }
  
  public Maze() {
    Crossword();
  }
}