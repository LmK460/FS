package com.example.aluca.fs.activity.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aluca.fs.R;
import com.example.aluca.fs.activity.Model.Medicamento;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyviewHolder> {

    private List<Medicamento> listaMedicamentos;
    public adapter(List<Medicamento> lista) {
        this.listaMedicamentos = lista;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_list,viewGroup,false);


        return new MyviewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {

        Medicamento medicamento = listaMedicamentos.get(i);
        myviewHolder.titulo.setText(medicamento.getTitulo());
        myviewHolder.ano.setText(medicamento.getAno());
        myviewHolder.genero.setText(medicamento.getGenero());

    }

    @Override
    public int getItemCount() {
        return listaMedicamentos.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView titulo,ano,genero;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
