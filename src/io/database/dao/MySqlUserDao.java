package io.database.dao;

import exceptions.DbOperationException;
import io.database.ConnectionProvider;
import model.CarRentalUser;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MySqlUserDao implements UserDao {
    private static final String CREATE = "INSERT INTO users(FirstName,LastName,Pesel) VALUES(?,?,?);";
    private static final String READ = "SELECT * FROM users WHERE pesel=?;";
    private static final String READ_ALL_ROWS = "SELECT * FROM users;";
    private static final String UPDATE = "UPDATE users SET FirstName=?, LastName=?,Pesel=? WHERE Pesel=?;";
    private static final String DELETE = "DELETE FROM users WHERE Pesel=?";

    @Override
    public void create(User user) {
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
                ){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPesel());
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
    }

    @Override
    public User read(String pesel) {
        User user = null;
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ);
        ){
            preparedStatement.setString(1, pesel);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String userPesel = resultSet.getString("Pesel");
                user = new CarRentalUser(firstName, lastName, userPesel);
            }
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
        return user;
    }

    @Override
    public Collection<User> readAll() {
        ArrayList<User> users = new ArrayList<>();
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_ROWS);
                ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String pesel = resultSet.getString("Pesel");
                users.add(new CarRentalUser(firstName, lastName, pesel));
            }
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }

        return users;
    }

    @Override
    public void update(User user) {
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ){
            preparedStatement.setString(1, user.getPesel());
            preparedStatement.setString(2, user.getPesel());
            preparedStatement.setString(3, user.getPesel());
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
    }

    @Override
    public void delete(String pesel) {
        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ){
            preparedStatement.setString(1, pesel);
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException ex) {
            throw new DbOperationException(ex.getMessage());
        }
    }

}
