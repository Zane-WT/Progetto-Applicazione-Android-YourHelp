package com.example.yourhelp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

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

        Button sendButton = findViewById(R.id.sendButton);
        Button verifyButton = findViewById(R.id.verifybutton);
        EditText textEmail = findViewById(R.id.textEmail);
        EditText textPassword = findViewById(R.id.textPassword);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        verifyButton.setOnClickListener(e->
        {
            String Email = textEmail.getText().toString().trim();
            String Password = textPassword.getText().toString().trim();

            if (Email.isEmpty() && Password.isEmpty()) {
                Toast.makeText(this, "Inserire email e password", Toast.LENGTH_LONG).show();
                return;
            }

            if (Email.isEmpty()) {
                Toast.makeText(this, "Inserire un indirizzo email", Toast.LENGTH_LONG).show();
                return;
            }

            if (Password.isEmpty()) {
                Toast.makeText(this, "Inserire una password", Toast.LENGTH_LONG).show();
                return;
            }

            auth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Utente creato!", Toast.LENGTH_LONG).show();
                        } else {
                            Log.e("FIREBASE_ERROR", task.getException().getMessage());
                            Toast.makeText(this, "Errore: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        sendButton.setOnClickListener(e ->
        {
            FirebaseUser user = auth.getCurrentUser();
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
            }
        });
    }
}