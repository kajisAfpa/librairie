/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import classes.Adresse;
import classes.Membre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReqMembre {
    
     public List<Membre> getListeMembre() throws ClassNotFoundException, SQLException {
        
        
        
        MaConnection mc = MaConnection.getInstance();
        Statement stm = mc.createStatement();
        String reqMembre = "select m.idMembre, m.typeMembre, m.nomMembre, m.prenomMembre, m.mailMembre, m.mdpMembre, "
                + "m.telMembre, portMembre,  m.dateNaissanceMembre, m.actifMembre "
                + "from Membre m "
                + "ORDER BY idMembre";
 
        ResultSet rs = stm.executeQuery(reqMembre);
        System.out.println("requete: "+reqMembre);
        
       
List<Membre> listMembre = new ArrayList(); 
        

            while( rs.next()) {
                Membre m = new Membre();
                   
                    m.setIdMembre(rs.getInt("idMembre"));
                    m.setTypeMembre(rs.getInt("typeMembre"));
                    m.setNomMembre(rs.getString("nomMembre"));
                    m.setPrenomMembre(rs.getString("prenomMembre"));
                    m.setMailMembre(rs.getString("mailMembre"));
                    m.setMdpMembre(rs.getString("mdpMembre"));
                    m.setTelMembre(rs.getString("telMembre"));
                    m.setPortMembre(rs.getString("portMembre"));
                    m.setDateNaissanceMembre(rs.getString("dateNaissanceMembre"));
                    m.setActifMembre(rs.getInt("actifMembre"));
                        
                listMembre.add(m);
                
                
            }
            


            rs.close();
            stm.close();
            
          String reqAdresse = "select a.idAdresse, a.nomAdresse, a.prenomAdresse, a.typeAdresse, a.libelleAdresse, a.rueAdresse, a.cpAdresse, a.villeAdresse "
                + "from Adresse a "
                + "join Facturation f "
                + "on f.idAdresse = a.idAdresse "
                + "join Membre m "
                + "on  m.idMembre = f.idMembre "
                + "where m.idMembre = ? ";
        
                PreparedStatement pstm = mc.prepareStatement(reqAdresse);
            
            for(int i = 0; i<listMembre.size(); i++){
                Membre m = listMembre.get(i);
                pstm.setInt(1, m.getIdMembre());
                ResultSet rs01 = pstm.executeQuery();
                while(rs01.next()){
                    Adresse adr  = new Adresse();
                    adr.setIdAdresse(Integer.valueOf(rs01.getString("idAdresse")));
                    adr.setNomAdresse(rs01.getString("nomAdresse"));
                    adr.setPrenomAdresse(rs01.getString("prenomAdresse"));
                    adr.setTypeAdresse(rs01.getString("typeAdresse"));
                    adr.setLibelleAdresse(rs01.getString("libelleAdresse"));
                    adr.setRueAdresse(rs01.getString("rueAdresse"));
                    adr.setCpAdresse(rs01.getString("cpAdresse"));
                    adr.setVilleAdresse(rs01.getString("villeAdresse"));
                    
                    m.getAdresses().add(adr);
                }
                rs01.close();
                
            }
            pstm.close();
//         
//
            
            
            
            
            return listMembre;
        
    }
     
     
     public Membre getMembre(int id) throws ClassNotFoundException, SQLException {
        
        
        
        MaConnection mc = MaConnection.getInstance();
        String reqMembre = "select m.idMembre, m.typeMembre, m.nomMembre, m.prenomMembre, m.mailMembre, m.mdpMembre, "
                + "m.telMembre, portMembre,  m.dateNaissanceMembre, m.actifMembre "
                + "from Membre m "
                + "where m.idMembre = ? "
                + "ORDER BY idMembre";
        
        PreparedStatement pstm = mc.prepareStatement(reqMembre);
        
        pstm.setInt(1, id);
 
        ResultSet rs = pstm.executeQuery();
        System.out.println("requete: "+reqMembre);
        
       
Membre membre = new Membre();
        

            while( rs.next()) {
                Membre m = new Membre();
                   
                    m.setIdMembre(rs.getInt("idMembre"));
                    m.setTypeMembre(rs.getInt("typeMembre"));
                    m.setNomMembre(rs.getString("nomMembre"));
                    m.setPrenomMembre(rs.getString("prenomMembre"));
                    m.setMailMembre(rs.getString("mailMembre"));
                    m.setMdpMembre(rs.getString("mdpMembre"));
                    m.setTelMembre(rs.getString("telMembre"));
                    m.setPortMembre(rs.getString("portMembre"));
                    m.setDateNaissanceMembre(rs.getString("dateNaissanceMembre"));
                    m.setActifMembre(rs.getInt("actifMembre"));
                        
                membre = m; 
                
                
            }
            


            rs.close();
            pstm.close();
            
          String reqAdresse = "select a.idAdresse, a.nomAdresse, a.prenomAdresse, a.typeAdresse, a.libelleAdresse, a.rueAdresse, a.cpAdresse, a.villeAdresse "
                + "from Adresse a "
                + "join Facturation f "
                + "on f.idAdresse = a.idAdresse "
                + "join Membre m "
                + "on  m.idMembre = f.idMembre "
                + "where m.idMembre = ? ";
        
                PreparedStatement pstm01 = mc.prepareStatement(reqAdresse);
            
            
                pstm01.setInt(1, membre.getIdMembre());
                ResultSet rs01 = pstm01.executeQuery();
                while(rs01.next()){
                    Adresse adr  = new Adresse();
                    adr.setIdAdresse(Integer.valueOf(rs01.getString("idAdresse")));
                    adr.setNomAdresse(rs01.getString("nomAdresse"));
                    adr.setPrenomAdresse(rs01.getString("prenomAdresse"));
                    adr.setTypeAdresse(rs01.getString("typeAdresse"));
                    adr.setLibelleAdresse(rs01.getString("libelleAdresse"));
                    adr.setRueAdresse(rs01.getString("rueAdresse"));
                    adr.setCpAdresse(rs01.getString("cpAdresse"));
                    adr.setVilleAdresse(rs01.getString("villeAdresse"));
                    
                    membre.getAdresses().add(adr);
                }
                rs01.close();
                
            
            pstm01.close();
//         
//
            
            
            
            
            return membre;
        
    }
     
    public static void main(String[] args) {
         try {
             ReqMembre req = new ReqMembre();
//         try {
//             for(Membre m : req.getListeMembre()) {
//                 System.out.println(m.toString());
//                 
//             }
//         } catch (ClassNotFoundException | SQLException ex) {
//             ex.printStackTrace();
//         }
             System.out.println(req.getMembre(1));
         } catch (ClassNotFoundException | SQLException ex) {
             ex.printStackTrace();
         }
    }
      
  
    
}
