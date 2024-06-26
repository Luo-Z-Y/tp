package seedu.voyagers.classes;

import seedu.voyagers.utils.Currency;

public class Profile {
    private String name;
    private Currency currency;

    public Profile(String name, Currency currency) {
        this.name = name;
        this.currency = currency;
    }

    public Profile(String name) {
        this.name = name;
        this.currency = null;
    }

    public boolean equals(Profile p) {
        if (this.name.equals(p.name)) {
            return true;
        } else {
            return false;
        }
    }

    //TODO
    public Bill billsOwed() {
        return null;
    }

    //TODO
    public Bill billsPaid() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
