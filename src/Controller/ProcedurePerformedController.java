/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Business.Services.AestheticProcedureService;
import Business.Services.ProcedurePerformedService;
import Controller.Helper.ProcedurePerformedViewHelper;
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
import Views.ProcedurePerformedView;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedController {

    private final ProcedurePerformedView _view;
    private final ProcedurePerformedViewHelper _helper;

    public ProcedurePerformedController(ProcedurePerformedView view) {
        _view = view;
        _helper = new ProcedurePerformedViewHelper(_view);
    }

    public void updateTable() {
        ProcedurePerformedService service = new ProcedurePerformedService();
        List<ProcedurePerformed> proceduresPerfomedDb = service.getAll();

        _helper.fillTable(proceduresPerfomedDb);
    }

    public void updateComboBox() {
        AestheticProcedureService service = new AestheticProcedureService();
        List<AestheticProcedure> proceduresPerfomedDb = service.getAll();

        _helper.fillComboBox(proceduresPerfomedDb);
    }

    public void updateAmountReceived() {
        AestheticProcedure procedure = _helper.getProcedure();
        _helper.setAmountReceived(procedure.getPrice());
    }

    public void updateDate() {
        _helper.setDate();
    }

    public void updateInputs() {
        ProcedurePerformedService service = new ProcedurePerformedService();
        int id = _helper.getId();
        ProcedurePerformed procedurePerformedDb = service.getById(id);
        _helper.setInputs(procedurePerformedDb);
    }

    public void createProcedurePerformed() {
        try {
            ProcedurePerformedService service = new ProcedurePerformedService();
            ProcedurePerformed procedurePerformed = _helper.getModel();

            boolean result = service.createProcedurePerformed(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                updateAmountReceived();
                _view.showMessage("Procedimento realizado, adicionado com sucesso!");
            } else {
                _view.showMessage("Falha ao adicionar procedimento realizado.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    public void updateProcedurePerformed() {
        try {
            ProcedurePerformedService service = new ProcedurePerformedService();
            ProcedurePerformed procedurePerformed = _helper.getModel();
            boolean result = service.updateProcedurePerformed(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                updateAmountReceived();
                _view.showMessage("Procedimento realizado, atualizado com sucesso!");
            } else {
                _view.showMessage("Falha ao atualizar procedimento realizado.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }
    
    public void deleteProcedurePerformed() {
        try {
            ProcedurePerformedService service = new ProcedurePerformedService();
            ProcedurePerformed procedurePerformed = _helper.getModel();
            boolean result = service.deleteProcedurePerformed(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                updateAmountReceived();
                _view.showMessage("Procedimento realizado, deletado com sucesso!");
            } else {
                _view.showMessage("Falha ao deletar procedimento realizado.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }
}
