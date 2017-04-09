import java.util.ArrayList;

public class TestBattle{

  // an action to allow a trainer to make two kudomons of his/her choice fight
  public static void kudomonFight(Trainer requiredTrainer, String firstKudomon,
                                    String secondKudomon){
    ArrayList<Kudomon> trainerKudomons = requiredTrainer.getTrainerKudomons();

    int option1=-1;
    int option2=-1;

    if (trainerKudomons.size() != 0){

      for (Kudomon kudomon:trainerKudomons){
        if (kudomon.getSpecies().equals(firstKudomon))
          option1 = trainerKudomons.indexOf(kudomon);

        if (kudomon.getSpecies().equals(secondKudomon))
          option2 = trainerKudomons.indexOf(kudomon);
      }

      Kudomon kudomonToAttackFirst;
      Kudomon kudomonToAttackSecond;

      /* decide randomly which kudomon attacks first */
      if (Math.round(Math.random()) == 0){
        // if random result is 0 then first option attacks first
        kudomonToAttackFirst = trainerKudomons.get(option1);
        kudomonToAttackSecond = trainerKudomons.get(option2);
      }// if
      else{
        // else second option attacks first
        kudomonToAttackFirst = trainerKudomons.get(option2);
        kudomonToAttackSecond = trainerKudomons.get(option1);
      }// else

      if (kudomonToAttackFirst.getType().equals("electric") &&
          kudomonToAttackSecond.getType().equals("water"))
        kudomonToAttackFirst.setCombatPoints(12);
      else if (kudomonToAttackSecond.getType().equals("electric") &&
              kudomonToAttackFirst.getType().equals("water"))
        kudomonToAttackSecond.setCombatPoints(12);

      System.out.println();
      System.out.println(kudomonToAttackFirst+" fights "+kudomonToAttackSecond);
      System.out.println();


      // keep fighting as long as both kudomons have health
      while ((kudomonToAttackSecond.getHealth() > 0) &
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

    //add trainer to the grid
    Trainer trainer  = new Trainer();
    Grid.addTrainer(trainer);
    System.out.println(trainer);

    //create kudomon objects and add it to trainer's collection
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

    kudomonFight(trainer, "Mewtwo", "Chipaku");
    System.out.println();
    kudomon = new Kudomon("Chipaku","electric", 2);
    trainer.catchKudomon(kudomon);
    kudomonFight(trainer, "Chipaku", "Blastoise");

  }// main

}// Class TestBattle
