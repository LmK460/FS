package com.example.aluca.fs.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aluca.fs.activity.RecyclerItemClickListener;
import com.example.aluca.fs.R;
import com.example.aluca.fs.activity.Adapter.adapter;
import com.example.aluca.fs.activity.Model.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Medicamento> listaMedicamentos = new ArrayList<>();
    private ImageButton NewDrug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        NewDrug = findViewById(R.id.buttonADD);

        NewDrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),AlarmActivity.class);
                startActivity(intent);
            }
        });





        recyclerView = findViewById(R.id.recyclerView);

        //Configurar Listade FIlems

        this.criarFilmes();

        //configurar adapater
        adapter adapter = new adapter(listaMedicamentos);
        //configurar RecycleView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Medicamento medicamento = listaMedicamentos.get(position);
                Toast.makeText(getApplicationContext(), medicamento.getTitulo(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Medicamento medicamento = listaMedicamentos.get(position);
                Toast.makeText(getApplicationContext(), medicamento.getAno(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    public void criarFilmes(){


    }


}
