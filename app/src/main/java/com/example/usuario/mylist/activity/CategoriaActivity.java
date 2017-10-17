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

    public static final String ITENS_FRIOS_LATICINIOS = "itens_frios_laticinios";
    public static final String ITENS_ACOUGUE = "itens_acougue";
    public static final String ITENS_HIGIENE = "itens_higiene";
    public static final String ITENS_BEBIDAS = "itens_bebidas";
    public static final String ITENS_PADARIA = "itens_padaria";
    public static final String ITENS_MERCEARIA = "itens_mercearia";

    public static String ITENS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        edtItensCategoria = (EditText) findViewById(R.id.edtItensCategoria);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recebeDados();

        recuperaDados(positionCategoria);
    }

    public void recebeDados() {
        Bundle args = getIntent().getExtras();

        positionCategoria = args.getInt("categoriaClicada");
    }

    public void salvarCategoria(View v) {

        salvarItens(positionCategoria);

        Intent intent = new Intent(this, ListasActivity.class);
        startActivity(intent);
    }

    public void salvarItens(int positionCategoria) {
        String itensCategoria = edtItensCategoria.getText().toString();

        switchPosition(positionCategoria);

        SharedPreferences sharedPreferences = getSharedPreferences(ITENS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(ITENS, itensCategoria);
        editor.commit();
    }

    public void recuperaDados(int positionCategoria) {

        switchPosition(positionCategoria);

        SharedPreferences sharedPreferences = getSharedPreferences(ITENS, 0);
        String itensCategoria = sharedPreferences.getString(ITENS, "");

        edtItensCategoria.setText(itensCategoria, TextView.BufferType.EDITABLE);
    }

    public void switchPosition(int positionCategoria){
        switch (positionCategoria) {
            case 0:
                ITENS = ITENS_FRIOS_LATICINIOS;
                break;
            case 1:
                ITENS = ITENS_ACOUGUE;
                break;
            case 2:
                ITENS = ITENS_HIGIENE;
                break;
            case 3:
                ITENS = ITENS_BEBIDAS;
                break;
            case 4:
                ITENS = ITENS_PADARIA;
                break;
            case 5:
                ITENS = ITENS_MERCEARIA;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
