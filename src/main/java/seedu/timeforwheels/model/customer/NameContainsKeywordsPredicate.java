package seedu.timeforwheels.model.customer;

import java.util.List;
import java.util.function.Predicate;

import seedu.timeforwheels.commons.util.StringUtil;

/**
 * Tests that a {@code Customer}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<Customer> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Customer customer) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(customer.getName().fullName, keyword)
                || StringUtil.containsWordIgnoreCase(customer.getAddress().value, keyword)
                || StringUtil.containsWordIgnoreCase(customer.getPhone().value, keyword)
                || StringUtil.containsWordIgnoreCase(customer.getDate().value, keyword)
                        || StringUtil.containsWordIgnoreCase(customer.getDone().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }
}
