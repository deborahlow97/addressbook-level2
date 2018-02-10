package seedu.addressbook.data.person;

/**
 * Represents a Person's address street in the address book.
 */
public class Street {

    private static String street;

    public Street(String StreetName){
        street = StreetName;
    }
    public String getStreetName(){
        return street;
    }
    public static void setStreetName(String StreetName) {
        street = StreetName;
    }
}
