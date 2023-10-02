/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Auth;

import Database.Models.User;
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
    public void authenticate(Scanner scanner) {
        for (int attempts = 1; attempts <= _user.MAX_ATTEMPTS; attempts++) {
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Senha: ");
            String password = scanner.nextLine();
            
            boolean logado = _user.login(email, password);
            if (logado) {
                System.out.println("Login bem-sucedido!");
                break;
            } else {
                System.out.println("Tentativa falhou.");
                if (attempts == _user.MAX_ATTEMPTS) {
                    System.out.println("Excedido o número máximo de tentativas. Conta bloqueada.");
                    break;
                }
            }
        }
    }
    public void logout(){
        _user.logout();
    }
}
