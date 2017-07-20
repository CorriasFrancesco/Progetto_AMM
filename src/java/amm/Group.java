/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

import java.util.ArrayList;
        
/**
 *
 * @author francesco
 */
public class Group {
    
    private int id;
    private String nomeGruppo;
    
    public Group(){
        id=-1;
        nomeGruppo="";
    }
            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGruppo() {
        return nomeGruppo;
    }

    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }
    
    public boolean equals (Object group){
        if(group instanceof Group){
            if(this.getId()==((Group)group).getId()){
                return true;
            }
        }
        return false;
    }
}
