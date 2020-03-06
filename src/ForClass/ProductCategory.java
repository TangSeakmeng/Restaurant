/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
    
    public static String getCategoryIdFromDB(String CategoryName)
    {
        String CategoryId = "";
        
        try 
        {
            String sql = "select id from tblCategory where CategoryName = '" + CategoryName + "'";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                CategoryId = r.getString(1);
            }
            
            r.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
        return CategoryId;
    }
}
