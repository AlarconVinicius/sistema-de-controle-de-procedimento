/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Services;

import Database.Models.AestheticProcedures;
import Database.Repositories.AestheticProceduresRepository;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureService {

    private final AestheticProceduresRepository _repository;

    public AestheticProcedureService() {
        _repository = new AestheticProceduresRepository();
    }

    public List<AestheticProcedures> getAll(){
        List<AestheticProcedures> proceduresDb = _repository.getAll();
        if(proceduresDb == null){
            return null;
        }
        return proceduresDb;
    }
}
