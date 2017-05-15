/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3;

import java.util.ArrayList;

/**
 *
 * @author francesco
 */
public class UserFactory {
    private static UserFactory singleton;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }
    
    private ArrayList<User> listaUtenti=new ArrayList<User>();
    
    public UserFactory(){
        User user1 = new User();
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
        
        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
        listaUtenti.add(user4);
    }
    
    public User getUserById(int id){
        for (User user : listaUtenti){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
}