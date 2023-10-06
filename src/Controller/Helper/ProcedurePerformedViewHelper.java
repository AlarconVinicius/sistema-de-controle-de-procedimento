/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller.Helper;

import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
import Views.ProcedurePerformedView;
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

    public void fillTable(List<ProceduresPerformed> proceduresPerfomed) {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedurePerformed().getModel();
        tableModel.setNumRows(0);
        double monthlyIncome = 0;
        for(ProceduresPerformed procedurePerformed : proceduresPerfomed){
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
    
    public void fillComboBox(List<AestheticProcedures> procedures) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) _view.getComboBoxProcedure().getModel();
        
        for(AestheticProcedures procedure : procedures){
            comboBoxModel.addElement(procedure);
        }
    }

}
