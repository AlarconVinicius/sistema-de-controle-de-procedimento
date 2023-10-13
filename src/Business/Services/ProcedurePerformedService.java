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

import Database.Models.ProcedurePerformed;
import Database.Repositories.ProceduresPerformedRepository;
import java.util.List;

/**
 * Serviço para gerenciar procedimentos realizados no sistema. Este serviço lida
 * com operações relacionadas a procedimentos realizados, incluindo a obtenção
 * de todos os procedimentos realizados, obtenção de um procedimento realizado
 * por ID, criação, atualização e exclusão de procedimentos realizados.
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedService {

    /**
     * Repositório de procedimentos realizados para acessar os dados.
     */
    private final ProceduresPerformedRepository _repository;

    /**
     * Construtor padrão da classe ProcedurePerformedService. Inicializa um novo
     * objeto ProcedurePerformedService.
     */
    public ProcedurePerformedService() {
        _repository = new ProceduresPerformedRepository();
    }

    /**
     * Obtém todos os procedimentos realizados no sistema.
     *
     * @return Uma lista de procedimentos realizados ou null em caso de erro.
     */
    public List<ProcedurePerformed> getAll() {
        List<ProcedurePerformed> proceduresPerformedDb = _repository.getAll();
        if (proceduresPerformedDb == null) {
            return null;
        }
        return proceduresPerformedDb;
    }

    /**
     * Obtém um procedimento realizado com base em seu ID.
     *
     * @param id O ID do procedimento realizado a ser obtido.
     * @return O procedimento realizado encontrado ou null se não existir.
     */
    public ProcedurePerformed getById(int id) {
        ProcedurePerformed procedurePerformedDb = _repository.getById(id);
        if (procedurePerformedDb == null) {
            return null;
        }
        return procedurePerformedDb;
    }

    /**
     * Cria um novo procedimento realizado no sistema.
     *
     * @param procedurePerformed O procedimento realizado a ser criado.
     * @return true se o procedimento foi criado com sucesso, false caso
     * contrário.
     */
    public boolean createProcedurePerformed(ProcedurePerformed procedurePerformed) {
        try {
            if (procedurePerformed.getId() > 0) {
                procedurePerformed.setId(0);
            }
            _repository.create(procedurePerformed);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Atualiza um procedimento realizado existente no sistema.
     *
     * @param procedurePerformed O procedimento realizado a ser atualizado.
     * @return true se o procedimento foi atualizado com sucesso, false caso
     * contrário.
     */
    public boolean updateProcedurePerformed(ProcedurePerformed procedurePerformed) {
        try {
            if (procedurePerformed.getId() > 0) {
                _repository.update(procedurePerformed);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Exclui um procedimento realizado do sistema.
     *
     * @param procedurePerformed O procedimento realizado a ser excluído.
     * @return true se o procedimento foi excluído com sucesso, false caso
     * contrário.
     */
    public boolean deleteProcedurePerformed(ProcedurePerformed procedurePerformed) {
        try {
            if (procedurePerformed.getId() > 0) {
                _repository.delete(procedurePerformed.getId());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
