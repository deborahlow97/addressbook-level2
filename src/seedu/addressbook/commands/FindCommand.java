package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-Insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Set<String> keywords;

    public FindCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        Set<String> lowerCaseKeyword = keywordToLowerCaseSet(keywords);
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(lowerCaseKeyword);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * This method converts the set of keywords to a set of lower case strings and returns it.
     * @return set of lower case string
     */
    private Set<String> keywordToLowerCaseSet(Set<String> keywords) {
        Set<String> lowerCaseKeywords = new HashSet<>();
        for(String key : keywords) {
            lowerCaseKeywords.add(key.toLowerCase());
        }
        return lowerCaseKeywords;
    }

    private List<String> keywordToLowerCaseList(List<String> keywords) {
        //List<String> lowerCaseKeywords = new ArrayList<>();
        for(int size = 0; size < keywords.size(); size++) {
            keywords.set(size, keywords.get(size).toLowerCase());
        }
        return keywords;
    }
    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(keywordToLowerCaseList(person.getName().getWordsInName()));
            if (!Collections.disjoint(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }



}
