package verifyingTools;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.regex.*;

/**
 *
 * @author Saurav
 */
public class Verify {

    public static boolean isValidEmail(String e) {
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        if (e == null) {
            return false;
        }

        return pat.matcher(e).matches();

    }
    
     public static boolean isValidMobile(String s){ 
        
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
        
        Matcher m = p.matcher(s); 
        
        return (m.find() && m.group().equals(s)); 
        
        
    }
     
     public static boolean isValidPassword(char s[]){ 
        
        if(s.length < 8) return false;
        
        return true; 
        
        
    }
     
     public static boolean isValidPinCode(String s) { 
        
       if ((s.length() != 6) || (Integer.parseInt(s) < 100000)) return false;
       
       return true;
            
    }
     
     public static boolean isValidConfirmPassword(char s1[],char s2[]){
       if( Arrays.equals(s1, s2)) return true;       
       return false;
    
    }

    public static boolean isValidAdhar(String a) {
        if(a.length()==12)
            return true;
        return false;
    }

    
    public static boolean isValidPan(String p) {
 //@saspg bhar de plij
        return false;
    }
}
