/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForComponent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tang Seakmeng
 */
public class SubJTable extends JTable{
    public void addRow(Object... row)
    {
        DefaultTableModel mod = (DefaultTableModel)this.getModel();
        mod.addRow(row);
    }
    
    public Object[] getRowAt(int rowIndex)
    {
        Object[] r = new Object[this.getColumnCount()];
        for (int i = 0; i < r.length; i++) 
            r[i] = this.getValueAt(rowIndex, i);
        return r;
    }
    
    public void removeRowAt(int rowIndex)
    {
        DefaultTableModel mod = (DefaultTableModel)this.getModel();
        mod.removeRow(rowIndex);
    }
    
    public void removeSelectedRow()
    {
        int numbers[] = this.getSelectedRows();
        for(int index = numbers.length - 1; index >= 0; index--)
            this.removeRowAt(numbers[index]);
    }
}
