/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auth;

import Database.Models.User;
import Helpers.ConsoleUtils;
import java.util.Scanner;

/**
 * Classe que representa o serviço de autenticação de usuários.
 *
 * Esta classe permite que os usuários se autentiquem e realizem logout.
 *
 * @author Alarcon Vinicius
 */
public class UserService {

    /**
     * O usuário associado a este serviço de autenticação.
     */
    private final User _user;

    /**
     * Cria uma nova instância do UserService associada a um usuário.
     *
     * @param user O usuário a ser associado ao serviço.
     */
    public UserService(User user) {
        _user = user;
    }

    /**
     * Realiza a autenticação do usuário com base no email e senha fornecidos.
     *
     * @param scanner O Scanner para entrada de dados.
     * @return true se a autenticação for bem-sucedida, caso contrário, false.
     */
    public boolean authenticate(Scanner scanner) {
        String email;
        String password;

        int attempts = 0;

        while (attempts < _user.MAX_ATTEMPTS) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            System.out.println("");
            System.out.print("Senha: ");
            password = scanner.nextLine();
            ConsoleUtils.clearConsole();
            var userExist = _user.userExists(email);
            if (userExist) {
                boolean logado = _user.login(email, password);
                if (logado) {
                    System.out.println("Login bem-sucedido!");
                    return logado;
                } else {
                    attempts++;
                }
            }

        }
        return false;
    }

    /**
     * Realiza o logout do usuário.
     */
    public void logout() {
        _user.logout();
    }
}
