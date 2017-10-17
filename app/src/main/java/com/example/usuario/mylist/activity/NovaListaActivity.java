package com.example.usuario.mylist.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.mylist.R;
import com.example.usuario.mylist.adapter.CategoriasAdapter;

import java.util.ArrayList;

/**
 * Created by Usuario on 15/10/2017.
 */

public class NovaListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_lista);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void criarLista (View v){
        EditText edtNomeNovaLista = (EditText) findViewById(R.id.edtNomeNovaLista);
        String nomeNovaLista = edtNomeNovaLista.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        Bundle parametros = new Bundle();
        parametros.putString("nomeNovaLista", nomeNovaLista);

        if (!parametros.getString("nomeNovaLista").equals("")) {
            intent.putExtras(parametros);
            startActivity(intent);
            finish();
        } else {
            toastNomeNovaListaEmpty();
        }
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

    private void toastNomeNovaListaEmpty() {
        Toast.makeText(this, "Nome da lista está vazio", Toast.LENGTH_SHORT).show();
    }
}
