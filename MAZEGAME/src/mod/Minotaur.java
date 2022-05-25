package mod;

//This class defines how minotaur can moce where they are and determine if it kills player and revive
public class Minotaur {
  private Location _position;
  
  private boolean _isDead;
  
  public Location getLoc() {
    return this._position;
  }
  
  public void moveUp() {
    this._position.moveUp();
  }
  
  public void moveDown() {
    this._position.moveDown();
  }
  
  public void moveLeft() {
    this._position.moveLeft();
  }
  
  public void moveRight() {
    this._position.moveRight();
  }
  
  public boolean isDead() {
    return this._isDead;
  }
  
  public void kill() {
    this._isDead = true;
  }
  
  public void revive() {
    this._isDead = false;
  }
  
  public Minotaur(Location pos) {
    this._position = pos;
    this._isDead = false;
  }
}