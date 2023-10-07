/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Controller.Helper.ProcedurePerformedViewHelper;
import Views.MainMenuView;
import Views.ProcedurePerformedView;
import Views.AestheticProcedureView;
import Views.LoginView;
import Views.ProfileView;

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
        AestheticProcedureView procedure = new AestheticProcedureView();
        procedure.setVisible(true);
    }
    
    public void navigateToProceduresPerformed(){
        ProcedurePerformedView procedurePerformed = new ProcedurePerformedView();
        procedurePerformed.setVisible(true);
    }

    public void navigateToProfile() {
        ProfileView profile = new ProfileView();
        profile.setVisible(true);
    }

    public void navigateToLogin() {
        LoginView login = new LoginView();
        _view.dispose();
        login.setVisible(true);
    }
    
}
