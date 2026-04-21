package com.example.yourhelp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





    private EditText etNome, etUsername, etPassword, etConfermaPassword;
    private Button btnCreaAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Collegamento con gli elementi del layout
        etNome = findViewById(R.id.etNome);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfermaPassword = findViewById(R.id.etConfermaPassword);
        btnCreaAccount = findViewById(R.id.btnCreaAccount);

        btnCreaAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registraUtente();
            }
        });
    }

    private void registraUtente() {
        String nome = etNome.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();
        String confermaPass = etConfermaPassword.getText().toString().trim();

        // Semplice validazione
        if (nome.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Per favore, compila tutti i campi", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(confermaPass)) {
            Toast.makeText(this, "Le password non coincidono", Toast.LENGTH_SHORT).show();
        } else {
            // Procedi con la logica di registrazione (es. salvataggio su database)
            Toast.makeText(this, "Registrazione in corso per " + nome, Toast.LENGTH_LONG).show();
        }
    }
}


}