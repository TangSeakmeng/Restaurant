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
public class User {

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
     * @return the staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName the staffName to set
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the activeOrInActive
     */
    public String getActiveOrInActive() {
        return activeOrInActive;
    }

    /**
     * @param activeOrInActive the activeOrInActive to set
     */
    public void setActiveOrInActive(String activeOrInActive) {
        this.activeOrInActive = activeOrInActive;
    }

    private int userId;
    private String username;
    private String password;
    private String activeOrInActive;
    private int staffId;
    private String staffName;

    public User() {
    }

    public User(int userId, String username, String password, String activeOrInActive, int staffId, String staffName) {
        this.username = username;
        this.password = password;
        this.activeOrInActive = activeOrInActive;
        this.staffId = staffId;
        this.userId = userId;
        this.staffName = staffName;
    }
    
    public static void addUserIntoDB(User user)
    {
        try 
        {
            String sql = "insert into tblUser(username, password, status, staffid) values(?,?,?,?)";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getActiveOrInActive());
            preparedStatement.setString(4, user.getStaffId() + "");
            
            preparedStatement.execute();
            preparedStatement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateUserInDB(User user)
    {
        try 
        {
            String sql = "update tblUser set username=?, password=?, status=?, staffid=? where id=?";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getActiveOrInActive());
            preparedStatement.setString(4, user.getStaffId() + "");
            preparedStatement.setString(5, user.getUserId()+ "");
            
            preparedStatement.execute();
            preparedStatement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteUserInDB(int userid)
    {
        try 
        {
            String sql = "delete from tbluser where id = ?";
            
            PreparedStatement preparedStatement = DataConnection.getDataCon().prepareStatement(sql);
            
            preparedStatement.setString(1, userid + "");
            
            preparedStatement.execute();
            preparedStatement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<User> getUserFromDB()
    {
        List<User> list_user = new ArrayList<>();
        
        try 
        {
            String sql = "select u.ID, u.username, u.password, u.status, u.staffid, s.fullname"
                    + " from tblUser u inner join tblStaff s on u.staffid = s.id;";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            User user;
            
            while(r.next())
            {
                user = new User(Integer.parseInt(r.getString(1) + ""), r.getString(2) + "", r.getString(3) + "", r.getString(4) + "", 
                        Integer.parseInt(r.getString(5) + ""), r.getString(6) + "");
                list_user.add(user);
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return list_user;
    }
    
    public static int getMaxUserId()
    {
        int userid = 0;
        
        try 
        {
            String sql = "select max(id) from tblUser";
            Statement s = DataConnection.getDataCon().createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                userid = Integer.parseInt(r.getString(1) + "");
            }
            
            r.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return userid;
    }
}
