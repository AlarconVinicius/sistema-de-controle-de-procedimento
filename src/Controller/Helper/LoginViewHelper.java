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
import Views.LoginView;

/**
 * Classe auxiliar para a LoginView, responsável por lidar com dados e
 * interações relacionados à autenticação de usuário.
 *
 * @author Alarcon Vinicius
 */
public class LoginViewHelper {

    private final LoginView _view;

    /**
     * Construtor para o LoginViewHelper.
     *
     * @param view A LoginView a ser assistida.
     */
    public LoginViewHelper(LoginView view) {
        _view = view;
    }

    /**
     * Obtém o modelo de usuário a partir dos campos de entrada na visualização.
     *
     * @return Um objeto User preenchido com os dados dos campos de email e
     * senha na visualização.
     */
    public User getModel() {
        var email = _view.getTxtEmail().getText();
        var password = _view.getTxtPassword().getText();

        return new User(0, email, password);
    }

    /**
     * Define o modelo de usuário na visualização.
     *
     * @param user O objeto User a ser exibido nos campos de email e senha na
     * visualização.
     */
    public void setModel(User user) {
        _view.getTxtEmail().setText(user.getEmail());
        _view.getTxtPassword().setText(user.getPassword());
    }

    /**
     * Limpa os campos de email e senha na visualização.
     */
    public void clearModel() {
        _view.getTxtEmail().setText("");
        _view.getTxtPassword().setText("");
    }
}
