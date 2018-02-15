package seedu.addressbook.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Returns true if any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if every element the given collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method converts the set of keywords to a set of lower case strings and returns it.
     * @return set of lower case string
     */
    public static Set<String> keywordToLowerCaseSet(Set<String> keywords) {
        Set<String> lowerCaseKeywords = new HashSet<>();
        for(String key : keywords) {
            lowerCaseKeywords.add(key.toLowerCase());
        }
        return lowerCaseKeywords;
    }

    public static List<String> keywordToLowerCaseList(List<String> keywords) {
        //List<String> lowerCaseKeywords = new ArrayList<>();
        for(int size = 0; size < keywords.size(); size++) {
            keywords.set(size, keywords.get(size).toLowerCase());
        }
        return keywords;
    }
}
