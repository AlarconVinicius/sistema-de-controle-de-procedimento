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
package Tests.Business;

import Business.Services.ProfileService;
import Database.Models.User;
import java.util.Scanner;

/**
 * Classe de teste para o serviço de perfis de usuário (ProfileService). Esta
 * classe permite testar a funcionalidade de gerenciamento de perfis de usuário,
 * incluindo a obtenção de usuário pelo ID e atualização de perfil de usuário.
 *
 * @author Alarcon Vinicius
 */
public class ProfileTest {

    /**
     * Método principal que inicia a execução do teste do serviço de perfis de
     * usuário. Permite ao usuário interagir com o serviço, obtendo um usuário
     * pelo ID e atualizando o perfil de um usuário existente.
     *
     * @param args Os argumentos da linha de comando (não são usados neste
     * contexto).
     */
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
