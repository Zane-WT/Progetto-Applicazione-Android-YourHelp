package com.example.yourhelp;

import java.time.LocalDate;

public class Utente {
    //private String nome;
    private String username;
   // private String email;
    private String password;
    // private String genere;
    //private LocalDate dataNascita;

    public Utente(String username, String password) {
        this.username = username;
        this.password = password;
    }



    /*public Utente(String nome, String username, String email, String password, String genere, LocalDate dataNascita) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.genere = genere;
        this.dataNascita = dataNascita;
    }*/


/*    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }
*/
    public String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }
/*
    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }
*/
    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }
/*
    public String getGenere() {
        return genere;
    }
    protected void setGenere(String genere) {
        this.genere = genere;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    protected void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "\n" + "Cognome:" + username +
                "\n" + "Email:" + email + "\n" + "Password:" + password;
    }
    public String toCsv() {
        return nome+";"+ username +";"+email+";"+password+";"+genere+";"+dataNascita;
    }
    */

}