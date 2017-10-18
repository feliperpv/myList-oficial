package com.example.usuario.mylist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.mylist.R;
import com.example.usuario.mylist.adapter.CategoriasAdapter;

public class ListasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public ListView categoria;
    private TextView txtTituloLista;
    private String tituloLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTituloLista = (TextView) findViewById(R.id.txtTituloLista);
        recebeDados();

        categoria = (ListView) findViewById(R.id.lvCategoria);
        categoria.setAdapter(new CategoriasAdapter(this));
        categoria.setOnItemClickListener(this);
    }

    public void recebeDados(){
        Bundle args = getIntent().getExtras();

        if (args != null) {
            tituloLista = args.getString("tituloLista");

            txtTituloLista.setText(tituloLista);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String tituloCategoria = (String) adapterView.getAdapter().getItem(position);

        Intent intent = new Intent(this, CategoriaActivity.class);
        Bundle parametros = new Bundle();

        parametros.putInt("categoriaClicada", position);
        parametros.putString("nomeCategoria", tituloCategoria);
        parametros.putString("tituloLista", tituloLista);

        intent.putExtras(parametros);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
