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
package Controller.Helper;

import Database.Models.AestheticProcedure;
import Views.AestheticProcedureView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Classe auxiliar para a AestheticProcedureView, responsável por lidar com
 * dados e interações entre a AestheticProcedureView e o
 * AestheticProcedureService. Esta classe auxilia no preenchimento da tabela, na
 * obtenção e atualização de dados e na limpeza dos campos de entrada.
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureViewHelper {

    private final AestheticProcedureView _view;

    /**
     * Construtor para o AestheticProcedureViewHelper.
     *
     * @param view A AestheticProcedureView a ser assistida.
     */
    public AestheticProcedureViewHelper(AestheticProcedureView view) {
        _view = view;
    }

    /**
     * Preenche a tabela na visualização com uma lista de objetos
     * AestheticProcedure.
     *
     * @param procedures A lista de objetos AestheticProcedure a ser exibida na
     * tabela.
     */
    public void fillTable(List<AestheticProcedure> procedures) {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedures().getModel();
        tableModel.setNumRows(0);
        for (AestheticProcedure procedure : procedures) {
            tableModel.addRow(new Object[]{
                procedure.getId(),
                procedure.getName(),
                procedure.getPrice()
            });
        }
    }

    /**
     * Obtém o ID do AestheticProcedure selecionado na tabela.
     *
     * @return O ID do AestheticProcedure selecionado, ou 0 se nenhum estiver
     * selecionado ou se o ID não for um número válido.
     */
    public int getId() {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedures().getModel();
        int selectedRow = _view.getTableProcedures().getSelectedRow();
        int id;
        try {
            id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        } catch (NumberFormatException e) {
            id = 0;
        }
        return id;
    }

    /**
     * Obtém um modelo de AestheticProcedure a partir dos campos de entrada na
     * visualização.
     *
     * @return Um objeto AestheticProcedure preenchido com os dados dos campos
     * de entrada.
     */
    public AestheticProcedure getModel() {
        int id;
        try {
            id = Integer.parseInt(_view.getTxtId().getText());
        } catch (NumberFormatException e) {
            id = 0;
        }
        String name = _view.getTxtNameP().getText();
        Double price = Double.parseDouble(_view.getTxtPriceP().getText());
        AestheticProcedure aestheticProcedure;

        if (id > 0) {
            aestheticProcedure = new AestheticProcedure(id, name, price);
        } else {
            aestheticProcedure = new AestheticProcedure(name, price);
        }
        return aestheticProcedure;
    }

    /**
     * Limpa os campos de entrada na visualização.
     */
    public void clearModel() {
        _view.getTxtId().setText("");
        _view.getTxtNameP().setText("");
        _view.getTxtPriceP().setText("");
    }

    /**
     * Define os campos de entrada na visualização com dados de um objeto
     * AestheticProcedure.
     *
     * @param aestheticProcedure O objeto AestheticProcedure a ser exibido nos
     * campos de entrada.
     */
    public void setInputs(AestheticProcedure aestheticProcedure) {
        if (aestheticProcedure != null) {
            _view.getTxtId().setText(aestheticProcedure.getId() + "");
            _view.getTxtNameP().setText(aestheticProcedure.getName());
            _view.getTxtPriceP().setText(aestheticProcedure.getPrice() + "");
        }
    }
}
