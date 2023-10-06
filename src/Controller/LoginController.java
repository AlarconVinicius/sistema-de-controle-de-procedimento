/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Business.Services.AuthService;
import Controller.Helper.LoginViewHelper;
import Database.Models.User;
import Views.LoginView;
import Views.MainMenuView;

/**
 *
 * @author Alarcon Vinicius
 */
public class LoginController {

    private final LoginView _view;
    private final LoginViewHelper _helper;
    private final AuthService _authService;

    /**
     * 
     * @param view 
     */
    public LoginController(LoginView view) {
        _view = view;
        _helper = new LoginViewHelper(_view);
        _authService = new AuthService();
    }

    public void login(){
        User user = _helper.getModel();
        User authenticatedUser = _authService.login(user);
        if(authenticatedUser != null){
            MainMenuView menu = new MainMenuView();
            menu.setVisible(true);
            _view.dispose();
        }else{
            _view.showMessage("Usuário ou senha inválidos!");
        }
    }
}
