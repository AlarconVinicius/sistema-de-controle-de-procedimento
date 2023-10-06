/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Controller.Helper.ProcedurePerformedViewHelper;
import Views.MainMenuView;
import Views.ProcedurePerformedView;
import Views.ProcedureView;

/**
 *
 * @author Alarcon Vinicius
 */
public class MainMenuController {
    private final MainMenuView _view;

    /**
     * 
     * @param view 
     */
    public MainMenuController(MainMenuView view) {
        _view = view;
    }
    
    public void navigateToProcedures(){
        ProcedureView procedure = new ProcedureView();
        procedure.setVisible(true);
    }
    
    public void navigateToProceduresPerformed(){
        ProcedurePerformedView procedurePerformed = new ProcedurePerformedView();
        procedurePerformed.setVisible(true);
    }
    
}
