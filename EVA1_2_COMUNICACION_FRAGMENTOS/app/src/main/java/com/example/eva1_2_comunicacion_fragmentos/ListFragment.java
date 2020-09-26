package com.example.eva1_2_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class ListFragment extends Fragment {
    //DATOS DE LA LISTA
    String[] datos = {
            "AK-47",
            "Holger 26",
            "AUG",
            "MP5",
            "HDR",
            "AX-50",
            "Kar98k",
            "CR- 56 AMAX",
            "Grau 5.56",
            "Kilo 101",
            "EBR",
            "M91",
            "PKM",
            "Renetti",
            "X16",
            ".50 GS",
            "Striker",
            "RPG",
            "Pila",
            "Strela P",
            "M19",
            "1911",
            "M13",
            "M4A1",
            "FR.56",
            "Fennec"

    };
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_list, container, false);
        //AQUÍ SE LLENA LA LISTA
        ListView lstVwDatos;
        lstVwDatos = frameLayout.findViewById(R.id.lstVwDatos);
        lstVwDatos.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                datos
        ));
        //EVENTO
        lstVwDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                main.onMessageFromFragToMain("LISTA", datos[i]);
            }
        });

        return frameLayout;
    }
}
