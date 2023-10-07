/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Repositories;

import Business.Interfaces.Repositories.IBaseRepository;
import Database.Configuration.DbContext;
import Database.Models.AestheticProcedure;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Repositório para operações relacionadas aos procedimentos estéticos no banco
 * de dados. Implementa a interface IBaseRepository com o tipo
 * AestheticProcedures.
 *
 * @author Alarcon Vinicius
 */
public class AestheticProceduresRepository implements IBaseRepository<AestheticProcedure> {

    /**
     * Obtém um procedimento estético pelo seu ID.
     *
     * @param id O ID do procedimento estético a ser encontrado.
     * @return O procedimento estético encontrado, ou null se não encontrado.
     */
    @Override
    public AestheticProcedure getById(int id) {
        AestheticProcedure aestheticProcedure = null;
        try {
            Connection connection = DbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_aesthetic_procedures WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                aestheticProcedure = new AestheticProcedure();
                aestheticProcedure.setId(resultSet.getInt("id"));
                aestheticProcedure.setName(resultSet.getString("name"));
                aestheticProcedure.setPrice(resultSet.getDouble("price"));
            }
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'getById':" + e.getMessage());
        }
        return aestheticProcedure;
    }

    /**
     * Obtém uma lista de todos os procedimentos estéticos no banco de dados.
     *
     * @return Uma lista de procedimentos estéticos.
     */
    @Override
    public List<AestheticProcedure> getAll() {
        List<AestheticProcedure> procedures = new ArrayList<>();
        try {
            Connection connection = DbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_aesthetic_procedures");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AestheticProcedure aestheticProcedure = new AestheticProcedure();
                aestheticProcedure.setId(resultSet.getInt("id"));
                aestheticProcedure.setName(resultSet.getString("name"));
                aestheticProcedure.setPrice(resultSet.getDouble("price"));
                procedures.add(aestheticProcedure);
            }
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'getAll()':" + e.getMessage());
            procedures = null;
        }
        return procedures;
    }

    /**
     * Cria um novo procedimento estético no banco de dados.
     *
     * @param entity O procedimento estético a ser criado.
     */
    @Override
    public void create(AestheticProcedure entity) {
        try {
            Connection connection = DbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tbl_aesthetic_procedures (name, price) VALUES (?, ?)");
            statement.setString(1, entity.getName());
            statement.setDouble(2, entity.getPrice());
            statement.executeUpdate();
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'create':" + e.getMessage());
        }
    }

    /**
     * Atualiza um procedimento estético existente no banco de dados.
     *
     * @param entity O procedimento estético a ser atualizado.
     */
    @Override
    public void update(AestheticProcedure entity) {
        try {
            Connection connection = DbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE tbl_aesthetic_procedures SET name = ?, price = ? WHERE id = ?");
            statement.setString(1, entity.getName());
            statement.setDouble(2, entity.getPrice());
            statement.setInt(3, entity.getId());
            statement.executeUpdate();
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'update':" + e.getMessage());
        }
    }

    /**
     * Exclui um procedimento estético pelo seu ID.
     *
     * @param id O ID do procedimento estético a ser excluído.
     */
    @Override
    public void delete(int id) {
        try {
            Connection connection = DbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tbl_aesthetic_procedures WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'delete':" + e.getMessage());
        }
    }

}
