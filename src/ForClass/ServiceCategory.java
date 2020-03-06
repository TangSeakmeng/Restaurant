/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tang Seakmeng
 */
public class ServiceCategory {

    /**
     * @return the ServiceCategoryId
     */
    public String getServiceCategoryId() {
        return ServiceCategoryId;
    }

    /**
     * @param ServiceCategoryId the ServiceCategoryId to set
     */
    public void setServiceCategoryId(String ServiceCategoryId) {
        this.ServiceCategoryId = ServiceCategoryId;
    }

    /**
     * @return the ServiceCategoryName
     */
    public String getServiceCategoryName() {
        return ServiceCategoryName;
    }

    /**
     * @param ServiceCategoryName the ServiceCategoryName to set
     */
    public void setServiceCategoryName(String ServiceCategoryName) {
        this.ServiceCategoryName = ServiceCategoryName;
    }
    
    private String ServiceCategoryId;
    private String ServiceCategoryName;

    public ServiceCategory() {
    }

    public ServiceCategory(String ServiceCategoryId, String ServiceCategoryName) {
        this.ServiceCategoryId = ServiceCategoryId;
        this.ServiceCategoryName = ServiceCategoryName;
    }
    
    public static String getCategoryIdFromDB(String categoryName)
    {
        String CategoryId = "";
        
        try 
        {
            String sql = "select id from tblservicecategory where CategoryName = '" + categoryName + "'";
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
