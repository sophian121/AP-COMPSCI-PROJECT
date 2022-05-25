package mod;

//CLASS DETERMINES DIFFERENT STATES OF PLAYER
public class Player {
  private Location _position;
  
  private boolean _isDead;
  
  private boolean _hasSword;
  
  private String _name;
  
  public Location getLoc() {
    return this._position;
  }
  
  public boolean isDead() {
    return this._isDead;
  }
  
  public boolean hasSword() {
    return this._hasSword;
  }
  
  public String getName() {
    return this._name;
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
  
  public void kill() {
    this._isDead = true;
  }
  
  public void revive() {
    this._isDead = false;
  }
  
  public void breakSword() {
    this._hasSword = false;
  }
  
  public void giveSword() {
    this._hasSword = true;
  }
  
  public Player(Location pos, String name) {
    this._position = pos;
    this._isDead = false;
    this._hasSword = false;
    this._name = name;
  }
}
