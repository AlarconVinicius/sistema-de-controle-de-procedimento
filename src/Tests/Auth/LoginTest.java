/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests.Auth;

import Auth.UserService;
import Database.Models.User;
import java.util.Scanner;

/**
 * Classe de teste para o sistema de autenticação.
 *
 * @author Alarcon Vinicius
 */
public class LoginTest {

    /**
     * Método principal da classe LoginTest.
     *
     * @param args Parâmetro não utilizado neste teste.
     */
    public static void main(String[] args) {
        var auth = new User();
        UserService userService = new UserService(auth);
        Scanner scanner = new Scanner(System.in);

        userService.authenticate(scanner);
        userService.logout();
        scanner.close();
    }
}
