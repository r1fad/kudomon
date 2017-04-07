public class Cell{

  private int xCoord; //x coordinate of cell
  private int yCoord; // y coordinate of cell
  private boolean empty; // boolean to determine if cell is empty or not
  private boolean kudomonExists;
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

  public boolean isKudomon(){
    return kudomonExists;
  }

  public void setKudomon(Kudomon requiredKudomon){
    this.kudomon = requiredKudomon;
    this.empty = false;
    this.kudomonExists = true;
  }

  public Kudomon getKudomon(){
    return this.kudomon;
  }// getKudomon

  public void clearKudomon(){
    this.kudomon = null;
    this.empty = true;
    this.kudomonExists = false;
  }

  public void setTrainer(Trainer requiredTrainer){
    this.trainer = requiredTrainer;
    this.empty=false;
  }

  public void clearTrainer(){
    this.trainer = null;
    this.empty = false;
  }

}// Cell
