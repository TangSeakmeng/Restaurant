/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import ForComponent.SubJTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tang Seakmeng
 */
public class Temporary_Data {

    /**
     * @return the temporary_table
     */
    public SubJTable getTemporary_table() {
        return temporary_table;
    }

    /**
     * @param temporary_table the temporary_table to set
     */
    public void setTemporary_table(SubJTable temporary_table) {
        this.temporary_table = temporary_table;
    }
    
    private SubJTable temporary_table;

    public Temporary_Data() {
        //temporary_table = new SubJTable();
    }
    
    public void addData(String col1, String col2, String col3)
    {
        DefaultTableModel mod = (DefaultTableModel) temporary_table.getModel();
        mod.addRow(new String[]{"", "", ""});
        
//        temporary_table.addRow(col1, col2, col3);
        
        System.out.println("hello");
        System.out.println(mod.getRowCount());
        System.out.println(mod.getColumnCount());
        
//        for(int index = 0; index < temporary_table.getRowCount(); index++)
//        {
//            Object[] r = temporary_table.getRowAt(index);
//            System.out.println(r.length);
//        }
    }
}
