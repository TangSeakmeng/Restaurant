/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Injection;

/**
 *
 * @author Tang Seakmeng
 */
public class Test_UC_Generator extends javax.swing.JFrame {

    /**
     * Creates new form Test_UC_Generator
     */
    public Test_UC_Generator() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        uC_Generator1 = new ForPanel.UC_Generator();
        btnDrink = new javax.swing.JButton();
        btnMainFood = new javax.swing.JButton();
        btnDesssert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(uC_Generator1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1390, 600));

        btnDrink.setText("Drink");
        btnDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(btnDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 30, 120, 60));

        btnMainFood.setText("MainFood");
        btnMainFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainFoodActionPerformed(evt);
            }
        });
        getContentPane().add(btnMainFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 120, 60));

        btnDesssert.setText("Dessert");
        btnDesssert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesssertActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesssert, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, 120, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrinkActionPerformed
        uC_Generator1.getUC(btnDrink.getText());
    }//GEN-LAST:event_btnDrinkActionPerformed

    private void btnMainFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainFoodActionPerformed
        uC_Generator1.getUC(btnMainFood.getText());
    }//GEN-LAST:event_btnMainFoodActionPerformed

    private void btnDesssertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesssertActionPerformed
        uC_Generator1.getUC(btnDesssert.getText());
    }//GEN-LAST:event_btnDesssertActionPerformed

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
            java.util.logging.Logger.getLogger(Test_UC_Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test_UC_Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test_UC_Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test_UC_Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test_UC_Generator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesssert;
    private javax.swing.JButton btnDrink;
    private javax.swing.JButton btnMainFood;
    private javax.swing.JScrollPane jScrollPane1;
    private ForPanel.UC_Generator uC_Generator1;
    // End of variables declaration//GEN-END:variables
}
