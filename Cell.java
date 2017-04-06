public class Cell{

  private int xCoord; //x coordinate of cell
  private int yCoord; // y coordinate of cell
  private boolean empty; // boolean to determine if cell is empty or not

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

}// Cell
