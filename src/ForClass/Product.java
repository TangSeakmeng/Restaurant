/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.sql.PreparedStatement;

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
        catch (Exception e) 
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
}
