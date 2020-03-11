/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tang Seakmeng
 */
public class Import_Master_Class {

    /**
     * @return the tax
     */
    public float getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(float tax) {
        this.tax = tax;
    }

    /**
     * @return the importId
     */
    public int getImportId() {
        return importId;
    }

    /**
     * @param importId the importId to set
     */
    public void setImportId(int importId) {
        this.importId = importId;
    }

    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the importDate
     */
    public String getImportDate() {
        return importDate;
    }

    /**
     * @param importDate the importDate to set
     */
    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the supplierId
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the staffId
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * @param staffId the staffId to set
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    private int importId;
    private String invoiceNumber;
    private String importDate;
    private double subtotal;
    private int supplierId;
    private String supplierName;
    private int staffId;
    private float tax;

    public Import_Master_Class() {
    }

    public Import_Master_Class(int importId, String invoiceNumber, String importDate, double subtotal, int supplierId, String supplierName, int staffId, float tax) {
        this.importId = importId;
        this.invoiceNumber = invoiceNumber;
        this.importDate = importDate;
        this.subtotal = subtotal;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.staffId = staffId;
        this.tax = tax;
    }
    
    public static void addImportIntoDB(Import_Master_Class im)
    {
        try 
        {
            String sql = "insert into tblImport(invoicenumber, importdate, subtotal, supplierid, staffid, tax, id) values (?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement =  DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, im.getInvoiceNumber());
           
            preparedStatement.setString(2, im.getImportDate());
            preparedStatement.setString(3, im.getSubtotal() + "");
            preparedStatement.setString(4, im.getSupplierId() + "");
            preparedStatement.setString(5, im.getStaffId() + "");
            preparedStatement.setString(6, im.getTax() + "");
            preparedStatement.setString(7, im.getImportId() + "");
            
            preparedStatement.execute();
            preparedStatement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static int getMaxImportIdFromDB()
    {
        int importId = 0;
        
        try 
        {
            String sql = "select max(id) from tblImport;";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);

            while(r.next())
            {
                if(r.getString(1) != null)
                    importId = Integer.parseInt(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return importId;
    }
    
    public static List<String> getImportFromDB()
    {
        List<String> arr_str = new ArrayList<>();
        String str = "";
        
        try 
        {
            String sql = "select im.id, im.importdate, im.subtotal, im.invoicenumber, sp.suppliername, st.FullName\n" +
                             "from tblImport im\n" +
                             "inner join tblsupplier sp\n" +
                             "on im.supplierid = sp.id\n" +
                             "inner join tblstaff st\n" +
                             "on im.staffid = st.id;";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);

            while(r.next())
            {
                if(r.getString(1) != null)
                {
                    str = r.getString(1) + "@" + r.getString(2) + "@" + 
                            r.getString(3) + "@" + r.getString(4) + "@" + 
                            r.getString(5) + "@" + r.getString(6);
                    
                    arr_str.add(str);
                }
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return arr_str;
    }
}
