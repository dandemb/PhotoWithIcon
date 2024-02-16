import java.util.HashMap;
import java.util.Set;

/**
 * A "Room" represents one location in the scenery of the game.It is connected to the other rooms via exits.
 * 
 * This class is part of the "Photo with Icon" application. 
 * "Photo with Icon" is a very simple, text based adventure game inherited from "World of Zuul" application. 
 *  The exits are labelled north, east, south, west. 
 *  For each direction, the room stores a reference to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Danylo Dembitskyi
 * 
 * @version 2008.03.30 + 2013.09.15 + 27.05.2022
 */

public class Room  //Une piece dans le jeu,contient des sorties des autres pieces.
{
 private String aDescription; 
 private HashMap<String, Room> aExits;
 private String aImageName;
 private HashMap<String,Item> aRoomItem;
 private HashMap <String, Boolean> aPiegeRoom;
 //private ItemList aRoomItem;
/**
 * constructeur naturel. @param pDescription pour initialiser l'attribut aDescription et Image de Room
 */
public Room(final String pDescription, final String pImage) 
{
    this.aDescription = pDescription;
    this.aExits = new HashMap<String, Room>();
    this.aImageName = pImage;
    this.aRoomItem = new HashMap<>();
    this.aPiegeRoom = new HashMap<>();
 }// Room();
 
 /**
  * Retourne la collection hashmap de l'item qui se trouve dans la piece
  */
 public HashMap getRoomItem() 
 {
     return this.aRoomItem;
 }//getRoomItem();
 
/**
  * Accesseur pour l'unique attribut aDescription. Affiche la description de la piece courante.
  */
 public String getDescription() 
 {
     return aDescription;
 }//getDescription();
 
 /*/**
  * Supprime un Item de la liste
  
 public void removeItem(final String pItem)
 {
     this.aRoomItem.deleteItem(pItem);
 }//removeItem();
 */
 /*
 /**
  * Ajout un Item dans la liste
  
 public void addItem(final String pNameItem,final Item pItem)
  {
      this.aRoomItem.addItem2(pNameItem,pItem);
  }//addItem();
  */
/**
* Accesseur attribut prive de la classe Room.@param Une des destination(nord sud etc...)
*/
   public Room getExit(final String pDestination) 
   {   return aExits.get(pDestination);
    }// getExit();
    
/**
 * Permet de savoir les sorties possibles de la piece courante.
 */
      public String getExitString()
      { 
        String vExits = "Exits : ";
        Set <String> vKey = aExits.keySet();
        for (String vPossiblesExits:vKey){vExits = vExits + " " +vPossiblesExits;}
        return vExits + "\n";
    }// getExitString();
    
    /*
/**
 *Retourne la description de l'Item sous format d'une chaine de charactere 
 
    public String getItemStringRoom()
    {
        return this.aRoomItem.getItemString();
       /* String vItemDescription = "";
        Set <String> vKeyItem = this.aRoomItem.keySet();
        for (String vItem: vKeyItem) {vItemDescription = vItemDescription + vItem + " " ;}
        if (vItemDescription.equals(""))return "No item here.";
        return vItemDescription;
    }//getItemString();
    */
/**
 * Creer des sorties de pieces @param la direction et la piece juste a cote
 */
public void setExit(final String pDirection, final Room pNeighbor,final boolean pPiege)
{ 
    this.aExits.put(pDirection,pNeighbor);
    this.aPiegeRoom.put(pDirection,pPiege);
}//setExit();

/**
 * Permet d'initialiser la liste HashMap d'Item @param le nom d'item et un objet de type Item
 */
 public void setItemRoom(final String pItem,final Item pTableOfItem)
{
    this.aRoomItem.put(pItem,pTableOfItem);
}//setItem();

/**
 * Accesseur Item dans le room @param le nom de l'Item
 */
public Item getItemRoom(final String pItem)
{
    return this.aRoomItem.get(pItem);
}

/**
 * Retourne la description longue de la piece courante  
 */
public String getLongDescription()
 {
    return aDescription + ".\n" + getExitString() + "\n"+getItemStringRoom();
 }// getLongDescription();
 
  /**
   * Retourne les noms des Items presents dans la piece
   */
      public String getItemStringRoom()
   {
       String vCle = "";
       Set <String> vKeys = this.aRoomItem.keySet();
          for (String vK : vKeys) {
              vCle = vCle + vK + " " ;
          }//for
          if (vCle == null)return "No Item";
          return vCle;
   }//getItemString()


/** 
 * Retourne String qui contient la description du nom de la piece courante
 */
   public String getImageName()
   {
      return this.aImageName; 
   }//getImageName()
   
   /**
    * Permet de savoir si la piece est en piegeuse @param La direction
    */
   public Boolean piegeRoom(final String pDirection) 
   {
       return this.aPiegeRoom.get(pDirection);
   }//piegeRoom()
   
} // Room
