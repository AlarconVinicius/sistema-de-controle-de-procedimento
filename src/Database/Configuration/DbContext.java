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
package Database.Configuration;

import java.sql.*;

/**
 * Classe que fornece configurações e métodos de acesso ao banco de dados
 * SQLite. Esta classe inclui métodos para obter uma conexão com o banco de
 * dados, fechar a conexão e criar as tabelas necessárias.
 *
 * @author Alarcon Vinicius
 */
public class DbContext {

    /**
     * Construtor padrão da classe DbContext.
     */
    public DbContext() {
    }

    /**
     * Obtém uma conexão com o banco de dados SQLite.
     *
     * @return A conexão com o banco de dados.
     */
    public static Connection getConnection() {
        Connection connection;
        String url = "jdbc:sqlite:sistema.db";
        try {
            connection = DriverManager.getConnection(url);
//            System.out.println("Conexão feita");
        } catch (SQLException e) {
            System.err.println("Falha na conexão: " + e.getMessage());
            connection = null;
        }
        return connection;
    }

    /**
     * Fecha uma conexão com o banco de dados.
     *
     * @param connection A conexão a ser fechada.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
//                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Falha ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    /**
     * Cria a tabela 'tbl_aesthetic_procedures' no banco de dados, se ainda não
     * existir.
     */
    public static void createAestheticProceduresTable() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS tbl_aesthetic_procedures ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "name TEXT,"
                        + "price REAL"
                        + ");"
                );
//                System.out.println("Tabela 'aesthetic_procedures' criada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Falha ao criar tabela: " + e.getMessage());
            } finally {
                closeConnection(connection);
            }
        }
    }

    /**
     * Cria a tabela 'tbl_procedures_performed' no banco de dados, se ainda não
     * existir.
     */
    public static void createProceduresPerformedTable() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS tbl_procedures_performed ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "date TEXT,"
                        + "procedure_id INTEGER,"
                        + "amount_received REAL"
                        + ");"
                );
//                System.out.println("Tabela 'tbl_procedures_performed' criada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Falha ao criar tabela: " + e.getMessage());
            } finally {
                closeConnection(connection);
            }
        }
    }

    /**
     * Cria a tabela 'user' no banco de dados e insere o usuário padrão, se
     * ainda não existir.
     */
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
