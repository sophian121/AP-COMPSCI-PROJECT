package mod;

//Gets the location of player
public class Location {
  private int _row;
  
  private int _col;
  
  public int getRow() {
    return this._row;
  }
  
  public int getCol() {
    return this._col;
  }
  
  public void moveDown() {
    this._row++;
  }
  
  public void moveUp() {
    this._row--;
  }
  
  public void moveLeft() {
    this._col--;
  }
  
  public void moveRight() {
    this._col++;
  }
  
  public void setRow(int row) {
    this._row = row;
  }
  
  public void setCol(int col) {
    this._col = col;
  }
  
  public Location(int row, int col) {
    this._row = row;
    this._col = col;
  }
}
