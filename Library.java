/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;

public class Library extends Building {

  // Attribute
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  // Constructor
  /**
   * Constructs the library with its name, address, and the number of floors,
   * and assigns a new Hashtable of books
   * 
   * @param name    name of library
   * @param address address of library
   * @param nFloors number of floors of library
   */
  public Library(String name, String address, int nFloors, boolean elevator) {
    super(name, address, nFloors);
    this.hasElevator = elevator;
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Overloaded Constructor with default setting
   */
  public Library() {
    super();
    this.name = "<Library Name Unknown>";
    this.hasElevator = true;
  }

  /**
   * Overloaded Constructor with name only
   */
  public Library(String name, int floor) {
    this();
    this.name = name;
    this.nFloors = floor;
  }

  /**
   * Checks if the book is in this collection
   * 
   * @param title title of the book
   * @return true if the title appears as a key in the Libary's collection,
   *         false otherwise
   */
  public boolean containsTitle(String title) {
    return this.collection.contains(title);
  }

  /**
   * Checks if the book is now available to check out
   * 
   * @param title title of the book
   * @return true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title) {
    return this.collection.get(title);
  }

  /**
   * Moves the person to the given floor,
   * overriding the superclass method
   * 
   * @param floorNum the number of the floor to which the person should go
   */
  public void goToFloor(int floorNum) {
    if (this.hasElevator == true || (this.activeFloor >= 1 && Math.abs(this.activeFloor - floorNum) == 1)) {
      super.goToFloor(floorNum);
    } else {
      System.out.println("There is no elevator in " + this.name + ", so you cannot go to floor #" + floorNum
          + " from floor #" + this.activeFloor);
    }
  }

  /**
   * Adds the book into the collection hashtable
   * with the title as a key and true as a value
   * 
   * @param title the title of the book
   */
  public void addTitle(String title) {
    try {
      if (this.containsTitle(title)) {
        System.out.println(title + " is already in this collection");
      } else {
        this.collection.put(title, true);
        System.out.println(title + " is successfully added!");
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
  }

  /**
   * Removes the book from the collection hashtable
   * and returns the title of the book
   * 
   * @param title the title of the book
   * @return the title of the book
   */
  public String removeTitle(String title) {
    try {
      if (this.containsTitle(title)) {
        this.collection.remove(title);
        System.out.println(title + " is successfully removed!");
      } else {
        System.out.println(title + " is not in this collection");
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
    return title;
  }

  /**
   * Changes the book's availability into false
   * 
   * @param title the title of the book
   */
  public void checkOut(String title) {
    try {
      if (this.isAvailable(title)) {
        this.collection.replace(title, false);
        System.out.println(title + " is checked out!");
      } else {
        System.out.println(title + " is not available now");
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
  }

  /**
   * Changes the book's availability into true
   * 
   * @param title the title of the book
   */
  public void returnBook(String title) {
    try {
      if (this.isAvailable(title)) {
        System.out.println(title + " seems to be already returned");
      } else {
        this.collection.replace(title, true);
        System.out.println(title + " is returned!");
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
  }

  /**
   * Prints all the book in the collection hashtable
   * including the title and the availability
   */
  public void printCollection() {
    System.out.println("Below is the entire list of books in the collection:");
    for (Map.Entry<String, Boolean> entry : this.collection.entrySet()) {
      System.out.print(entry.getKey() + " -> ");
      if (entry.getValue().equals(true)) {
        System.out.println("available");
      } else {
        System.out.println("not available");
      }
    }
  }

  /**
   * Shows all options of method
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name
        + ":\n + addTitle() + removeTitle() \n + checkOut() \n + returnBook() \n + printCollection()\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson Library", "neilson", 5, true);
    myLibrary.addTitle("The Lorax by Dr. Seuss");
    myLibrary.printCollection();
  }

}