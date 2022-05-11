package com.example.maquinaexpendedora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etCodigoProducto;
    private EditText etCategoriaProducto;
    private EditText etNombreProducto;
    private EditText etCantidad;
    private EditText etPrecio;
    private Switch swBillete;
    private Button btnTrabado;
    private Button btnRegistrar;

    private Maquina maquina;

    String codigoProducto;
    String categoriaProducto;
    String nombreProducto;
    String cantidad;
    String precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        swBillete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                activaBillete(b);
            }
        });
        btnRegistrar.setOnClickListener(view -> {
            //validar();
            obtenerInformacionEnObjeto();
            pasarSegundaPantalla();
            pasarPantallaEnviandoObjeto();

        });
        btnTrabado.setOnClickListener(view -> {
            Toast.makeText(this, "La maquina se trabo", Toast.LENGTH_SHORT).show();

        });


    }

    private void pasarPantallaEnviandoObjeto() {
        Intent i = new Intent(this,HomeActivity.class);
        Bundle archivo = new Bundle();
        archivo.putSerializable("pedido_objeto",maquina);
        archivo.putString("nombre producto" , nombreProducto);
        i.putExtras(archivo);
        startActivity(i);

    }

    private void obtenerInformacionEnObjeto() {
        maquina = new Maquina(
                etCodigoProducto.getText().toString(),
                etCategoriaProducto.getText().toString(),
                etNombreProducto.getText().toString(),
                Integer.parseInt(etCantidad.getText().toString()),
                Integer.parseInt(etPrecio.getText().toString())
        );
    }

    private void pasarSegundaPantalla() {
        Intent intencion = new Intent(this,HomeActivity.class);
        intencion.putExtra("codigo",etCodigoProducto.getText().toString());
        intencion.putExtra("categoria",etCategoriaProducto.getText().toString());
        startActivity(intencion);

    }


    private void inicializarVistas() {
        etCodigoProducto = findViewById(R.id.etCodigoProducto);
        etCategoriaProducto = findViewById(R.id.etCategoriaProducto);
        etNombreProducto = findViewById(R.id.etNombreProducto);
        etCantidad = findViewById(R.id.etCantidad);
        etPrecio = findViewById(R.id.etPrecio);
        swBillete = findViewById(R.id.swBillete);
        btnTrabado = findViewById(R.id.btnTrabado);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

    private void activaBillete(boolean marcado) {
        String mensaje = "Pago con moneda";
        if(marcado){
            mensaje = "Pago con billete";
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    private void validar() {
        codigoProducto = etCodigoProducto.getText().toString();
        categoriaProducto = etCategoriaProducto.getText().toString();
        nombreProducto = etNombreProducto.getText().toString();
        cantidad = etCantidad.getText().toString();
        precio = etPrecio.getText().toString();

        if (codigoProducto.length() == 0 || categoriaProducto.length()==0 || nombreProducto.length()==0||
                cantidad.length()==0||precio.length()==0){
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Codigo: " +codigoProducto+ '\''+categoriaProducto+ '\''+
                    nombreProducto+ '\''+cantidad+ '\''+precio+ '\''+ '\''+"No fue trabado", Toast.LENGTH_SHORT).show();
        }

    }
}
