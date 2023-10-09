/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tests.Business;

import Business.Services.ProfileService;
import Database.Models.User;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProfileTest {
    public static void main(String[] args) {
        ProfileService service = new ProfileService();
        Scanner scanner = new Scanner(System.in);

        // Obter um usuário pelo ID
        System.out.println("Informe o ID do usuário a ser obtido: ");
        int idToGet = Integer.parseInt(scanner.nextLine());
        User userToGet = service.getById(idToGet);
        if (userToGet != null) {
            System.out.println("Usuário encontrado:");
            System.out.println("ID: " + userToGet.getId() + ", Nome: " + userToGet.getName() + ", Email: " + userToGet.getEmail() + ", Senha: " + userToGet.getPassword());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Atualizar o perfil de um usuário existente
        System.out.println("Informe o ID do usuário a ser atualizado: ");
        int idToUpdate = Integer.parseInt(scanner.nextLine());
        User updatedUser = service.getById(idToUpdate);
        if (updatedUser != null) {
            System.out.println("Novo nome: ");
            String newName = scanner.nextLine();
            System.out.println("Novo email: ");
            String newEmail = scanner.nextLine();
            System.out.println("Nova senha: ");
            String newPassword = scanner.nextLine();
            updatedUser.setName(newName);
            updatedUser.setEmail(newEmail);
            updatedUser.setPassword(newPassword);
            boolean profileUpdated = service.updateProfile(updatedUser);
            if (profileUpdated) {
                System.out.println("Perfil de usuário atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar perfil de usuário!");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }

        scanner.close();
    }
}