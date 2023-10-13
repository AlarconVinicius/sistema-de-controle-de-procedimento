/*
 * The MIT License
 *
 * Copyright 2023 Alarcon Vinicius.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * ---
 * 
 * Este projeto é disponibilizado sob a licença MIT.
 * 
 * 🔗 LinkedIn: https://www.linkedin.com/in/vin%C3%ADcius-alarcon-52a8a820a/
 * 🔗 GitHub: https://github.com/AlarconVinicius
 * 💼 Website: http://alarconvinicius.com.br/
 */
package Controller;

import Business.Services.ProfileService;
import Controller.Helper.ProfileViewHelper;
import Database.Models.User;
import Views.ProfileView;

/**
 * Controlador para a tela de perfil de usuário. Gerencia as operações
 * relacionadas ao perfil do usuário, como atualização dos campos e informações
 * do usuário. Atualiza os campos da tela de perfil com os dados do usuário.
 *
 * @author Alarcon Vinicius
 */
public class ProfileController {

    private final ProfileView _view;
    private final ProfileViewHelper _helper;

    /**
     *
     * @param view
     */
    public ProfileController(ProfileView view) {
        _view = view;
        _helper = new ProfileViewHelper(_view);
    }

    /**
     * Atualiza os campos da tela de perfil com os dados do usuário.
     */
    public void updateFields() {
        int idDefault = 1; // Considerando um ID de usuário padrão.
        ProfileService service = new ProfileService();
        User user = service.getById(idDefault);
        _helper.setInputs(user);
    }

    /**
     * Atualiza o perfil do usuário com os dados fornecidos.
     */
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
