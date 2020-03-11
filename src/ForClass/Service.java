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

/**
 *
 * @author Tang Seakmeng
 */
public class Service {

    /**
     * @return the ProductBarcode
     */
    public String getProductBarcode() {
        return ProductBarcode;
    }

    /**
     * @param ProductBarcode the ProductBarcode to set
     */
    public void setProductBarcode(String ProductBarcode) {
        this.ProductBarcode = ProductBarcode;
    }

    /**
     * @return the Size
     */
    public String getSize() {
        return Size;
    }

    /**
     * @param Size the Size to set
     */
    public void setSize(String Size) {
        this.Size = Size;
    }

    /**
     * @return the ServiceBarcode
     */
    public String getServiceBarcode() {
        return ServiceBarcode;
    }

    /**
     * @param ServiceBarcode the ServiceBarcode to set
     */
    public void setServiceBarcode(String ServiceBarcode) {
        this.ServiceBarcode = ServiceBarcode;
    }

    /**
     * @return the ServiceName
     */
    public String getServiceName() {
        return ServiceName;
    }

    /**
     * @param ServiceName the ServiceName to set
     */
    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    /**
     * @return the CategoryId
     */
    public String getCategoryId() {
        return CategoryId;
    }

    /**
     * @param CategoryId the CategoryId to set
     */
    public void setCategoryId(String CategoryId) {
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

    /**
     * @return the SalePrice
     */
    public double getSalePrice() {
        return SalePrice;
    }

    /**
     * @param SalePrice the SalePrice to set
     */
    public void setSalePrice(double SalePrice) {
        this.SalePrice = SalePrice;
    }

    /**
     * @return the ImagePath
     */
    public String getImagePath() {
        return ImagePath;
    }

    /**
     * @param ImagePath the ImagePath to set
     */
    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }
    private String ServiceBarcode;
    private String ServiceName;
    private String CategoryId;
    private String CategoryName;
    private double SalePrice;
    private String ProductBarcode;
    private String ImagePath;
    private String Size;

    public Service() {
    }

    public Service(String ServiceBarcode, String ServiceName, String CategoryId, String CategoryName, double SalePrice, String ProductBarcode, String ImagePath, String Size) {
        this.ServiceBarcode = ServiceBarcode;
        this.ServiceName = ServiceName;
        this.CategoryId = CategoryId;
        this.CategoryName = CategoryName;
        this.SalePrice = SalePrice;
        this.ProductBarcode = ProductBarcode;
        this.ImagePath = ImagePath;
        this.Size = Size;
    }

    public static void addServiceIntoDB(Service s)
    {
        try 
        {
            String sql = "insert into tblService(Barcode, Name, ServiceCategoryId, ProductId, price, Image) "
                    + "values(?,?,?,?,?,?)";
            
            PreparedStatement p_sql = DataConnection.getDataCon().prepareStatement(sql);
            
            p_sql.setString(1, s.getServiceBarcode());
            p_sql.setString(2, s.getServiceName());
            p_sql.setString(3, s.getCategoryId());
            p_sql.setString(4, Product.getProductIdUsingBarcode(s.getProductBarcode())+ "");
            p_sql.setString(5, s.getSalePrice()+ "");
            p_sql.setString(6, s.getImagePath()+ "");
            
            p_sql.execute();
            p_sql.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static int countService()
    {
        int count = 0;
        
        try
        {
            String sql = "select count(*) from tblService";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                count = Integer.parseInt("" + r.getString(1));
            }
            
            r.close();
        } 
        catch (NumberFormatException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return count;
    }
    
    public static void deleteServiceByBarcode(String barcode)
    {
        try {
            String sql = "delete from tblService where barcode = ?";
            
            PreparedStatement p_sql = DataConnection.getDataCon().prepareStatement(sql);
            
            p_sql.setString(1, barcode);
            
            p_sql.execute();
            p_sql.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateServiceByBarcode(Service s)
    {
        try 
        {
            String sql = "update tblService set name = ?, price = ?, servicecategoryid = ?, productid = ?, image = ? where barcode = ?";
            PreparedStatement p = DataConnection.getDataCon().prepareCall(sql);
            p.setString(1, s.getServiceName());
            p.setString(2, s.getSalePrice() + "");
            p.setString(3, ServiceCategory.getCategoryIdFromDB(s.getCategoryName())+ "");
            p.setString(4, Product.getProductIdUsingBarcode(s.getProductBarcode()) + "");
            p.setString(5, s.getImagePath());
            p.setString(6, s.getServiceBarcode());
            
            p.execute();
            p.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
