 import java.util.StringTokenizer;

/**
 * This parser reads upon input and tries to interpret it as an "Adventure".
 * 
 * This class is part of the "Photo with Icon" application. 
 * "Photo with Icon" is a very simple, text based adventure game, inherited from "World of Zull Bad".  
 * 
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau+Danylo Dembitskyi
 * 
 * @version 2008.03.30 + 2013.09.15 + 17.02.2022 +27.05.2022
 */
public class Parser 
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)
    
    /**
     * Constructeur par defaut qui cree objet avec 1 attribut
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
    } // Parser()

    /**
     * Recoit la commande tapee par l'utilisateur. @param La commande est lit a partir de  "input line"
     */
    public Command getCommand(final String pInputLine) 
    {
        //pInputLine contiendra toute la ligne tapee par l'utilisateur
        String vWord1 = null;
        String vWord2 = null;

        StringTokenizer vTokenizer = new StringTokenizer(pInputLine);

        // cherche jusqu'a 2 mots dans la ligne tapee
        if (vTokenizer.hasMoreTokens() ) //y'a t'il un mot?
            vWord1 = vTokenizer.nextToken(); //obtient premier mot
            
        if ( vTokenizer.hasMoreTokens() )      // y a-t-il encore un mot suivant ?
            vWord2 = vTokenizer.nextToken();      // recupere le deuxieme mot

        // Verifie si le premier mot est une commande connue.
        // Si oui, cree un objet Command avec ce mot. (vWord2 peut etre null)
        // Sinon, cree une commande vide avec "null" (pour dire 'commande inconnue').
        if ( this.aValidCommands.isCommand( vWord1 ) ) 
            return new Command( vWord1, vWord2 );
        else 
            return new Command( null, vWord2 ); 
    } // getCommand(param)
    
    /**
     * Affiche la liste des commandes valides
     */
    public String showCommands() // etait showCommands() jusqu'a 7.18.6
    { //etait une procedure avec void jusq'au 7.18
        return aValidCommands.getCommandList();
    }//showCommands();
} // Parser
