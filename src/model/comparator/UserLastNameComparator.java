package model.comparator;

import model.User;

import java.util.Comparator;

public class UserLastNameComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.getLastName().compareToIgnoreCase(u2.getLastName());
    }
}
