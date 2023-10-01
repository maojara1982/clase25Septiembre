package com.examplemauriciojaramillo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button  google,alarma,llamada,temp,cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamada);
        temp = findViewById(R.id.temporizador);
        cam = findViewById(R.id.camara);


        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAgoogle= new Intent(Intent.ACTION_VIEW);
                irAgoogle.setData(Uri.parse("http://www.google.com"));
                startActivity(irAgoogle);

            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "Gimnasio");
                alarma.putExtra(AlarmClock.EXTRA_HOUR, 10);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);

                if (alarma.resolveActivity(getPackageManager())!=null) {
                    startActivity(alarma);
                }
            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("3174390055");

            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent incTemprozador = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "comenzando temporizador")
                        .putExtra(AlarmClock.EXTRA_LENGTH,160)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                if (incTemprozador.resolveActivity(getPackageManager()) != null) {
                    startActivity(incTemprozador);
                }
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camara = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivityForResult(camara);
            }
        });



    }

    private void startActivityForResult(Intent camara) {
        startActivity(camara);
    }

    public void dialPhoneNumber(String s) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + s));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }





}