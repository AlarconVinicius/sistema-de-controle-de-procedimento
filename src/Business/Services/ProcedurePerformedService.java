/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Services;

import Database.Models.ProcedurePerformed;
import Database.Repositories.ProceduresPerformedRepository;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedService {

    /**
     *
     */
    private final ProceduresPerformedRepository _repository;

    /**
     *
     */
    public ProcedurePerformedService() {
        _repository = new ProceduresPerformedRepository();
    }

    /**
     *
     * @return
     */
    public List<ProcedurePerformed> getAll() {
        List<ProcedurePerformed> proceduresPerformedDb = _repository.getAll();
        if (proceduresPerformedDb == null) {
            return null;
        }
        return proceduresPerformedDb;
    }

    /**
     *
     * @param id
     * @return
     */
    public ProcedurePerformed getById(int id) {
        ProcedurePerformed procedurePerformedDb = _repository.getById(id);
        if (procedurePerformedDb == null) {
            return null;
        }
        return procedurePerformedDb;
    }

    /**
     *
     * @param procedurePerformed
     * @return
     */
    public boolean createProcedurePerformed(ProcedurePerformed procedurePerformed) {
        try {
            if (procedurePerformed.getId() > 0) {
                procedurePerformed.setId(0);
            }
            _repository.create(procedurePerformed);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param procedurePerformed
     * @return
     */
    public boolean updateProcedurePerformed(ProcedurePerformed procedurePerformed) {
        try {
            if (procedurePerformed.getId() > 0) {
                _repository.update(procedurePerformed);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteProcedurePerformed(ProcedurePerformed procedurePerformed) {
        try {
            if (procedurePerformed.getId() > 0) {
                _repository.delete(procedurePerformed.getId());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
