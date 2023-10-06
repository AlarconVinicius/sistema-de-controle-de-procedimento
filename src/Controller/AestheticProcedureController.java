/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Business.Services.AestheticProcedureService;
import Controller.Helper.AestheticProcedureViewHelper;
import Database.Models.AestheticProcedures;
import Views.ProcedureView;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureController {

    private final ProcedureView _view;
    private final AestheticProcedureViewHelper _helper;

    public AestheticProcedureController(ProcedureView view) {
        _view  = view;
        _helper = new AestheticProcedureViewHelper(_view);
    }

    public void updateTable(){
        AestheticProcedureService service = new AestheticProcedureService();
        List<AestheticProcedures> proceduresDb = service.getAll();
        
        _helper.fillTable(proceduresDb);
    }

}
