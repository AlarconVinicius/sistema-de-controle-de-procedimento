/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Database.Models.AestheticProcedures;
import Views.ProcedureView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureViewHelper {

    private final ProcedureView _view;

    public AestheticProcedureViewHelper(ProcedureView view) {
        _view = view;
    }

    public void fillTable(List<AestheticProcedures> procedures) {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedures().getModel();
        tableModel.setNumRows(0);
        for (AestheticProcedures procedure : procedures) {
            tableModel.addRow(new Object[]{
                procedure.getId(),
                procedure.getName(),
                procedure.getPrice()
            });
        }
    }
}
