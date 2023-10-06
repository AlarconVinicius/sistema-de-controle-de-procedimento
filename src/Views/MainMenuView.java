/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controller.MainMenuController;

/**
 *
 * @author alarc
 */
public class MainMenuView extends javax.swing.JFrame {

    private final MainMenuController _controller;

    /**
     * Creates new form MainMenuView
     */
    public MainMenuView() {
        initComponents();
        _controller = new MainMenuController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        menuProcedures = new javax.swing.JMenuItem();
        menuProcePerformed = new javax.swing.JMenuItem();
        menuProfile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Menu.png"))); // NOI18N

        mainMenu.setText("Menu");

        menuProcedures.setText("Procedimentos");
        menuProcedures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProceduresActionPerformed(evt);
            }
        });
        mainMenu.add(menuProcedures);

        menuProcePerformed.setText("Procedimentos Realizados");
        menuProcePerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProcePerformedActionPerformed(evt);
            }
        });
        mainMenu.add(menuProcePerformed);

        menuProfile.setText("Perfil");
        mainMenu.add(menuProfile);

        jMenuBar1.add(mainMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelBackground)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelBackground)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuProceduresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProceduresActionPerformed
        _controller.navigateToProcedures();
    }//GEN-LAST:event_menuProceduresActionPerformed

    private void menuProcePerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcePerformedActionPerformed
        _controller.navigateToProceduresPerformed();
    }//GEN-LAST:event_menuProcePerformedActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuItem menuProcePerformed;
    private javax.swing.JMenuItem menuProcedures;
    private javax.swing.JMenuItem menuProfile;
    // End of variables declaration//GEN-END:variables
}
