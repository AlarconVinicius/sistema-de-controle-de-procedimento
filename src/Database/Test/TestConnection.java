/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Database.Test;

import Database.Configuration.DbContext;
import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;


/**
 *
 * @author Alarcon Vinicius
 */
public class TestConnection {
    public static void main(String[] args) {
        DbContext.getConnection();
        DbContext.createAestheticProceduresTable();
        DbContext.createProceduresPerformedTable();
        
        AestheticProceduresRepository _aesProduceresRepository = new AestheticProceduresRepository();
        ProceduresPerformedRepository _procePerformedRepository = new ProceduresPerformedRepository();
        
//        _aesProduceresRepository.create(new AestheticProcedures("Servico 1", "Desc", 20.00));
//        _aesProduceresRepository.create(new AestheticProcedures("Servico 2", "Desc", 50.00));
//        _aesProduceresRepository.create(new AestheticProcedures("Servico 3", "Desc", 30.00));
        
//        _procePerformedRepository.create(new ProceduresPerformed("09/01/2023", 1, 200));
//        _procePerformedRepository.create(new ProceduresPerformed("10/01/2023", 2, 200));
//        _procePerformedRepository.create(new ProceduresPerformed("11/01/2023", 3, 200));
        
        var procedures = _aesProduceresRepository.findAll();
        var procedure = _aesProduceresRepository.findById(1); 
        
        var procesPerformed = _procePerformedRepository.findAll();
        var procePerformed = _procePerformedRepository.findById(1);
        
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
