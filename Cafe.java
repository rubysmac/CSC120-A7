/* This is a stub for the Cafe class */
public class Cafe extends Building {

    // Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    // Constructor
    /**
     * Constructs the cafe with its name, address, and the number of floors
     * and sets the initial value for the cafe's inventory
     * including ounces of coffee, sugar packets, creams, and cups
     * 
     * @param name    the name of cafe
     * @param address the address of cafe
     * @param nFloors the number of floors of cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 20;
        this.nSugarPackets = 50;
        this.nCreams = 20;
        this.nCups = 20;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded Constructor with default setting
     */
    public Cafe() {
        super();
        this.name = "<Cafe Name Unknown>";
        this.nFloors = 2;
    }

    /**
     * Overloaded Constructor with name only
     * 
     * @param name the name of cafe
     */
    public Cafe(String name) {
        this();
        this.name = name;
    }

    /**
     * Throws an exception if the person tries to move to inappropriate floor in
     * cafe,
     * overriding the superclass method
     * 
     * @param floorNum the number of the floor to which the person should go
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException(
                    "You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException(
                    "Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
        }
        throw new RuntimeException("You cannot move to other floors in " + this.name + ". It is for employees only.");
    }

    /**
     * Adds the inventory with given values
     * for each ounces of coffee, sugar packets, creams, and cups
     * 
     * @param nCoffeeOunces the number of coffee ounces to add
     * @param nSugarPackets the number of sugar packets to add
     * @param nCreams       the number of creams to add
     * @param nCups         the number of cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Sells a coffee deducting given value of size, sugar, and cream from the
     * inventory
     * if all required ingredients and cups are available.
     * 
     * @param size          the size of the coffee ounces required
     * @param nSugarPackets the number of sugar packets required
     * @param nCreams       the number of creams required
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        try {
            if (this.nCups > 0) {
                if (this.nCoffeeOunces - size >= 0) {
                    if (this.nSugarPackets - nSugarPackets >= 0) {
                        if (this.nCreams - nCreams >= 0) {
                            this.nCoffeeOunces -= size;
                            this.nSugarPackets -= nSugarPackets;
                            this.nCreams -= nCreams;
                            this.nCups -= 1;
                            System.out.println("This coffee is successfully sold!");
                        } else {
                            System.out.println("There is not enough creams left");
                            this.restock(0, 0, 20, 0);
                            System.out.println("Now creams are restocked!");
                        }
                    } else {
                        System.out.println("There is not enough sugars left");
                        this.restock(0, 50, 0, 0);
                        System.out.println("Now sugars are restocked!");
                    }
                } else {
                    System.out.println("There is not enough ounces of coffee left");
                    this.restock(20, 0, 20, 0);
                    System.out.println("Now coffee ounces are restocked!");
                }
            } else {
                System.out.println("There are no cups left");
                this.restock(0, 0, 0, 20);
                System.out.println("Now creams are restocked!");
            }
        } catch (Exception e) {
            System.out.println("Something's wrong.");
        }

    }

    /**
     * Shows all options of method
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name
                + ":\n + sellCoffee()\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("CC", "elm street", 2);
        myCafe.sellCoffee(7, 5, 1);
        myCafe.sellCoffee(7, 5, 1);
        myCafe.sellCoffee(7, 5, 1);
        myCafe.sellCoffee(7, 5, 1);
    }
}
