package model.comparator;

import model.User;

import java.util.Comparator;

public class UserNameComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.getFirstName().compareToIgnoreCase(u2.getFirstName());
    }
}
