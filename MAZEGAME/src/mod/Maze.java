package mod;

//This class responsible for the spawn points of mins., player start and end, sword place, and traps. 
public class Maze {
  private Map _map;
  
  private Location _start;
  
  private Location _end;
  
  private Location _spawn;
  
  private Location _spawn2;
  
  private Location _spawn3;
  
  private Location _sword;
  
  private Location _trap;
  
  public Map getMap() {
    return this._map;
  }
  
  public Location getStart() {
    return this._start;
  }
  
  public Location getEnd() {
    return this._end;
  }
  
  public Location getSpawn() {
    return this._spawn;
  }
  
  public Location getSpawn2() {
    return this._spawn2;
  }
  
  public Location getSpawn3() {
    return this._spawn3;
  }
  
  public Location getSword() {
    return this._sword;
  }
  
  public Location getTrap() {
    return this._trap;
  }
  
  public void setSpawn1(int row, int col) {
    this._spawn.setRow(row);
    this._spawn.setCol(col);
  }
  
  public void setSpawn2(int row, int col) {
    this._spawn2.setRow(row);
    this._spawn2.setCol(col);
  }
  
  public void setSpawn3(int row, int col) {
    this._spawn3.setRow(row);
    this._spawn3.setCol(col);
  }
  
  public void setTrap(int row, int col) {
    this._trap.setRow(row);
    this._trap.setCol(col);
  }
  
  public void setStart(int row, int col) {
    this._start.setRow(row);
    this._start.setCol(col);
  }
  
  public void setEnd(int row, int col) {
    this._end.setRow(row);
    this._end.setCol(col);
  }
  
  public void setMap(Map map) {
    this._map = map;
  }
  
  public void setSword(int row, int col) {
    this._sword.setRow(row);
    this._sword.setCol(col);
  }
  
  public Maze() {
    this._map = Map.Easy;
    this._start = new Location(8, 1);
    this._end = new Location(0, 8);
    this._spawn = new Location(1, 1);
    this._spawn2 = new Location(4, 6);
    this._spawn3 = new Location(1, 3);
    this._sword = new Location(-1, -1);
    this._trap = new Location(3, 7);
  }
  
  public Maze(int x) {
    if (x == 1) {
      this._map = Map.Easy;
      this._start = new Location(9, 1);
      this._end = new Location(0, 9);
      this._spawn = new Location(0, 0);
      this._sword = new Location(7, 1);
    } else {
      this._map = Map.Easy;
      this._start = new Location(9, 1);
      this._end = new Location(0, 9);
      this._spawn = new Location(0, 0);
      this._sword = new Location(7, 1);
    } 
  }
}