public class Kudomon{

  private String species;
  private String type;
  private int xCoord;
  private int yCoord;

  public Kudomon(String reqSpecies, String reqType)
  {
    this.species = reqSpecies;
    this.type = reqType;
    this.xCoord = (int)(Math.random()*100);
    this.yCoord = (int)(Math.random()*100);
  }// Constructor Kudomon

  public int getX(){
    return xCoord;
  }

  public int getY(){
    return yCoord;
  }

}// Kudomon
