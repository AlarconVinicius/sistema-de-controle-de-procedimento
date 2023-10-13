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

import Business.Services.AuthService;
import Database.Models.User;
import java.util.Scanner;

/**
 * Classe de teste para o serviço de autenticação (AuthService). Esta classe
 * permite testar a funcionalidade de autenticação, onde os usuários inserem seu
 * email e senha para realizar login no sistema.
 *
 * @author Alarcon Vinicius
 */
public class AuthTest {

    /**
     * Método principal que inicia a execução do teste do serviço de
     * autenticação. Permite ao usuário interagir com o serviço, inserindo seu
     * email e senha para autenticação e, em seguida, exibe uma mensagem com
     * base no resultado da autenticação.
     *
     * @param args Os argumentos da linha de comando (não são usados neste
     * contexto).
     */
    public static void main(String[] args) {
        AuthService service = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        User user = new User(0, email, password);
        User userAuth = service.login(user);
        if (userAuth == null) {
            System.out.println("Falha no login!");
        } else {
            System.out.println("Login realizado!");
        }
        scanner.close();
    }
}
