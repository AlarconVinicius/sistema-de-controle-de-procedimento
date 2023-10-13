/*
 * The MIT License
 *
 * Copyright 2023 Alarcon Vinicius.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * ---
 * 
 * Este projeto é disponibilizado sob a licença MIT.
 * 
 * 🔗 LinkedIn: https://www.linkedin.com/in/vin%C3%ADcius-alarcon-52a8a820a/
 * 🔗 GitHub: https://github.com/AlarconVinicius
 * 💼 Website: http://alarconvinicius.com.br/
 */
package Database.Repositories;

import Business.Interfaces.Repositories.IBaseRepository;
import Database.Configuration.DbContext;
import Database.Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório para operações relacionadas aos usuários no banco de dados.
 * Implementa a interface IBaseRepository com o tipo User.
 *
 * @author Alarcon Vinicius
 */
public class UserRepository implements IBaseRepository<User> {

    /**
     * Obtém um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser encontrado.
     * @return O usuário encontrado, ou null se não encontrado.
     */
    @Override
    public User getById(int id) {
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
            System.err.println("Falha ao executar o método 'getById': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
        return user;
    }

    /**
     * Obtém um usuário pelo seu email.
     *
     * @param email O email do usuário a ser encontrado.
     * @return O usuário encontrado, ou null se não encontrado.
     */
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

    /**
     * Obtém uma lista de todos os usuários no banco de dados.
     *
     * @return Uma lista de usuários.
     */
    @Override
    public List<User> getAll() {
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
            System.err.println("Falha ao executar o método 'getAll': " + e.getMessage());
        } finally {
            DbContext.closeConnection(connection);
        }
        return users;
    }

    /**
     * Cria um novo usuário no banco de dados.
     *
     * @param user O usuário a ser criado.
     */
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

    /**
     * Atualiza um usuário existente no banco de dados.
     *
     * @param user O usuário a ser atualizado.
     */
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

    /**
     * Exclui um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser excluído.
     */
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
