package com.econpublicite.hndadelia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button fraga,maqui,cuerpo,cuidado,bien,interior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fraga = (Button) findViewById(R.id.fragancia);
        fraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactoIntente = new Intent( MainActivity.this, FraganciaActivity.class );
                startActivity( contactoIntente );
            }
        });
        maqui = (Button) findViewById(R.id.Maquillaje);
        maqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactoIntente = new Intent( MainActivity.this, MaquillajesActivity.class );
                startActivity( contactoIntente );
            }
        });
        cuerpo = (Button) findViewById(R.id.Cuerpo);
        cuerpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactoIntente = new Intent( MainActivity.this, CuerpoActivity.class );
                startActivity( contactoIntente );
            }
        });

        cuidado = (Button) findViewById(R.id.Cuidado);
        cuidado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactoIntente = new Intent( MainActivity.this, CuidadoActivity.class );
                startActivity( contactoIntente );
            }
        });
        bien = (Button) findViewById(R.id.Bienestar);
        bien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactoIntente = new Intent( MainActivity.this, BienestarActivity.class );
                startActivity( contactoIntente );
            }
        });}
    public void afiliacion(View view){
        Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=51 988 356 368&text=Hola ADELIA, Solicito Información Para Afiliación a Hinode"));
        startActivity(BrowserIntent);}

    };
