/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Services;

import Database.Models.User;
import Database.Repositories.UserRepository;

/**
 *
 * @author Alarcon Vinicius
 */
public class AuthService {

    /**
     * Construtor padrão da classe Auth. Inicializa um novo objeto Auth com
     * valores padrão para tentativas e estado de bloqueio.
     */
    public AuthService() {
    }

    /**
     * Realiza uma tentativa de login com um email e senha fornecidos.
     *
     * @param user Usuário a ser autenticado.
     */
    public final User login(User user) {
        
        UserRepository userRepository = new UserRepository();
        if (!userExists(user.getEmail())) {
            return null;
        }

        User userDb = userRepository.getByEmail(user.getEmail());

        if (user.getEmail().equals(userDb.getEmail()) && user.getPassword().equals(userDb.getPassword())) {
            return userDb;
        }
        return null;
    }

    /**
     * Verifica se um usuário com o email fornecido existe no sistema.
     *
     * @param email O email do usuário a ser verificado.
     * @return true se o usuário existir, false caso contrário.
     */
    private boolean userExists(String email) {
        // Obtém o repositório de usuários e verifica se o usuário existe
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getByEmail(email);

        if (user == null) {
            return false;
        }

        return true;
    }
}
