/* MyMoviesCollection.java contains:
 *   1) a collection of all Movie objects, 
 *   2) a computeRank() method that computes the ranking for every Movie object of this
 *      genre
 *   3) a prioritize() method that organizes the collection of Movie objects according to 
 *      this computed rating order into a priority queue.
 * 
 * CS230 Final Project
 * Written by: Eva Stern-Rodriguez and Sharon Kim
 * Modified date: May 12, 2016
 */

import java.util.*;
import javafoundations.*;

public class MyMovieCollection {
  
  private ArrayStack<Movie> myRankedQueue;
  private Vector<Movie> moviesOfGenre;
  
  public MyMovieCollection(String genre) {
    myRankedQueue = new ArrayStack<Movie>();
    moviesOfGenre = new MovieLibrary("film.csv").getMoviesOfGenre(genre);
  }
  
  // computes rank for each Movie object in movies
  public void computeRank(int time, String actor, String director, int wTime, int wActor, int wDirector) {
    for (int i = 0; i < moviesOfGenre.size(); i++) {
      Movie current = moviesOfGenre.elementAt(i);
      int actorExists = current.actorExists(actor);
      int dirExists = current.directorExists(director);
      int timeExists = current.timeExists(time);
      current.setRank(current.getPopularity()+(actorExists*wActor)+(dirExists*wDirector)+(timeExists*wTime));
    }
  }
  
  // adds the sorted movies to a priority queue to be returned
  public ArrayStack<Movie> prioritize() {
    Collections.sort(moviesOfGenre);
    
    for (int i = 0; i < moviesOfGenre.size(); i++)
      myRankedQueue.push(moviesOfGenre.remove(i));
    
    return myRankedQueue;
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < moviesOfGenre.size(); i++)
      s += moviesOfGenre.elementAt(i);
    
    return s;
  }
  
  public static void main(String[] args) {
    MyMovieCollection m = new MyMovieCollection("Horror");
    //m.computeRank(3, 3, 0, 1);
    //System.out.println(m);
    m.prioritize();
    System.out.println(m);
  }
}