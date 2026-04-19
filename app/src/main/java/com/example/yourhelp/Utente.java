package com.example.yourhelp;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String password;

    public Utente(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }


    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    protected void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "\n" + "Cognome:" + cognome +
                "\n" + "Email:" + email + "\n" + "Password:" + password;
    }


    public String toCsv() {
        return nome+";"+cognome+";"+email+";"+password;
    }
}