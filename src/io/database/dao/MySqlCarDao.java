package io.database.dao;

import exceptions.DbOperationException;
import io.database.ConnectionProvider;
import model.Car;
import model.LightCommercialCar;
import model.PassengerCar;
import model.User;
import model.enums.Transmission;
import model.enums.TypeOfDrive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MySqlCarDao implements CarDao {
    private static final String CREATE = "INSERT INTO cars(RegistrationNumber,Brand,Model,Seats,AirConditioning,\n" +
                                         "Transmission,NumberOfDoors,TypeOfDrive,TrunkCapacity,Payload,LoadVolume,\n" +
                                         "LoadHeight,LoadWidth,LoadLength,TypeOfCar,UserPesel)\n" +
                                         "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String READ = "SELECT * FROM cars where RegistrationNumber=?;";
    private static final String READ_ALL_ROWS = "SELECT * FROM cars;";
    private static final String UPDATE = "UPDATE cars SET RegistrationNumber=?,Brand=?,Model=?,Seats=?,AirConditioning=?," +
                                         "Transmission=?,NumberOfDoors=?,TypeOfDrive=?,TrunkCapacity=?,Payload=?,LoadVolume=?," +
                                         "LoadHeight=?,LoadWidth=?,LoadLength=?,TypeOfCar=?,UserPesel=? WHERE RegistrationNumber=?;";
    private static final String DELETE = "DELETE FROM cars WHERE RegistrationNumber=?;";


    @Override
    public void create(Car car) {
    try(Connection connection = ConnectionProvider.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
    ){
        if (car.getTypeOfCar().equals(PassengerCar.TYPE_OF_CAR)) {
            createPassangerCar(preparedStatement, car);
        }else if (car.getTypeOfCar().equals(LightCommercialCar.TYPE_OF_CAR)) {
            createLightCommercialCar(preparedStatement, car);
        }
        preparedStatement.executeUpdate();
    }catch (SQLException | ClassNotFoundException ex) {
        throw new DbOperationException(ex.getMessage());
    }
}

    @Override
    public Car read(String registrationNumber) {
        Car car = null;
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ);
                ){
            preparedStatement.setString(1, registrationNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String typeOfCar = resultSet.getString("TypeOfCar");
                if (typeOfCar.equals(PassengerCar.TYPE_OF_CAR)) {
                    car = readPassengerCar(resultSet);
                }else if (typeOfCar.equals(LightCommercialCar.TYPE_OF_CAR)) {
                    car = readLightCommercialCar(resultSet);
                }
            }
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
        return car;
    }

    @Override
    public Collection<Car> readAll() {
        ArrayList<Car> cars = new ArrayList<>();
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_ROWS);
                ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeOfCar = resultSet.getString("TypeOfCar");
                Car car = null;
                if (typeOfCar.equals(PassengerCar.TYPE_OF_CAR)) {
                    car = readPassengerCar(resultSet);
                }else if (typeOfCar.equals(LightCommercialCar.TYPE_OF_CAR)) {
                    car = readLightCommercialCar(resultSet);
                }
                cars.add(car);
            }
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }

        return cars;
    }

    @Override
    public void update(Car car) {
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
                ){
            preparedStatement.setString(17, car.getRegistrationNumber());
            if (car.getTypeOfCar().equals(PassengerCar.TYPE_OF_CAR)) {
                createPassangerCar(preparedStatement, car);
            }else if (car.getTypeOfCar().equals(LightCommercialCar.TYPE_OF_CAR)) {
                createLightCommercialCar(preparedStatement, car);
            }
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
    }

    @Override
    public void delete(String registrationNumber) {
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
                ) {
            preparedStatement.setString(1,registrationNumber);
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
    }

    private void createPassangerCar(PreparedStatement preparedStatement, Car car) throws SQLException {
        preparedStatement.setString(1, car.getRegistrationNumber());
        preparedStatement.setString(2, car.getBrand());
        preparedStatement.setString(3, car.getModel());
        preparedStatement.setInt(4, car.getSeats());
        preparedStatement.setBoolean(5, car.isAirConditioning());
        preparedStatement.setString(6, car.getTransmission().toString());
        preparedStatement.setInt(7,((PassengerCar)car).getNumberOfDoors());
        preparedStatement.setString(8, ((PassengerCar)car).getTypeOfDrive().toString());
        preparedStatement.setInt(9,((PassengerCar)car).getTrunkCapacity());
        preparedStatement.setString(10, null);
        preparedStatement.setString(11, null);
        preparedStatement.setString(12, null);
        preparedStatement.setString(13, null);
        preparedStatement.setString(14, null);
        preparedStatement.setString(15, car.getTypeOfCar());
        if (car.getUser() != null) {
            preparedStatement.setString(16, car.getUser().getPesel());
        }else {
            preparedStatement.setString(16, null);
        }

    }

    private void createLightCommercialCar(PreparedStatement preparedStatement, Car car) throws SQLException {
        preparedStatement.setString(1, car.getRegistrationNumber());
        preparedStatement.setString(2, car.getBrand());
        preparedStatement.setString(3, car.getModel());
        preparedStatement.setInt(4, car.getSeats());
        preparedStatement.setBoolean(5, car.isAirConditioning());
        preparedStatement.setString(6, car.getTransmission().toString());
        preparedStatement.setString(7, null);
        preparedStatement.setString(8, null);
        preparedStatement.setString(9, null);
        preparedStatement.setDouble(10,((LightCommercialCar)car).getPayload());
        preparedStatement.setDouble(11,((LightCommercialCar)car).getLoadVolume());
        preparedStatement.setDouble(12,((LightCommercialCar)car).getLoadHeight());
        preparedStatement.setDouble(13,((LightCommercialCar)car).getLoadWidth());
        preparedStatement.setDouble(14,((LightCommercialCar)car).getLoadWidth());
        preparedStatement.setString(15, car.getTypeOfCar());
        if (car.getUser() != null) {
            preparedStatement.setString(16, car.getUser().getPesel());
        }else {
            preparedStatement.setString(16, null);
        }
    }

    private PassengerCar readPassengerCar(ResultSet resultSet) throws SQLException {
        String registrationNumber = resultSet.getString("RegistrationNumber");
        String brand = resultSet.getString("Brand");
        String model = resultSet.getString("Model");
        int seats = resultSet.getInt("Seats");
        boolean airConditioning = resultSet.getBoolean("AirConditioning");
        String transmissionDesc = resultSet.getString("Transmission");
        Transmission transmission = Transmission.getFromDescription(transmissionDesc);
        String userPesel = resultSet.getString("UserPesel");
        User user = null;
        if (userPesel != null) {
            MySqlUserDao mySqlUserDao = new MySqlUserDao();
            user = mySqlUserDao.read(userPesel);
        }
        int numberOfDoors = resultSet.getInt("NumberOfDoors");
        String typeOfDriveDesc = resultSet.getString("TypeOfDrive");
        TypeOfDrive typeOfDrive = TypeOfDrive.getFromDescription(typeOfDriveDesc);
        int trunkCapacity = resultSet.getInt("TrunkCapacity");

        return new PassengerCar(registrationNumber, brand, model, seats, airConditioning, transmission, user,
                                numberOfDoors, typeOfDrive,trunkCapacity);
    }

    private LightCommercialCar readLightCommercialCar(ResultSet resultSet) throws SQLException {
        String registrationNumber = resultSet.getString("RegistrationNumber");
        String brand = resultSet.getString("Brand");
        String model = resultSet.getString("Model");
        int seats = resultSet.getInt("Seats");
        boolean airConditioning = resultSet.getBoolean("AirConditioning");
        String transmissionDesc = resultSet.getString("Transmission");
        Transmission transmission = Transmission.getFromDescription(transmissionDesc);
        String userPesel = resultSet.getString("UserPesel");
        User user = null;
        if (userPesel != null) {
            MySqlUserDao mySqlUserDao = new MySqlUserDao();
            user = mySqlUserDao.read(userPesel);
        }
        double payload = resultSet.getDouble("Payload");
        double loadVolume = resultSet.getDouble("LoadVolume");
        double loadHeight = resultSet.getDouble("LoadHeight");
        double loadWidth = resultSet.getDouble("LoadWidth");
        double loadLegth = resultSet.getDouble("LoadLength");

        return new LightCommercialCar(registrationNumber, brand, model, seats, airConditioning, transmission, user,
                                      payload, loadVolume, loadHeight, loadWidth, loadLegth);
    }
}
