/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Database.Models.User;
import Views.LoginView;

/**
 *
 * @author Alarcon Vinicius
 */
public class LoginViewHelper {

    /**
     * 
     */
    private final LoginView _view;

    /**
     *
     * @param view
     */
    public LoginViewHelper(LoginView view) {
        _view = view;
    }

    /**
     * Obtém o Usuario da view.
     *
     * @return O Usuario da view.
     */
    public User getModel() {
        var email = _view.getTxtEmail().getText();
        var password = _view.getTxtPassword().getText();

        return new User(0, email, password);
    }
    
    /**
     * Define o Usuario da view.
     *
     * @param user O Usuario da view.
     */
    public void setModel(User user) {
        _view.getTxtEmail().setText(user.getEmail());
        _view.getTxtPassword().setText(user.getPassword());

    }
    
    /**
     * Limpa o Usuario da view.
     *
     */
    public void clearModel() {
        _view.getTxtEmail().setText("");
        _view.getTxtPassword().setText("");

    }

}
