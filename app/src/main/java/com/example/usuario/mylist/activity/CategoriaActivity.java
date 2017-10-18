package com.example.usuario.mylist.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.usuario.mylist.R;

/**
 * Created by Usuario on 15/10/2017.
 */

public class CategoriaActivity extends AppCompatActivity {

    private int positionCategoria;
    private EditText edtItensCategoria;
    private TextView txtCategoria;
    private String tituloLista;

    public static final String ARQUIVO_ITENS = "arquivo_itens";
    public static String ITENS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        edtItensCategoria = (EditText) findViewById(R.id.edtItensCategoria);
        txtCategoria = (TextView) findViewById(R.id.txtCategoria);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recebeDados();

        recuperaDados(positionCategoria);
    }

    public void recebeDados() {
        Bundle args = getIntent().getExtras();

        if (args != null) {

            String tituloCategoria = args.getString("nomeCategoria");
            positionCategoria = args.getInt("categoriaClicada");

            tituloLista = args.getString("tituloLista");

            txtCategoria.setText(tituloCategoria);
        }
    }

    public void salvarCategoria(View v) {

        Intent intent = new Intent(this, ListasActivity.class);
        Bundle parametros = new Bundle();

        parametros.putString("tituloLista", tituloLista);

        intent.putExtras(parametros);
        salvarItens(positionCategoria);

        startActivity(intent);
    }

    public void salvarItens(int positionCategoria) {
        String itensCategoria = edtItensCategoria.getText().toString();

        switchPosition(positionCategoria);

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_ITENS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(ITENS, itensCategoria);
        editor.commit();
    }

    public void recuperaDados(int positionCategoria) {

        switchPosition(positionCategoria);

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_ITENS, 0);
        String itensCategoria = sharedPreferences.getString(ITENS, "");

        edtItensCategoria.setText(itensCategoria, TextView.BufferType.EDITABLE);
    }

    public void switchPosition(int positionCategoria){
        switch (positionCategoria) {
            case 0:
                ITENS = "itens_frios_laticinios";
                break;
            case 1:
                ITENS = "itens_acougue";
                break;
            case 2:
                ITENS = "itens_higiene";
                break;
            case 3:
                ITENS = "itens_bebidas";
                break;
            case 4:
                ITENS = "itens_padaria";
                break;
            case 5:
                ITENS = "itens_mercearia";
                break;
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
}
