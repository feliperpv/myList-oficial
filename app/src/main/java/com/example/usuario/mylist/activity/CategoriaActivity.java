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
    public static final String ITENS_HIGIENE= "itens_higiene";
    public static final String ITENS_BEBIDAS = "itens_bebidas";
    public static final String ITENS_PADARIA = "itens_padaria";
    public static final String ITENS_MERCEARIA = "itens_mercearia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        edtItensCategoria = (EditText) findViewById(R.id.edtItensCategoria);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recebeDados();

        recuperaDados(positionCategoria);
    }

    public void recebeDados(){
        Bundle args = getIntent().getExtras();

        positionCategoria = args.getInt("categoriaClicada");
    }

    public void salvarCategoria(View v) {

        salvarItens(positionCategoria);

        Intent intent = new Intent(this, ListasActivity.class);
//        Bundle parametros = new Bundle();
//
//        parametros.putString("itensCategoria", itensCategoria);
//
//        intent.putExtras(parametros);
        startActivity(intent);
        finish();
    }

    public void salvarItens(int positionCategoria){
        String itensCategoria = edtItensCategoria.getText().toString();

        if (positionCategoria == 0) {
            SharedPreferences sharedPreferences = getSharedPreferences(ITENS_FRIOS_LATICINIOS, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("itens_frios_laticinios", itensCategoria);
            editor.commit();
        }

        if (positionCategoria == 1) {
            SharedPreferences sharedPreferences = getSharedPreferences(ITENS_ACOUGUE, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("itens_acougue", itensCategoria);
            editor.commit();
        }

        if (positionCategoria == 2) {
            SharedPreferences sharedPreferences = getSharedPreferences(ITENS_HIGIENE, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("itens_higiene", itensCategoria);
            editor.commit();
        }

        if (positionCategoria == 3) {
            SharedPreferences sharedPreferences = getSharedPreferences(ITENS_BEBIDAS, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("itens_bebidas", itensCategoria);
            editor.commit();
        }

    }

    public void recuperaDados (int positionCategoria){

        if (positionCategoria == 0) {
            SharedPreferences sharedPreferences = getSharedPreferences(ITENS_FRIOS_LATICINIOS, 0);
            String itensCategoria = sharedPreferences.getString("itens_frios_laticinios", "");

            edtItensCategoria.setText(itensCategoria, TextView.BufferType.EDITABLE);
        }

        if (positionCategoria == 1) {
            SharedPreferences sharedPreferences = getSharedPreferences(ITENS_ACOUGUE, 0);
            String itensCategoria = sharedPreferences.getString("itens_acougue", "");

            edtItensCategoria.setText(itensCategoria, TextView.BufferType.EDITABLE);
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
