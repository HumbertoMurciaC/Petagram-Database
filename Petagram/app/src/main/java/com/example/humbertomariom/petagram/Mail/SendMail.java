package com.example.humbertomariom.petagram.Mail;

import android.content.pm.PackageInstaller;
import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by Humberto Mario M on 3/07/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail extends AsyncTask<Void,Void,Void> {


    private Context context;
    private Session session;
    private String email;
    private String Nombre;
    private String message;
    private final String username = "correo@gmail.com";// Cambiar por tu direccion de correo de gmail
    private final String password = "********";//Contraseña del correo
    private final String asunto = "Mensaje de Petagram";
    private ProgressDialog progressDialog;

    public SendMail(Context context, String email, String nombre, String message){

        this.context = context;
        this.email = email;
        this.Nombre = nombre;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"Enviando mensaje","Por favor espere...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
        Toast.makeText(context,"Mensaje enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);

                    }
                });


        try {

            MimeMessage mm = new MimeMessage(session);

            mm.setFrom(new InternetAddress(email));

            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            mm.setSubject(asunto);

            String mensaje=Nombre+",\n"+message+"\n"+"Mensaje enviado desde Petagram.";

            mm.setText(mensaje);

            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
