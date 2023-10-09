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
public class ProfileService {

    private final UserRepository _repository;

    public ProfileService() {
        _repository = new UserRepository();
    }

    public User getById(int id) {
        User userDb = _repository.getById(id);
        if (userDb == null) {
            return null;
        }
        return userDb;
    }

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
