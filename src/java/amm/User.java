/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

/**
 *
 * @author francesco
 */
public class User {
    
    private int id;
    private String nome;
    private String cognome;
    private String urlFotoProfilo;
    private String frasePresentazione;
    private String dataDiNascita;
    private String password;

    public User(){
        id=-1;
        nome="";
        cognome="";
        urlFotoProfilo="";
        frasePresentazione="";
        dataDiNascita="";
        password="";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        save("id", (Integer)id);
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        save("nome", nome);
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
        save("cognome", cognome);
    }

    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
        save("urlFotoProfilo", urlFotoProfilo);
    }

    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
        save("frasePresentazione", frasePresentazione);
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
        save("dataDiNascita", dataDiNascita);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        save("password", password);
    }
    
    public boolean equals(Object user){
        if(user instanceof User){
            if(this.getId()==((User)user).getId()){
                return true;
            }
        }
        return false;
    }
    
    public void save(String attributo, Object valore){
        if(valore instanceof String){
            UserFactory.getInstance().save(attributo, (String)valore, this.id);
        }
        else{
            if(valore instanceof Integer){
                UserFactory.getInstance().save(attributo, (int)valore, this.id);
            }
        }
    }
}
