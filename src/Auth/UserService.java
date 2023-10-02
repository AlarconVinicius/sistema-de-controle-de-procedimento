/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auth;

import Database.Models.User;
import Helpers.ConsoleUtils;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class UserService {

    private final User _user;

    public UserService(User user) {
        _user = user;
    }

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


    public void logout() {
        _user.logout();
    }
}
