import java.util.ArrayList;

// A class to model a square grid on which kudomons and trainers will be placed
public class Grid{

  // a class variable to store size of square grid
  public static int GRID_SIZE = 50;

  //a 2D array to model the grid. it contains objects from the Cell class
  private static Cell[][] GRID = new Cell[GRID_SIZE][GRID_SIZE];

  // fill the 2D array with cell objects
  public static void initializeGrid(){
    //add cell objects
    for (int x=0 ; x<GRID_SIZE ; x++ ) {
      for (int y=0 ; y<GRID_SIZE ; y++ ) {
        GRID[x][y] = new Cell(x,y);
      }// for y
    }// for x
    System.out.println("Grid Initialized");
  }// initializeGrid

  // remove a kudomon from a cell after it is captured by the trainer
  public static void clearKudomonCell(Kudomon requiredKudomon){
    int xOfKudomon = requiredKudomon.getX();
    int yOfKudomon = requiredKudomon.getY();
    GRID[xOfKudomon][yOfKudomon].clearKudomon();
  }// clearCell

  /* add kudomon to grid. the x and y coordinate of the kudomon is randomly
  generated. */
  public static void addKudomon(Kudomon requiredKudomon){
    //generate random x and y cooridnates
    requiredKudomon.setX((int)(Math.random()*Grid.GRID_SIZE));
    requiredKudomon.setY((int)(Math.random()*Grid.GRID_SIZE));
    Cell kudomonCell = GRID[requiredKudomon.getX()][requiredKudomon.getY()];
    // check if cell is empty. if empty then add kudomon to cell
    if (kudomonCell.isEmpty()){
      kudomonCell.setKudomon(requiredKudomon);
    }// if
    else
      System.out.println("failed to add kudomon to grid");
  }// addKudomon

  /* add trainer to grid. the x and y coordinate of the trainer is randomly
  generated. */
  public static void addTrainer(Trainer requiredTrainer){
    // generate random x and y coordinates
    requiredTrainer.setX((int)(Math.random()*Grid.GRID_SIZE));
    requiredTrainer.setY((int)(Math.random()*Grid.GRID_SIZE));
    Cell trainerCell = GRID[requiredTrainer.getX()][requiredTrainer.getY()];
    // check if cell is empty. if empty then add trainer to cell
    if (trainerCell.isEmpty())
      trainerCell.setTrainer(requiredTrainer);
  }// addTrainer

  /* Method to find kudomon which are in a 10 or less units away from the
  trainer. Method reutrns an ArrayList */
  public static ArrayList<Kudomon> findNearbyKudomon(Trainer requiredTrainer){
    ArrayList<Kudomon> listOfNearbyKudomon = new ArrayList<Kudomon>();
    for (int x = 0; x<GRID_SIZE; x++)
      for (int y = 0; y<GRID_SIZE; y++){
        // check if cell has a kudomon
        if (GRID[x][y].isKudomon()){
          Kudomon kudomon = GRID[x][y].getKudomon();
          double distanceFromTrainer;
          // find distance of kudomon from trainer
          distanceFromTrainer =
            Math.sqrt(Math.pow((requiredTrainer.getX()-kudomon.getX()),2)+
                      Math.pow((requiredTrainer.getY()-kudomon.getY()),2));
          // if distance is 10 or less units, then it is considered nearby
          if (distanceFromTrainer <= 10.0){
            listOfNearbyKudomon.add(kudomon);
          }
        }//if
      }// for
      // if no nearby kudomon then print appropriate message
      if (listOfNearbyKudomon.size() == 0)
        System.out.println("No kudomon within a 10 unit radius, try again.");
      return listOfNearbyKudomon;
  }// findNearbyKudomon

}// Grid
