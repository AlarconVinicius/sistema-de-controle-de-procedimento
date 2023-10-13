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
package Business.Services;

import Database.Models.User;
import Database.Repositories.UserRepository;

/**
 * Serviço de autenticação para realizar login de usuários no sistema. Este
 * serviço lida com operações de autenticação, incluindo tentativas de login e
 * verificação da existência de um usuário no sistema.
 *
 * @author Alarcon Vinicius
 */
public class AuthService {

    /**
     * Construtor padrão da classe AuthService. Inicializa um novo objeto
     * AuthService.
     */
    public AuthService() {
    }

    /**
     * Realiza uma tentativa de login com um email e senha fornecidos.
     *
     * @param user Usuário a ser autenticado.
     * @return O usuário autenticado se o login for bem-sucedido, ou null caso
     * contrário.
     */
    public final User login(User user) {
        UserRepository userRepository = new UserRepository();

        // Verifica se o usuário existe no sistema
        if (!userExists(user.getEmail())) {
            return null;
        }

        User userDb = userRepository.getByEmail(user.getEmail());

        // Compara as credenciais fornecidas com as do usuário no banco de dados
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
