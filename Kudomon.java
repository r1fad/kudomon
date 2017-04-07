// A class to model kudmons
public class Kudomon{

  //Define instance variables

   //name of speices
  private String species;

  // type of kudomon i.e water, fire, electric, rock, psychic and grass
  private String type;

  // to store the x coordinate of the kudomon in the grid
  private int xCoord;

  // to store the y coordinate of the kudomon in the grid
  private int yCoord;

  //Constructor
  public Kudomon(String reqSpecies, String reqType)
  {
    this.species = reqSpecies;
    this.type = reqType;
  }// Constructor Kudomon

  //return x coordinate
  public int getX(){
    return this.xCoord;
  }// getX

  //return y coordinate
  public int getY(){
    return this.yCoord;
  }// getY

  // mutator method to set x coordinate
  public void setX(int requiredX){
    this.xCoord = requiredX;
  }// setX

  // mutator method to set y coordinate
  public void setY(int requiredY){
    this.yCoord = requiredY;
  }// setY

  // overide toString to print species and type of kudomon
  @Override
  public String toString(){
    return this.species+" ("+this.type+")";
  }// toString

}// Kudomon
