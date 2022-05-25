package mod;

//Creates map of spaces that are available to move to and not available to move to. 
public enum Map {
  Easy(new boolean[][] { { false, false, false, false, false, false, false, false, true }, { false, true, true, true }, { false, true, true, true, true }, { false, false, false, true, true, true, true }, { false, false, false, true, true, true }, { false, false, false, true, true }, { false, true, true, true, true, true, true, true, true }, { false, true }, { false, true }, new boolean[10] }),
  Easy2(new boolean[][] { { false, false, false, false, false, false, true }, { false, false, false, true, true, true, true, true }, { false, true, true, true, true }, { false, true, true, true, true, true, true }, { false, true, true, true }, { false, true, true, true }, { false, true, true, true, true }, { false, true, true, true, true }, { false, true, true, true, true, true, true, true }, { false, false, false, false, false, false, false, false, true } }),
  Easy3(new boolean[][] { { false, false, false, false, false, false, true }, { false, false, false, false, false, false, true }, { false, false, false, false, false, false, true }, { false, false, false, false, false, false, true }, { false, false, false, false, false, false, true }, { false, false, false, false, false, false, true }, { false, false, false, true, true, true, true }, { false, false, false, true, true, true, true }, { false, false, false, false, false, false, true, true }, { false, false, false, false, false, false, true } });
  
  private boolean[][] _map;
  
  public boolean[][] getArr() {
    return this._map;
  }
  
  Map(boolean[][] map) {
    this._map = map;
  }
}