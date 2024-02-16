
/**
 * This class holds an enumeration table of all command words known to the game.
 * 
 * This class is part of the "Photo with Icon" application. 
 * "Photo with Icon" is a very simple, text based adventure game, inherited from "World of Zull".  
 * 
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau +Danylo Dembitskyi
 * 
 * @version 2008.03.30 + 2019.09.25 + 17.02.2022 +27.05.2022
 */
public class CommandWords //cette classe definit toutes les commandes valides.Il contient un tab de String
{
    // a constant array that will hold all valid command words
    private final String[] aValidCommands;
    
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new String[10];
        this.aValidCommands[0] = "go";
        this.aValidCommands[1] = "help";
        this.aValidCommands[2] = "quit";
        this.aValidCommands[3] = "look";
        this.aValidCommands[4] = "eat";
        this.aValidCommands[5] = "back";
        this.aValidCommands[6] = "test";
        this.aValidCommands[7]= "take";
        this.aValidCommands[8]="drop";
        this.aValidCommands[9]= "inventory";
    } // CommandWords()
     private static final String[] validCommands = {"go","quit","help","look","eat","back","test","take","drop","inventory"};
    /**
     * Verifie si le String entre correspond a une commande valide.
     * @return true si la commande est valide
     * false autrement
     */
    public boolean isCommand( final String pString )
    {
        for ( int vI=0; vI<this.aValidCommands.length; vI++ ) {
            if ( this.aValidCommands[vI].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isCommand()
   // /**
     //* Permet d'afficher toutes les commandes disponibles.SOP. Une procedure.
     //*/
    //public void showAll() {
       // for (String vCommand : validCommands) {System.out.print(vCommand+ " ");}
        //System.out.println();
   // }//showAll();
    
    /**
     * Un accesseur de commandes possibles. Return de type String. Une fonction.
     */
    public String getCommandList()
    {
        String vWords = "";
        for (String vWordsEach : validCommands) vWords = vWords + vWordsEach +" ";
        return vWords;
    }// getCommandList();
    
} // CommandWords


