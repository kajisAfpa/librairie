/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cdi418
 */
public class TestHash {
    
    public static void main(String[] args) {
        
        Map<String, String> map = new HashMap();
        map.put("cle1", "val1");
        map.put("cle2", "val2");
        map.put("cle3", "val3");
        
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String cle = entry.getKey();
            String valeur = entry.getValue();
            System.out.println(cle + " " + valeur + " ");
            
        }
        
    }
    
}
