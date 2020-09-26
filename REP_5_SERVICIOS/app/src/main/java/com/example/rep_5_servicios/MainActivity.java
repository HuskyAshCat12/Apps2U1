package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inServicio = new Intent(this, MyService.class);
        BroadcastReceiver breceiver = new MiBroadCastReceiver();

        IntentFilter intentFilter = new IntentFilter("MI SERVICIO");
        registerReceiver(breceiver, intentFilter);
    }
    public void iniciar(View v){
        startService(inServicio);
    }

    public void detener(View v){
        stopService(inServicio);
    }

    class MiBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //PROCESAMOS EL MENSAJE
            Log.wtf("MENSAJE", "THREAD");
        }
    }
}