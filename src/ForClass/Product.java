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
public class Product {

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
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the productBarcode
     */
    public String getProductBarcode() {
        return productBarcode;
    }

    /**
     * @param productBarcode the productBarcode to set
     */
    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the unitInStock
     */
    public int getUnitInStock() {
        return unitInStock;
    }

    /**
     * @param unitInStock the unitInStock to set
     */
    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
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

    /**
     * @return the salePrice
     */
    public float getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    private String productId;
    private String productBarcode;
    private String productName;
    
    private String CategoryId;
    private String categoryName;
    
    private int unitInStock;
    private float costOfSale;
    private float salePrice;
    private String imagePath;
    
    public Product() {
    
    }

    public Product(String productId, String productBarcode, String productName, String CategoryId, String categoryName, int unitInStock, float costOfSale, float salePrice, String imagePath) {
        this.productId = productId;
        this.productBarcode = productBarcode;
        this.productName = productName;
        this.CategoryId = CategoryId;
        this.categoryName = categoryName;
        this.unitInStock = unitInStock;
        this.costOfSale = costOfSale;
        this.salePrice = salePrice;
        this.imagePath = imagePath;
    }
    
    
    
    public Product(Product temp)
    {
        this.productId = temp.productId;
        this.productBarcode = temp.productBarcode;
        this.productName = temp.productName;
        this.CategoryId = temp.CategoryId;
        this.categoryName = temp.categoryName;
        this.unitInStock = temp.unitInStock;
        this.costOfSale = temp.costOfSale;
        this.salePrice = temp.salePrice;
        this.imagePath = temp.imagePath;
    }
    
    public static void addProductIntoDB(Product p)
    {
        try 
        {
//            String sql = "insert into tblProduct(Barcode, Name, CategoryId, UnitInStock, CostOfSale, SalePrice, ImagePath) "
//                    + "values(:Barcode, :Name, :CategoryId, :UnitInStock, :CostOfSale, :SalePrice, :ImagePath)";
            
            PreparedStatement s = DataConnection.getDataCon().prepareStatement("insert into tblProduct(Barcode, Name, CategoryId, UnitInStock, CostOfSale, SalePrice, Image) values(?, ?, ?, ?, ?, ?, ?)");
            
            s.setString(1, p.getProductBarcode());
            s.setString(2, p.getProductName());
            s.setString(3, p.getCategoryId());
            s.setString(4, p.getUnitInStock() + "");
            s.setString(5, p.getCostOfSale() + "");
            s.setString(6, p.getSalePrice() + "");
            s.setString(7, p.getImagePath() + "");
            
            s.execute();
            s.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteProductFromDB(String Barcode)
    {
        try 
        {
            String sql = "delete from tblProduct where Barcode = ?";
            PreparedStatement p = DataConnection.getDataCon().prepareStatement(sql);
            p.setString(1, Barcode);
            p.execute();
            p.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateProductFromDB(Product product)
    {
        try 
        {
            String sql = "update tblproduct set name = ?, categoryid = ?, unitinstock = ?, costofsale = ?, saleprice = ?, image = ?"
                    + " where barcode = ?";
            
            PreparedStatement s = DataConnection.getDataCon().prepareStatement(sql);
            
            s.setString(1, product.getProductName());
            s.setString(2, product.getCategoryId());
            s.setString(3, product.getUnitInStock() + "");
            s.setString(4, product.getCostOfSale() + "");
            s.setString(5, product.getSalePrice() + "");
            s.setString(6, product.getImagePath() + "");
            s.setString(7, product.getProductBarcode()+ "");
            
            s.execute();
            s.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static Product getProductUsingProductBarcode(String barcode)
    {
        Product product = new Product();
        
        try 
        {
            String sql = "select p.name, c.categoryName, costofsale, saleprice, "
                    + "image from tblProduct p inner join tblcategory c on p.categoryid = c.id where p.barcode = '" + barcode + "'";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                product.setProductName(r.getString(1) + "");
                product.setCategoryName(r.getString(2) + "");
                product.setCostOfSale(Float.parseFloat(r.getString(3) + ""));
                product.setSalePrice(Float.parseFloat(r.getString(4) + ""));
                product.setImagePath(r.getString(5) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return product;
    }
    
    public static int getProductIdUsingBarcode(String barcode)
    {
        int productId = 0;
        
        try
        {
            String sql = "select id from tblProduct where barcode = '" + barcode + "'";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                productId = Integer.parseInt("" + r.getString(1));
            }
            
            r.close();
        } 
        catch (NumberFormatException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return productId;
    }
    
    public static int getProductIdUsingProductName(String productName)
    {
        int productId = 0;
        
        try
        {
            String sql = "select id from tblProduct where name = '" + productName + "'";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                productId = Integer.parseInt("" + r.getString(1));
            }
            
            r.close();
        } 
        catch (NumberFormatException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return productId;
    }
    
    public static String getProductNameUsingProductBarcode(String Barcode)
    {
        String productName = "";
        
        try
        {
            String sql = "select name from tblProduct where barcode = '" + Barcode + "'";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                productName = "" + r.getString(1);
            }
            
            r.close();
        } 
        catch (NumberFormatException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return productName;
    }
    
    public static boolean isExistedInProductDB(String barcode)
    {
        boolean result = false;
        
        try
        {
            String sql = "select count(*) from tblProduct where barcode = '" + barcode + "'";
            
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                if(Integer.parseInt(r.getString(1) + "") > 0)
                    result = true;
            }
            
            r.close();
        } 
        catch (NumberFormatException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return result;
    }
}
