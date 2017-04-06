public class Cell{

  private int xCoord; //x coordinate of cell
  private int yCoord; // y coordinate of cell
  private boolean empty; // boolean to determine if cell is empty or not
  private Kudomon kudomon; //to store kudomon
  private Trainer trainer; // to store trainer
  //Constructor
  public Cell(int reqX, int reqY){
    this.xCoord = reqX;
    this.yCoord = reqY;
    this.empty = true;
  }// Constructor Cell

  public boolean isEmpty(){
    return empty;
  }// isEmpty

  public void setEmpty(boolean value){
    this.empty = value;
  }// setEmpty

  public void setKudomon(Kudomon requiredKudomon){
    this.kudomon = requiredKudomon;
    setEmpty(false);
  }

  public void clearKudomon(){
    this.kudomon = null;
    setEmpty(true);
  }

  public void setTrainer(Trainer requiredTrainer){
    this.trainer = requiredTrainer;
    System.out.println("Trainer is at ("+xCoord+", "+yCoord+")");
    setEmpty(false);
  }

  public void clearTrainer(){
    this.trainer = null;
    setEmpty(true);
  }

}// Cell
