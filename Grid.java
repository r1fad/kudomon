public class Grid{

  // a class variable to store size of square grid
  private static int GRID_SIZE = 100;

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

  public static void addKudomon(Kudomon requiredKudomon){
    Cell kudomonCell = GRID[requiredKudomon.getX()][requiredKudomon.getY()];
    if (kudomonCell.isEmpty()){
      kudomonCell.setKudomon(requiredKudomon);
    }// if
    else
      System.out.println("failed to add kudomon to grid");
  }// addKudomon

  public static void addTrainer(Trainer requiredTrainer){
    Cell trainerCell = GRID[requiredTrainer.getX()][requiredTrainer.getY()];
    if (trainerCell.isEmpty())
      trainerCell.setTrainer(requiredTrainer);
  }// addTrainer

}// Grid
