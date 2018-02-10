package seedu.addressbook.data.person;

/**
 * Represents a Person's address block data in the address book.
 */
public class Block {

    private static String block;

    public Block(String Block){
        block = Block;
    }

    public String getBlockExample(){
        return block;
    }

    public static void setBlockExample(String Block) {
        block = Block;
    }
}