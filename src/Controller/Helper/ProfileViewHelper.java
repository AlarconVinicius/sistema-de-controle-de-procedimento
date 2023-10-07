/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller.Helper;

import Database.Models.User;
import Views.ProfileView;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProfileViewHelper {

    private final ProfileView _view;

    public ProfileViewHelper(ProfileView view) {
        _view = view;
    }

    
    public void setInputs(User user) {
        if (user != null) {
            _view.getTxtId().setText(user.getId() + "");
            _view.getTxtName().setText(user.getName());
            _view.getTxtEmail().setText(user.getEmail());
            _view.getTxtPassword().setText(user.getPassword());
        }
    }

    public User getModel() {
        int id;
        try{
            id = Integer.parseInt(_view.getTxtId().getText());
        } catch (NumberFormatException e){
            id = 0;
        }
        String name = _view.getTxtName().getText();
        String email = _view.getTxtEmail().getText();
        String password = _view.getTxtPassword().getText();
        System.out.println(id + " | " + name + " | " + email + " | " + password);
         User user = new User();
        if(id > 0) {
            user = new User(id, name, email, password);
        }else{
            return null;
        }
        return user;
    }
}
