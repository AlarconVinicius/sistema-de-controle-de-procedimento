/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tests.Database;

import Database.Configuration.DbContext;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import Database.Repositories.UserRepository;


/**
 * Classe de teste para verificar a conexão e operações no banco de dados.
 * Esta classe cria tabelas no banco de dados, insere dados de exemplo e realiza consultas.
 * 
 * @author Alarcon Vinicius
 */
public class TestConnection {

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
        
//        _aesProduceresRepository.create(new AestheticProcedures("Servico 1", "Desc", 20.00));
//        _aesProduceresRepository.create(new AestheticProcedures("Servico 2", "Desc", 50.00));
//        _aesProduceresRepository.create(new AestheticProcedures("Servico 3", "Desc", 30.00));
        
//        _procePerformedRepository.create(new ProceduresPerformed("09/01/2023", 1, 200));
//        _procePerformedRepository.create(new ProceduresPerformed("10/01/2023", 2, 200));
//        _procePerformedRepository.create(new ProceduresPerformed("11/01/2023", 3, 200));
        
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
