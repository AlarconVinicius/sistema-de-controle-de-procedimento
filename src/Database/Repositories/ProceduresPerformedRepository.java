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
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
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
public class ProceduresPerformedRepository implements IBaseRepository<ProcedurePerformed> {

    /**
     * Obtém um procedimento realizado pelo seu ID.
     *
     * @param id O ID do procedimento realizado a ser encontrado.
     * @return O procedimento realizado encontrado, ou null se não encontrado.
     */
    @Override
    public ProcedurePerformed getById(int id) {
        ProcedurePerformed procedurePerformed = null;
        try {
            Connection connection = DbContext.getConnection();
            String query = "SELECT pp.id, pp.date, pp.amount_received, pp.procedure_id, ap.name, ap.price "
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
                double procedurePrice = resultSet.getDouble("price");

                // Mapear os dados para a classe ProceduresPerformed
                procedurePerformed = new ProcedurePerformed(id, date, procedureId, amountReceived, new AestheticProcedure(procedureId, procedureName, procedurePrice));
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
    public List<ProcedurePerformed> getAll() {
        List<ProcedurePerformed> proceduresPerformed = new ArrayList<>();
        try {
            Connection connection = DbContext.getConnection();
            String query = "SELECT pp.id, pp.date, pp.amount_received, pp.procedure_id, ap.name, ap.price "
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
                double procedurePrice = resultSet.getDouble("price");

                // Mapear os dados para a classe ProceduresPerformed
                ProcedurePerformed procedurePerformed = new ProcedurePerformed(id, date, procedureId, amountReceived, new AestheticProcedure(procedureId, procedureName, procedurePrice));
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
    public void create(ProcedurePerformed entity) {
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
    public void update(ProcedurePerformed entity) {
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
            AestheticProcedure procedure = _repository.getById(procedureId);
            return procedure != null;
        } catch (Exception e) {
            System.out.println("Falha ao verificar o procedure_id: " + e.getMessage());
            return false;
        }
    }
}
