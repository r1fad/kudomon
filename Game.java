import java.util.Scanner;
import java.util.ArrayList;

// This class is used to model an interactive game.
public class Game{

  //an action to allow a trainer to catch a kudomon
  public static void catchKudomon(Trainer requiredTrainer){

    /* A list of nearby kudomon is returned by the function with the same name
       in the grid class */
    ArrayList<Kudomon> listOfNearbyKudomon = Grid.findNearbyKudomon(requiredTrainer);

    // if the list contains nearby kudomons
    if (listOfNearbyKudomon.size() != 0){
      // display all the kudomons in the list
      System.out.println("Which Kudomon do you want to catch?");
      for (int index=0; index<listOfNearbyKudomon.size(); index++){
        System.out.println((index+1)+" - "+listOfNearbyKudomon.get(index));
      }//for

      /* create a scanner object which lets user input the number corresponding
         to the kudomon */
      Scanner input = new Scanner(System.in);
      System.out.print("Enter your choice: ");
      int optionCatch = Integer.parseInt(input.nextLine());

      // store the kudomon trainer wants to catch in a variable
      Kudomon kudomonToCatch = listOfNearbyKudomon.get(optionCatch-1);

      /* if 2 people try to catch the same kudomon, the trainer that types
         out the species and type of the kudomon first is allowed to capture
         the kudomon */
      System.out.print("Type out the species and type of the kudomon "+
                        "separated by a space: ");
      String speciesType = input.nextLine();
      String[] arraySpeciesType = speciesType.split(" ");

      String species = arraySpeciesType[0];
      String type = arraySpeciesType[1];
      System.out.println(species+" "+type);

      boolean enteredCorrectly = (species.equals(kudomonToCatch.getSpecies())) &
                                 (type.equals(kudomonToCatch.getType()));

      if (enteredCorrectly){
        // add the kudomon to the trainer's collection
        requiredTrainer.catchKudomon(kudomonToCatch);
        // clear the cell in which the kudomon exists
        Grid.clearKudomonCell(kudomonToCatch);
        System.out.println();
        // print out the kudomon that was caught
        System.out.println("You caught "+kudomonToCatch);
        /* add some more kudomon to the grid so that there the chances of more
           kudomon appearing nearby are higher */
        addKudomon();
      }//if

      else
        System.out.println("You could not catch that kudomon");

    }// if

    else
      // if no kudomon nearby, then add kudomon to the grid
      addKudomon();
  }// catchKudomon

  // a method to add kudomons to the grid
  public static void addKudomon(){
    Kudomon kudomon;
    kudomon = new Kudomon("Sourbulb","grass", 6);
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Mancharred","fire", 8);
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Chipaku","electric", 2);
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Blastoise","water", 10);
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Shrewsand","rock", 4);
    Grid.addKudomon(kudomon);

    kudomon = new Kudomon("Mewtwo","psychic",12);
    Grid.addKudomon(kudomon);
  }// addKudomon

  // an action to allow a trainer to make two kudomons of his/her choice fight
  public static void kudomonFight(Trainer requiredTrainer){
    ArrayList<Kudomon> trainerKudomons = requiredTrainer.getTrainerKudomons();
    if (trainerKudomons.size() != 0){
      // display all the kudomons in the list
      System.out.println("Which 2 kudomons should fight each other?");
      for (int index=0; index<trainerKudomons.size(); index++){
        System.out.println((index+1)+" - "+trainerKudomons.get(index));
      }//for

      /* create a scanner object which lets user input the number corresponding
         to the kudomon */
      Scanner input = new Scanner(System.in);
      System.out.print("Enter both your choices separated by spaces: ");
      int option1 = input.nextInt();
      int option2 = input.nextInt();

      System.out.println();
      System.out.println("FIGHT!!!");
      System.out.println();

      Kudomon kudomonToAttackFirst;
      Kudomon kudomonToAttackSecond;

      /* decide randomly which kudomon attacks firs */
      if (Math.round(Math.random()) == 0){
        // if random result is 0 then first option attacks first
        kudomonToAttackFirst = trainerKudomons.get(option1-1);
        kudomonToAttackSecond = trainerKudomons.get(option2-1);
      }// if
      else{
        // else second option attacks first
        kudomonToAttackFirst = trainerKudomons.get(option2-1);
        kudomonToAttackSecond = trainerKudomons.get(option1-1);
      }// else

      // if one of the kudomons is electric and the other is water, the electric
      // kudomon's combat points get upgraded

      if (kudomonToAttackFirst.getType().equals("electric") &&
          kudomonToAttackSecond.getType().equals("water"))
        kudomonToAttackFirst.setCombatPoints(12);
      else if (kudomonToAttackSecond.getType().equals("electric") &&
              kudomonToAttackFirst.getType().equals("water"))
        kudomonToAttackSecond.setCombatPoints(12);

      // keep fighting as long as both kudomons have health
      while ((kudomonToAttackSecond.getHealth() > 0) &&
              (kudomonToAttackFirst.getHealth() > 0))
      {
        kudomonToAttackFirst.inflictDamage(kudomonToAttackSecond);
        if (kudomonToAttackSecond.getHealth() <= 0){
          System.out.println(kudomonToAttackFirst+" has won!");
          break;
        }// if

        kudomonToAttackSecond.inflictDamage(kudomonToAttackFirst);
        if (kudomonToAttackFirst.getHealth() <= 0){
          System.out.println(kudomonToAttackSecond+" has won!");
          break;
        }// if

      }// while
    }// if

    else
      System.out.println("You don't have kudomons. Try catching some first");

  }// kudomonFight

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

    // create a scanner object
    Scanner input = new Scanner(System.in);

    boolean gameIsRunning = true;

    // a loop that executes as long as the above boolean value is true.
    while (gameIsRunning){
      // print out all the actions that a trainer can perform
      System.out.println();
      System.out.println("What would you like to do?");
      System.out.println("1 - Catch Kudomon");
      System.out.println("2 - Kudomons Fight");
      System.out.println("3 - Exit");

      /* ask the user to enter the number that corresponds to the action
         that the user wants to perform */
      System.out.print("Enter your choice: ");
      int option = input.nextInt();
      System.out.println();

      switch (option){
        case 1: catchKudomon(trainer);
                break;
        case 2: kudomonFight(trainer);
                break;
        case 99: gameIsRunning = false;
                 break;
        default: System.out.println("Invalid choice!");
                 break;
      }// switch
    }// while
  }// main
}// Game
