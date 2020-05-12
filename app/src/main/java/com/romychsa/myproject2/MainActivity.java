package com.romychsa.myproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText etNombre, etTelefono, etEmail, etDescripcion;
        final DatePicker fechaNac;
        Button sig;


        etNombre =(TextInputEditText)findViewById(R.id.etNombre);
        etTelefono =(TextInputEditText)findViewById(R.id.etTelefono);
        etEmail =(TextInputEditText)findViewById(R.id.etEmail);
        etDescripcion=(TextInputEditText)findViewById(R.id.etDescripcion);
        fechaNac = (DatePicker) findViewById(R.id.cvFechaNacimiento);
        sig = (Button) findViewById(R.id.btnSiguiente);

        Bundle parametros1 = getIntent().getExtras();
        if(parametros1 != null){
            String Nombre = parametros1.getString(getResources().getString(R.string.intNombre));
            String Telefono = parametros1.getString(getResources().getString(R.string.intTelefono));
            String Email =parametros1.getString(getResources().getString(R.string.intEmail));
            String Descripcion =parametros1.getString(getResources().getString(R.string.intDescripcion));
            int day1 = Integer.valueOf(parametros1.getString(getResources().getString(R.string.day)));
            int month1 = Integer.valueOf(parametros1.getString(getResources().getString(R.string.month)));
            int year1 = Integer.valueOf(parametros1.getString(getResources().getString(R.string.year)));

            etNombre.setText(Nombre);
            etTelefono.setText(Telefono);
            etEmail.setText(Email);
            etDescripcion.setText(Descripcion);
            fechaNac.updateDate(year1, month1, day1);

        }


            sig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DatosContacto.class);
                    intent.putExtra(getResources().getString(R.string.intNombre), etNombre.getText().toString());
                    intent.putExtra(getResources().getString(R.string.intTelefono), etTelefono.getText().toString());
                    intent.putExtra(getResources().getString(R.string.intEmail), etEmail.getText().toString());
                    intent.putExtra(getResources().getString(R.string.intDescripcion), etDescripcion.getText().toString());
                    intent.putExtra(getResources().getString(R.string.intFecha), (String.valueOf(fechaNac.getDayOfMonth()) + "/" + String.valueOf(fechaNac.getMonth()) + "/" + String.valueOf(fechaNac.getYear())));
                    intent.putExtra(getResources().getString(R.string.day), String.valueOf(fechaNac.getDayOfMonth()));
                    intent.putExtra(getResources().getString(R.string.month), String.valueOf(fechaNac.getMonth()));
                    intent.putExtra(getResources().getString(R.string.year), String.valueOf(fechaNac.getYear()));
                    startActivity(intent);


                }
            });












    }
}
