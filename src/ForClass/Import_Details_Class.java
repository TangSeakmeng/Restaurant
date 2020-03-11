/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tang Seakmeng
 */
public class Import_Details_Class 
{

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
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
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the costOfSale
     */
    public float getCostOfSale() {
        return costOfSale;
    }

    /**
     * @param costOfSale the costOfSale to set
     */
    public void setCostOfSale(float costOfSale) {
        this.costOfSale = costOfSale;
    }
    
    private int importId;
    private int productId;
    private int quantity;
    private float costOfSale;
    private double total;

    public Import_Details_Class() {
    }

    public Import_Details_Class(int importId, int productId, int quantity, float costOfSale, double total) {
        this.importId = importId;
        this.productId = productId;
        this.quantity = quantity;
        this.costOfSale = costOfSale;
        this.total = total;
    }
    
    public static void addImportDetailsIntoDB(Import_Details_Class import_details)
    {
        try 
        {
            String sql = "insert into tblImportDetails(importid, productid, quantity, costofsale, subtotal) values (?,?,?,?,?)";
        
            PreparedStatement ps = DataConnection.getDataCon().prepareStatement(sql);
            
            ps.setString(1, import_details.getImportId() + "");
            ps.setString(2, import_details.getProductId()+ "");
            
            ps.setString(3, import_details.getQuantity()+ "");
            ps.setString(4, import_details.getCostOfSale()+ "");
            ps.setString(5, import_details.getTotal()+ "");
            
            ps.execute();
            ps.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
