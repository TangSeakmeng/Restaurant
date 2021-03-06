/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForUserControl;

import java.awt.Color;

/**
 *
 * @author Tang Seakmeng
 */
public class ucTable extends javax.swing.JPanel {

    /**
     * Creates new form ucTable
     */
    public ucTable() {
        initComponents();
    }
    
    public ucTable(String[] arr) {
        initComponents();
        
        lblTableNumber.setText(arr[0]);
        lbTableDescription.setText(arr[1]);
        lbNumberOfPeople.setText(arr[2]);
        lbStatus.setText(arr[3]);
        lbTime.setText(arr[4]);
        lbServiceOrder.setText(arr[6]);
        lbServicePending.setText(arr[7]);
        
        Color color = new Color(Integer.parseInt(arr[8]));
        this.setBackground(color);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        lblTableNumber = new javax.swing.JLabel();
        lbTableDescription = new javax.swing.JLabel();
        lbNumberOfPeople = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbServiceOrder = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbServicePending = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Table Number :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 19, 115, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Description :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 56, 115, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Num. Of People :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 93, -1, -1));

        lbStatus.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setText("Status:");
        add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 115, -1));

        lblTableNumber.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblTableNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblTableNumber.setText("001");
        add(lblTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 19, 44, -1));

        lbTableDescription.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTableDescription.setForeground(new java.awt.Color(255, 255, 255));
        lbTableDescription.setText("None");
        add(lbTableDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 56, 85, -1));

        lbNumberOfPeople.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbNumberOfPeople.setForeground(new java.awt.Color(255, 255, 255));
        lbNumberOfPeople.setText("10");
        add(lbNumberOfPeople, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 93, 75, -1));

        lbTime.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText("7 : 00 PM");
        add(lbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 130, 75, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Service Ordered :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 93, 120, -1));

        lbServiceOrder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbServiceOrder.setForeground(new java.awt.Color(255, 255, 255));
        lbServiceOrder.setText("001");
        add(lbServiceOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 73, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Service Pending :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 130, 130, -1));

        lbServicePending.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbServicePending.setForeground(new java.awt.Color(255, 255, 255));
        lbServicePending.setText("001");
        add(lbServicePending, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 73, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbNumberOfPeople;
    private javax.swing.JLabel lbServiceOrder;
    private javax.swing.JLabel lbServicePending;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTableDescription;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lblTableNumber;
    // End of variables declaration//GEN-END:variables
}
