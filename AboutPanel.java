/** 
 * AboutPanel.java
 * Written by: Eva Stern-Rodriguez and Sharon Kim
 * Modified date: May 13, 2016
 * CS230 Final Project
 * <p>
 * Sets up the About Panel for the EntertainMEGUI. This pannel initialized various sub-panels, labels,
 * and text areas in order to create an aethitically pleasing GUI
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class AboutPanel extends JPanel{
  
  // instance variables
  private JLabel background, titleLabel;
  private JTextArea info, movieCalcInfo;
  private JLabel encourageLabel;
  private JPanel textPanel, infoPanel, instructionPanel;

  // constructor
  public AboutPanel() {
    
    //create label to display info
    titleLabel = new JLabel("\n   EntertainME   \n");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
    titleLabel.setForeground (new Color(239,53,47));
    titleLabel.setBackground (Color.white);
    titleLabel.setOpaque(true);
    
    
    //text area welcoming the user
    info = new JTextArea("\n Hello! Welcome to EntertainMe. \n \n EntertainMe is a movie"+ 
                         " recommendation application that is meant to make the process"+ 
                         " of finding the perfect movie to watch a little easier for you."+  
                         "With a few simple steps, you’ll be entertained in no time.");
    info.setLineWrap(true);
    info.setPreferredSize(new Dimension(700,100));
    
    
    
    //Text area with info about how to use the applications
    movieCalcInfo=new JTextArea("Movie Calculator is made with an easy and intuitive GUI so you can easily input informtion"
                                  +" and get the movie that is right for you. To start, click on the Movie Calculator tab "+
                                "located above.  The only information you are required to provide is the genre. "+
                                " Click on one of categories that fits you best.  Then, you can provide some more general "+
                                "information about the movie you want by inputting the Name of a actor or a director "+
                                "you like into the text box.  Move the slider in order give weight or importance "+
                                "to the category directly above. The Preferred Time slider allows your preferred maximum"+
                                " time you would like to spend watching a movie. When you have filled out enough information"+
                                " click the 'Get My Movies' button and we will give you a movie to watch that fits your needs. "+
                                "If you are unhappy with our selection or would prefer to watch another movie "+
                                "other than the one provided, just click the button again!");
    movieCalcInfo.setLineWrap(true);
    movieCalcInfo.setWrapStyleWord(true);
    movieCalcInfo.setPreferredSize(new Dimension(400,350));
    
    
    
    encourageLabel = new JLabel("You'll find the right movie for you in no time!");
    
    //create panels to hold labels
    
    infoPanel =  new JPanel();
    instructionPanel = new JPanel();
    
    
    // panels to hold labels panels
    textPanel = new JPanel();
    
    
    //change background color of main panel
    //setBackground(Color.black);
    background=new JLabel(new ImageIcon("movies.png"));
    background.setLayout(new FlowLayout());
    
    //set layout of text panel for style
    textPanel.setLayout(new BorderLayout());  
    
    //add labels panels and place them on textPanel
    instructionPanel.add(encourageLabel); 
    instructionPanel.setBackground(Color.white);
    textPanel.add (instructionPanel, BorderLayout.CENTER);
    
    
    
    infoPanel.add(info);
    infoPanel.add(movieCalcInfo);
    infoPanel.setBackground(Color.white);
    textPanel.add (infoPanel, BorderLayout.NORTH);
    
    
    
    
    //Set inner panel color and dimensions
    textPanel.setPreferredSize(new Dimension(800, 400));
    textPanel.setAlignmentX (Component.CENTER_ALIGNMENT);
    textPanel.setBackground(Color.white);
    
    //set background image
    add(background);
    
    //add panels with text to iamge
    
    background.add(titleLabel);
    background.add(textPanel);
    
    
    
  }
  
  
}