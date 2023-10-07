/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Business.Services.ProfileService;
import Controller.Helper.ProfileViewHelper;
import Database.Models.User;
import Views.ProfileView;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProfileController {

    private final ProfileView _view;
    private final ProfileViewHelper _helper;

    public ProfileController(ProfileView view) {
        _view = view;
        _helper = new ProfileViewHelper(_view);
    }

    public void updateFields() {
        int idDefault = 1;
        ProfileService service = new ProfileService();
        User user = service.getById(idDefault);
        _helper.setInputs(user);
    }

    public void updateProfile() {
        try {
            ProfileService service = new ProfileService();
            User user = _helper.getModel();
            if (user != null) {
                boolean result = service.updateProfile(user);
                if (result) {
                    _view.showMessage("Perfil, atualizado com sucesso!");
                } else {
                    _view.showMessage("Falha ao atualizar perfil.");
                }
            } else {
                _view.showMessage("Falha ao atualizar perfil.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }
}
