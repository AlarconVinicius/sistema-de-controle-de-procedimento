/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedViewHelper {

    private final ProcedurePerformedView _view;

    public ProcedurePerformedViewHelper(ProcedurePerformedView view) {
        _view = view;
    }

    public void fillTable(List<ProcedurePerformed> proceduresPerfomed) {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedurePerformed().getModel();
        tableModel.setNumRows(0);
        double monthlyIncome = 0;
        for (ProcedurePerformed procedurePerformed : proceduresPerfomed) {
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

    public void fillComboBox(List<AestheticProcedure> procedures) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) _view.getComboBoxProcedure().getModel();

        for (AestheticProcedure procedure : procedures) {
            comboBoxModel.addElement(procedure);
        }
    }

    public AestheticProcedure getProcedure() {
        return (AestheticProcedure) _view.getComboBoxProcedure().getSelectedItem();
    }

    public void setAmountReceived(double price) {
        _view.getTxtAmountReceivedP().setText(price + "");
    }

    public void setDate() {
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateNowString = dateNow.format(formatter);
        _view.getTxtDateP().setText(dateNowString);
    }

    public int getId() {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedurePerformed().getModel();
        int selectedRows = _view.getTableProcedurePerformed().getSelectedRow();
        int id;
        try{
            id = Integer.parseInt(tableModel.getValueAt(selectedRows, 0).toString());
        } catch (NumberFormatException e){
            id = 0;
        }
        return id;
    }
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
    public ProcedurePerformed getModel(){
        int id;
        try{
            id = Integer.parseInt(_view.getTxtId().getText());
        } catch (NumberFormatException e){
            id = 0;
        }
        AestheticProcedure procedure = getProcedure();
        String date = _view.getTxtDateP().getText();
        Double amountReceived = Double.parseDouble(_view.getTxtAmountReceivedP().getText());
        ProcedurePerformed procedurePerformed;
        
        if(id > 0) {
            procedurePerformed = new ProcedurePerformed(id, date, procedure.getId(), amountReceived);
        }else{
            procedurePerformed = new ProcedurePerformed(date, procedure.getId(), amountReceived);
        }
        return procedurePerformed;
    }
    
    public void clearModel() {
        _view.getTxtId().setText("");
        setDate();
        _view.getTxtAmountReceivedP().setText("");
    }
}
