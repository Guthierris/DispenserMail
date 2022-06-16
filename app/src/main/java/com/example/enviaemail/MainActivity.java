package com.example.enviaemail;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText editdestino, editassunto,editmensagem;
Button btenviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editdestino = findViewById(R.id.editdestino);
        editassunto = findViewById(R.id.editassunto);
        editmensagem = findViewById(R.id.editmensagem);

        btenviar = findViewById(R.id.btenviar);


        btenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar_email();

            }

            private void enviar_email(){

                String destino = editdestino.getText().toString();
                String assunto = editassunto.getText().toString();
                String mensagem = editmensagem.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ destino });
                intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,""));

                Toast.makeText(MainActivity.this,"entrei",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
