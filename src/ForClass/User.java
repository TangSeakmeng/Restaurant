/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

/**
 *
 * @author Tang Seakmeng
 */
public class User {

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

    /**
     * @return the StaffId
     */
    public int getStaffId() {
        return StaffId;
    }

    /**
     * @param StaffId the StaffId to set
     */
    public void setStaffId(int StaffId) {
        this.StaffId = StaffId;
    }
    private String username;
    private String password;
    private String activeOrInActive;
    private int StaffId;

    public User() {
    }

    public User(String username, String password, String activeOrInActive, int StaffId) {
        this.username = username;
        this.password = password;
        this.activeOrInActive = activeOrInActive;
        this.StaffId = StaffId;
    }
    
    public static void addUserIntoDB()
    {
        try 
        {
            
        } 
        catch (Exception e) 
        {
        }
    }
}
