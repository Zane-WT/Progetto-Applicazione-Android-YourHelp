package com.example.yourhelp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestioneCSV {

    protected ArrayList<Utente> listaUtenti = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void caricaUtenti(File obj)
    {
        if(obj.exists())
        {
            String path = obj.getAbsolutePath();
            try(BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while( (line = br.readLine()) != null )
                {
                    String[] data = line.split(";");
                    String[] nascita = data[4].split("-");
                    LocalDate dataNascita = LocalDate.of(Integer.parseInt(nascita[0]),Integer.parseInt(nascita[1]),Integer.parseInt(nascita[2]));
                    listaUtenti.add(new Utente(data[0],data[1],data[2],data[3],data[4], dataNascita));

                }
            }catch(IOException e)
            {
                System.out.println("Errore livello" + e.getMessage());
            }
        }else{
            System.out.println("File not found");
        }
    }
    public Utente controlloCredenziali(String emailOrUser, String password)
    {
        for (Utente e:listaUtenti)
        {
            if((e.getEmail().equals(emailOrUser)||e.getUsername().equals(emailOrUser))&&e.getPassword().equals(password))
            {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }
}
