package viewcon;

/** CLASS CONTROLS THE GAME
 * 
 */
import javax.swing.JOptionPane;
import mod.Direction;
import mod.Maze;
import mod.Minotaur;
import mod.Player;

public class Controller {
  private Player _ply;
  
  private Minotaur _min;
  
  private Minotaur _min2;
  
  private Minotaur _min3;
  
  private Maze _map;
  
  private String _name;
  
  private String _msg;
  
  private boolean hideSword;
  
  private int win;
  
  public int getWin() {
    return this.win;
  }
  
  public void hideSword() {
    this.hideSword = true;
  }
  
  public void showSword() {
    this.hideSword = false;
  }
  
  public Controller(Player ply, Minotaur min, Minotaur min2, Minotaur min3, Maze map, String name, String m) {
    this._ply = ply;
    this._min = min;
    this._min2 = min2;
    this._min3 = min3;
    this._map = map;
    this._name = name;
    this._msg = m;
  }
  
  private String getName() {
    return this._name;
  }
  
  public void updateMsg(String newMsg) {
    this._msg = newMsg;
  }
  
  //DETERMINES IF PLAYER MOVEMENT IS VALID (IF IT CAN MOVE TO SPACE OR NOT) 
  public Direction move() {
    String s = JOptionPane.showInputDialog(String.valueOf(drawMap()) + "\n" + this._msg + "\n");
    Direction d = convertInput(s);
    while (!isValid(d)) {
      JOptionPane.showMessageDialog(null, "Move not valid");
      s = JOptionPane.showInputDialog(String.valueOf(drawMap()) + "\n" + this._msg + "\n");
      d = convertInput(s);
    } 
    return d;
  }
  
  //IF NOTHING BLOCK MOVE
  private boolean isValid(Direction d) {
    boolean[][] map = this._map.getMap().getArr();
    int row = this._ply.getLoc().getRow();
    int col = this._ply.getLoc().getCol();
    if (d == Direction.UP) {
      if (row == 0)
        return false; 
      row--;
      return map[row][col];
    } 
    if (d == Direction.DOWN) {
      if (row == map.length - 1)
        return false; 
      row++;
      return map[row][col];
    } 
    if (d == Direction.LEFT) {
      if (col == 0)
        return false; 
      col--;
      return map[row][col];
    } 
    if (col == (map[row]).length - 1)
      return false; 
    col++;
    return map[row][col];
  }
  
  //KEYS TO MAKE PLAYER MOVE
  private Direction convertInput(String s) {
    if (s.equals("w"))
      return Direction.UP; 
    if (s.equals("a"))
      return Direction.LEFT; 
    if (s.equals("s"))
      return Direction.DOWN; 
    if (s.equals("d"))
      return Direction.RIGHT; 
    return Direction.UP;
  }
  //LEVELING UP AND FINISHING ALL LEVELS
  public void victory(int win) {
    if (win == 0) {
      JOptionPane.showMessageDialog(null, String.valueOf(drawMap()) + "\n" + "Next level" + "\n" + "However, you're not done yet");
    } else if (win == 1) {
      JOptionPane.showMessageDialog(null, String.valueOf(drawMap()) + "\n" + "You're still not done" + "\n" + "idk tng");
    } else if (win == 2) {
      JOptionPane.showMessageDialog(null, String.valueOf(drawMap()) + "\n" + "OMG Congrats!!! " + "\n");
    } 
  }
  
  //SWORD BREAKS AGAINST MINOTAUR DEFEAT, PLAYER DIES DEFEAT
  public void defeat(boolean tkill) {
    if (!this._ply.hasSword() && !tkill) {
      JOptionPane.showMessageDialog(null, String.valueOf(drawMap()) + "\n" + "Defeat" + "\n");
    } else if (tkill) {
      JOptionPane.showMessageDialog(null, String.valueOf(drawMap()) + "\n" + "Lol get nerfed " + "\n" + "Defeat");
    } else {
      JOptionPane.showMessageDialog(null, String.valueOf(drawMap()) + "\n" + "Broken sword " + "\n" + "Defeat");
    } 
  }
  
  //CHARACTERS AND MAP 
  private String drawMap() {
    String MAP = "";
    String ply = "☺";
    String wall = "▢";
    String path = " o ";
    String space = "  ";
    String min = "℧";
    String min2 = "℧";
    String min3 = "℧";
    String trap = path;
    if (this._ply.getName().equalsIgnoreCase("Rico"))
      trap = "☠"; 
    String end = "✪";
    String sword = "⚔︎";
    if (this.hideSword)
      sword = path; 
    int pRow = this._ply.getLoc().getRow();
    int pCol = this._ply.getLoc().getCol();
    int mRow = this._min.getLoc().getRow();
    int mCol = this._min.getLoc().getCol();
    int m2Row = this._min2.getLoc().getRow();
    int m2Col = this._min2.getLoc().getCol();
    int m3Row = this._min3.getLoc().getRow();
    int m3Col = this._min3.getLoc().getCol();
    int eRow = this._map.getEnd().getRow();
    int eCol = this._map.getEnd().getCol();
    int sRow = this._map.getSword().getRow();
    int sCol = this._map.getSword().getCol();
    int tRow = this._map.getTrap().getRow();
    int tCol = this._map.getTrap().getCol();
    boolean[][] map = this._map.getMap().getArr();
    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < (map[r]).length; c++) {
        if (r == pRow && c == pCol) {
          MAP = String.valueOf(MAP) + ply + space;
        } else if (r == mRow && c == mCol) {
          MAP = String.valueOf(MAP) + min + space;
        } else if (r == m2Row && c == m2Col) {
          MAP = String.valueOf(MAP) + min + space;
        } else if (r == m3Row && c == m3Col) {
          MAP = String.valueOf(MAP) + min + space;
        } else if (r == tRow && c == tCol) {
          MAP = String.valueOf(MAP) + trap + space;
        } else if (r == eRow && c == eCol) {
          MAP = String.valueOf(MAP) + end + space;
        } else if (r == sRow && c == sCol) {
          MAP = String.valueOf(MAP) + sword + space;
        } else if (map[r][c]) {
          MAP = String.valueOf(MAP) + path + space;
        } else {
          MAP = String.valueOf(MAP) + wall + space;
        } 
      } 
      MAP = String.valueOf(MAP) + "\n";
    } 
    return MAP;
  }
}