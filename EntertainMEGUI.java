/** 
 * EnertainMEGUI.java
 * Written by: Eva Stern-Rodriguez and Sharon Kim
 * Modified date: May 13, 2016
 * CS230 Final Project
 * <p>
 * This is the panel that should be run in order to make the GUI appear
 * Creates a tabben panel with two tabs, the AboutPanel and the MovieCalcPanel
 * 
 * */

import java.awt.*;

import javax.swing.*;
import javax.swing.JOptionPane;


public class EntertainMEGUI{
  
  public static void main (String[] args) {
    // creates and shows a Frame 
    
    MovieLibrary myLib= new MovieLibrary("film.csv");
    
    JFrame frame = new JFrame("EntertainME");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    //create an instance of the GradSchools game
    //GradSchools gschool = new GradSchools();
    
    JTabbedPane tp = new JTabbedPane();
    tp.addTab ("About", new AboutPanel());
    tp.addTab ("Movie Calculator", new MovieCalcPanel(myLib));
    
    //create a panel, and add it to the frame
    
    frame.setPreferredSize(new Dimension(900, 600));
    frame.getContentPane().add(tp);
    
    frame.pack();
    frame.setVisible(true);
  }
}