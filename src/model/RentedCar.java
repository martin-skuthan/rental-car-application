package model;

import java.time.LocalDate;

public class RentedCar {
    private String carId;
    private String userId;
    private LocalDate dateOfRent;
    private LocalDate dateOfReturn;

    public RentedCar(String carId, String userId, LocalDate dateOfRent, LocalDate dateOfReturn) {
        this.carId = carId;
        this.userId = userId;
        this.dateOfRent = dateOfRent;
        this.dateOfReturn = dateOfReturn;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
