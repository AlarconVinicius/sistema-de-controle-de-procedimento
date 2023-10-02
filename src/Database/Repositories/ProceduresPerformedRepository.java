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
 *
 * @author Alarcon Vinicius
 */
public class ProceduresPerformedRepository implements IBaseRepository<ProceduresPerformed> {

    @Override
    public ProceduresPerformed findById(int id) {
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
            System.out.println("Falha ao executar o método 'findById':" + e.getMessage());
        }
        return procedurePerformed;
    }

    @Override
    public List<ProceduresPerformed> findAll() {
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
            System.out.println("Falha ao executar o método 'findAll':" + e.getMessage());
        }
        return proceduresPerformed;
    }

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

    private boolean isValidProcedureId(int procedureId) {
        AestheticProceduresRepository _repository = new AestheticProceduresRepository();
        try {
            AestheticProcedures procedure = _repository.findById(procedureId);
            return procedure != null;
        } catch (Exception e) {
            System.out.println("Falha ao verificar o procedure_id: " + e.getMessage());
            return false;
        }
    }
}
