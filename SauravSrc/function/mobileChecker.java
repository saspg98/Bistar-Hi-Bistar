/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author Saurav
 */

import java.util.regex.*; 

public class mobileChecker {
    
    public static boolean isValidMobile(String s){ 
        
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
        
        Matcher m = p.matcher(s); 
        
        return (m.find() && m.group().equals(s)); 
        
        
    }
    
}
