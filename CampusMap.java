import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * 
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * 
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " ("
                    + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new House("Talbot House", false));
        myMap.addBuilding(new House("Tyler House", "164 Green Street, Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new House("Chapin House", true));

        myMap.addBuilding(new Cafe("Campus Center Cafe"));
        myMap.addBuilding(new Cafe());

        myMap.addBuilding(new Library("Neilson Library", 4));
        myMap.addBuilding(
                new Library("Josten Performing Arts Library", "122 Green Street, Northampton, MA 01063", 2, false));
        myMap.addBuilding(new Library());

        myMap.addBuilding(new Building("10 Elm Street, Northampton, MA 01063"));
        myMap.addBuilding(new Building("Seelye Hall", "3 Seelye Drive, Northampton, MA 01063"));
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Elm Street, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("McConnell Hall", "30 Belmont Avenue, Northampton, MA 01063", 3));

        System.out.println(myMap);

        myMap.buildings.get(3).enter();
        myMap.buildings.get(3).goToFloor(4);
        myMap.buildings.get(5).enter();
        myMap.buildings.get(5).goToFloor(2);
        myMap.buildings.get(7).enter();
        myMap.buildings.get(7).goToFloor(4);
    }

}
