/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Database.Repositories;

/**
 *
 * @author Alarcon Vinicius
 */

import Business.Interfaces.Repositories.IBaseRepository;
import Database.Configuration.DbContext;
import Database.Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IBaseRepository<User>{

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection = null;
        try {
            connection = DbContext.getConnection();
            if (connection != null) {
                String query = "SELECT * FROM user WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Falha ao executar o método 'findById': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
        return user;
    }
    public User getByEmail(String email) {
        User user = null;
        Connection connection = null;
        try {
            connection = DbContext.getConnection();
            if (connection != null) {
                String query = "SELECT * FROM user WHERE email = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Falha ao executar o método 'getByEmail': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DbContext.getConnection();
            if (connection != null) {
                String query = "SELECT * FROM user";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("Falha ao executar o método 'findAll': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
        return users;
    }

    @Override
    public void create(User user) {
        Connection connection = null;
        try {
            connection = DbContext.getConnection();
            if (connection != null) {
                String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Falha ao executar o método 'create': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
    }

    @Override
    public void update(User user) {
        Connection connection = null;
        try {
            connection = DbContext.getConnection();
            if (connection != null) {
                String query = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setInt(4, user.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Falha ao executar o método 'update': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        try {
            connection = DbContext.getConnection();
            if (connection != null) {
                String query = "DELETE FROM user WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Falha ao executar o método 'delete': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
    }
}

