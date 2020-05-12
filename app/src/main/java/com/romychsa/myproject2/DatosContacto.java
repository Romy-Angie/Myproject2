package com.romychsa.myproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosContacto extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView tvFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);

        Bundle parametros = getIntent().getExtras();
        String Nombre = parametros.getString(getResources().getString(R.string.intNombre));
        String Telefono = parametros.getString(getResources().getString(R.string.intTelefono));
        String Email = parametros.getString(getResources().getString(R.string.intEmail));
        String Descripcion = parametros.getString(getResources().getString(R.string.intDescripcion));
        String Fecha = parametros.getString(getResources().getString(R.string.intFecha));
        final int day = Integer.valueOf(parametros.getString(getResources().getString(R.string.day)));
        final int month = Integer.valueOf(parametros.getString(getResources().getString(R.string.month)));
        final int year = Integer.valueOf(parametros.getString(getResources().getString(R.string.year)));

        tvNombre =(TextView) findViewById(R.id.Nombre);
        tvTelefono =(TextView)findViewById(R.id.Telefono);
        tvEmail =(TextView)findViewById(R.id.Email);
        tvDescripcion =(TextView)findViewById(R.id.Descripcion);
        tvFecha =(TextView)findViewById(R.id.Fecha);

        tvNombre.setText(Nombre);
        tvTelefono.setText(Telefono);
        tvEmail.setText(Email);
        tvDescripcion.setText(Descripcion);
        tvFecha.setText(Fecha);


        Button editar = (Button)findViewById(R.id.btnEditar);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DatosContacto.this, MainActivity.class);
                intent1.putExtra(getResources().getString(R.string.intNombre), tvNombre.getText().toString());
                intent1.putExtra(getResources().getString(R.string.intTelefono), tvTelefono.getText().toString());
                intent1.putExtra(getResources().getString(R.string.intEmail), tvEmail.getText().toString());
                intent1.putExtra(getResources().getString(R.string.intDescripcion), tvDescripcion.getText().toString());
                intent1.putExtra(getResources().getString(R.string.intFecha), tvFecha.getText().toString());
                intent1.putExtra(getResources().getString(R.string.day), day);
                intent1.putExtra(getResources().getString(R.string.month), month);
                intent1.putExtra(getResources().getString(R.string.year), year);
                startActivity(intent1);
                finish();
            }
        });



    }
}
