/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {

  // Attributes
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  // Constructor
  /**
   * Constructs the house with its name, address, the number of floors,
   * and the presence of dining room, and assigns a new arraylist of residents
   * 
   * @param name    the name of house
   * @param address the address of house
   * @param nFloors the number of floors of house
   * @param dining  the boolean value if the dining room exists in house
   */
  public House(String name, String address, int nFloors, boolean dining, boolean elevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = dining;
    this.hasElevator = elevator;
    this.residents = new ArrayList<String>();
  }

  /**
   * Overloaded Constructor with default setting
   */
  public House() {
    super();
    this.name = "<House Name Unknown>";
    this.nFloors = 4;
    this.hasDiningRoom = false;
    this.hasElevator = false;
  }

  /**
   * Overloaded Constructor with name and boolean value of a dining presence
   * 
   * @param name   the name of the house
   * @param dining true if this house has a dining, false otherwise
   */
  public House(String name, boolean dining) {
    this();
    this.name = name;
    this.hasDiningRoom = dining;
  }

  // Accessors
  /**
   * Returns the
   * 
   * @return true if it has, false if it doesn't
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents in this house
   * 
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Checks if the person is living in this house
   * 
   * @param person the person to check
   * @return true if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      return true;
    } else {
      return false;
    }
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
   * Shows all options of method
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name
        + ":\n + moveIn() \n + moveOut()\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
  }

  /**
   * Adds the person into this house's resident list
   * 
   * @param name the person to be added
   */
  public void moveIn(String name) {
    try {
      if (this.isResident(name)) {
        System.out.println(name + " is already living in " + this.name);
      } else {
        residents.add(name);
        System.out.println(name + " successfully moved in to " + this.name);
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
  }

  /**
   * Removes the person from this house's resident list
   * 
   * @param name the person to be removed
   * @return the person's name
   */
  public String moveOut(String name) {
    try {
      if (this.isResident(name)) {
        residents.remove(name);
        System.out.println(name + " successfully moved out from " + this.name);
      } else {
        System.out.println(name + " is not living in " + this.name);
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
    return name;
  }

  public static void main(String[] args) {
    House myHouse = new House("Tyler", "1 chapin way", 4, true, false);
    String ruby = new String("Ruby");
    myHouse.moveIn(ruby);
  }

}