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
public class LoginTest {
    public static void main(String[] args) {
        var auth = new User();
        UserService userService = new UserService(auth);
        Scanner scanner = new Scanner(System.in);
        
        userService.authenticate(scanner);
        userService.logout();
        scanner.close();
    }
}
