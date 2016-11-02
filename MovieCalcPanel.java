/** 
 * MovieCalct.java
 * Written by: Eva Stern-Rodriguez and Sharon Kim
 * Modified date: May 13, 2016
 * CS230 Final Project
 * <p>
 * Sets up the Movie Calculator Panel for the EntertainMEGUI.  
 * This pannel initialized various sub-panels, labels, and buttons
 * in order to create an aethitically pleasing GUI
 * 
 * Contains a private class that hold the event listeners for genre butttons
 * and the get my movie button.  
 * 
 * */

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.*;
import javafoundations.*;
import javafoundations.exceptions.*;


public class MovieCalcPanel extends JPanel{
  private JPanel inputPanel, genrePanel, actorPanel, directorPanel, timePanel, movieInfoPanel, wrapperPanel,
    timeWeightPanel, actorWeightPanel, directorWeightPanel, yourMoviePanel, yourTitlePanel, yourActorPanel, 
    yourDirectorPanel, yourTimePanel, yourYearPanel;
  private JLabel genreLabel, actorLabel, directorLabel, timeLabel, background, directorWeightLabel,
    timeWeightLabel, actorWeightLabel,yourMovieLabel, yourTitleLabel, yourActorLabel, yourDirectorLabel,
    yourTimeLabel, yourYearLabel;
  private JRadioButton comedy, action, horror, drama, mystery, scienceFiction, 
     western, music, war, romance, adventure, fantasy;
  private JButton  getMovie;
  private JTextField actorField, directorField;
  private JSlider timeSlider, timeWeightSlider, actorWeightSlider, directorWeightSlider;
  private MovieLibrary myLib;
  private ButtonGroup group;
  private MyMovieCollection myMovies;
 
  
  public MovieCalcPanel(MovieLibrary lib){
    
    myLib = lib;
    myMovies = new MyMovieCollection("Comedy");
    
    //initialize panels
    inputPanel= new JPanel();
    genrePanel= new JPanel();
    actorPanel= new JPanel();
    directorPanel= new JPanel();
    timePanel= new JPanel();
    movieInfoPanel= new JPanel();
    wrapperPanel = new JPanel();
    timeWeightPanel = new JPanel();
    actorWeightPanel = new JPanel();
    directorWeightPanel = new JPanel();
    
    
    //set text for labels on user input panel
    genreLabel= new JLabel("Preferred Genre"+"                                           ");
    actorLabel= new JLabel("Preferred Actor (Last name, first)");
    directorLabel= new JLabel("Preffered Director");
    timeLabel = new JLabel("Prefrered Time (min)");
    directorWeightLabel = new JLabel("Assign A Weight");
    timeWeightLabel = new JLabel("Assign A Weight");
    actorWeightLabel = new JLabel("Assign A Weight");
    
    
    
    //panel that goes on top of background image.  Holds all other panels
    wrapperPanel.setLayout(new BorderLayout());
    wrapperPanel.setPreferredSize(new Dimension(800, 485));
    wrapperPanel.setBackground (Color.white);
    
    
    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
    inputPanel.setBackground (Color.white);
    
    //Radio Buttons
    comedy = new JRadioButton ("Comedy");
    action = new JRadioButton ("Action"); 
    horror = new JRadioButton ("Horror"); 
    drama = new JRadioButton ("Drama"); 
    mystery = new JRadioButton ("Mystery");
    scienceFiction = new JRadioButton ("Science Fiction");
    western = new JRadioButton ("Westerns"); 
    music = new JRadioButton ("Music");
    war = new JRadioButton ("War"); 
    romance = new JRadioButton ("Romance");
    adventure = new JRadioButton("Adventure");
    fantasy = new JRadioButton("Fantasy");
    
    //Button that generates the user's movies when clicked
    getMovie = new JButton("Get My Movies");
    
    //Event listener that responds when button is clicked
    ButtonListener buttonListener = new ButtonListener();
    getMovie.addActionListener (buttonListener);
    
    
    //set layout for panel with radio button
    genrePanel.setLayout(new GridLayout(5, 3));
    genrePanel.setBackground (Color.white);
    
    
    
    //add button to group so that when only one button can be clicked at a time
    group = new ButtonGroup();
    group.add(comedy);
    group.add(action);
    group.add(horror);
    group.add(drama);
    group.add(mystery);
    group.add(scienceFiction);
    group.add(western);
    group.add(music);
    group.add(war);
    group.add(romance);
    group.add(adventure);
    group.add(fantasy);
    
    //add button listner to radio button
    //use this listener to create myMovieCollection with correct genre
    ButtonListener radioListener = new ButtonListener();
    comedy.addActionListener(radioListener);
    action.addActionListener(radioListener);
    horror.addActionListener(radioListener);
    drama.addActionListener(radioListener);
    mystery.addActionListener(radioListener);
    scienceFiction.addActionListener(radioListener);
    music.addActionListener(radioListener);
    war.addActionListener(radioListener);
    romance.addActionListener(radioListener);
    adventure.addActionListener(radioListener);
    fantasy.addActionListener(radioListener);

    

    
    //add all the radio button to genrePanel
    genrePanel.add(comedy);
    genrePanel.add(action);
    genrePanel.add(horror);
    genrePanel.add(drama);
    genrePanel.add(mystery);
    genrePanel.add(scienceFiction);
    genrePanel.add(western);
    genrePanel.add(music);
    genrePanel.add(war);
    genrePanel.add(romance);
    genrePanel.add(adventure);
    genrePanel.add(fantasy);
    
    //create textfields
    actorField = new JTextField (12);
    directorField = new JTextField (12);
    
    //creates slider for time and giving weight to movie factors
    timeSlider = new JSlider (JSlider.HORIZONTAL, 0, 150, 0);
    timeSlider.setMinorTickSpacing (15);
    timeSlider.setMajorTickSpacing (30);
    timeSlider.setPaintTicks (true);
    timeSlider.setPaintLabels (true);
    
    timeWeightSlider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);
    timeWeightSlider.setMinorTickSpacing (1);
    timeWeightSlider.setMajorTickSpacing (5);
    timeWeightSlider.setPaintTicks (true);
    timeWeightSlider.setPaintLabels (true);
    
    actorWeightSlider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);
    actorWeightSlider.setMinorTickSpacing (1);
    actorWeightSlider.setMajorTickSpacing (5);
    actorWeightSlider.setPaintTicks (true);
    actorWeightSlider.setPaintLabels (true);
    
    directorWeightSlider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);
    directorWeightSlider.setMinorTickSpacing (1);
    directorWeightSlider.setMajorTickSpacing (5);
    directorWeightSlider.setPaintTicks (true);
    directorWeightSlider.setPaintLabels (true);
    
    
    
    
    //add genre label and panel to menu
    inputPanel.add(genreLabel);
    inputPanel.add(genrePanel);
    
    
    //create panel to hold actor label and textfield, add it to menu
    actorPanel.setLayout(new FlowLayout());
    actorPanel.add(actorLabel);
    actorPanel.add(actorField);
    actorPanel.setBackground (Color.white);
    actorWeightPanel.add(actorWeightLabel);
    actorWeightPanel.add(actorWeightSlider);
    inputPanel.add(actorPanel);
    inputPanel.add(actorWeightPanel);
    
    //create panel to hold director label and textfield, add it to menu
    directorPanel.setLayout(new FlowLayout());
    directorPanel.add(directorLabel);
    directorPanel.add(directorField);
    directorPanel.setBackground (Color.white);
    directorWeightPanel.add(directorWeightLabel);
    directorWeightPanel.add(directorWeightSlider);
    inputPanel.add(directorPanel);
    inputPanel.add(directorWeightPanel);
    
    //create panel to hold time label and textfield, add it to menu 
    timePanel.setLayout(new FlowLayout());
    timePanel.add(timeLabel);
    timePanel.add(timeSlider);
    timePanel.setBackground (Color.white);
    timeWeightPanel.add(timeWeightLabel);
    timeWeightPanel.add(timeWeightSlider);
    inputPanel.add(timePanel);
    inputPanel.add(timeWeightPanel);
    inputPanel.add(getMovie);
    
    
    
    //Panel for displaying your generated movie
    yourMoviePanel = new JPanel();      
    yourMoviePanel.setLayout(new FlowLayout());
    yourMoviePanel.setBackground (Color.white);
    yourTitlePanel = new JPanel();    
    yourActorPanel = new JPanel();
    yourDirectorPanel = new JPanel();
    yourTimePanel = new JPanel();
    yourYearPanel = new JPanel();
    
    //Label for showing info about generated movie
    //Add labels to panels and size the panel for
    //aesthetic  reason
    yourMovieLabel= new JLabel("  Your Movie");
    yourMovieLabel.setFont(new Font("Arial", Font.BOLD, 20));
    yourTitleLabel = new JLabel(" ");
    yourTitlePanel.add(yourTitleLabel);
    yourTitleLabel.setFont(new Font("Arial",  Font.BOLD, 15));
    yourTitlePanel.setPreferredSize(new Dimension(335, 101));                                
    yourActorLabel = new JLabel(" ");
    yourActorLabel.setFont(new Font("Arial", Font.BOLD, 15));
    yourActorPanel.setPreferredSize(new Dimension(335, 101));
    yourActorPanel.add(yourActorLabel);
    yourDirectorLabel = new JLabel(" ");
    yourDirectorLabel.setFont(new Font("Arial", Font.BOLD, 15));
    yourDirectorPanel.setPreferredSize(new Dimension(335, 101)); 
    yourDirectorPanel.add(yourDirectorLabel);
    yourTimeLabel = new JLabel(" ");
    yourTimeLabel.setFont(new Font("Arial", Font.BOLD, 15));
    yourTimePanel.add(yourTimeLabel);
    yourTimePanel.setPreferredSize(new Dimension(335, 101));
    yourYearLabel = new JLabel(" ");
    yourYearLabel.setFont(new Font("Arial", Font.BOLD, 15));
    yourYearPanel.add(yourYearLabel);
    yourYearPanel.setPreferredSize(new Dimension(335, 101));
    
    //Add Labels and panels to your movie panel
    //that displays all the generated movie info
    yourMoviePanel.add(yourMovieLabel);
    yourMoviePanel.add(yourTitlePanel);
    yourMoviePanel.add(yourActorPanel);
    yourMoviePanel.add(yourDirectorPanel);
    yourMoviePanel.add(yourTimePanel);
    
    
    //set background image
    background=new JLabel(new ImageIcon("movies.png"));
    background.setLayout(new FlowLayout());
    
    //empty label for aesthetics
    JLabel space = new JLabel("\n                                      \n \n \n \n ");
    
    //set background image
    add(background);
    background.add(space);
    wrapperPanel.add(inputPanel, BorderLayout.LINE_START);
    wrapperPanel.add(yourMoviePanel,BorderLayout.CENTER);
    background.add(wrapperPanel);
    
    
  }
  //*****************************************************************
  // Represents a listener for button push (action) events.
  //*****************************************************************
  
  private class ButtonListener implements ActionListener
  {

    public void actionPerformed (ActionEvent event){
     
      
      //creates a new movie collection every time a radio button is pressed 
      //using the genre as a parameter
      if (event.getSource() != getMovie){
        myMovies = new MyMovieCollection(getSelectedButtonText(group));
        
      }    
      
      if(event.getSource() == getMovie) {
        try{
          
           //Compute the rating of each of the movies in a specified genre based
      //deuqueue the first value.  If you have already pushed the button once,
      //just dequeue the next value
          
        myMovies.computeRank(timeSlider.getValue(), actorField.getText(), directorField.getText(),
                             timeWeightSlider.getValue(), actorWeightSlider.getValue(), 
                             directorWeightSlider.getValue());
        ArrayStack<Movie> recommendedMovies= myMovies.prioritize(); 
        
        //ask users to choose a genre if they press the generate buttton
        //before choosing a genre
        if(getSelectedButtonText(group)==null){
          final JFrame alert = new JFrame();
          JOptionPane.showMessageDialog(alert, "Please choose a genre");
        }
        else{
          
          if(recommendedMovies.pop()!=null){
            
            //get first item in stack and set labels on panel
            //to display information for the given movie
            Movie m1 = recommendedMovies.pop();
            yourTitleLabel.setText("Title: " + m1.getTitle());
            yourActorLabel.setText("Actor: " + m1.getActors().elementAt(0)+ "         " 
                                     +m1.getActors().elementAt(1));
            yourDirectorLabel.setText("Director: " +m1.getDirector());
            yourTimeLabel.setText("Length: " + m1.getLength());
            yourYearLabel.setText("Year: " + m1.getLength());
          }
        }
        }
        //if there are no more items in the stack, alert the user
        //that there are no more movies, throw empty collection
        catch (EmptyCollectionException e) {
          final JFrame alert = new JFrame();
          JOptionPane.showMessageDialog(alert, "There are no movies for you at this time"); 
          throw new EmptyCollectionException("Empty collection");
        }
      }
    }
    
    //Method that returns the String associated with given radio button
    private String getSelectedButtonText(ButtonGroup group) {
      for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
        AbstractButton button = buttons.nextElement();
        
        if (button.isSelected()) {
          return button.getText();
        }
      }
      
      return null;
    }
    
  }
//}
}