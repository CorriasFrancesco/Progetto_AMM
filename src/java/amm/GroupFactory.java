/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francesco
 */
public class GroupFactory {
    private static GroupFactory singleton;
    private String connectionString;

    public static GroupFactory getInstance() {
        if (singleton == null) {
            singleton = new GroupFactory();
        }
        return singleton;
    }
    
    //private ArrayList<Group> listaGruppi=new ArrayList<Group>();
    
    private GroupFactory() {
        /*UserFactory userFactory = UserFactory.getInstance();
        
        Group gruppo1 = new Group();
        gruppo1.setNomeGruppo("Gruppo");
        gruppo1.setId(0);
        gruppo1.setIscritti(userFactory.getUserById(0));
        gruppo1.setIscritti(userFactory.getUserById(1));
        gruppo1.setIscritti(userFactory.getUserById(2));
        gruppo1.setIscritti(userFactory.getUserById(3));
        
        Group gruppo2 = new Group();
        gruppo2.setNomeGruppo("Gruppo2");
        gruppo2.setId(0);
        gruppo2.setIscritti(userFactory.getUserById(0));
        gruppo2.setIscritti(userFactory.getUserById(3));
        
        Group gruppo3 = new Group();
        gruppo3.setNomeGruppo("Gruppo3");
        gruppo3.setId(0);
        gruppo3.setIscritti(userFactory.getUserById(2));
        gruppo3.setIscritti(userFactory.getUserById(3));
        
        Group gruppo4 = new Group();
        gruppo4.setNomeGruppo("Gruppo4");
        gruppo4.setId(0);
        gruppo4.setIscritti(userFactory.getUserById(1));
        gruppo4.setIscritti(userFactory.getUserById(3));
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
        listaGruppi.add(gruppo4);*/
    }
    
    public Group getGroupById(int id){
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from groups "
                    + "where group_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Group current = new Group();
                
                current.setId(res.getInt("group_id"));
                current.setNomeGruppo(res.getString("group_id"));
                
                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Group> getGroupsList()
    {
        List<Group> listaGruppi = new ArrayList<>();
        
        try {
            Connection connessione = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = "select * from gruppi";
            
            PreparedStatement stmt = connessione.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Group gruppoAttuale = new Group();
                
                gruppoAttuale.setId(res.getInt("gruppoId"));
                gruppoAttuale.setNomeGruppo(res.getString("nome"));
                listaGruppi.add(gruppoAttuale);
            }
            

            stmt.close();
            connessione.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGruppi;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
