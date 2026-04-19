package com.example.yourhelp;

import java.util.ArrayList;

public class Auth {

    private static String file = "Utenti_Password";
    private ArrayList<Utente> utenti = new ArrayList<>();

    public Auth()
    {
        GestioneFile gf = new GestioneFile();
        utenti = gf.salva_utenti();
    }

    public Utente controlla(String email, String password)
    {
        for(Utente e: utenti)
        {
            if(e.getEmail().equals(email) && e.getPassword().equals(password))
            {
                return e;
            }
        }
        return null;
    }

    public boolean controlla_email(String email)
    {
        for(Utente e: utenti)
        {
            if(e.getEmail().equals(email))
            {
                return false;
            }
        }
        return true;
    }
}
