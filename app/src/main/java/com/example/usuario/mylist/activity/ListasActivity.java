package com.example.usuario.mylist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.mylist.R;
import com.example.usuario.mylist.adapter.CategoriasAdapter;

public class ListasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public ListView categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        recebeDados();

        categoria = (ListView) findViewById(R.id.lvCategoria);
        categoria.setAdapter(new CategoriasAdapter(this));
        categoria.setOnItemClickListener(this);
    }

    public void recebeDados(){
        Bundle args = getIntent().getExtras();

        if (args != null) {
            String tituloLista = args.getString("tituloLista");

            TextView txtTituloLista = (TextView) findViewById(R.id.txtTituloLista);
            txtTituloLista.setText(tituloLista);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, CategoriaActivity.class);
        Bundle parametros = new Bundle();

        parametros.putInt("categoriaClicada", position);

        intent.putExtras(parametros);

        startActivity(intent);
    }
}
