/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Business.Services.AestheticProcedureService;
import Database.Models.AestheticProcedure;
import Views.AestheticProcedureView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureViewHelper {

    private final AestheticProcedureView _view;

    public AestheticProcedureViewHelper(AestheticProcedureView view) {
        _view = view;
    }

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

    public int getId() {
        DefaultTableModel tableModel = (DefaultTableModel) _view.getTableProcedures().getModel();
        int selectedRows = _view.getTableProcedures().getSelectedRow();
        int id;
        try{
            id = Integer.parseInt(tableModel.getValueAt(selectedRows, 0).toString());
        } catch (NumberFormatException e){
            id = 0;
        }
        return id;
    }

    public AestheticProcedure getModel() {
        int id;
        try{
            id = Integer.parseInt(_view.getTxtId().getText());
        } catch (NumberFormatException e){
            id = 0;
        }
        String name = _view.getTxtNameP().getText();
        Double price = Double.parseDouble(_view.getTxtPriceP().getText());
        AestheticProcedure aestheticProcedure;
        
        if(id > 0) {
            aestheticProcedure = new AestheticProcedure(id, name, price);
        }else{
            aestheticProcedure = new AestheticProcedure(name, price);
        }
        return aestheticProcedure;
    }

    public void clearModel() {
        _view.getTxtId().setText("");
        _view.getTxtNameP().setText("");
        _view.getTxtPriceP().setText("");
    }

    public void setInputs(AestheticProcedure aestheticProcedure) {
        if (aestheticProcedure != null) {
            _view.getTxtId().setText(aestheticProcedure.getId() + "");
            _view.getTxtNameP().setText(aestheticProcedure.getName());
            _view.getTxtPriceP().setText(aestheticProcedure.getPrice() + "");
        }
    }
}
