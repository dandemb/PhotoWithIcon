
/**
 * La classe Item est utilisee pour representer et avoir toute sorte d'information concernant un objet Item.
 *
 * @author Dembitskyi Danylo
 * @version 27/05/2022
 */
public class Item
{
    private String aItemDescription;
    private double aWeigth;
    
    /**
     * Conctructeur naturel de l'objet de type Item @param La dscription d'Item et le poids
     */
    public Item(final String pItemDescription,final double pWeigth)
    {
        this.aItemDescription = pItemDescription;
        this.aWeigth = pWeigth;
    }//Construceteur Item();
    
    /**
     * Accesseur d'attribut (chaine de charactere) aItemDescription
     */
    public String getItemDescription()
    {
        return this.aItemDescription;
    }//Accesseur getItemDescription();

    /**
     * Accesseur d'attribut aWeigth
     */
    public double getWeigth()
    {
        return this.aWeigth;
    }// Acceseur getWeigth();
    
    /**
     * Modificateur d'attribut aItemDescription @param Description d'un Item en parametres
     */
    public void setItemDescription(final String pItemDescription)
    {
        this.aItemDescription = pItemDescription;
    }//Modificateur setItemDescription();
    
    /**
     * Modificteur d'attribut aWeigth @param Le poids de l'objet 
     */
    public void setWeigth(final double pWeigth)
    {
        this.aWeigth = pWeigth;
    }//Modificateur setWeigth();
}//Item
