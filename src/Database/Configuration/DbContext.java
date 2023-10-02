/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Database.Configuration;

import java.sql.*;

/**
 *
 * @author Alarcon Vinicius
 */
public class DbContext {

    public DbContext() {
    }

    public static Connection getConnection(){
        Connection connection;
        String url = "jdbc:sqlite:src\\Database\\sistema.db";
        try
        {
            connection = DriverManager.getConnection(url);
            System.out.println("Conexão feita");
        }
        catch(SQLException e)
        {
            System.err.println("Falha na conexão: " + e.getMessage());
            connection = null;
        }
        return connection;
    }
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Falha ao fechar a conexão: " + e.getMessage());
            }
        }
    }
    
    public static void createAestheticProceduresTable() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS tbl_aesthetic_procedures (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT," +
                                "description TEXT," +
                                "price REAL" +
                                ");"
                );
                System.out.println("Tabela 'aesthetic_procedures' criada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Falha ao criar tabela: " + e.getMessage());
            } finally {
                closeConnection(connection);
            }
        }
    }
    public static void createProceduresPerformedTable() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS tbl_procedures_performed (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "date TEXT," +
                                "procedure_id INTEGER," +
                                "amount_received REAL" +
                                ");"
                );
                System.out.println("Tabela 'tbl_procedures_performed' criada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Falha ao criar tabela: " + e.getMessage());
            } finally {
                closeConnection(connection);
            }
        }
    }
    public static void createUserTableAndDefaultUser() {
        Connection connection = null;
        try {
            connection = getConnection();
            if (connection != null) {
                String createUserTableSQL = "CREATE TABLE IF NOT EXISTS user ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "name TEXT,"
                        + "email TEXT UNIQUE,"
                        + "password TEXT"
                        + ");";
                PreparedStatement createUserTableStatement = connection.prepareStatement(createUserTableSQL);
                createUserTableStatement.execute();
                
                String checkUserExistsSQL = "SELECT id FROM user WHERE id = ?";
                PreparedStatement checkUserExistsStatement = connection.prepareStatement(checkUserExistsSQL);
                checkUserExistsStatement.setInt(1, 1);
                ResultSet resultSet = checkUserExistsStatement.executeQuery();

                if (!resultSet.next()) {
                    String insertDefaultUserSQL = "INSERT INTO user (id, name, email, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertDefaultUserStatement = connection.prepareStatement(insertDefaultUserSQL);
                    insertDefaultUserStatement.setInt(1, 1);
                    insertDefaultUserStatement.setString(2, "Usuario Admin");
                    insertDefaultUserStatement.setString(3, "admin@email.com");
                    insertDefaultUserStatement.setString(4, "Admin@123");
                    insertDefaultUserStatement.execute();
                }

//                System.out.println("Tabela 'user' criada com sucesso e usuário padrão inserido.");
            }
        } catch (SQLException e) {
            System.err.println("Falha ao criar a tabela 'user' e inserir o usuário padrão: " + e.getMessage());
        } finally {
            closeConnection(connection);
        }
    }
}
