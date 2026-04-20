package com.example.yourhelp;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class GestioneCSV extends AppCompatActivity {

    protected ArrayList<Utente> listaUtenti = new ArrayList<>();
    private Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Utente> caricaUtenti()
    {
        try {
            InputStream is = context.getAssets().open("credenziali.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    listaUtenti.add(new Utente(parts[0], parts[1]));
                }
            }

            reader.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUtenti;
    }

        /*if(obj.exists())
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
        }*/
        public Utente controlloCredenziali(String emailOrUser, String password)
        {
            for (Utente e:caricaUtenti())
            {
                if(e.getUsername().equals(emailOrUser)&&e.getPassword().equals(password))
                {
                    return e;
                }
            }
            return null;
        }
    }

