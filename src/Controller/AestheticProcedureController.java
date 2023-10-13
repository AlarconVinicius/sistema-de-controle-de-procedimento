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
import Controller.Helper.AestheticProcedureViewHelper;
import Database.Models.AestheticProcedure;
import Views.AestheticProcedureView;
import java.util.List;

/**
 * Controlador para a funcionalidade relacionada a procedimentos estéticos.
 * Gerencia a interação entre a visualização (AestheticProcedureView) e o
 * serviço (AestheticProcedureService).
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureController {

    private final AestheticProcedureView _view;
    private final AestheticProcedureViewHelper _helper;

    /**
     * Construtor para o AestheticProcedureController.
     *
     * @param view A visualização de procedimentos estéticos a ser controlada.
     */
    public AestheticProcedureController(AestheticProcedureView view) {
        _view = view;
        _helper = new AestheticProcedureViewHelper(_view);
    }

    /**
     * Atualiza a tabela de procedimentos estéticos na visualização.
     */
    public void updateTable() {
        AestheticProcedureService service = new AestheticProcedureService();
        List<AestheticProcedure> proceduresDb = service.getAll();

        _helper.fillTable(proceduresDb);
    }

    /**
     * Cria um novo procedimento estético com base nos dados da visualização.
     */
    public void createAestheticProcedure() {
        try {
            AestheticProcedureService service = new AestheticProcedureService();
            AestheticProcedure aestheticPerformed = _helper.getModel();

            boolean result = service.createAestheticProcedure(aestheticPerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                _view.showMessage("Procedimento estético adicionado com sucesso!");
            } else {
                _view.showMessage("Falha ao adicionar procedimento estético.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    /**
     * Atualiza um procedimento estético com base nos dados da visualização.
     */
    public void updateAestheticProcedure() {
        try {
            AestheticProcedureService service = new AestheticProcedureService();
            AestheticProcedure procedurePerformed = _helper.getModel();
            boolean result = service.updateAestheticProcedure(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                _view.showMessage("Procedimento estético atualizado com sucesso!");
            } else {
                _view.showMessage("Falha ao atualizar procedimento estético.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    /**
     * Deleta um procedimento estético com base nos dados da visualização.
     */
    public void deleteAestheticProcedure() {
        try {
            AestheticProcedureService service = new AestheticProcedureService();
            AestheticProcedure procedurePerformed = _helper.getModel();
            boolean result = service.deleteAestheticProcedure(procedurePerformed);
            if (result) {
                updateTable();
                _helper.clearModel();
                _view.showMessage("Procedimento estético deletado com sucesso!");
            } else {
                _view.showMessage("Falha ao deletar procedimento estético.\nCertifique-se de selecionar um registro da tabela.");
            }
        } catch (Exception e) {
            _view.showMessage("Erro: " + e.getMessage());
        }
    }

    /**
     * Atualiza os campos de entrada na visualização com base em um procedimento
     * estético selecionado na tabela.
     */
    public void updateInputs() {
        AestheticProcedureService service = new AestheticProcedureService();
        int id = _helper.getId();
        AestheticProcedure procedurePerformedDb = service.getById(id);
        _helper.setInputs(procedurePerformedDb);
    }
}
