/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Repositories;

import Business.Interfaces.Repositories.IBaseRepository;
import Database.Configuration.DbContext;
import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Repositório para operações relacionadas aos procedimentos realizados no banco
 * de dados. Implementa a interface IBaseRepository com o tipo
 * ProceduresPerformed.
 *
 * @author Alarcon Vinicius
 */
public class ProceduresPerformedRepository implements IBaseRepository<ProceduresPerformed> {

    /**
     * Obtém um procedimento realizado pelo seu ID.
     *
     * @param id O ID do procedimento realizado a ser encontrado.
     * @return O procedimento realizado encontrado, ou null se não encontrado.
     */
    @Override
    public ProceduresPerformed getById(int id) {
        ProceduresPerformed procedurePerformed = null;
        try {
            Connection connection = DbContext.getConnection();
            String query = "SELECT pp.id, pp.date, pp.amount_received, pp.procedure_id, ap.name, ap.description, ap.price "
                    + "FROM tbl_procedures_performed pp "
                    + "JOIN tbl_aesthetic_procedures ap ON pp.procedure_id = ap.id "
                    + "WHERE pp.id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String date = resultSet.getString("date");
                Double amountReceived = resultSet.getDouble("amount_received");
                int procedureId = resultSet.getInt("procedure_id");
                String procedureName = resultSet.getString("name");
                String procedureDescription = resultSet.getString("description");
                double procedurePrice = resultSet.getDouble("price");

                // Mapear os dados para a classe ProceduresPerformed
                procedurePerformed = new ProceduresPerformed(id, date, procedureId, amountReceived, new AestheticProcedures(procedureId, procedureName, procedureDescription, procedurePrice));
            }
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'getById':" + e.getMessage());
        }
        return procedurePerformed;
    }

    /**
     * Obtém uma lista de todos os procedimentos realizados no banco de dados.
     *
     * @return Uma lista de procedimentos realizados.
     */
    @Override
    public List<ProceduresPerformed> getAll() {
        List<ProceduresPerformed> proceduresPerformed = new ArrayList<>();
        try {
            Connection connection = DbContext.getConnection();
            String query = "SELECT pp.id, pp.date, pp.amount_received, pp.procedure_id, ap.name, ap.description, ap.price "
                    + "FROM tbl_procedures_performed pp "
                    + "JOIN tbl_aesthetic_procedures ap ON pp.procedure_id = ap.id";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("date");
                Double amountReceived = resultSet.getDouble("amount_received");
                int procedureId = resultSet.getInt("procedure_id");
                String procedureName = resultSet.getString("name");
                String procedureDescription = resultSet.getString("description");
                double procedurePrice = resultSet.getDouble("price");

                // Mapear os dados para a classe ProceduresPerformed
                ProceduresPerformed procedurePerformed = new ProceduresPerformed(id, date, procedureId, amountReceived, new AestheticProcedures(procedureId, procedureName, procedureDescription, procedurePrice));
                proceduresPerformed.add(procedurePerformed);
            }
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'getAll()':" + e.getMessage());
        }
        return proceduresPerformed;
    }

    /**
     * Cria um novo procedimento realizado no banco de dados.
     *
     * @param entity O procedimento realizado a ser criado.
     */
    @Override
    public void create(ProceduresPerformed entity) {
        // Verifica se o procedure_id existe antes de criar o registro
        if (isValidProcedureId(entity.getProcedure_id())) {
            try {
                Connection connection = DbContext.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO tbl_procedures_performed (date, procedure_id, amount_received) VALUES (?, ?, ?)");
                statement.setString(1, entity.getDate());
                statement.setInt(2, entity.getProcedure_id());
                statement.setDouble(3, entity.getAmountReceived());
                statement.executeUpdate();
                DbContext.closeConnection(connection);
            } catch (SQLException e) {
                System.out.println("Falha ao executar o método 'create':" + e.getMessage());
            }
        } else {
            System.out.println("Procedure_id não existe. A operação de criação foi cancelada.");
        }
    }

    /**
     * Atualiza um procedimento realizado existente no banco de dados.
     *
     * @param entity O procedimento realizado a ser atualizado.
     */
    @Override
    public void update(ProceduresPerformed entity) {
        // Verifica se o procedure_id existe antes de atualizar o registro
        if (isValidProcedureId(entity.getProcedure_id())) {
            try {
                Connection connection = DbContext.getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE tbl_procedures_performed SET date = ?, procedure_id = ?, amount_received = ? WHERE id = ?");
                statement.setString(1, entity.getDate());
                statement.setInt(2, entity.getProcedure_id());
                statement.setDouble(3, entity.getAmountReceived());
                statement.setInt(4, entity.getId());
                statement.executeUpdate();
                DbContext.closeConnection(connection);
            } catch (SQLException e) {
                System.out.println("Falha ao executar o método 'update':" + e.getMessage());
            }
        } else {
            System.out.println("Procedure_id não existe. A operação de atualização foi cancelada.");
        }
    }

    /**
     * Exclui um procedimento realizado pelo seu ID.
     *
     * @param id O ID do procedimento realizado a ser excluído.
     */
    @Override
    public void delete(int id) {
        try {
            Connection connection = DbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tbl_procedures_performed WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            DbContext.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Falha ao executar o método 'delete':" + e.getMessage());
        }
    }

    /**
     * Verifica se um procedure_id é válido, ou seja, se corresponde a um
     * procedimento estético existente.
     *
     * @param procedureId O ID do procedimento estético a ser verificado.
     * @return true se o ID é válido, false caso contrário.
     */
    private boolean isValidProcedureId(int procedureId) {
        AestheticProceduresRepository _repository = new AestheticProceduresRepository();
        try {
            AestheticProcedures procedure = _repository.getById(procedureId);
            return procedure != null;
        } catch (Exception e) {
            System.out.println("Falha ao verificar o procedure_id: " + e.getMessage());
            return false;
        }
    }
}
