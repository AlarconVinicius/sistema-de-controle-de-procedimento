/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auth;

import Database.Models.User;
import Database.Repositories.UserRepository;

/**
 * Classe abstrata que representa um sistema de autenticação básico.
 *
 * Esta classe oferece funcionalidades para autenticar usuários, controlando o
 * número máximo de tentativas de login e bloqueando contas após muitas
 * tentativas malsucedidas.
 *
 * Os métodos de login e logout são implementados aqui, enquanto o acesso ao
 * repositório de usuários é usado para verificar a existência do usuário.
 *
 * Subclasses podem estender esta classe para implementar sistemas de
 * autenticação específicos, como autenticação de usuário, autenticação de
 * administrador, etc.
 *
 * @author Alarcon Vinicius
 */
public abstract class Auth {

    /**
     * O número máximo de tentativas de login permitidas.
     */
    public final int MAX_ATTEMPTS = 3;

    /**
     * O número de tentativas de login atual.
     */
    private int attempts = 0;

    /**
     * Uma flag que indica se a conta está bloqueada devido a muitas tentativas
     * malsucedidas.
     */
    private boolean blocked = false;

    /**
     * Construtor padrão da classe Auth. Inicializa um novo objeto Auth com
     * valores padrão para tentativas e estado de bloqueio.
     */
    public Auth() {
    }

    /**
     * Realiza uma tentativa de login com um email e senha fornecidos.
     *
     * @param email O email do usuário.
     * @param password A senha do usuário.
     * @return true se o login for bem-sucedido, false caso contrário.
     */
    public final boolean login(String email, String password) {
        // Verifica se a conta está bloqueada
        if (blocked) {
            System.out.println("Conta bloqueada devido a muitas tentativas malsucedidas.");
            return false;
        }

        // Obtém o repositório de usuários e verifica se o usuário existe
        UserRepository userRepository = new UserRepository();
        if (!userExists(email)) {
            return false;
        }

        // Obtém o usuário pelo email
        User user = userRepository.getByEmail(email);

        // Verifica se o email e a senha correspondem
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            System.out.println("Usuário logado.");
            resetTentativas();
            return true;
        }

        // Incrementa o número de tentativas
        attempts++;

        // Bloqueia a conta se exceder o número máximo de tentativas
        if (attempts >= MAX_ATTEMPTS) {
            blocked = true;
            System.out.println("Conta bloqueada devido a muitas tentativas malsucedidas.");
        } else {
            System.out.println("Email ou senha inválido! Tentativas restantes: " + (MAX_ATTEMPTS - attempts));
        }

        return false;
    }

    /**
     * Realiza o logout do usuário.
     */
    public void logout() {
        System.out.println("Usuário deslogado.");
        resetTentativas();
    }

    /**
     * Verifica se um usuário com o email fornecido existe no sistema.
     *
     * @param email O email do usuário a ser verificado.
     * @return true se o usuário existir, false caso contrário.
     */
    protected boolean userExists(String email) {
        // Obtém o repositório de usuários e verifica se o usuário existe
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getByEmail(email);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }

        return true;
    }

    /**
     * Reinicia o contador de tentativas e desbloqueia a conta.
     */
    protected final void resetTentativas() {
        attempts = 0;
        blocked = false;
    }
}
