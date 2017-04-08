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

  // to store health points.
  private int health;

  // to store combat points.
  private int combatPoints;

  //Constructor
  public Kudomon(String requiredSpecies, String requiredType,
                                         int requiredCombatPoints)
  {
    this.species = requiredSpecies;
    this.type = requiredType;

    // all kudomon have the same health points
    this.health = 50;
    this.combatPoints = requiredCombatPoints;
  }// Constructor Kudomon

  //return x coordinate
  public int getX(){
    return this.xCoord;
  }// getX

  //return y coordinate
  public int getY(){
    return this.yCoord;
  }// getY

  // accessor method to return species
  public String getSpecies(){
    return this.species;
  }// getSpecies

  // accessor method to return type
  public String getType(){
    return this.type;
  }// getType

  // mutator method to set x coordinate
  public void setX(int requiredX){
    this.xCoord = requiredX;
  }// setX

  // mutator method to set y coordinate
  public void setY(int requiredY){
    this.yCoord = requiredY;
  }// setY

  public int getHealth(){
    return this.health;
  }// getHealth

  public void reduceHealth(int value){
    this.health -= value;
  }// reduceHealth

  public int getCombatPoints(){
    return this.combatPoints;
  }// getCombatPoints

  public void inflictDamage(Kudomon other){
    other.reduceHealth(this.combatPoints);
    System.out.println(this+" infilicted "+this.combatPoints+
                                            " damage points on "+ other);
    System.out.println(other+" Health now: "+other.getHealth());
  }// inflictDamage

  // overide toString to print species and type of kudomon
  @Override
  public String toString(){
    return this.species+" ("+this.type+")";
  }// toString

}// Kudomon
