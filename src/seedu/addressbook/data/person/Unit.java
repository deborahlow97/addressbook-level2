package seedu.addressbook.data.person;

/**
 * Represents a Person's address unit in the address book.
 */
public class Unit {

    private static String unit;

    public Unit(String Unit){
        unit = Unit;
    }
    public String getUnit(){
        return unit;
    }
    public static void setUnit(String Unit) {
        unit = Unit;
    }
}

