package com.example.maquinaexpendedora;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    String codigoProducto, categoriaProducto, nombreProducto, cantidad, precio;

    private TextView txtPantalla2;
    private Maquina maquina;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        obtenerDatosPrimerPantalla();
        mostrarDatos();
       mostrarDatosDesdeObjeto();

    }
    //jhk

    private void mostrarDatos() {txtPantalla2.setText(nombreProducto+","+codigoProducto);
    }

    private void mostrarDatosDesdeObjeto() {
        maquina = (Maquina) this.getIntent().getExtras().getSerializable("pedido_objeto");
        txtPantalla2.setText(maquina.toString());

    }

    private void obtenerDatosPrimerPantalla() {
        codigoProducto = this.getIntent().getExtras().getString("codigo","");
        categoriaProducto = this.getIntent().getExtras().getString("categoria","");
        nombreProducto = this.getIntent().getExtras().getString("nombre","");

}

    private void inicializarVistas() {txtPantalla2= findViewById(R.id.txtPantalla2);  }
}
