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
public class Supplier 
{

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
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    private int supplierId;
    private String supplierName;
    private String phoneNumber;
    private String email;
    private String address;

    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName, String phoneNumber, String email, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
    
    public static List<Supplier> getSupplierFromDB()
    {
        List<Supplier> list_supplier = new ArrayList<>();
        
        try 
        {
            String sql = "select id, suppliername, phonenumber, email, address from tblSupplier";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            Supplier supplier;
            
            while(r.next())
            {
                supplier = new Supplier();
                
                supplier.setSupplierId(Integer.parseInt(r.getString(1) + ""));
                supplier.setSupplierName(r.getString(2) + "");
                supplier.setPhoneNumber(r.getString(3) + "");
                supplier.setEmail(r.getString(4) + "");
                supplier.setAddress(r.getString(5) + "");
                
                list_supplier.add(supplier);
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return list_supplier;
    }
    
    public static List<String> getSupplierNameFromDB()
    {
        List<String> list_supplier = new ArrayList<>();
        
        try 
        {
            String sql = "select suppliername from tblSupplier";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                list_supplier.add(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return list_supplier;
    }
    
    public static int getSupplierIdFromDBUsingSuppliername(String supplierName)
    {
        int supplierId = 0;
        
        try 
        {
            String sql = "select Id from tblSupplier where suppliername = '" + supplierName + "';";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                supplierId = Integer.parseInt(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return supplierId;
    }
    
    public static void addSupplierIntoDB(Supplier supplier)
    {
        try 
        {
            String sql = "insert into tblsupplier(suppliername, phonenumber, email, address) values(?,?,?,?)";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getPhoneNumber());
            preparedStatement.setString(3, supplier.getEmail());
            preparedStatement.setString(4, supplier.getAddress());
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateSupplierInDB(Supplier supplier)
    {
        try 
        {
            String sql = "update tblSupplier set suppliername=?, phonenumber=?, email=?, address=? where id=?";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getSupplierName());
            preparedStatement.setString(3, supplier.getSupplierName());
            preparedStatement.setString(4, supplier.getSupplierName());
            preparedStatement.setString(5, supplier.getSupplierId() + "");
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteSupplierFromDB(int supplierId)
    {
        try 
        {
            String sql = "delete from tblSupplier where id=?;";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, supplierId + "");
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static int getMaxSupplierIdFromDB()
    {
        int supplierId = 0;
        
        try 
        {
            String sql = "select max(id) from tblSupplier";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                if(r.getString(1) != null)
                    supplierId = Integer.parseInt(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return supplierId;
    }
}
