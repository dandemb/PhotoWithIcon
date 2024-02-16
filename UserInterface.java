import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling + Danylo Dembitskyi
 * @version 1.0 (Jan 2003) DB edited (2019) + 27.05.2022
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton    aBouton1;
    private JButton    aBouton2;
    private JButton    aBouton3;
    private JButton    aBouton4;
    private JButton    aBouton5;
    private JButton    aBouton6;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.@param Text
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.@param Le nom de l'image dont on veut afficher
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.@pOnOff = verifie si allume ou eteint 
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        if ( ! pOnOff ) { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "Photo with Icon" ); // change the title
        this.aEntryField = new JTextField( 34 );

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        
        JLabel vBouton = new JLabel();// creation de bouton
        JPanel vBoutonPanel = new JPanel();// creation de panel pour le bouton
        vBoutonPanel.setLayout(new GridLayout(0,1,2,3)); //on determine comment positionner le bouton   
        
        aBouton1=  new JButton("north");
        aBouton2= new JButton("east");
        aBouton3= new JButton("south");
        aBouton4= new JButton("west"); // Creation de bouton poussoire tel quel est
        aBouton5= new JButton("up");
        aBouton6= new JButton("down");
        
        this.aBouton1.addActionListener(this);
        this.aBouton2.addActionListener(this);
        this.aBouton3.addActionListener(this);
        this.aBouton4.addActionListener(this);//lorsquo'on appuie sur le bouton une action se deroule 
        this.aBouton5.addActionListener(this);
        this.aBouton6.addActionListener(this);
        
        vBoutonPanel.add(aBouton1);
        vBoutonPanel.add(aBouton2);
        vBoutonPanel.add(aBouton3);
        vBoutonPanel.add(aBouton4);//ajouter les boutons sur le panel dedie aux bouttons
        vBoutonPanel.add(aBouton5);
        vBoutonPanel.add(aBouton6);
        
        //vBouton.setPreferredSize(new Dimension(20,20));
        
        

        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(vBoutonPanel, BorderLayout.EAST);//il nous reste que east a utiliser
        
        
        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );

        // to end program when window is closed
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        // no need to check the type of action at the moment
        // because there is only one possible action (text input) :
        this.processCommand(); // never suppress this line
        
        //si on clique su le bouton,action suivant a realiser :
        if(pE.getSource().equals(this.aBouton1)) this.aEngine.interpretCommand("go north");
        if(pE.getSource().equals(this.aBouton2)) this.aEngine.interpretCommand("go east");
        if(pE.getSource().equals(this.aBouton3)) this.aEngine.interpretCommand("go south");
        if(pE.getSource().equals(this.aBouton4)) this.aEngine.interpretCommand("go west");//getSource() permet de savoir quelle action a ete realise
        if(pE.getSource().equals(this.aBouton5)) this.aEngine.interpretCommand("go up");
        if(pE.getSource().equals(this.aBouton6)) this.aEngine.interpretCommand("go down");
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
