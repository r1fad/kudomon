import java.util.Scanner;
import java.util.ArrayList;
public class Game{

  public static void catchKudomon(Trainer requiredTrainer){

    ArrayList<Kudomon> listOfNearbyKudomon = Grid.findNearbyKudomon(requiredTrainer);

    if (listOfNearbyKudomon.size() != 0){
      System.out.println("Which Kudomon do you want to catch?");
      for (int index=0; index<listOfNearbyKudomon.size(); index++){
        System.out.println((index+1)+" - "+listOfNearbyKudomon.get(index));
      }//for

      Scanner input = new Scanner(System.in);
      System.out.print("Enter your choice: ");
      int optionCatch = input.nextInt();

      Kudomon kudomonToCatch = listOfNearbyKudomon.get(optionCatch-1);
      requiredTrainer.catchKudomon(kudomonToCatch);
      Grid.clearKudomonCell(kudomonToCatch);
      System.out.println();
      System.out.println("You caught "+kudomonToCatch);
      addKudomon();
    }// if

    else
      addKudomon();

  }// catchKudomon

  public static void addKudomon(){
    Kudomon kudomon;
    kudomon = new Kudomon("Sourbulb","grass");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Mancharred","fire");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Chipaku","electric");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Blastoise","water");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Shrewsand","rock");
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Mewtwo","psychic");
    Grid.addKudomon(kudomon);
  }// addKudomon

  public static void main(String[] args){

    // initialize grid
    Grid.initializeGrid();

    //add kudomons to the grid
    addKudomon();
    addKudomon();
    addKudomon();


    //add trainer to the grid
    Trainer trainer  = new Trainer();
    Grid.addTrainer(trainer);
    System.out.println(trainer);

    Scanner input = new Scanner(System.in);

    boolean gameIsRunning = true;

    while (gameIsRunning){
      System.out.println();
      System.out.println("What would you like to do?");
      System.out.println("1 - Catch Kudomon");

      System.out.print("Enter your choice: ");
      int option = input.nextInt();

      if (option == 1)
        catchKudomon(trainer);

    }// while


  }// main

}// Game
