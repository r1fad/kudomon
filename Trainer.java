import java.util.ArrayList;
public class Trainer{
  private int xCoord;
  private int yCoord;
  private ArrayList trainerKudomons = new ArrayList();

  public Trainer(){
    this.xCoord = (int)(Math.random()*100);
    this.yCoord = (int)(Math.random()*100);
  }// Trainer

  public int getX(){
    return xCoord;
  }

  public int getY(){
    return yCoord;
  }

}// Trainer
