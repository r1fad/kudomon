import java.util.ArrayList;
import java.util.Scanner;

// This class is used for testing purposes, execute the shell script 'run-tests'
public class TestGame{

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

      // keep fighting as long as both kudomons have health
      while ((kudomonToAttackFirst.getHealth() > 0) &&
              (kudomonToAttackSecond.getHealth() > 0))
      {
        kudomonToAttackFirst.inflictDamage(kudomonToAttackSecond);
        if (kudomonToAttackSecond.getHealth() <= 0)
          System.out.println(kudomonToAttackFirst+" has won!");

        kudomonToAttackSecond.inflictDamage(kudomonToAttackFirst);
        if (kudomonToAttackFirst.getHealth() <= 0)
          System.out.println(kudomonToAttackSecond+" has won!");
      }// while
    }// if
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

    // add some kudomons to the trainer's collection
    Kudomon kudomon;
    kudomon = new Kudomon("Sourbulb","grass", 6);
    trainer.catchKudomon(kudomon);

    kudomon = new Kudomon("Mancharred","fire", 8);
    trainer.catchKudomon(kudomon);

    kudomon = new Kudomon("Chipaku","electric", 2);
    trainer.catchKudomon(kudomon);

    kudomon = new Kudomon("Blastoise","water", 10);
    trainer.catchKudomon(kudomon);

    kudomon = new Kudomon("Shrewsand","rock", 4);
    trainer.catchKudomon(kudomon);

    kudomon = new Kudomon("Mewtwo","psychic",12);
    trainer.catchKudomon(kudomon);

    // any 2 kudomons fight each other 
    kudomonFight(trainer);

  }// main


}// Game
