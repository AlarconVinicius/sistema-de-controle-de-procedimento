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
