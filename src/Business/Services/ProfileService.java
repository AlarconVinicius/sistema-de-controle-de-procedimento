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
 * Serviço para gerenciar o perfil de usuário no sistema. Este serviço lida com
 * operações relacionadas ao perfil do usuário, incluindo a obtenção do perfil
 * do usuário por ID e a atualização do perfil do usuário.
 *
 * @author Alarcon Vinicius
 */
public class ProfileService {

    /**
     * Repositório de usuários para acessar os dados.
     */
    private final UserRepository _repository;

    /**
     * Construtor padrão da classe ProfileService. Inicializa um novo objeto
     * ProfileService.
     */
    public ProfileService() {
        _repository = new UserRepository();
    }

    /**
     * Obtém o perfil do usuário com base em seu ID.
     *
     * @param id O ID do usuário cujo perfil deve ser obtido.
     * @return O perfil do usuário encontrado ou null se não existir.
     */
    public User getById(int id) {
        User userDb = _repository.getById(id);
        if (userDb == null) {
            return null;
        }
        return userDb;
    }

    /**
     * Atualiza o perfil do usuário no sistema.
     *
     * @param user O perfil do usuário a ser atualizado.
     * @return true se o perfil do usuário foi atualizado com sucesso, false
     * caso contrário.
     */
    public boolean updateProfile(User user) {
        try {
            if (user.getId() > 0) {
                _repository.update(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
