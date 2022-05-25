package mod;

import viewcon.Controller;

public class Overseer {
  private Controller _cnt;
  
  private Maze _maze;
  
  private Player _ply;
  
  private Minotaur _min;
  
  private Minotaur _min2;
  
  private Minotaur _min3;
  
  private String _name;
  
  public boolean tKill = false;
  
  private int _win;
  
  private boolean defeat;
  
  public boolean getDefeat() {
    return this.defeat;
  }
  
  //START POINTS FOR EVERYONE AND PLAYER SWORD 
  public Overseer(int win, String name) {
    this._win = win;
    this.defeat = false;
    this._maze = new Maze();
    if (win == 1) {
      this._maze.setMap(Map.Easy2);
      this._maze.setStart(9, 8);
      this._maze.setEnd(0, 6);
      this._maze.setSpawn1(1, 8);
      this._maze.setSpawn2(8, 2);
      this._maze.setSpawn3(3, 5);
      this._maze.setTrap(3, 3);
      this._maze.setSword(6, 8);
    } else if (win == 2) {
      this._maze.setMap(Map.Easy3);
      this._maze.setStart(9, 6);
      this._maze.setEnd(0, 6);
      this._maze.setSpawn1(1, 6);
      this._maze.setSpawn2(8, 8);
      this._maze.setSpawn3(7, 3);
      this._maze.setTrap(9, 6);
      this._maze.setSword(8, 6);
    } 
    this._min = new Minotaur(this._maze.getSpawn());
    this._min2 = new Minotaur(this._maze.getSpawn2());
    this._min3 = new Minotaur(this._maze.getSpawn3());
    this._name = name;
    this._ply = new Player(this._maze.getStart(), this._name);
    this._cnt = new Controller(this._ply, this._min, this._min2, this._min3, this._maze, this._name, "Use wasd to move. Sword:" + this._ply.hasSword());
    update(win);
  }
  
  //KEY INPUT
  public Controller getCnt() {
    return this._cnt;
  }
  
  
  //NAME OF PLAYER
  public String getName() {
    return this._name;
  }
  
  //UPDATES STATS AND DETERMINES IF PLATER WINS OR LOSES, DEAD
  private void update(int win) {
    int pRow = this._ply.getLoc().getRow(), pCol = this._ply.getLoc().getCol(), mRow = this._min.getLoc().getRow(), mCol = this._min.getLoc().getCol();
    int m2Row = this._min2.getLoc().getRow(), m2Col = this._min2.getLoc().getCol(), m3Row = this._min3.getLoc().getRow(), m3Col = this._min3.getLoc().getCol();
    int endRow = this._maze.getEnd().getRow(), endCol = this._maze.getEnd().getCol();
    int sRow = this._maze.getSword().getRow(), sCol = this._maze.getSword().getCol(), tRow = this._maze.getTrap().getRow(), tCol = this._maze.getTrap().getCol();
    while ((pRow != endRow || pCol != endCol) && 
      !this._ply.isDead()) {
      movePlayer(this._cnt.move());
      moveMinotaur(this._min);
      moveMinotaur(this._min2);
      moveMinotaur(this._min3);
      pRow = this._ply.getLoc().getRow();
      pCol = this._ply.getLoc().getCol();
      mRow = this._min.getLoc().getRow();
      mCol = this._min.getLoc().getCol();
      m2Row = this._min2.getLoc().getRow();
      m2Col = this._min2.getLoc().getCol();
      m3Row = this._min3.getLoc().getRow();
      m3Col = this._min3.getLoc().getCol();
      if (pRow == tRow && pCol == tCol) {
        this._ply.kill();
        this.tKill = true;
      } 
      if (pRow == sRow && pCol == sCol) {
        this._ply.giveSword();
        this._cnt.hideSword();
      } 
      pVE(pRow, pCol, mRow, mCol, this._min);
      pVE(pRow, pCol, m2Row, m2Col, this._min2);
      pVE(pRow, pCol, m3Row, m3Col, this._min3);
      this._cnt.updateMsg("Use wasd to move. Sword:" + this._ply.hasSword());
    } 
    if (!this._ply.isDead()) {
      this._cnt.victory(win);
    } else {
      this._cnt.defeat(this.tKill);
      this.defeat = true;
    } 
  }
  //PLAYER HAS SWORD AND IT BREAKS OR NOT MIN IS DEAD OR NOT AND KILLS PLAYER
  private void pVE(int pRow, int pCol, int mRow, int mCol, Minotaur _min) {
    if (!_min.isDead())
      if (pRow == mRow && pCol == mCol && !this._ply.hasSword()) {
        this._ply.kill();
      } else if (pRow == mRow && pCol == mCol && this._ply.hasSword()) {
        if (!breakSword()) {
          _min.kill();
        } else {
          this._ply.kill();
        } 
      }  
  }
 //SWORD BREAK AND % IT HAS TO BREAK 
  private boolean breakSword() {
    int x = (int)(Math.random() + 0.5D);
    return (x == 1);
  }
  
  //PLAYER MOVING 
  private void movePlayer(Direction d) {
    if (d == Direction.UP) {
      this._ply.moveUp();
    } else if (d == Direction.DOWN) {
      this._ply.moveDown();
    } else if (d == Direction.LEFT) {
      this._ply.moveLeft();
    } else {
      this._ply.moveRight();
    } 
  }
 
  //MOVE MINOTAUR
  
  private void moveMinotaur(Minotaur _min) {
    int _minRow = _min.getLoc().getRow();
    int _minCol = _min.getLoc().getCol();
    boolean[][] map = this._maze.getMap().getArr();
    int rowDist = _min.getLoc().getRow() - this._ply.getLoc().getRow();
    int colDist = _min.getLoc().getCol() - this._ply.getLoc().getCol();
    if (rowDist > 0) {
      if (map[_minRow - 1][_minCol]) {
        _min.moveUp();
      } else if (colDist > 0 && map[_minRow][_minCol - 1]) {
        _min.moveLeft();
      } else if (colDist < 0 && map[_minRow][_minCol + 1]) {
        _min.moveRight();
      } 
    } else if (rowDist < 0) {
      if (map[_minRow + 1][_minCol]) {
        _min.moveDown();
      } else if (colDist > 0 && map[_minRow][_minCol - 1]) {
        _min.moveLeft();
      } else if (colDist < 0 && map[_minRow][_minCol + 1]) {
        _min.moveRight();
      } 
    } else if (colDist > 0 && map[_minRow][_minCol - 1]) {
      _min.moveLeft();
    } else if (colDist < 0 && map[_minRow][_minCol + 1]) {
      _min.moveRight();
    } 
  }
}