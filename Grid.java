import java.util.ArrayList;
public class Grid{

  // a class variable to store size of square grid
  public static int GRID_SIZE = 50;

  //a 2D array to model the grid. it contains cell objects
  private static Cell[][] GRID = new Cell[GRID_SIZE][GRID_SIZE];

  public static void initializeGrid(){
    //add cell objects
    for (int x=0 ; x<GRID_SIZE ; x++ ) {
      for (int y=0 ; y<GRID_SIZE ; y++ ) {
        GRID[x][y] = new Cell(x,y);
      }// for y
    }// for x
    System.out.println("Grid Initialized");
  }// initializeGrid

  public static void clearKudomonCell(Kudomon requiredKudomon){
    int xOfKudomon = requiredKudomon.getX();
    int yOfKudomon = requiredKudomon.getY();
    GRID[xOfKudomon][yOfKudomon].clearKudomon();
  }// clearCell

  public static void addKudomon(Kudomon requiredKudomon){
    requiredKudomon.setX((int)(Math.random()*Grid.GRID_SIZE));
    requiredKudomon.setY((int)(Math.random()*Grid.GRID_SIZE));
    Cell kudomonCell = GRID[requiredKudomon.getX()][requiredKudomon.getY()];
    if (kudomonCell.isEmpty()){
      kudomonCell.setKudomon(requiredKudomon);
    }// if
    else
      System.out.println("failed to add kudomon to grid");
  }// addKudomon

  public static void addTrainer(Trainer requiredTrainer){
    requiredTrainer.setX((int)(Math.random()*Grid.GRID_SIZE));
    requiredTrainer.setY((int)(Math.random()*Grid.GRID_SIZE));
    Cell trainerCell = GRID[requiredTrainer.getX()][requiredTrainer.getY()];
    if (trainerCell.isEmpty())
      trainerCell.setTrainer(requiredTrainer);
  }// addTrainer

  public static ArrayList<Kudomon> findNearbyKudomon(Trainer requiredTrainer){
    ArrayList<Kudomon> listOfNearbyKudomon = new ArrayList<Kudomon>();
    for (int x = 0; x<GRID_SIZE; x++)
      for (int y = 0; y<GRID_SIZE; y++){
        if (GRID[x][y].isKudomon()){
          Kudomon kudomon = GRID[x][y].getKudomon();
          double distanceFromTrainer;
          distanceFromTrainer =
            Math.sqrt(Math.pow((requiredTrainer.getX()-kudomon.getX()),2)+
                      Math.pow((requiredTrainer.getY()-kudomon.getY()),2));
          if (distanceFromTrainer <= 10.0){
            listOfNearbyKudomon.add(kudomon);
          }
        }//if
      }// for
      if (listOfNearbyKudomon.size() == 0)
        System.out.println("No kudomon within a 10 unit radius, try again.");
      return listOfNearbyKudomon;
  }// findNearbyKudomon

}// Grid
