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
public class UserFactory {
    private static UserFactory singleton;
    private String connectionString;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }
    
   // private ArrayList<User> listaUtenti=new ArrayList<User>();
    
    
    public UserFactory(){
        /*User user1 = new User();
        user1.setId(0);
        user1.setNome("Djanni");
        user1.setCognome("Incrocio");
        user1.setUrlFotoProfilo("img/djanniprofilo.jpg");
        user1.setFrasePresentazione("");
        user1.setDataDiNascita("");
        user1.setPassword("123");
    
        User user2 = new User();
        user2.setId(1);
        user2.setNome("HeavyBreathing");
        user2.setCognome("British Shorthair");
        user2.setUrlFotoProfilo("img/user1.gif");
        user2.setFrasePresentazione("");
        user2.setDataDiNascita("");
        user2.setPassword("123");

        //GymWorkOut
        User user3 = new User();
        user3.setId(2);
        user3.setNome("GymWorkOut");
        user3.setCognome("User Sacro di Birmania");
        user3.setUrlFotoProfilo("img/user2.jpg");
        user3.setFrasePresentazione("");
        user3.setDataDiNascita("");
        user3.setPassword("123");

        //ChaoPovery
        User user4 = new User();
        user4.setId(3);
        user4.setNome("ChaoPovery");
        user4.setCognome("Ocicat");
        user4.setUrlFotoProfilo("img/user3.jpg");
        user4.setFrasePresentazione("");
        user4.setDataDiNascita("");
        user4.setPassword("123");
        
        User user5=new User();
        user5.setId(4);
        user5.setNome("utente");
        user5.setCognome("sbagliato");
        user5.setUrlFotoProfilo("img/user3.jpg");
        user5.setFrasePresentazione(null);
        user5.setDataDiNascita("");
        user5.setPassword("123");
        
        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
        listaUtenti.add(user4);
        listaUtenti.add(user5);*/
    }
    
    public User getUserById(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from utenti "
                    + "where utente_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                User current = new User();
                current.setId(res.getInt("user_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataDiNascita(res.getString("dataDiNascita"));
                current.setPassword(res.getString("password"));
                
                stmt.close();
                conn.close();
                return current;
            }
            
            //Chiusura connessioni
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPass(String username, String password){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = "select utente_id from utenti where nome = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            //Se è stato trovato prendo l'id dell'utente
            if (res.next()) {
                int id = res.getInt("utente_id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
            return e.getErrorCode();
        }
        
        //Se l'uente non è stato trovato restituisco -1
        return -1;
    }
    
    public boolean completeData(int id){
        User user= UserFactory.getInstance().getUserById(id);
        
            if(user.getNome()!=null && user.getCognome()!=null && 
               user.getUrlFotoProfilo()!=null && user.getFrasePresentazione()!=null){
                return true;
            }
        return false;
    }
    
    public List getUsersList()
    {
        List<User> listaUtenti = new ArrayList<User>();
        
        try {
            Connection connessione = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = "select * from utenti";
            PreparedStatement stmt = connessione.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                User utente = new User();
                
                utente.setId(res.getInt("utenteId"));
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                utente.setFrasePresentazione(res.getString("frasePresentazione"));
                utente.setDataDiNascita(res.getString("dataDiNascita"));
                utente.setPassword(res.getString("password"));
                
                listaUtenti.add(utente);
            }

            stmt.close();
            connessione.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUtenti;
    }
    
     public List getUsersList(String q)
    {
        List<User> listaUtenti = new ArrayList<User>();
        
        try {
            Connection connessione = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = "select * from utenti where nome like ? or cognome like ?";
            
            PreparedStatement stmt = connessione.prepareStatement(query);
            stmt.setString(1, "%" + q + "%");
            stmt.setString(2, "%" + q + "%");
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                User utente = new User();
                
                utente.setId(res.getInt("utenteId"));
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                utente.setFrasePresentazione(res.getString("frasePresentazione"));
                utente.setDataDiNascita(res.getString("dataDiNascita"));
                utente.setPassword(res.getString("password"));
                
                listaUtenti.add(utente);
            }

            stmt.close();
            connessione.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUtenti;
    }
    
    public void save(String attributo, String valore, int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            // UPDATE utenti set ?=? WHERE id=?
            
            String query = "update utenti set ? = ? where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, attributo);
            stmt.setString(2, valore);
            stmt.setInt(3, id);
            
            stmt.executeQuery();
            
            stmt.close();
            conn.close();
                
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void save(String attributo, int valore, int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
                        
            String query = "update utenti set ? = ? where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, attributo);
            stmt.setInt(2, valore);
            stmt.setInt(3, id);
            
            stmt.executeQuery();
            
            stmt.close();
            conn.close();
                
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteUser (int id){
        boolean i=true;
        boolean j=false;
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            conn.setAutoCommit(false);
            
            //Eliminazione dei post, se al termine i==false allora non è riuscita
            for(Post post: PostFactory.getInstance().getPostList(UserFactory.getInstance().getUserById(id))){
                j=PostFactory.getInstance().eliminaPost(post.getId());
                if(j==false){
                    i=false;
                }
            }
            
            //Se l'eliminazione dei post è riuscita elimino l'utente e salvo i cambiamenti
            if(i=true){
                i=this.elimina(id);
                if(i=true){
                    conn.commit();
                }
            }
            //Se qualcosa non ha funzionato eseguo il rollback
            else{
                conn.rollback();
            }
            conn.setAutoCommit(true);
            conn.close();
                
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean elimina(int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");

            String query="DELETE FROM utenti where id = ?";
            PreparedStatement stmt=conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.executeUpdate(query);

            stmt.close();
            
            query="SELECT * FROM utenti where id = ?";
            stmt=conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            ResultSet set=stmt.executeQuery(query);
            
            //Se viene trovato un elemento significa che non è stato eliminato
            if(set.next()){
                stmt.close();
                conn.close();
                return false;
            }
            
            stmt.close();
            conn.close();
            return true;
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
