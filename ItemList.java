import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
/**
 * Une classe ItemList permet de gerer les inventaire des Room et Player. Il comporte tous les Items presents dans le jeu.
 *
 * @author Danylo Dembitskyi
 * @version 27.05.2022
 */
public class ItemList
{
   private HashMap <String,Item> aItemInventory;
   
   /**
    * Constructeur naturel Itemlist
    */
   public ItemList() {
       this.aItemInventory = new HashMap<>();
   }//ItemList
   
   /*public boolean containItem(final String pItem)
   {
      Set vKeys = this.aItemInventory.keySet();
       Iterator <String> vDetection =vKeys.iterator();
       while (vDetection.hasNext()) {
           if (vDetection.equals(pItem)) return true;
       }//while
       return false;
   }// containItem();
   */
     /**
      * Permet de savoir si l'Item est present dans le jeu @param Le nom de l'Item
      */
     public boolean isInclus(final String pString)
     {
       String aKnow[] = new String[12];
       aKnow[0] ="Bed";
       aKnow[1] ="Sac";
       aKnow[2] ="Key";
       aKnow[3] ="Key of garage";
       aKnow[4] = "Clothes";
       aKnow[5] = "Mirroir";
       aKnow[6] = "Cake";
       aKnow[7] = "Schkaf";
       aKnow [8]= "Velo";
       aKnow[9]= "Ball";
       aKnow[10] = "MagicCookie";
       aKnow[11]="0";
       
       for ( int vI=0; vI<aKnow.length; vI++ ) {
            if ( aKnow[vI].equals( pString ) )
                return true;
        } // for si l'item n'a pas ete retrouve dans la liste 
        return false;
    } // isInclus()
    
   /*
    /
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     
    public boolean isItem( final String pString )
    {
        for ( int vI=0; vI<this.aKnow.length; vI++ ) {
            if ( this.aKnow[vI].equals( pString ) )
                return true;
        } // for
        // si l'item n'a pas ete retrouve dans la liste 
        return false;
    } // isCommand()
   */
    /*
   /**
    * Permet d'avoir le nom de tous les Item present chez Player. 
    
   */
   /*/**
    * Permet d'ajouter un Item dans la liste @param Le nom d'Item et Item lui-meme
   
   public void addItem2(final String pName, final Item pItem) {
       this.aItemInventory.put(pName,pItem);
   }//additem
   
   /**
    * Permet de supprimer un item de la collection associative HashMap a partir de cle String  @param le nom d'Item
    
   public void deleteItem(final String pItemSupp) {
       Set vKeys = this.aItemInventory.keySet();
       Iterator <String> vDetection =vKeys.iterator();
       while (vDetection.hasNext()) {
           if (vDetection.equals(pItemSupp))this.aItemInventory.remove(pItemSupp);
       }//while
   }// deleteItem
   
   public String getItemString()
   {
       String vCle = "";
       Set <String> vKeys = this.aItemInventory.keySet();
          for (String vK : vKeys) {
              vCle = vCle + vK + " " ;
          }//for
          if (vCle == null)return "No Item";
          return vCle;
   }//getItemString()
   
   public void setItem(final String pString, final Item pItem) 
   {
       this.aItemInventory.put(pString,pItem);
   }//setItem();
   */
   /**
    * Ascesseur de collection d'item @param Le nom d'Item
    */

   public Item getItem(final String pItemName){
       return this.aItemInventory.get(pItemName);
   }// getItem

   /** 
    * Permet de savoir si un Item est present dans l'inventaire du personnage @param String d'un Item
    */
      public boolean presentInInventor(final String pNameItem) 
      {
          Set <String> vKeys = this.aItemInventory.keySet();
          for (String vK : vKeys) {
              if(pNameItem.equals(vK)) return true;
          }//for
          return false;
      }//presentInInventor();
      
   /**
    * Permet de verifier si le personnage a un sac pour plus de capacite
    */   
      public boolean bigSpace() 
      {
          if (this.presentInInventor("Sac"))return true;
          return false;
      }//bigSpace();
     
   /*   
   /**
    * Permet de savoir si le personnage peut encore prendre des items
      
   public boolean moreItems()
   {
       double vTotalWeigth = 0;
       Set <String> vKeys = this.aItemInventory.keySet();
       for (String vBase : vKeys) {
           vTotalWeigth += getItem(vBase).getWeigth();
           
           if (!bigSpace() && vTotalWeigth >= 8 || bigSpace() && vTotalWeigth>=16)return false;
       }// for chaque element de linventaire verifie s'il y a suffisament d'espace pour prendre des items.
       return true;  
    }//moreItems();
      */
     /**
      * Permet de prendre Item @param Le nom de l'Item et Item lui-meme
      */
     public void takeItem(final String pNameItem, final Item pItem)
     {
         this.aItemInventory.put(pNameItem,pItem);
     }//takeItem();
     
    /**
     * Permet de drop Item @param Le nom de l'Item
     */
     public void dropItem(final String pNameItem)
     {
         this.aItemInventory.remove(pNameItem);
     }//dropItem();
     
     /**
      * Retourne tous les elements dans le jeu sous format d'un String
      */
     public String getItemString()
   {
       String vCle = "";
       Set <String> vKeys = this.aItemInventory.keySet();
          for (String vK : vKeys) {
              vCle = vCle + vK + " " ;
          }//for
          if (vCle == null)return "No Item";
          return vCle;
   }//getItemString()
   
   /**
    * Permet de connaitre le poids de tous les Items.
    */
   public double knowWeigth()
   {
       double vWeigth =0;
       Set <String> vKeys = this.aItemInventory.keySet();
       for (String vK:vKeys) {
           vWeigth += this.getItem(vK).getWeigth();
       }//for 
       return vWeigth;
   }//knowWeigth();

}//ItemList
