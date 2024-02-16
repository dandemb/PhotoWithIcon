/**This class holds information about a command that was issued by the user.
* A command currently consists of two strings: a command word and a second word (for example, if the command was "take map", then the two strings obviously are "take" and "map"). 
* The way this is used is: Commands are already checked for being valid command words. 
* If the user entered an invalid command (a word that is not known) then the command word is . 
* If the command had only one word, then the second word is .
*
*@author Michael Kolling and David J.Barnes + D.Bureau + Danylo Dembitskyi
*
*@version 2006.03.30 + 27.05.2022
*/
public class Command // Permet de rendre la commande de l'utilisateur comprehensible pour le programme.
                     // Ensuite l'identifie et l'effectue. 
{                  
    private String aCommandWord; // premier mot; ex: take
    private String aSecondWord;  // deuxieme mot ; ex:key
    
/**
 * Constructeur naturel de la classe Command @param Deux mots 
 */
public Command (final String pCommandWord, final String pSecondWord)
{
    this.aCommandWord = pCommandWord;
    this.aSecondWord = pSecondWord;
} // Command();

/**
 * Permet de recuperer premier mot entre par l'utilisateur
 */
public String getCommandWord()
{
    return this.aCommandWord;
}//getCommandWord();

/**
 * Permet de recuperer deuxieme mot entre par l'utilisateur
 */
public String getSecondWord()
{
    return this.aSecondWord;
}// getSecondWord();

/**
 * Permet de savoir si le second mot est bien presente 
 */
public boolean hasSecondWord() 
{ // boolean no = true;
    //if (this.aSecondWord==null) {
      //  no = false;
    //}
    return this.aSecondWord != null;
}// hasSecondMot ();

/**
 * Permet de savoir si l'utilisateur n'a entre aucun mot
 */
public boolean isUnknown() 
{
    return this.aCommandWord == null;
} //isUnknown();

} // Command
