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
public class Staff {

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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the nationalId
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * @param nationalId the nationalId to set
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    private int staffId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String telephone;
    private String email;
    private String position;
    private String nationalId;
    private String image;

    public Staff() 
    {
        
    }

    public Staff(int staffId, String name, String gender, String dateOfBirth, String address, String telephone, 
            String email, String position, String nationalId, String image) 
    {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.position = position;
        this.nationalId = nationalId;
        this.image = image;
        this.staffId = staffId;
    }
    
    public static void addStaffIntoDB(Staff s)
    {
        try 
        {
            String sql = "insert into tblStaff(fullname, gender, dateofbirth, address, email, phonenumber, position, identifiedCardId, Image, id) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement p_sql = DataConnection.getDataCon().prepareStatement(sql);
            
            p_sql.setString(1, s.getName());
            p_sql.setString(2, s.getGender());
            p_sql.setString(3, s.getDateOfBirth() + "");
            p_sql.setString(4, s.getAddress());
            p_sql.setString(5, s.getEmail());
            p_sql.setString(6, s.getTelephone());
            p_sql.setString(7, s.getPosition());
            p_sql.setString(8, s.getNationalId());
            p_sql.setString(9, s.getImage());
            p_sql.setString(10, s.getStaffId() + "");
            
            p_sql.execute();
            p_sql.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateStaffInDB(Staff staff)
    {
        try 
        {
            String sql = "update tblStaff set fullname=?, gender=?, dateofbirth=?, "
                    + "address=?, email=?, phonenumber=?, position=?, identifiedCardId=?, Image=? where id=?";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getGender());
            preparedStatement.setString(3, staff.getDateOfBirth());
            preparedStatement.setString(4, staff.getAddress()+ "");
            preparedStatement.setString(5, staff.getEmail()+ "");
            preparedStatement.setString(6, staff.getTelephone()+ "");
            preparedStatement.setString(7, staff.getPosition()+ "");
            preparedStatement.setString(8, staff.getNationalId()+ "");
            preparedStatement.setString(9, staff.getImage()+ "");
            preparedStatement.setString(10, staff.getStaffId()+ "");
            
            preparedStatement.execute();
            preparedStatement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteStaffInDB(int staffId)
    {
        try 
        {
            String sql = "delete from tblStaff where id = ?";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, staffId + "");
            
            preparedStatement.execute();
            preparedStatement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<Staff> getStaffFromDB()
    {
        List<Staff> list_staff = new ArrayList<>();
        
        try 
        {
            String sql = "select * from tblStaff";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            Staff staff;
            
            while(r.next())
            {
                staff = new Staff(Integer.parseInt(r.getString(1) + "")
                        , r.getString(2) + ""
                        , r.getString(3) + ""
                        , r.getString(4) + ""
                        , r.getString(5) + ""
                        , r.getString(6) + ""
                        , r.getString(7) + ""
                        , r.getString(8) + ""
                        , r.getString(9) + ""
                        , r.getString(10) + "");
                
                list_staff.add(staff);
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return list_staff;
    }
    
    public static String getStaffNameUsingStaffId(int staffId)
    {
        String staffName = "Not Found";
        
        try 
        {
            String sql = "select fullname from tblStaff where id = " + staffId + ";";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);

            while(r.next())
            {
                staffName = r.getString(1) + "";
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return staffName;
    }
    
    public static int getMaxStaffId()
    {
        int staffId = 0;
        
        try 
        {
            String sql = "select max(id) from tblStaff";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            
            
            while(r.next())
            {
                staffId = Integer.parseInt(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return staffId;
    }
}
