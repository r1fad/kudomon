public class Game{

  public static void main(String[] args){

    // initialize grid
    Grid.initializeGrid();

    //add kudomons to the grid
    Kudomon kudomon;

    kudomon = new Kudomon("Sourbulb","grass");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Mancharred","fire");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Chipaku","electric");
    Grid.addKudomon(kudomon);

    //add trainer to the grid
    Trainer trainer  = new Trainer();
    Grid.addTrainer(trainer);


  }// main

}// Game
