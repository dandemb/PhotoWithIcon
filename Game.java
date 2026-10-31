/**
 * This main class creates and initialises all the others: it creates alll rooms,creates the parser and starts the game.
 * 
 * You are the teenager football fan who lives in Paris.
 * Once you have heard the legend of football Lionel Messi is signed for Paris-Saint-Germain
 * all you think is meet him in person and take a photo with him! 
 * Because it's your favourite footballer of all time! Unfourtunately, you don't know where he is now. 
 * Youre main mission is to find Messi. 
 * It also should be extended to make it more interesting!
 * To play this game, create an instance of this class and call the "play" method.
 * 
 * @author Michael Kolling and David J.Barnes + D.Bureau + Danylo Dembitskyi
 * 
 * @version 2006.03.30 + 27.05.2022
*/
public class Game  
{
private UserInterface aInterface;
private GameEngine aEngine;

/**
 * Creer le jeu et permet de lancer le jeu(ancienne methode play()).Permet de creer un interface avec les images.
 */
public Game() 
 {
    this.aEngine = new GameEngine();
    this.aInterface = new UserInterface (this.aEngine);
    this.aEngine.setInterface(this.aInterface);
 }// Game();

 
    /**
     * Point d'entrée du jeu.
     */
    public static void main(String[] args) {
        Game game = new Game();
    }

}//Game
