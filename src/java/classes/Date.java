/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author kevin
 */
public class Date {
    
    //	* Choix de la langue francaise
	static Locale locale = Locale.getDefault();
	static Date actuelle = new Date();
	
//	* Definition du format utilise pour les dates
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

//	* Donne la date au format "aaaa-mm-jj"
	public static String date()
	{
		String dat = dateFormat.format(actuelle);
		return dat;
	}
        
        public static void main(String[] args) {
        
            
    }
    
}
