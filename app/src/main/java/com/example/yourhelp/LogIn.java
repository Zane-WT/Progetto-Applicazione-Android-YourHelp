package com.example.yourhelp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;

public class LogIn extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GestioneCSV gest = new GestioneCSV();
        //File obj = new File("C:\\Users\\Zane\\Documents\\Scuola\\YourHelp\\app\\src\\main\\assets\\credenziali.txt");
        Button sendButton = findViewById(R.id.sendButton);
        Button verifyButton = findViewById(R.id.verifybutton);
        EditText textEmail = findViewById(R.id.textEmail);
        EditText textPassword = findViewById(R.id.textPassword);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        verifyButton.setOnClickListener(e->
        {
            String EmailOrUsername = textEmail.getText().toString();
            String Password = textPassword.getText().toString();

            if (EmailOrUsername.isEmpty() && Password.isEmpty()) {
                Toast.makeText(this, "Inserire email e password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (EmailOrUsername.isEmpty()) {
                Toast.makeText(this, "Inserire un indirizzo email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (Password.isEmpty()) {
                Toast.makeText(this, "Inserire una password", Toast.LENGTH_SHORT).show();
                return;
            }

            Utente trovato = gest.controlloCredenziali(EmailOrUsername,Password);
            if(gest.controlloCredenziali(EmailOrUsername,Password)==null)
            {
                Toast.makeText(this, "Credenziali errate", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intento = new Intent(LogIn.this,MainActivity.class);
            startActivity(intento);
            finish();


            /*auth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Utente creato!", Toast.LENGTH_LONG).show();
                        } else {
                            Log.e("FIREBASE_ERROR", task.getException().getMessage());
                            Toast.makeText(this, "Errore: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });*/
        });

        sendButton.setOnClickListener(e ->
        {
            /*FirebaseUser user = auth.getCurrentUser();
            if (user != null) {
                user.sendEmailVerification()
                        .addOnCompleteListener(task ->
                        {
                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Email mandata!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "Errore:2 " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }*/
        });
    }
}