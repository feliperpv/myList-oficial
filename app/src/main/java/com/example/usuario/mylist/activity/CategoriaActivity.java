package com.example.usuario.mylist.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.usuario.mylist.R;

/**
 * Created by Usuario on 15/10/2017.
 */

public class CategoriaActivity extends Activity {

    private int positionCategoria;
    private EditText edtItensCategoria;

    public static final String ITENS_FRIOS_LATICINIOS = "itens_frios_laticinios";
    public static final String ITENS_ACOUGUE = "itens_acougue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        edtItensCategoria = (EditText) findViewById(R.id.edtItensCategoria);

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
}
