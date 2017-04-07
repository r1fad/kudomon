import java.util.ArrayList;

public class Trainer{

  private int xCoord;
  private int yCoord;
  private ArrayList<Kudomon> trainerKudomons;

  public Trainer(){
    trainerKudomons = new ArrayList<Kudomon>();
  }// Trainer

  public int getX(){
    return xCoord;
  }

  public int getY(){
    return yCoord;
  }

  public void setX(int requiredX){
    this.xCoord = requiredX;
  }

  public void setY(int requiredY){
    this.yCoord = requiredY;
  }

  public void catchKudomon(Kudomon kudomonToCatch){
    trainerKudomons.add(kudomonToCatch);
  }// catchKudomon

  @Override
  public String toString(){
    return "Trainer is at ("+xCoord+", "+yCoord+")";
  }// toString

}// Trainer
