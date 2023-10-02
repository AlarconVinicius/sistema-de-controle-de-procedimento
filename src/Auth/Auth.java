/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Auth;

import Database.Models.User;
import Database.Repositories.UserRepository;

/**
 *
 * @author Alarcon Vinicius
 */
public abstract class Auth {
    public final int MAX_ATTEMPTS = 3;
    private int attempts = 0;
    private boolean blocked = false;
    
    public final boolean login(String email, String password){
        if (blocked) {
            System.out.println("Conta bloqueada devido a muitas tentativas malsucedidas.");
            return false;
        }
        
        UserRepository userRepository = new UserRepository();
        if(!userExists(email)){
            return false;
        }
        User user = userRepository.getByEmail(email);
        
        if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
            System.out.println("Usuário logado.");
            resetTentativas();
            return true;
        }
        
        attempts++;
        if (attempts >= MAX_ATTEMPTS) {
            blocked = true;
            System.out.println("Conta bloqueada devido a muitas tentativas malsucedidas.");
        } else {
            System.out.println("Email ou senha inválido! Tentativas restantes: " + (MAX_ATTEMPTS - attempts));
        }
        
        return false;
    }
    
    public void logout() {
        System.out.println("Usuário deslogado.");
        resetTentativas();
    }

    protected boolean userExists(String email) {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getByEmail(email);
        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }
        return true;
    }
    
    protected final void resetTentativas() {
        attempts = 0;
        blocked = false;
    }
    
}
