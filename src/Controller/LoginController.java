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

import Business.Services.AuthService;
import Controller.Helper.LoginViewHelper;
import Database.Models.User;
import Views.LoginView;
import Views.MainMenuView;

/**
 * Controlador para a funcionalidade de login do usuário. Gerencia a interação
 * entre a visualização (LoginView) e o serviço de autenticação (AuthService).
 *
 * @author Alarcon Vinicius
 */
public class LoginController {

    private final LoginView _view;
    private final LoginViewHelper _helper;
    private final AuthService _authService;

    /**
     * Construtor para o LoginController.
     *
     * @param view A visualização de login a ser controlada.
     */
    public LoginController(LoginView view) {
        _view = view;
        _helper = new LoginViewHelper(_view);
        _authService = new AuthService();
    }

    /**
     * Realiza a operação de login com base nos dados fornecidos na
     * visualização. Se o usuário for autenticado com sucesso, a tela do menu
     * principal (MainMenuView) é exibida.
     */
    public void login() {
        User user = _helper.getModel();
        User authenticatedUser = _authService.login(user);
        if (authenticatedUser != null) {
            MainMenuView menu = new MainMenuView();
            menu.setVisible(true);
            _view.dispose();
        } else {
            _view.showMessage("Usuário ou senha inválidos!");
        }
    }
}
