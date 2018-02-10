package seedu.addressbook.data.person;

/**
 * Represents a Person's address PostalCode data in the address book.
 */
public class PostalCode {

    private static String postalCode;

    public PostalCode(String postalcode){
        postalCode = postalcode;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public static void setPostalCode(String postalcode) {
        postalCode = postalcode;
    }
}