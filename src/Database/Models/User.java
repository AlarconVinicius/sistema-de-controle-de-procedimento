/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Models;

import Auth.Auth;

/**
 * Classe que representa um usuário no sistema. Um usuário possui um ID, nome,
 * email e senha. Esta classe herda da classe `Auth`, que fornece funcionalidade
 * de autenticação.
 *
 * @author Alarcon Vinicius
 */
public class User extends Auth {

    /**
     * O identificador único do usuário.
     */
    private int id;

    /**
     * O nome do usuário.
     */
    private String name;

    /**
     * O endereço de email do usuário.
     */
    private String email;

    /**
     * A senha do usuário.
     */
    private String password;

    /**
     * Construtor padrão da classe `User`.
     */
    public User() {
    }

    /**
     * Construtor que inicializa um objeto `User` com nome, email e senha.
     *
     * @param name O nome do usuário.
     * @param email O endereço de email do usuário.
     * @param password A senha do usuário.
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Construtor que inicializa um objeto `User` com um identificador único,
     * nome, email e senha.
     *
     * @param id O identificador único do usuário.
     * @param name O nome do usuário.
     * @param email O endereço de email do usuário.
     * @param password A senha do usuário.
     */
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Obtém o identificador único do usuário.
     *
     * @return O identificador único do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do usuário.
     *
     * @param id O identificador único do usuário.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do usuário.
     *
     * @param name O nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o endereço de email do usuário.
     *
     * @return O endereço de email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do usuário.
     *
     * @param email O endereço de email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     *
     * @param password A senha do usuário.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Realiza o logout do usuário, limpando suas informações e redefinindo as
     * tentativas de login.
     */
    @Override
    public void logout() {
        setId(0);
        setName("");
        setEmail("");
        setPassword("");
        System.out.println("Usuário deslogado.");
        this.resetTentativas();
    }

    /**
     * Retorna uma representação em string do objeto `User`.
     *
     * @return Uma string que representa o objeto `User`.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(this.id).append(", ")
                .append("Email = ").append(this.email).append(", ")
                .append("Password = ").append(this.password);
        return sb.toString();
    }
}
