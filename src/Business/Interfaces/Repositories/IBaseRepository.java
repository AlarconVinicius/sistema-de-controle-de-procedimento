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
