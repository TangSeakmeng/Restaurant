/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForUserControl;

import ForClass.Temporary_Data;
import ForComponent.SubJTable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.graalvm.compiler.lir.LIRInstruction;

/**
 *
 * @author Tang Seakmeng
 */
public class ucService extends javax.swing.JPanel {

    /**
     * @return the order_table
     */
    public SubJTable getOrder_table() {
        return order_table;
    }

    /**
     * @param order_table the order_table to set
     */
    public void setOrder_table(SubJTable order_table) {
        this.order_table = order_table;
    }

    /**
     * @return the namePrice
     */
    public String getNamePrice() {
        return namePrice;
    }

    /**
     * @param namePrice the namePrice to set
     */
    public void setNamePrice(String namePrice) {
        this.namePrice = namePrice;
    }

    private String namePrice;
    
    static int time = 0;
    
    public ucService(String name, String Image, String price, SubJTable table) {
        initComponents();
        
        this.lbServiceName.setText(name);
        this.lbServicePrice.setText( "$ " + price);
        
        ImageIcon im = new ImageIcon(Image);
        jPictureBox1.setIcon(im);
        
        setOrder_table(table);
        
//        if(time == 0)
//        {
//            order_table = new SubJTable();
//            time++;
//        }
//        
//        System.out.println(order_table);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPictureBox1 = new ForComponent.JPictureBox();
        jPanel2 = new javax.swing.JPanel();
        lbServiceName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbServicePrice = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(190, 260));

        jPictureBox1.setBackground(new java.awt.Color(153, 153, 153));
        jPictureBox1.setImageMode(ForComponent.JPictureBox.mode.Zoom);
        jPictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPictureBox1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPictureBox1Layout = new javax.swing.GroupLayout(jPictureBox1);
        jPictureBox1.setLayout(jPictureBox1Layout);
        jPictureBox1Layout.setHorizontalGroup(
            jPictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
        jPictureBox1Layout.setVerticalGroup(
            jPictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbServiceName.setForeground(new java.awt.Color(255, 255, 255));
        lbServiceName.setText("jLabel1");
        jPanel2.add(lbServiceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 18, -1, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 18, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbServicePrice.setForeground(new java.awt.Color(255, 255, 255));
        lbServicePrice.setText("jLabel1");
        jPanel3.add(lbServicePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 16, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Price :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPictureBox1MouseClicked
        setNamePrice(lbServiceName.getText().trim() + "," + lbServicePrice.getText().trim());
        
        //JOptionPane.showMessageDialog(this, this.getNamePrice());
        
        String serviceName = lbServiceName.getText().trim();
        String servicePrice = lbServicePrice.getText().trim();
        
//        System.out.println(getOrder_table().getRowCount());
//        System.out.println(getOrder_table().getColumnCount());
        
//        getOrder_table().addRow(serviceName,"1",servicePrice);
        
//        -------------------------------------------------------------------------------------------
        
//        int n = getOrder_table().getRowCount();
//        boolean found = true;
//        int amount = 0;
//        
//        if(n > 0)
//        {
//            Object[] r2 = getOrder_table().getRowAt(0);
//            System.out.println(r2[0] + "");
//
//            amount = Integer.parseInt(r2[1] + "");
//            System.out.println(amount + "");
//            
//            found = false;
//        }
//        
//        if(found)
//        {
//            getOrder_table().addRow(serviceName,"1",servicePrice);
//        }
//        else
//        {
//            amount++;
//            getOrder_table().setValueAt(amount, 0, 1);
//        }

//        -------------------------------------------------------------------------------------------

        boolean found = false;
        int rowNumber = 0, amount = 0;
        String name = "";
        Object[] r = null;
        
        int n = getOrder_table().getRowCount();

        if(n > 0)
        {
            for(int index = 0; index < n; index++)
            {
                r = getOrder_table().getRowAt(index);

                System.out.println(r.length);
                System.out.println(r[0] + "");
                System.out.println(r[1] + "");

                name = r[0] + "";
                amount = Integer.parseInt(r[1] + "");

                if(name.equals(serviceName))
                {
                    found = true;
                    rowNumber = index;

                    System.out.println(found + ", " + rowNumber);
                }
            }
        }
       
        if(!found)
        {
            getOrder_table().addRow(serviceName,"1",servicePrice);
        }
        else
        {
            amount++;
            getOrder_table().setValueAt(amount, rowNumber, 1);
        }
        
//        -------------------------------------------------------------------------------------------
        
//        DefaultTableModel mod=(DefaultTableModel)order_table.getModel();
//        mod.addRow(new String[]{"", "", "1"});
//        
//        System.out.println(mod.getColumnCount());
//        
//        for(int index = 0; index < mod.getRowCount(); index++)
//        {
//            Object[] r = order_table.getRowAt(index);
//            System.out.println(r.length);
//        }
    }//GEN-LAST:event_jPictureBox1MouseClicked

    private ForComponent.SubJTable order_table;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private ForComponent.JPictureBox jPictureBox1;
    private javax.swing.JLabel lbServiceName;
    private javax.swing.JLabel lbServicePrice;
    // End of variables declaration//GEN-END:variables
}