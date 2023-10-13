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
package Controller;

import Business.Services.AestheticProcedureService;
import Business.Services.ProcedurePerformedService;
import Controller.Helper.ProcedurePerformedViewHelper;
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
import Views.ProcedurePerformedView;
import java.util.List;

/**
 * Controlador para a tela de procedimentos realizados. Gerencia operações
 * relacionadas a procedimentos realizados, como criação, atualização e
 * exclusão. Atualiza a visualização dos procedimentos realizados e os dados
 * associados.
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedController {

    private final ProcedurePerformedView _view;
    private final ProcedurePerformedViewHelper _helper;

    /**
     *
     * @param view
     */
    public ProcedurePerformedController(ProcedurePerformedView view) {
        _view = view;
        _helper = new ProcedurePerformedViewHelper(_view);
    }

    /**
     * Atualiza a tabela de procedimentos realizados com os dados do banco de
     * dados.
     */
    public void updateTable() {
        ProcedurePerformedService service = new ProcedurePerformedService();
        List<ProcedurePerformed> proceduresPerformedDb = service.getAll();

        _helper.fillTable(proceduresPerformedDb);
    }

    /**
     * Atualiza o ComboBox de procedimentos estéticos com dados do banco de
     * dados.
     */
    public void updateComboBox() {
        AestheticProcedureService service = new AestheticProcedureService();
        List<AestheticProcedure> aestheticProceduresDb = service.getAll();

        _helper.fillComboBox(aestheticProceduresDb);
    }

    /**
     * Atualiza o valor recebido com base no procedimento estético selecionado
     * no ComboBox.
     */
    public void updateAmountReceived() {
        AestheticProcedure procedure = _helper.getProcedure();
        if (procedure != null) {
            _helper.setAmountReceived(procedure.getPrice());
        }
    }

    /**
     * Atualiza a data para a data atual.
     */
    public void updateDate() {
        _helper.setDate();
    }

    /**
     * Atualiza os campos de entrada com dados do procedimento realizado
     * selecionado na tabela.
     */
    public void updateInputs() {
        ProcedurePerformedService service = new ProcedurePerformedService();
        int id = _helper.getId();
        ProcedurePerformed procedurePerformedDb = service.getById(id);
        _helper.setInputs(procedurePerformedDb);
    }

    /**
     * Cria um novo procedimento realizado com base nos dados fornecidos.
     */
    public void createProcedurePerformed() {
        try {
            ProcedurePerformedService service = new ProcedurePerformedService();
            ProcedurePerformed procedurePerformed = _helper.getModel();

            boolean result = service.createProcedurePerformed(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                updateAmountReceived();
                _view.showMessage("Procedimento realizado, adicionado com sucesso!");
            } else {
                _view.showMessage("Falha ao adicionar procedimento realizado.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    /**
     * Atualiza um procedimento realizado com base nos dados fornecidos.
     */
    public void updateProcedurePerformed() {
        try {
            ProcedurePerformedService service = new ProcedurePerformedService();
            ProcedurePerformed procedurePerformed = _helper.getModel();
            boolean result = service.updateProcedurePerformed(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                updateAmountReceived();
                _view.showMessage("Procedimento realizado, atualizado com sucesso!");
            } else {
                _view.showMessage("Falha ao atualizar procedimento realizado.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    /**
     * Exclui um procedimento realizado com base nos dados fornecidos.
     */
    public void deleteProcedurePerformed() {
        try {
            ProcedurePerformedService service = new ProcedurePerformedService();
            ProcedurePerformed procedurePerformed = _helper.getModel();
            boolean result = service.deleteProcedurePerformed(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                updateAmountReceived();
                _view.showMessage("Procedimento realizado, deletado com sucesso!");
            } else {
                _view.showMessage("Falha ao deletar procedimento realizado.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }
}
