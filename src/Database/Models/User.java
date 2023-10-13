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
package Database.Models;


/**
 * Classe que representa um usuário no sistema.
 * Um usuário possui um ID, nome, email e senha.
 * Esta classe herda da classe `Auth`, que fornece funcionalidade de autenticação.
 * 
 * @author Alarcon Vinicius
 */
public class User {

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
     * @param name     O nome do usuário.
     * @param email    O endereço de email do usuário.
     * @param password A senha do usuário.
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Construtor que inicializa um objeto `User` com id, email e senha.
     * 
     * @param id       O identificador único do usuário.
     * @param email    O endereço de email do usuário.
     * @param password A senha do usuário.
     */
    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    /**
     * Construtor que inicializa um objeto `User` com um identificador único,
     * nome, email e senha.
     * 
     * @param id       O identificador único do usuário.
     * @param name     O nome do usuário.
     * @param email    O endereço de email do usuário.
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
     * Retorna uma representação em string do objeto `User`.
     * 
     * @return Uma string que representa o objeto `User`.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id).append(", ")
          .append("Email = ").append(email).append(", ")
          .append("Password = ").append(password);
        return sb.toString();
    }
}
