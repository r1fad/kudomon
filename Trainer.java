import java.util.ArrayList;

// a class to model Trainers
public class Trainer{

  // Define instance variables

  // to store x coordinate of trainer in the grid
  private int xCoord;

  // to store y cooridnate of trainer in the grid
  private int yCoord;

  // an array list to store all kudomons captured by the trainer
  private ArrayList<Kudomon> trainerKudomons;

  // Constructor
  public Trainer(){
    trainerKudomons = new ArrayList<Kudomon>();
  }// Constructor Trainer

  // return x coordinate of the trainer
  public int getX(){
    return this.xCoord;
  }

  // return y cooridnate of the trainer
  public int getY(){
    return this.yCoord;
  }

  // mutator method to set the x coordinate of the trainer
  public void setX(int requiredX){
    this.xCoord = requiredX;
  }

  // mutator method to set the y cooridnate of the trainer
  public void setY(int requiredY){
    this.yCoord = requiredY;
  }

  // method to add given kudomon to array list
  public void catchKudomon(Kudomon kudomonToCatch){
    this.trainerKudomons.add(kudomonToCatch);
  }// catchKudomon

  // override toString to print postion of the trainer
  @Override
  public String toString(){
    return "Trainer is at ("+this.xCoord+", "+this.yCoord+")";
  }// toString

  public ArrayList<Kudomon> getTrainerKudomons(){
    return this.trainerKudomons;
  }

}// Trainer
