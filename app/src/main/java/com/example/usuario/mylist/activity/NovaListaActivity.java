package com.example.usuario.mylist.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class NovaListaActivity extends Activity {

    public ListView categoria;

    public static final ArrayList<String> CATEGORIAS = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_lista);

        android.app.ActionBar actionBar = getActionBar();

    }

    public void toAdicionarCategoria(View v) {

        Intent intent = new Intent(this, CategoriaActivity.class);
        startActivity(intent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toastNomeNovaListaEmpty() {
        Toast.makeText(this, "Nome da lista está vazio", Toast.LENGTH_SHORT).show();
    }
}
