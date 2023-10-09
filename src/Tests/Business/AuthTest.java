/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests.Business;

import Business.Services.AuthService;
import Database.Models.User;
import java.util.Scanner;

/**
 * Classe de teste para o sistema de autenticação.
 *
 * @author Alarcon Vinicius
 */
public class AuthTest {

    /**
     * Método principal da classe LoginTest.
     *
     * @param args Parâmetro não utilizado neste teste.
     */
    public static void main(String[] args) {
        AuthService service = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        
        
        User user = new User(0, email, password);
        User userAuth  = service.login(user);
        if (userAuth == null) {
            System.out.println("Falha no login!");
        } else {
            System.out.println("Login realizado!");
        }
        scanner.close();
    }
}
