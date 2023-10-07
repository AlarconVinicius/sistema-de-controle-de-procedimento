/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Services;

import Database.Models.AestheticProcedure;
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

    public List<AestheticProcedure> getAll(){
        List<AestheticProcedure> proceduresDb = _repository.getAll();
        if(proceduresDb == null){
            return null;
        }
        return proceduresDb;
    }

    public AestheticProcedure getById(int id) {
        AestheticProcedure aestheticProceduresDb = _repository.getById(id);
        if (aestheticProceduresDb == null) {
            return null;
        }
        return aestheticProceduresDb;
    }

    public boolean createAestheticProcedure(AestheticProcedure aestheticPerformed) {
        try {
            if (aestheticPerformed.getId() > 0) {
                aestheticPerformed.setId(0);
            }
            _repository.create(aestheticPerformed);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateAestheticProcedure(AestheticProcedure aestheticPerformed) {
        try {
            if (aestheticPerformed.getId() > 0) {
                _repository.update(aestheticPerformed);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteAestheticProcedure(AestheticProcedure aestheticPerformed) {
        try {
            if (aestheticPerformed.getId() > 0) {
                _repository.delete(aestheticPerformed.getId());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
