/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author kevin
 */
public class Authentification implements Serializable {
    
    
    
    public Authentification() {
        
    }
    
    public Boolean check(String login, String mdp, String bonLogin, String bonMdp) {
        
        Boolean check = false;
        
        if ( login.trim().isEmpty() || mdp.trim().isEmpty() ) {
            check = false; 
        }
        
        else if(login.length() <= 3 || mdp.length() <=3) {
            check = false;
        }
        
        else if(login.equals(bonLogin) && mdp.equals(bonMdp)) {
            check = true;
        }
        else {
            check = false;
        }
        
        return check;
        
    }
    
    
}
