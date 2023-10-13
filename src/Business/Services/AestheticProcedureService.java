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

import Database.Models.AestheticProcedure;
import Database.Repositories.AestheticProceduresRepository;
import java.util.List;

/**
 * Serviço para gerenciar procedimentos estéticos. Este serviço lida com
 * operações relacionadas a procedimentos estéticos, como buscar todos os
 * procedimentos, buscar um procedimento por ID, criar, atualizar e deletar
 * procedimentos estéticos.
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureService {

    private final AestheticProceduresRepository _repository;

    /**
     *
     */
    public AestheticProcedureService() {
        _repository = new AestheticProceduresRepository();
    }

    /**
     * Obtém todos os procedimentos estéticos.
     *
     * @return Uma lista de procedimentos estéticos ou null em caso de falha.
     */
    public List<AestheticProcedure> getAll() {
        List<AestheticProcedure> proceduresDb = _repository.getAll();
        if (proceduresDb == null) {
            return null;
        }
        return proceduresDb;
    }

    /**
     * Obtém um procedimento estético pelo ID.
     *
     * @param id O ID do procedimento estético a ser buscado.
     * @return O procedimento estético correspondente ao ID ou null em caso de
     * falha.
     */
    public AestheticProcedure getById(int id) {
        AestheticProcedure aestheticProceduresDb = _repository.getById(id);
        if (aestheticProceduresDb == null) {
            return null;
        }
        return aestheticProceduresDb;
    }

    /**
     * Cria um novo procedimento estético.
     *
     * @param aestheticPerformed O procedimento estético a ser criado.
     * @return true se o procedimento estético foi criado com sucesso, false em
     * caso de falha.
     */
    public boolean createAestheticProcedure(AestheticProcedure aestheticPerformed) {
        try {
            if (aestheticPerformed.getId() > 0) {
                aestheticPerformed.setId(0);
            }
            _repository.create(aestheticPerformed);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Atualiza um procedimento estético existente.
     *
     * @param aestheticPerformed O procedimento estético a ser atualizado.
     * @return true se o procedimento estético foi atualizado com sucesso, false
     * em caso de falha.
     */
    public boolean updateAestheticProcedure(AestheticProcedure aestheticPerformed) {
        try {
            if (aestheticPerformed.getId() > 0) {
                _repository.update(aestheticPerformed);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Deleta um procedimento estético existente.
     *
     * @param aestheticPerformed O procedimento estético a ser deletado.
     * @return true se o procedimento estético foi deletado com sucesso, false
     * em caso de falha.
     */
    public boolean deleteAestheticProcedure(AestheticProcedure aestheticPerformed) {
        try {
            if (aestheticPerformed.getId() > 0) {
                _repository.delete(aestheticPerformed.getId());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
