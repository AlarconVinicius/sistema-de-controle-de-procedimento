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
import Database.Models.ProcedurePerformed;
import Views.ProcedurePerformedView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * Classe auxiliar para a ProcedurePerformedView, responsável por lidar com
 * dados e interações relacionados aos procedimentos realizados.
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedViewHelper {

    private final ProcedurePerformedView _view;

    /**
     * Construtor para o ProcedurePerformedViewHelper.
     *
     * @param view A ProcedurePerformedView a ser assistida.
     */
    public ProcedurePerformedViewHelper(ProcedurePerformedView view) {
        _view = view;
    }

    /**
     * Preenche a tabela na visualização com uma lista de objetos
     * ProcedurePerformed.
     *
     * @param proceduresPerformed A lista de objetos ProcedurePerformed a ser
     * exibida na tabela.
     */
    public void fillTable(List<ProcedurePerformed> proceduresPerformed) {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedurePerformed().getModel();
        tableModel.setNumRows(0);
        double monthlyIncome = 0;
        for (ProcedurePerformed procedurePerformed : proceduresPerformed) {
            tableModel.addRow(new Object[]{
                procedurePerformed.getId(),
                procedurePerformed.getProcedure().getName(),
                procedurePerformed.getDate(),
                procedurePerformed.getAmountReceived(),
                ""
            });
            monthlyIncome += procedurePerformed.getAmountReceived();
        }
        tableModel.addRow(new Object[]{
            "",
            "",
            "",
            "",
            monthlyIncome
        });
    }

    /**
     * Preenche o ComboBox na visualização com uma lista de objetos
     * AestheticProcedure.
     *
     * @param procedures A lista de objetos AestheticProcedure a ser exibida no
     * ComboBox.
     */
    public void fillComboBox(List<AestheticProcedure> procedures) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) _view.getComboBoxProcedure().getModel();

        for (AestheticProcedure procedure : procedures) {
            comboBoxModel.addElement(procedure);
        }
    }

    /**
     * Obtém o procedimento selecionado no ComboBox.
     *
     * @return O procedimento estético selecionado no ComboBox.
     */
    public AestheticProcedure getProcedure() {
        return (AestheticProcedure) _view.getComboBoxProcedure().getSelectedItem();
    }

    /**
     * Define o valor recebido com base no preço do procedimento selecionado.
     *
     * @param price O preço do procedimento estético.
     */
    public void setAmountReceived(double price) {
        _view.getTxtAmountReceivedP().setText(price + "");
    }

    /**
     * Define a data atual nos campos de data na visualização.
     */
    public void setDate() {
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateNowString = dateNow.format(formatter);
        _view.getTxtDateP().setText(dateNowString);
    }

    /**
     * Obtém o ID do procedimento realizado selecionado na tabela.
     *
     * @return O ID do procedimento realizado selecionado na tabela, ou 0 se
     * nenhum estiver selecionado ou se o ID não for um número válido.
     */
    public int getId() {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedurePerformed().getModel();
        int selectedRow = _view.getTableProcedurePerformed().getSelectedRow();
        int id;
        try {
            id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        } catch (NumberFormatException e) {
            id = 0;
        }
        return id;
    }

    /**
     * Define os campos de entrada na visualização com dados de um objeto
     * ProcedurePerformed.
     *
     * @param procedurePerformed O objeto ProcedurePerformed a ser exibido nos
     * campos da visualização.
     */
    public void setInputs(ProcedurePerformed procedurePerformed) {
        if (procedurePerformed != null) {
            DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) _view.getComboBoxProcedure().getModel();
            comboBoxModel.setSelectedItem(procedurePerformed.getProcedure());
            _view.getTxtId().setText(procedurePerformed.getId() + "");
            _view.getComboBoxProcedure().setSelectedItem(procedurePerformed.getProcedure());
            _view.getTxtDateP().setText(procedurePerformed.getDate());
            _view.getTxtAmountReceivedP().setText(procedurePerformed.getAmountReceived() + "");
        }
    }

    /**
     * Obtém o modelo de ProcedurePerformed a partir dos campos de entrada na
     * visualização.
     *
     * @return Um objeto ProcedurePerformed preenchido com os dados dos campos
     * de entrada na visualização.
     */
    public ProcedurePerformed getModel() {
        int id;
        try {
            id = Integer.parseInt(_view.getTxtId().getText());
        } catch (NumberFormatException e) {
            id = 0;
        }
        AestheticProcedure procedure = getProcedure();
        String date = _view.getTxtDateP().getText();
        Double amountReceived = Double.parseDouble(_view.getTxtAmountReceivedP().getText());
        ProcedurePerformed procedurePerformed;

        if (id > 0) {
            procedurePerformed = new ProcedurePerformed(id, date, procedure.getId(), amountReceived);
        } else {
            procedurePerformed = new ProcedurePerformed(date, procedure.getId(), amountReceived);
        }
        return procedurePerformed;
    }

    /**
     * Limpa os campos de entrada na visualização.
     */
    public void clearModel() {
        _view.getTxtId().setText("");
        setDate();
        _view.getTxtAmountReceivedP().setText("");
    }
}
