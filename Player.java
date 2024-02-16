import java.util.HashMap;
import java.util.Stack;
import java.util.Set;
/**
 * Classe Player est destine a la creation de personnage dans un jeu.
 *
 * @author Danylo Dembitskyi
 * @version 27.05.2022
 */
public class Player
{
  private String aName;
  private double aAge;
  private String aNationality;
  //private HashMap <String,Item> aInventor;
  private Room aCurrentoRoom;
  private Stack <Room> aPreviousRooms;
  private double aPoidsMax;
  private ItemList aInventor;
 /**
  * Constructeur naturel de Player. @param Le nom de personnage,son age et sa nationalite
  */
 public Player(final String pName,final double pAge,final String pNationality)
    {
      this.aName=pName;
      this.aAge=pAge;
      this.aPoidsMax = 8;
      this.aNationality=pNationality;
      this.aInventor= new ItemList();
      this.aPreviousRooms = new Stack<>();
    }//Constructeur naturel Player();
   
    /**
     * Retourne l'attribut prive Inventor de Player(ce que correspond a un inventaire de Player)
     */
 public ItemList getInventor() {
   return this.aInventor;
 }//getInventor();
    
  /**
   * Accesseur attribut aName
   */
 public String getName()
 {
     return this.aName;
    }//getName();
 
 /**
  * Modificateur attribut aName @param Le nom a remplacer
  */
 public void setName(final String pName)
 {
     this.aName = pName;
 }//setName();
 
 
 /**
  * Accesseur attribut aAge
  */
 public double getAge()
 {
     return this.aAge;
 }//getAge();
 
 /**
  * Modificateur attribut aAge @param L'age a remplacer
  */
 public void setAge(final double pAge)
 {
     this.aAge = pAge;
 }//setAge();
 
 /**
  * Accesseur attribut aNationality 
  */
 public String getNationality()
 {
     return this.aNationality;
 }//getNationality();
 
  /**
  * Modificateur attribut aNationality @param La nationalite a remplacer
  */
  public void setNationality(final String pNationality) 
  {
      this.aNationality = pNationality;
  }//setNationality();
 
  /**
   * Accesseur attribut aCurrentoRoom
   */
  public Room getRoom()
  {
      return this.aCurrentoRoom;
  }//getRoom();
  
  /**
   * Modificateur attribut aCurrentoRoom @Le room a modifier
   */
  public void setRoom(final Room pRoom)
  {
      this.aCurrentoRoom = pRoom;
  }//setRoom();
  /*
  /**
   * Accesseur attribut Item dans Player(un item de l'inventaire de personnage)
   
   
  public Item getItem(final String pNameString) {
      return this.aI.(pNameString);
  }//getItem();
  */
  /**
   * Permet de retrouver la derniere piece (utile pour la methode back)
   */
  public Room findLastRoom()
  {
      return this.aPreviousRooms.pop();
  }//findLastRoom();
  
  /**
   * Permet d'etablir la derniere piece dans une collection Stack  @param Dernier Room
   */
  public void pumpLastRoom(final Room pLastRoom)
  {
      this.aPreviousRooms.push(pLastRoom);
  }//establishLastRoom();
  
  /**
   * Permet de savoir le poids maximal autorise a porter 
   */
  public double getPoidsMax() 
  {
      return this.aPoidsMax;
  }//getPoidsMax();
  
  /**
   * Augmente ou reduit la capacite de Poids porte par l'utilisateur
   */
  public void setPoidsMax(final double pPoidsMax )
  {
      this.aPoidsMax = pPoidsMax;
  }//setPoidsMax();
  
  /*public String getItemStringPlayer() {
      return this.aInventor.getItemString();
  }//getItemStringPlayer();*/
  /**
   * Ajoute un Item dans l'inventaire de Player @param Le nom de l'Item et l'item lui meme
   */
  public void takeItemPlayer(final String pString, final Item pItem)
  {
      this.aInventor.takeItem(pString,pItem);
  }//takeItemPlayer();
  
  /**
   * Supprime l'Item de la collection de Player @param Le nom de l'Item a enlever de l'inventaire de Player
   */
  public void dropItemPlayer(final String pString) 
  {
      this.aInventor.dropItem(pString);
  }//dropItemPlayer();
  
  /**
   * Permet de retrouver un Item dans l'inventaire Player a partir de son String @param Le nom d'Item  
   */
  public Item getItemPlayer(final String pString) 
  {
      return this.aInventor.getItem(pString);
  }//getItemPlayer();
  
  /**
   * Retourne tous les Items de l'inventaire de Player 
   */
  public String getItemStringPlayer() 
  {
      return this.aInventor.getItemString();
  }//getItemStringPlayer();
  
  /**
   * Permet de savoir la capacite maximale de Player
   */
  public double knowWeigthPlayer()
  {
     return this.aInventor.knowWeigth();
  }//knowWeigthPlayer();
  
  /**
   * Permet de savoir si l'Item est present dans l'inventaire de Player @param Son String
   */
  public boolean presentInInventorPlayer(final String pString) 
  {
      return this.aInventor.presentInInventor(pString);
  }//presentInInventorPlayer
  
  /**
   * Permet de savoir si Player possede un Sac qui augmente le poids maximal a porter
   */
  public boolean bigSpacePlayer() 
  {
      if (this.aInventor.bigSpace()){
          this.aPoidsMax = 16;
          return true;
      }//if
      return false;
  }//bigSpacePlayer();
  
  /**
   * Permet de savoir si le Player peut encore ajouter des Items dans son inventaire
   */
  public boolean moreItemsPlayer() 
  {
     return this.knowWeigthPlayer() <= this.aPoidsMax;
  }//moreItemsPlayer();
  
  /** 
   * Supprime la pile de Stack dans le Room, pour que quand le personnage rentre dans la piece piegeuse il ne pourra pas retourner en arriere
   */
  public void resetPreviousRooms() 
  {
      this.aPreviousRooms.clear();
  }//resetPreviousRooms();
}//Player



