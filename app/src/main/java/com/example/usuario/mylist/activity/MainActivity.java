package com.example.usuario.mylist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.mylist.R;
import com.example.usuario.mylist.adapter.ListasAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lista;
    private ArrayAdapter<String> adapter;
    public static final ArrayList<String> LISTAS = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recebeDados();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LISTAS);

        lista = (ListView) findViewById(R.id.lvListas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);

    }

    public void toNovaLista(View v) {
        Intent intent = new Intent(this, NovaListaActivity.class);
        startActivity(intent);
    }

    public void recebeDados(){
        Bundle args = getIntent().getExtras();

        if (args != null) {
            String nomeNovaLista = args.getString("nomeNovaLista");

            if (nomeNovaLista != null){
                LISTAS.add(nomeNovaLista);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(onSearch());

        return true;
    }

    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == android.R.id.home) {
            finish();
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String tituloLista = (String) adapterView.getAdapter().getItem(i);
        Toast.makeText(this, "Texto selecionado: " + tituloLista + " posicao: " + i,
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ListasActivity.class);
        Bundle parametros = new Bundle();
        parametros.putString("tituloLista", tituloLista);

        intent.putExtras(parametros);
        startActivity(intent);
        finish();
    }

}
