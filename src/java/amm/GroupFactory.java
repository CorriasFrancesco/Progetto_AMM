/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

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
    
    private ArrayList<Group> listaGruppi=new ArrayList<Group>();
    
    private GroupFactory() {
        UserFactory userFactory = UserFactory.getInstance();
        
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
        listaGruppi.add(gruppo4);
    }
    
    public Group getGroupById(int id){
        for(Group group:listaGruppi){
            if(group.getId()==id){
                return group;
            }
        }
        return null;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
