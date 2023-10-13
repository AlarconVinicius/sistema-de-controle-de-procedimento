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
package Views;

import Controller.AestheticProcedureController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Classe que representa a interface gráfica para gerenciamento de procedimentos
 * estéticos. Esta classe fornece funcionalidades para adicionar, atualizar e
 * excluir procedimentos estéticos. Ela também exibe uma lista de procedimentos
 * estéticos disponíveis.
 *
 * A classe utiliza um controller para realizar operações de gerenciamento de
 * procedimentos estéticos.
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureView extends javax.swing.JFrame {

    /**
     * Controlador para operações relacionadas a procedimentos estéticos
     */
    private final AestheticProcedureController _controller;

    /**
     * Cria uma nova instância da classe AestheticProcedureView. Essa instância
     * é responsável por exibir a interface gráfica para gerenciamento de
     * procedimentos estéticos.
     */
    public AestheticProcedureView() {
        initComponents();
        this.setLocationRelativeTo(null);
        _controller = new AestheticProcedureController(this);
        initView();
    }

    /**
     * Inicializa os componentes da interface gráfica. Isso inclui a
     * configuração de botões, campos de texto e tabelas.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        labelNameP = new javax.swing.JLabel();
        txtNameP = new javax.swing.JTextField();
        labelPrice = new javax.swing.JLabel();
        txtPriceP = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProcedures = new javax.swing.JTable();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtId.setEditable(false);
        txtId.setText("jTextField1");
        txtId.setUI(null);
        txtId.setActionCommand("<Not Set>");
        txtId.setFocusable(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        labelNameP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNameP.setForeground(new java.awt.Color(255, 255, 255));
        labelNameP.setText("Nome: ");
        getContentPane().add(labelNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 30));
        getContentPane().add(txtNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 220, 30));

        labelPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelPrice.setForeground(new java.awt.Color(255, 255, 255));
        labelPrice.setText("Valor: ");
        getContentPane().add(labelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, 30));
        getContentPane().add(txtPriceP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 180, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 80, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 80, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 80, -1));

        tableProcedures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Botox", "1000"},
                {"2", "Preenchimento Labial", "800"},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Procedimento", "Valor"
            }
        ));
        tableProcedures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProceduresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProcedures);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 560, 290));

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/TelasMenu.png"))); // NOI18N
        getContentPane().add(labelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        _controller.createAestheticProcedure();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        _controller.updateAestheticProcedure();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        _controller.deleteAestheticProcedure();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableProceduresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProceduresMouseClicked
        _controller.updateInputs();
    }//GEN-LAST:event_tableProceduresMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AestheticProcedureView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AestheticProcedureView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AestheticProcedureView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AestheticProcedureView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AestheticProcedureView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelNameP;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JTable tableProcedures;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNameP;
    private javax.swing.JTextField txtPriceP;
    // End of variables declaration//GEN-END:variables
    /**
     * Inicializa a visualização da interface gráfica. Essa função é chamada
     * após a criação da instância da classe para configurar a visualização
     * inicial.
     */
    private void initView() {
        _controller.updateTable();
    }

    /**
     *
     * @return
     */
    public JTable getTableProcedures() {
        return tableProcedures;
    }

    /**
     *
     * @param tableProcedures
     */
    public void setTableProcedures(JTable tableProcedures) {
        this.tableProcedures = tableProcedures;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtId() {
        return txtId;
    }

    /**
     *
     * @param txtId
     */
    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtNameP() {
        return txtNameP;
    }

    /**
     *
     * @param txtNameP
     */
    public void setTxtNameP(JTextField txtNameP) {
        this.txtNameP = txtNameP;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPriceP() {
        return txtPriceP;
    }

    /**
     *
     * @param txtPriceP
     */
    public void setTxtPriceP(JTextField txtPriceP) {
        this.txtPriceP = txtPriceP;
    }

    /**
     * Exibe uma mensagem na tela.
     *
     * @param message Mensagem a ser exibida.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
