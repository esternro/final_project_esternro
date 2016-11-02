/* MovieLibrary.java
 * CS230 FINAL PROJECT
 * Written by: Sharon Kim and Eva Stern-Rodriguez
 * Modified date: May 6, 2016
 */

import java.util.*;
import java.io.*;

public class MovieLibrary {
  
  private Hashtable<String, Vector<Movie>> allMovies;
  
  public MovieLibrary(String inFile) {
    
    allMovies = new Hashtable<String, Vector<Movie>>();
    
    try {
      
      Scanner scan = new Scanner(new File(inFile));
      
      // throwing out the first two lines of the file (headers)
      String trash1 = scan.nextLine();
      String trash2 = scan.nextLine();
      
      while (scan.hasNext()) {
        
        String line = scan.nextLine();
        String[] info = line.split(";");
        
        int year, length, popularity;
        String title = "";
        String genre = "";
        String director = "";
        String actor = "";
        String actress = "";
        Vector<String> actors = new Vector<String>();
        
        // get year
        if (!info[0].equals(""))
          year = Integer.parseInt(info[0]);
        else
          year = 0;
        
        // get length
        if (!info[1].equals(""))
          length = Integer.parseInt(info[1]);
        else
          length = 0;
        
        // get title
        if (!info[2].equals(""))
          title = info[2];
        else
          title = "n/a";
        
        // get genre
        if (!info[3].equals(""))
          genre = info[3];
        else
          genre = "Independent";
        
        // get actors and actresses and create a Vector<String>
        if (!info[4].equals(""))
          actor = info[4];
        else
          actor = "n/a";
        if (!info[5].equals(""))
          actress = info[5];
        else
          actress = "n/a";
        actors.add(actor);
        actors.add(actress);
        
        // get director
        if (!info[6].equals(""))
          director = info[6];
        else
          director = "n/a";
        
        // get popularity
        if (!info[7].equals(""))
          popularity = Integer.parseInt(info[7]);
        else
          popularity = 0;
        
        // create a new Movie object
        Movie movie = new Movie(title, genre, length, actors, director, popularity, year);
        
        // add to Hashtable with genre as the key
        String g = movie.getGenre();
        if (!allMovies.containsKey(g)) {
          Vector<Movie> moviesByGenre = new Vector<Movie>();
          moviesByGenre.add(movie);
          allMovies.put(g, moviesByGenre);
        }
        else {
          Vector<Movie> values = allMovies.get(g);
          values.add(movie);
        }
      }
      
      scan.close();
    }
    
    catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException " + e);
    }
  }
  
  public String toString() {
    return allMovies.toString();
  }
  
  public Vector<Movie> getMoviesOfGenre(String genre) {
    return allMovies.get(genre);
  }
  
  public static void main(String[] args) {
    
    MovieLibrary m = new MovieLibrary("film.csv");
    System.out.println(m);
    
  }
}