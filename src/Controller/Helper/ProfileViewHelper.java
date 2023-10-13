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
package Controller.Helper;

import Database.Models.User;
import Views.ProfileView;

/**
 * Classe auxiliar para a ProfileView, responsável por lidar com dados e
 * interações relacionados ao perfil do usuário.
 *
 * @author Alarcon Vinicius
 */
public class ProfileViewHelper {

    private final ProfileView _view;

    /**
     * Construtor para o ProfileViewHelper.
     *
     * @param view A ProfileView a ser assistida.
     */
    public ProfileViewHelper(ProfileView view) {
        _view = view;
    }

    /**
     * Define os campos de entrada na visualização com dados de um objeto User.
     *
     * @param user O objeto User a ser exibido nos campos da visualização.
     */
    public void setInputs(User user) {
        if (user != null) {
            _view.getTxtId().setText(user.getId() + "");
            _view.getTxtName().setText(user.getName());
            _view.getTxtEmail().setText(user.getEmail());
            _view.getTxtPassword().setText(user.getPassword());
        }
    }

    /**
     * Obtém o modelo de usuário a partir dos campos de entrada na visualização.
     *
     * @return Um objeto User preenchido com os dados dos campos de entrada na
     * visualização.
     */
    public User getModel() {
        int id;
        try {
            id = Integer.parseInt(_view.getTxtId().getText());
        } catch (NumberFormatException e) {
            id = 0;
        }
        String name = _view.getTxtName().getText();
        String email = _view.getTxtEmail().getText();
        String password = _view.getTxtPassword().getText();

        User user;
        if (id > 0) {
            user = new User(id, name, email, password);
        } else {
            user = new User();
        }
        return user;
    }
}
