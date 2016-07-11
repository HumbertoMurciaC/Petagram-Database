package com.example.humbertomariom.petagram.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.humbertomariom.petagram.R;
import com.example.humbertomariom.petagram.Mail.SendMail;

public class ActivityContacto extends AppCompatActivity {

    EditText Et_Nombre;
    EditText Et_Mensaje;
    EditText Et_Mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.action_bar2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button b_siguiente = (Button) findViewById(R.id.bEnviar);

        Et_Nombre = (EditText) findViewById(R.id.etNombre);
        Et_Mail = (EditText) findViewById(R.id.etEmail);
        Et_Mensaje = (EditText) findViewById(R.id.mensaje);


        //Adding click listener
        b_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        //Getting content for email
        String email = Et_Mail.getText().toString().trim();
        String subject = Et_Nombre.getText().toString().trim();
        String message = Et_Mensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
