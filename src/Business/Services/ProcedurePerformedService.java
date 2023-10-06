/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Services;

import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedService {

    private final ProceduresPerformedRepository _repository;

    public ProcedurePerformedService() {
        _repository = new ProceduresPerformedRepository();
    }

    public List<ProceduresPerformed> getAll(){
        List<ProceduresPerformed> procedurePerformedDb = _repository.getAll();
        if(procedurePerformedDb == null){
            return null;
        }
        return procedurePerformedDb;
    }
}
