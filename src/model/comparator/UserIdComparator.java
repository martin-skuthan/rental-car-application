package model.comparator;

import model.User;

import java.util.Comparator;

public class UserIdComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.getUserId().compareToIgnoreCase(u2.getUserId());
    }
}
