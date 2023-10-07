/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Business.Services.AestheticProcedureService;
import Controller.Helper.AestheticProcedureViewHelper;
import Database.Models.AestheticProcedure;
import Views.AestheticProcedureView;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureController {

    private final AestheticProcedureView _view;
    private final AestheticProcedureViewHelper _helper;

    public AestheticProcedureController(AestheticProcedureView view) {
        _view  = view;
        _helper = new AestheticProcedureViewHelper(_view);
    }

    public void updateTable(){
        AestheticProcedureService service = new AestheticProcedureService();
        List<AestheticProcedure> proceduresDb = service.getAll();
        
        _helper.fillTable(proceduresDb);
    }

    public void createAestheticProcedure() {
        try {
            AestheticProcedureService service = new AestheticProcedureService();
            AestheticProcedure aestheticPerformed = _helper.getModel();

            boolean result = service.createAestheticProcedure(aestheticPerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                _view.showMessage("Procedimento estético, adicionado com sucesso!");
            } else {
                _view.showMessage("Falha ao adicionar procedimento estético.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    public void updateAestheticProcedure() {
        try {
            AestheticProcedureService service = new AestheticProcedureService();
            AestheticProcedure procedurePerformed = _helper.getModel();
            boolean result = service.updateAestheticProcedure(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                _view.showMessage("Procedimento estético, atualizado com sucesso!");
            } else {
                _view.showMessage("Falha ao atualizar procedimento estético.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    public void deleteAestheticProcedure() {
        try {
            AestheticProcedureService service = new AestheticProcedureService();
            AestheticProcedure procedurePerformed = _helper.getModel();
            boolean result = service.deleteAestheticProcedure(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                _view.showMessage("Procedimento estético, deletado com sucesso!");
            } else {
                _view.showMessage("Falha ao deletar procedimento estético.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    public void updateInputs() {
        AestheticProcedureService service = new AestheticProcedureService();
        int id = _helper.getId();
        AestheticProcedure procedurePerformedDb = service.getById(id);
        _helper.setInputs(procedurePerformedDb);
    }

}
