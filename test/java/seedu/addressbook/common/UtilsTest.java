package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void isAnyNull() throws Exception {
        //empty list
        assertNoNull();

        //all objects are null
        assertThereIsNull(null, null);
        assertThereIsNull(null, null, null);

        //there exists a null object
        assertThereIsNull(null, "a", "b", null);
        assertThereIsNull("abc", null);
        assertThereIsNull("abc", "", "abc", null);
        assertThereIsNull("", "abc", "a", null);
        assertThereIsNull(null, new Integer(1));
        assertThereIsNull(null, 1, new Integer(1));

        //there is no null objects
        assertNoNull("abc", "ab", "a");
        assertNoNull(1, 2);
        assertNoNull(1, 2, 3);
    }

    private void assertThereIsNull(Object... objects) {assertTrue(Utils.isAnyNull(objects));}
    private void assertNoNull(Object... objects) {assertFalse(Utils.isAnyNull(objects));}
    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
