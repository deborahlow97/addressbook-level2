package seedu.addressbook.data.person;

/**
 * Represents a Person's address unit in the address book.
 */
public class Unit {

    private static String unit;

    public Unit(String Unit){
        unit = Unit;
    }
    public String getUnitExample(){
        return unit;
    }
    public static void setUnitExample(String Unit) {
        unit = Unit;
    }
}

