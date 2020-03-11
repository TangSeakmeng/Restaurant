/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForComponent;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Tang Seakmeng
 */
public class SubJTable extends JTable{

    /**
     * @return the row1
     */
    public Color getRow1() {
        return row1;
    }

    /**
     * @param row1 the row1 to set
     */
    public void setRow1(Color row1) {
        this.row1 = row1;
    }

    /**
     * @return the row2
     */
    public Color getRow2() {
        return row2;
    }

    /**
     * @param row2 the row2 to set
     */
    public void setRow2(Color row2) {
        this.row2 = row2;
    }
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

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) 
    {
        Component com = super.prepareRenderer(renderer, row, column);
        
        if(row % 2 == 0 && !isCellSelected(row, column))
        {
            com.setBackground(getRow1());
        }
        else if(!isCellSelected(row, column))
        {
            com.setBackground(getRow2());
        }
        
        return com;
    }
    
    private Color row1 = this.getBackground();
    private Color row2 = this.getBackground();
}
