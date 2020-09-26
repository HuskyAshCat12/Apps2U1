package com.example.rep_1_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtxVwDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtxVwDatos = findViewById(R.id.txtxVwDatos);
        MiClaseAsincrona mcaPrueba = new MiClaseAsincrona();
        mcaPrueba.execute(1, 10, 1000);
    }
                                            //INPUT, COMUNICATION, OUTPUT
    class MiClaseAsincrona extends AsyncTask <Integer, String, Double>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtxVwDatos.append("Inicio del hilo");
        }

        @Override
        protected Double doInBackground(Integer... integers) {
            int i = integers[0];
            while (i <= integers[1]){//final
                try{
                    Thread.sleep(integers[2]);
                    publishProgress("Eit \n");
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                i++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            txtxVwDatos.append("Final del hilo");
        }
    }
}
