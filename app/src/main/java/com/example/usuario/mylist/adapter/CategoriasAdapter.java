package com.example.usuario.mylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.usuario.mylist.R;

import java.util.ArrayList;

/**
 * Created by Usuario on 15/10/2017.
 */

public class CategoriasAdapter extends BaseAdapter {

    private static final String[] CATEGORIAS = new String[]{
            "Frios e Laticínios", "Açougue", "Higiene",
            "Bebidas", "Padaria", "Mercearia", "Mercearia",
            "Mercearia", "Mercearia", "Mercearia", "Mercearia"
    };

    private Context context;

    public CategoriasAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return CATEGORIAS.length;
    }

    @Override
    public Object getItem(int i) {
        return CATEGORIAS[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        String lista = CATEGORIAS[i];
        View view = LayoutInflater.from(context).inflate(R.layout.listas, viewGroup, false);
        TextView txtListas = (TextView) view.findViewById(R.id.txt_listas);
        txtListas.setText(lista);

        return view;
    }
}
