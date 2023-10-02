/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Interfaces.Repositories;

import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public interface IBaseRepository<T> {
    T findById(int id);
    List<T> findAll();
    void create(T entity);
    void update(T entity);
    void delete(int id);
}
