/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Interfaces.Repositories;

import java.util.List;

/**
 * Interface genérica para repositórios de entidades.
 *
 * @param <T> O tipo da entidade manipulada pelo repositório.
 *
 * @author Alarcon Vinicius
 */
public interface IBaseRepository<T> {

    /**
     * Obtém uma entidade pelo seu ID.
     *
     * @param id O ID da entidade a ser obtida.
     * @return A entidade correspondente ao ID, ou null se não encontrada.
     */
    T getById(int id);

    /**
     * Obtém uma lista de todas as entidades.
     *
     * @return Uma lista contendo todas as entidades do repositório.
     */
    List<T> getAll();

    /**
     * Cria uma nova entidade no repositório.
     *
     * @param entity A entidade a ser criada.
     */
    void create(T entity);

    /**
     * Atualiza uma entidade existente no repositório.
     *
     * @param entity A entidade a ser atualizada.
     */
    void update(T entity);

    /**
     * Remove uma entidade do repositório com base em seu ID.
     *
     * @param id O ID da entidade a ser removida.
     */
    void delete(int id);
}
