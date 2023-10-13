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

import Views.MainMenuView;
import Views.ProcedurePerformedView;
import Views.AestheticProcedureView;
import Views.LoginView;
import Views.ProfileView;

/**
 * Controlador para a tela do menu principal. Gerencia a navegação entre as
 * diferentes funcionalidades do sistema.
 *
 * @author Alarcon Vinicius
 */
public class MainMenuController {

    private final MainMenuView _view;

    /**
     * Construtor para o MainMenuController.
     *
     * @param view A visualização do menu principal a ser controlada.
     */
    public MainMenuController(MainMenuView view) {
        _view = view;
    }

    /**
     * Navega para a tela de procedimentos estéticos (AestheticProcedureView).
     */
    public void navigateToProcedures() {
        AestheticProcedureView procedure = new AestheticProcedureView();
        procedure.setVisible(true);
    }

    /**
     * Navega para a tela de procedimentos realizados (ProcedurePerformedView).
     */
    public void navigateToProceduresPerformed() {
        ProcedurePerformedView procedurePerformed = new ProcedurePerformedView();
        procedurePerformed.setVisible(true);
    }

    /**
     * Navega para a tela de perfil de usuário (ProfileView).
     */
    public void navigateToProfile() {
        ProfileView profile = new ProfileView();
        profile.setVisible(true);
    }

    /**
     * Navega de volta para a tela de login (LoginView) e fecha a tela do menu
     * principal.
     */
    public void navigateToLogin() {
        LoginView login = new LoginView();
        _view.dispose();
        login.setVisible(true);
    }
}
