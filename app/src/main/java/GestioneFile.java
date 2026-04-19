import com.example.yourhelp.Utente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestioneFile {
    File obj = new File("Credenziali");
    ArrayList<Utente> lista = new ArrayList<>();

    public ArrayList<Utente> getLista() {
        return lista;
    }

    private boolean checkUtente(String email)
    {
        for(Utente e : lista)
        {
            if(e.getEmail().equals(email))
            {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Utente> salva_utenti()
    {
        if(obj.exists())
        {
            try (BufferedReader bw = new BufferedReader(new FileReader(obj.getAbsolutePath()))) {

                String line;
                while((line=bw.readLine()) != null)
                {
                    String[] arr = line.split(";");
                    lista.add(new Utente(arr[0],arr[1],arr[2],arr[3]));
                }
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        else
        {
            System.out.println("File non esistente");
            return null;
        }
        return lista;
    }

    public void registra_utenti(Utente e)
    {
        if(obj.exists())
        {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(obj.getAbsoluteFile(),true)))
            {
                bw.newLine();
                bw.write(e.toCsv());
            }catch (IOException exception)
            {
                System.out.println("File non esistente");
            }
        }else {
            return;
        }
    }



    public void stampaArray(ArrayList<Utente> list)
    {
        for(Utente e:list)
        {
            System.out.println(e.toString());
        }
    }

}

