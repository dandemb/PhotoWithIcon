import java.util.Stack;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * This main class creates and initialises all the others: it creates all rooms,creates the parser and starts the game.
 * 
 * You are the teenager football fan who lives in Paris.
 * Once you have heard the legend of football Lionel Messi is signed for Paris-Saint-Germain
 * all you think is meet him in person and take a photo with him! 
 * Because it's your favourite footballer of all time! Unfourtunately, you don't know where he is now. 
 * Youre main mission it to find Messi. 
 * It also should be extended to make it more interesting!
 * To play this game, create an instance of this class and call the "play" method.
 * 
 * @author Michael Kolling and David J.Barnes + D.Bureau + Danylo Dembitskyi
 * 
 * @version 2006.03.30 + 27.05.2022
*/

public class GameEngine //Initialisation du jeu. Le coeur de notre programme.
{
    private Room aCurrentRoom;
    private Parser aParser;
    private UserInterface aInterface;
    private Room aBack;
    private Player aPlayer;
    private double aTimeLeft;
 /**
  * Creer une nouvelle Room
  */
 private void createRooms()
 {   
    
     // Creer 24 lieux
     Room vMyChambre = new Room("I am now in my room,such a great time","Images/mychambre.gif"); 
     Room vSalon = new Room("I am in salon. A lot of places to go.","Images/salon.gif"); 
     Room vSalleDeBain = new Room("I am in bathroom","Images/salledebain.gif"); 
     Room vCuisine = new Room("I am in the kitchen.Woah, my mother made me a cake, hell yeah!","Images/cuisine.gif"); 
     Room vCouloir = new Room ("I am in couloir","Images/couloir.gif"); 
     Room vChambreDeParents = new Room("I am in my parent's room","Images/chambredeparents.gif"); 
     Room vGarage = new Room ("I am in garage now,let's see, maybe there is something interesting...","Images/garage.gif"); 
     Room vVeranda = new Room ("I am outside,it's a great weather today","Images/veranda.gif"); 
     Room vCollege = new Room ("I am near my college, let's talk to security garde","Images/college.gif"); 
     Room vRestaurant = new Room("I am near the restaurant, but I am not hungry","Images/restaurant.gif"); 
     Room vStade = new Room ("That's our college stadium, I spend a lot of time here","Images/stadium.gif"); 
     Room vArretDeBus = new Room ("Bus station, let's see what I can do here...","Images/arret.gif");//
     Room vAchatDeTicket = new Room ("I can pay for a ticket here","Images/banc.gif");
     Room vTableau = new Room ("I am near the bus information.Let's see where I can go","Images/bus.gif");
     Room vTourEiffel = new Room ("I am at Eiffel Tour","Images/eiffel.gif");
     Room vLouvre = new Room ("I am in Louvre","Images/louvre.gif");
     Room vArcDeTriomphe = new Room ("I am at Arc de Triomphe","Images/arc.gif");
     Room vPalaisGarnier = new Room ("I am at Palais Garnier","Images/palais.gif");
     Room vSacreCoeur = new Room ("I am at Sacre Couer","Images/sacre.gif");
     Room vStadeDeFrance = new Room ("I am in my favourite place, Stade de France","Images/stade.gif");
     Room vNotreDame = new Room ( "I am at Notre Dame","Images/notredame.gif");//c'est ou Messi doit s'apparaitre
     Room vPanteon = new Room ("I am in Panteon","Images/panteon.gif");
     Room vHotelDesNations = new Room ("I am in Hotel Des Nations","Images/hotel.gif");
     Room vCherdak = new Room ("I am at cherdak. Let's see what we can do upstairs","Images/cherdak.gif");
     Room vEtageEiffel = new Room ("What a beautiful view from Eiffel Tour","Images/eiffelup.gif");
     
     //Positionner les sorties pour chaque Room.Premier ordre:North East South West Up Down
     vEtageEiffel.setExit("down",vTourEiffel,false);
     vCherdak.setExit("down",vChambreDeParents,false);
     vMyChambre.setExit("west",vSalon,false);
     
     vSalon.setExit("north",vSalleDeBain,false);
     vSalon.setExit("east", vMyChambre,false);
     vSalon.setExit("south",vCuisine,false);
     vSalon.setExit("west",vChambreDeParents,false);
     
     // On creer les items notamment
     Item vCanape = new Item("It's my bed",30);
     Item vTelecommande = new Item("Telecommande",0.3);
     Item vBallon = new Item("My favourite ball",0.1);
     Item vVieuxVelo = new Item("My old broken velo",10);
     Item vVielleLampe = new Item("That's used to be a lamp",3);
     Item vTelephone = new Item("Telephone in da house",0.150);
     Item vGardeRobe = new Item("I can dress here",15);
     Item vVeste = new Item("Can I put it on me?",0.12);
     Item vSacADos = new Item("I have a backpack here",0.5);
     Item vGrandMirroir = new Item("Mirror",5);
     Item vBrosse = new Item ("Toothpaste",0.1);
     Item vCleDeGarage = new Item("Key of garage",0.150);
     Item vFleurs = new Item("Flowers",0.1);
     Item vMirroir = new Item("Small mirror",0.2);
     Item vVetements = new Item("Clothes",0.4);
     Item vCleMaison = new Item("Key of house",0.2);
     Item vFood = new Item("Cake",0.325);
     Item vCle = new Item("Key",0.5);
     Item vMagicCookie = new Item("MagicCookie",0);
     //On associt des Items pour chaque(ou presque) Room
     vSalon.setItemRoom("Bed",vCanape);
     
     vMyChambre.setItemRoom("Clothes",vVetements);
     vMyChambre.setItemRoom("Key",vCle);
     
     vChambreDeParents.setItemRoom("Key of garage",vCleDeGarage);
     
     vSalleDeBain.setItemRoom("Mirroir",vMirroir);
     
     vCuisine.setItemRoom("Cake",vFood);
     vCuisine.setItemRoom("MagicCookie",vMagicCookie);
     
     vCouloir.setItemRoom("Schkaf",vGardeRobe);
     
     vGarage.setItemRoom("Velo",vVieuxVelo);
     
     vStade.setItemRoom("Ball",vBallon);
     
     vCherdak.setItemRoom("Sac",vSacADos);
     
     
     //Positionner les sorties pour chaque Room.
     vSalleDeBain.setExit("south",vSalon,false);
     
     vCuisine.setExit("north",vSalon,false);
     vCuisine.setExit("west",vCouloir,false);
     
     vCouloir.setExit("north",vGarage,false);
     vCouloir.setExit("south",vVeranda,false);
     vCouloir.setExit("east",vCuisine,false);
     
     vGarage.setExit("south",vCouloir,false);
     
     vVeranda.setExit("north",vCouloir,false);
     vVeranda.setExit("east",vCollege,false);
     vVeranda.setExit("west",vArretDeBus,false);
     
     vCollege.setExit("east",vStade,false);
     vCollege.setExit("south",vRestaurant,false);
     vCollege.setExit("west",vVeranda,false);
     
     vStade.setExit("west",vCollege,false);
     vRestaurant.setExit("north",vCollege,false);
     
     vArretDeBus.setExit("north",vAchatDeTicket,false);
     vArretDeBus.setExit("east",vVeranda,false);
     vArretDeBus.setExit("south",vTableau,false);
     vArretDeBus.setExit("west",vTourEiffel,false);
     
     vTourEiffel.setExit("north",vArcDeTriomphe,true);
     vTourEiffel.setExit("east",vArretDeBus,false);
     vTourEiffel.setExit("south",vPanteon,false);
     vTourEiffel.setExit("west",vLouvre,false);
     vTourEiffel.setExit("up",vEtageEiffel,false);
     
     vLouvre.setExit("north",vPalaisGarnier,false);
     vLouvre.setExit("east",vTourEiffel,false);
     vLouvre.setExit("south",vNotreDame,false);
     
     vArcDeTriomphe.setExit("south",vTourEiffel,false);
     vArcDeTriomphe.setExit("west",vPalaisGarnier,false);
     
     vPalaisGarnier.setExit("north",vSacreCoeur,false);
     vPalaisGarnier.setExit("east",vArcDeTriomphe,true);
     vPalaisGarnier.setExit("south",vLouvre,false);
     
     vSacreCoeur.setExit("north",vStadeDeFrance,false);
     vSacreCoeur.setExit("south",vPalaisGarnier,false);
     
     vStadeDeFrance.setExit("south",vSacreCoeur,false);
     
     vChambreDeParents.setExit("east",vSalon,false);
     vChambreDeParents.setExit("up", vCherdak,false);
     
     vPanteon.setExit("north",vTourEiffel,false);
     vPanteon.setExit("west",vHotelDesNations,false);
     
     vNotreDame.setExit("north",vLouvre,false);
     vNotreDame.setExit("east",vPanteon,false);
     vNotreDame.setExit("south",vHotelDesNations,false);
     
     vHotelDesNations.setExit("north",vNotreDame,false);
     vHotelDesNations.setExit("east",vPanteon,false);
     
     vTableau.setExit("north",vArretDeBus,false);
     
     vAchatDeTicket.setExit("east",vVeranda,false);
     vAchatDeTicket.setExit("south",vArretDeBus,false);
     vAchatDeTicket.setExit("west",vTourEiffel,false);
     
     
     // Mettre la position de depart 
     createPlayer();
     this.aPlayer.setRoom(vMyChambre);
 } //CreateRooms();
 
 /**
  * Creation d'un personnage
  */
 public void createPlayer()
 {
   this.aPlayer = new Player ("Mateo",12,"French");     
 }//createPlayer();
 
 /**
 * Lancer le jeu
 */
 public GameEngine ()
 {   aParser = new Parser();
     createRooms();
     this.aTimeLeft = 40;
 }// Game();
 
 /**
  * Creer une interface @param Une interface
  */
 public void setInterface(final UserInterface pUserInterface)
 {
     this.aInterface = pUserInterface;
     this.printWelcome();
 }//setInterface();
 
 /**
 * En fonction de commande rentre par l'utilisateur change de piece @param Second mot rentre par l'utilisateur
 */
 private void goRoom(final Command pDirection)
 {   this.wasted();
     boolean vSecondMot = pDirection.hasSecondWord();
     String vPremierMot = pDirection.getCommandWord();
     if (!vSecondMot && vPremierMot.equals("go")) {
         aInterface.println("\n"+"Go where ?");
         return;
     }//if il existe second mot
     //Room vNextRoom;
     String vDirection = pDirection.getSecondWord();
     Room vNextRoom = this.aPlayer.getRoom().getExit(vDirection);//stocke une sortie de l'utilisateur dans vNextRoom
     /*
      * switch (vDirection) {
         case "north" :
             vNextRoom = this.aCurrentRoom.aNorthExit;
             break;
         case "east" :
             vNextRoom = this.aCurrentRoom.aEastExit;
             break;
         case "south" :
              vNextRoom = this.aCurrentRoom.aSouthExit;
             break;
         case "west" :
              vNextRoom = this.aCurrentRoom.aWestExit;
             break;
         case "Up" :
               vNextRoom = this.aCurrentRoom.aDownExit;
             break;
         case "Down" :
              vNextRoom = this.aCurrentRoom.aUpExit;
             break;
         default :
             vNextRoom = null;
             System.out.println("\n"+"Unknown direction !");
             break;
                }//switch pour savoir la chambre ou aller 
      */
     
     //verifie si on peut aller dans la prochaine piece
     if (vNextRoom == null && vPremierMot.equals("go") && vSecondMot) {
            aInterface.println("\n"+"There is no door!");
            return;
        }//if la prochaine sortie est null(n'existe pas);
     else {
         if (this.aPlayer.getRoom().piegeRoom(vDirection)) this.aPlayer.resetPreviousRooms();
         //this.aBack = this.aCurrentRoom;
         Room vPlayerRoom = this.aPlayer.getRoom();
         this.aPlayer.pumpLastRoom(vPlayerRoom);
         this.aPlayer.setRoom(vNextRoom);
         printLocationInfo();
         //this.aPreviousRooms.push(this.aPlayer.getRoom());
        }//else change de location dans le  cas ou sortie est accessible
 }//goRoom();
   
 /**
 * Message pour le joueur 
 */
   private void printWelcome() 
   {
     aInterface.println("\n"+"Welcome to the Photo with Icon!");
     aInterface.println("Photo with Icon is a new, boring(yet) adventure game.");
     aInterface.println("Type 'help' if you need help.");
     printLocationInfo();
     }//printWelcome();
     
 /**
 *  Description de la piece courante
 */
     private void printLocationInfo()
     { Room vCurrentiRoom = this.aPlayer.getRoom();
       aInterface.print("\n"+vCurrentiRoom.getDescription());
       
       /*
          * if (this.aCurrentRoom.aNorthExit!=null) {
           vExitsPossibles = vExitsPossibles + "north";  
         }//if north existe
         if (this.aCurrentRoom.aEastExit!=null) {
             vExitsPossibles = vExitsPossibles + " east";
            } //if east existe
         if (this.aCurrentRoom.aSouthExit!=null) {
             vExitsPossibles = vExitsPossibles + " south";
            } //if south existe
         if (this.aCurrentRoom.aWestExit!=null) {
             vExitsPossibles = vExitsPossibles + " west";
         } //if il existe west
         if (this.aCurrentRoom.aDownExit!=null) {
             vExitsPossibles = vExitsPossibles + " down";
         }// if down existe
         if (this.aCurrentRoom.aUpExit!=null) {
             vExitsPossibles =vExitsPossibles + " up";
         }// if up existe
          */
        // System.out.print("\n"+vExitsPossibles);
        aInterface.print("\n"+vCurrentiRoom.getExitString());
        aInterface.print("\n"+vCurrentiRoom.getItemStringRoom());
        
        if (vCurrentiRoom.getImageName() != null)
        aInterface.showImage(vCurrentiRoom.getImageName() );
   }// printLocationInfo();
   
 /**
 * Affiche les commandes disponibles
 */
   private void printHelp()
   { //7.18 avant procedure void
     aInterface.println("\n"+"You are lost. You are alone.");
     aInterface.println("You wander around at some location you don't know");
     aInterface.println("\n" + "Your command words are:");
     //System.out.println("go quit help");
     //System.out.println("Your command words are : ");
     aInterface.println(aParser.showCommands());
   }//printHelp();
 
 ///**
 //* Permet de savoir si l'utilisateur veut arreter le jeu
 //*/
 //private boolean quit(final Command pCommand) 
 //{
   //  if (pCommand.hasSecondWord()) {
     //    aInterface.println("\n"+"Quit what ?");
       //  return false;
     //}//if
     //return true;
 //}//quit();
 
 /**
 * Permet d'appeler la methode en fonction de commande saisie @param la commande tapee par l'utilisateur
 */
 public void interpretCommand(final String pProcces) 
  { // appele la methode en fonction du parametre
     
     this.aInterface.println( "> " + pProcces );// pour afficher a l'interface la ligne tapee par l'utilisateur
     Command vCommand = this.aParser.getCommand(pProcces);
     if (vCommand.isUnknown() ){
         aInterface.println("\n"+"I don't know what you mean..."); // on verifie le 1er des 2 mots!
     }//if pas de methode correspondante
     else {
         String vKnowMethod = vCommand.getCommandWord(); //on extrait le 1er mot
         switch(vKnowMethod) {
             case "quit" :
                if (vCommand.hasSecondWord())
                this.aInterface.println("Quit what?");
                 else this.endGame();// nous appliquons la methode correspondante 
             case "go" :
                 goRoom(vCommand);
                 return;
             case "help" :
                 printHelp();
                 return;
             case "look" :
                 look();
                 return;
             case "eat" :
                 eat(vCommand);
                 return;
             case "back" :
                 back();
                 return;
             case "test" :
                 test(vCommand);
                 return;
             case "take":
                 take(vCommand);
                 return;
             case "drop" :
                 drop(vCommand);
                 return;
             case "inventory" :
                  inventory();
                  return;
             default :
              return;
         }//switch de notre premier mot
     }//else identifie la commande correspondante
  }//processCommand();
    
    
  /**
   * Arrete le jeu
   */
  private void endGame()
  {
   this.aInterface.println("Thank you for playing. Good bye.") ;
   this.aInterface.enable(false);
  }// endGame();
  
    /**
     * Permet de reafficher la description de la piece courante et ses sorties accessibles
     */
  private void look() 
  {
      aInterface.println(this.aPlayer.getRoom().getLongDescription());
    }// look();
    
    /**
     * Permet de manger @param Si besoin preciser la chose a manger 
     */
  private void eat(final Command pCommand) 
  {
      if (!pCommand.hasSecondWord()){
      this.aInterface.println("You have eaten now and you are not hungry any more.");
      return;
     }//if On conserve la fonctionnement de la methode eat() si uniquement 1 mot est rentre
     if (!this.aPlayer.getInventor().presentInInventor("MagicCookie")){
          this.aInterface.println("Nothing to eat");
          return;
      }// si le personnage ne possede pas MagicCookie
      if (this.aPlayer.getInventor().presentInInventor("MagicCookie")){
      this.aPlayer.dropItemPlayer("MagicCookie");
      this.aPlayer.setPoidsMax(this.aPlayer.getPoidsMax()*1.2);
      this.aInterface.println("Now you have more capacity");
      return;
     }//si le personnage possede MagicCookie
     else{
         this.aInterface.println("You can't eat it");
     }//si la commande contien eat comme command word et deuxieme mot autre que MagicCookie
  }//eat();
  
  /**
   * Methode pour se retourner dans la piece precedente
   */
   private void back()
   {
       if(this.aPlayer.findLastRoom().equals(null))this.aInterface.println("Nowhere to back");
       else {
           Room vLastRoom = this.aPlayer.findLastRoom();
           this.aPlayer.setRoom(vLastRoom);
           this.aInterface.println("You back");
        }//else
        this.aInterface.println(this.aPlayer.getRoom().getLongDescription());
        
        if(this.aPlayer.getRoom().getImageName()!=null) this.aInterface.showImage(this.aPlayer.getRoom().getImageName());
        return;
   }//back();
   
  /**
    * Permet d'effectuer le test selon la commande tapee par l'utilisateur @param commande de l'utilisateur
    */
   private void test(final Command pCommand)
   {
    if(!pCommand.hasSecondWord())
    {
        this.aInterface.println("Nothing to test");
        return;
    }         

    String vFile = pCommand.getSecondWord();
    Scanner vScanner=null;

    try {vScanner = new Scanner(new File("./"+vFile+".txt"));}
    catch ( final java.io.FileNotFoundException pException )
    {
        this.aInterface.println("File could not be found");
    }

    while(vScanner.hasNextLine())
    {
        String vLigne = vScanner.nextLine();
        interpretCommand(vLigne);
    }
    if (vScanner != null) {vScanner.close();}
   }//test();

   /**
 * Permet de prendre Item @param la commande tapee par l'utilisateur
 */
 public void take(final Command pCommand) 
  {   String vChose =pCommand.getSecondWord();
    Item vChoseTake =this.aPlayer.getRoom().getItemRoom(vChose);
    if (!pCommand.hasSecondWord())
    {this.aInterface.println("Take what?");
    return;
    }//if
    
    if (vChoseTake==null || !this.aPlayer.getInventor().isInclus(vChose)) {
    this.aInterface.println("Nothing to take!");
    return;}
    if (!this.aPlayer.moreItemsPlayer()) this.aInterface.println("Not enough capacity!");
    
    else{
        this.aPlayer.getInventor().takeItem(vChose,vChoseTake);
        this.aPlayer.getRoom().getRoomItem().remove(vChose);
        this.aInterface.println("I got a new item");
    }//else
 }//take();

 /**
 * Permet de drop Item @param l'Item entre dans la ligne de commande 
 */
 public void drop(final Command pCommand) 
 { 
    String vChose =pCommand.getSecondWord();
    Item vChoseToDrop = this.aPlayer.getInventor().getItem(vChose);
    if(vChose==null) this.aInterface.println("Drop what?");
    
    if(vChoseToDrop == null) 
    {
        this.aInterface.println("Nothing to drop"); 
    }//if
    else {
        this.aPlayer.getRoom().getRoomItem().put(vChose,vChoseToDrop);
        this.aPlayer.getInventor().dropItem(vChose);
        this.aInterface.println("I dropped the item: "+vChose);
    }///else
   }//drop();
   
 /**
  * Permet d'afficher la liste d'items dans la console 
  */
  public void inventory() 
  {   if (this.aPlayer.getInventor().getItemString().equals(null)){
      this.aInterface.println("Nothing in inventory");
      this.aInterface.println("0");
      return;}
      this.aInterface.println(this.aPlayer.getInventor().getItemString());
      this.aInterface.println(this.aPlayer.knowWeigthPlayer()+"");
      return;
  }//inventory();
   
  /**
   * Permet de savoir si l'utilisateur a depase la limite de maximum 40 tours autour des pieces
   */
  private boolean wasted()
  {
      this.aTimeLeft +=-1;
      this.aInterface.println("You have " + this.aTimeLeft +" Try");
      if (this.aTimeLeft == 0) {
          this.aInterface.println("You didn't find Messi in time. It's too late... But never mind,maybe you can meet him tomorrow");
          this.endGame();
          
          return true;
      }//if Time est ecoule
      return false;
  }//wasted();
}// Game