// A class to model cells that will be placed in the grid
public class Cell{

  // define all the instance variables

  private int xCoord; //x coordinate of cell
  private int yCoord; // y coordinate of cell

  // boolean to determine if cell is empty or not
  private boolean empty;

  // boolean to determine if given cell has a kudomon
  private boolean kudomonExists;
  
  private Kudomon kudomon; //to store kudomon
  private Trainer trainer; // to store trainer

  //Constructor
  public Cell(int requiredX, int requiredY){
    this.xCoord = requiredX;
    this.yCoord = requiredY;
    this.empty = true;
  }// Constructor Cell

  // an accessor method to return value of 'empty' of cell
  public boolean isEmpty(){
    return this.empty;
  }// isEmpty

  // an accessor method to detemrine if given cell has kudomon
  public boolean isKudomon(){
    return this.kudomonExists;
  }// isKudomon

  // a mutator method to set given kudomon to the cell
  public void setKudomon(Kudomon requiredKudomon){
    this.kudomon = requiredKudomon;
    this.empty = false;
    this.kudomonExists = true;
  }// setKudomon

  // an accessor method to return kudomon in this cell
  public Kudomon getKudomon(){
    return this.kudomon;
  }// getKudomon

  // mutator method to clear a kudomon
  public void clearKudomon(){
    this.kudomon = null;
    this.empty = true;
    this.kudomonExists = false;
  }// clearKudomon

  // mutator method to set trainer in this cell
  public void setTrainer(Trainer requiredTrainer){
    this.trainer = requiredTrainer;
    this.empty=false;
  }// setTrainer

  // mutator method to remove trainer from the cell
  public void clearTrainer(){
    this.trainer = null;
    this.empty = false;
  }// clearTrainer

}// Cell
