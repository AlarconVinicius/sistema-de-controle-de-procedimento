/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Business.Services.AestheticProcedureService;
import Business.Services.ProcedurePerformedService;
import Controller.Helper.ProcedurePerformedViewHelper;
import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
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

    public void updateTable(){
        ProcedurePerformedService service = new ProcedurePerformedService();
        List<ProceduresPerformed> proceduresPerfomedDb = service.getAll();
        
        _helper.fillTable(proceduresPerfomedDb);
    }
    
    public void updateComboBox(){
        AestheticProcedureService service = new AestheticProcedureService();
        List<AestheticProcedures> proceduresPerfomedDb = service.getAll();
        
        _helper.fillComboBox(proceduresPerfomedDb);
    }
}
