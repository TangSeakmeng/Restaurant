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
public class ProductCategory {

    /**
     * @return the CategoryId
     */
    public int getCategoryId() {
        return CategoryId;
    }

    /**
     * @param CategoryId the CategoryId to set
     */
    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    /**
     * @return the CategoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     * @param CategoryName the CategoryName to set
     */
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
    private String CategoryName;
    private int CategoryId;

    public ProductCategory() {
    }

    public ProductCategory(String CategoryName, int CategoryId) {
        this.CategoryName = CategoryName;
        this.CategoryId = CategoryId;
    }
    
    public static void insertProductCategoryFromDB(ProductCategory productCategory)
    {
        try 
        {
            String sql = "insert into tblcategory(categoryname) values(?)";
            
            PreparedStatement s = DataConnection.getDataCon().prepareStatement(sql);
            
            s.setString(1, productCategory.getCategoryName());
            s.execute();
            s.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteProductCategoryFromDB(int productCategoryid)
    {
        try 
        {
            String sql = "delete from tblcategory where id = ?";
            
            PreparedStatement s = DataConnection.getDataCon().prepareStatement(sql);
            
            s.setString(1, productCategoryid + "");
            s.execute();
            s.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateProductCategoryFromDB(ProductCategory productCategory)
    {
        try 
        {
            String sql = "update tblcategory set categoryname = ? where id = ?";
            
            PreparedStatement s = DataConnection.getDataCon().prepareStatement(sql);
            
            s.setString(1, productCategory.getCategoryName()+ "");
            s.setString(2, productCategory.getCategoryId() + "");
            s.execute();
            s.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<ProductCategory> getCategoryFromDB()
    {
        List<ProductCategory> list_productcategory = new ArrayList<>();
        
        try 
        {
            String sql = "select id, CategoryName from tblCategory";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            ProductCategory pc;
            
            while(r.next())
            {
                pc = new ProductCategory();
                
                pc.setCategoryId(Integer.parseInt(r.getString(1)));
                pc.setCategoryName(r.getString(2));
                
                list_productcategory.add(pc);
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return list_productcategory;
    }
    
    public static int getCategoryIdUsingCategoryName(String categoryName)
    {
        int categoryId = 1;
        
        try 
        {
            String sql = "select id from tblCategory where categoryName = '" + categoryName + "'";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                categoryId = Integer.parseInt(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (NumberFormatException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return categoryId;
    }
}
