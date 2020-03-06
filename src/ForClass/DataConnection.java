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

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {

    /**
     * @return the dataCon
     */
    public static Connection getDataCon() {
        return dataCon;
    }

    /**
     * @param aDataCon the dataCon to set
     */
    public static void setDataCon(Connection aDataCon) {
        dataCon = aDataCon;
    }
    private static Connection dataCon;
    
    public static void ConnectionDB(String ip, String dbName, String user, String password) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        setDataCon(DriverManager.getConnection("jdbc:mysql://" + ip + "/" + dbName + "?verifyServerCertificate=true&useSSL=false&allowPublicKeyRetrieval=true", user, password));
    }
}
