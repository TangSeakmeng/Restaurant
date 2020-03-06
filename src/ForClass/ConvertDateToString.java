/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tang Seakmeng
 */
public class ConvertDateToString {
    public static String convertDateToString(Date d)
    {
        String result = "";
        SimpleDateFormat formatter = null;
         
        formatter = new SimpleDateFormat("yyyy-MM-dd");  
        
        result = formatter.format(d); 
        return result;
    }
}
