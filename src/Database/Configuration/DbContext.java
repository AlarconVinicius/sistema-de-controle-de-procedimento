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
}
