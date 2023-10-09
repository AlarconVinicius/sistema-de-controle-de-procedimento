/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tests.Database;

import Database.Configuration.DbContext;
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import Database.Repositories.UserRepository;


/**
 * Classe de teste para verificar a conexão e operações no banco de dados.
 * Esta classe cria tabelas no banco de dados, insere dados de exemplo e realiza consultas.
 * 
 * @author Alarcon Vinicius
 */
public class DatabaseTest {

    /**
     * Método principal da classe TestConnection.
     *
     * @param args Parâmetro não utilizado neste teste.
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
