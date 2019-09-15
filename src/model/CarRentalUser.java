package model;

public class CarRentalUser extends User {

    public CarRentalUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    public CarRentalUser(String userId, String firstName, String lastName, String pesel) {
        super(userId, firstName, lastName, pesel);
    }

}
