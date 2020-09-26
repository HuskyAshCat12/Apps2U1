package com.example.eva1_10_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lstVwClima;
    List<Weather> lstCiudades = new ArrayList<>();
    /**  Weather[] cities = {
     new Weather("Chihuahua", 654, "Nublado",R.drawable.cloudy),
     new Weather("Juárez", 23, "Nevando",R.drawable.snow),
     new Weather("Casas Chicas", 65, "Granizo",R.drawable.tornado),
     new Weather("Villa Juárez", 666, "Pepinillo",R.drawable.cloudy),
     new Weather("Matachí", 420, "Soleado",R.drawable.sunny),
     new Weather("Guadalupe y Calvo", 69, "Nevando",R.drawable.snow),
     new Weather("Parral", 30, "Medio soleado",R.drawable.atmospher),
     new Weather("Aldama", 67, "Nublado",R.drawable.cloudy),
     new Weather("Villa Ahumada", 12, "Lluvioso",R.drawable.rainy),
     new Weather("Fondo de Bikini", 25, "Lluvioso",R.drawable.light_rain)
     };**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstVwClima = findViewById(R.id.lstVwClima);

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("list");
                            for(int i = 0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Weather wCiudad = new Weather();
                                wCiudad.setCity(jsonObject.getString("name"));
                                JSONObject jsMain = jsonObject.getJSONObject("main");
                                wCiudad.setTemp((int)jsMain.getDouble("temp"));

                                JSONArray jaClima = jsonObject.getJSONArray("weather");
                                JSONObject joClimaCiudad = jaClima.getJSONObject(0);
                                wCiudad.setClimate(joClimaCiudad.getString("description"));
                                int iId = joClimaCiudad.getInt("id");

                                if(iId < 300){//TORMENTAS
                                    wCiudad.setImage(R.drawable.thunderstorm);
                                }else if(iId <400){//LLUVIA LIGERA
                                    wCiudad.setImage(R.drawable.light_rain);
                                }
                                else if(iId <600){//LLUVIA INTENSA
                                    wCiudad.setImage(R.drawable.rainy);
                                }
                                else if(iId <700){//NIEVE
                                    wCiudad.setImage(R.drawable.snow);
                                }
                                else if(iId <801){//DESPEJADO
                                    wCiudad.setImage(R.drawable.sunny);
                                }
                                else if(iId <900){//NUBLADO
                                    wCiudad.setImage(R.drawable.cloudy);
                                }
                                else{
                                    wCiudad.setImage(R.drawable.tornado);
                                }
                                lstCiudades.add(wCiudad);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        lstVwClima.setAdapter(new WeatherAdapter(MainActivity.this, R.layout.mi_layout,lstCiudades));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);
        //lstVwClima.setAdapter(new WeatherAdapter(this,R.layout.mi_layout, cities));
    }
}
