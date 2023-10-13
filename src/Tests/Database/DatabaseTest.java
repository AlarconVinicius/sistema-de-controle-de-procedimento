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
package Tests.Database;

import Database.Configuration.DbContext;
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import Database.Repositories.UserRepository;

/**
 * Classe de teste para configuração do banco de dados e operações de acesso a
 * dados. Esta classe cria tabelas no banco de dados, insere dados de exemplo e
 * realiza operações de leitura nos repositórios relacionados a usuários,
 * procedimentos estéticos e procedimentos realizados.
 *
 * @author Alarcon Vinicius
 */
public class DatabaseTest {

    /**
     * Método principal que inicia a execução do teste de configuração do banco
     * de dados e acesso a dados. Este método cria tabelas no banco de dados,
     * insere dados de exemplo e realiza operações de leitura nos repositórios
     * relacionados a usuários, procedimentos estéticos e procedimentos
     * realizados.
     *
     * @param args Os argumentos da linha de comando (não são usados neste
     * contexto).
     */
    public static void main(String[] args) {
        DbContext.getConnection();
        DbContext.createUserTableAndDefaultUser();
        DbContext.createAestheticProceduresTable();
        DbContext.createProceduresPerformedTable();

        AestheticProceduresRepository _aesProduceresRepository = new AestheticProceduresRepository();
        ProceduresPerformedRepository _procePerformedRepository = new ProceduresPerformedRepository();
        UserRepository _userRepository = new UserRepository();

        _aesProduceresRepository.create(new AestheticProcedure(1, "Servico 1", 1000.00));
        _aesProduceresRepository.create(new AestheticProcedure(2, "Servico 2", 500.00));
        _aesProduceresRepository.create(new AestheticProcedure(3, "Servico 3", 300.00));

        _procePerformedRepository.create(new ProcedurePerformed("09/01/2023", 1, 1000));
        _procePerformedRepository.create(new ProcedurePerformed("10/01/2023", 2, 500));
        _procePerformedRepository.create(new ProcedurePerformed("11/01/2023", 3, 300));

        var user = _userRepository.getAll();

        var procedures = _aesProduceresRepository.getAll();
        var procedure = _aesProduceresRepository.getById(1);

        var procesPerformed = _procePerformedRepository.getAll();
        var procePerformed = _procePerformedRepository.getById(1);

        System.out.println("Users: " + user.size());
        System.out.println("---------------------------------");
        System.out.println("User: " + user);
        System.out.println("---------------------------------");
        System.out.println("Procedures: " + procedures.size());
        System.out.println("---------------------------------");
        System.out.println("Procedures: " + procedures);
        System.out.println("---------------------------------");
        System.out.println("Procedures: " + procedure);
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println("Procedures Performed: " + procesPerformed.size());
        System.out.println("---------------------------------");
        System.out.println("Procedures Performed: " + procesPerformed);
        System.out.println("---------------------------------");
        System.out.println("Procedure Performed: " + procePerformed);
        System.out.println("---------------------------------");
    }
}
