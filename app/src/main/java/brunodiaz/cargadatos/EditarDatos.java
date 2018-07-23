package brunodiaz.cargadatos;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class EditarDatos extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mdateSetListener;
    private EditText mDisplayDate;
    private Button btnSiguiente;
    private String nombre;
    private String fecha;
    private String telefono;
    private String correo;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);


        // check if there are extras
        if( getIntent().getExtras() != null)
        {
            Bundle parametros = getIntent().getExtras();
            nombre = parametros.getString(getResources().getString(R.string.pNombre));
            fecha = parametros.getString(getResources().getString(R.string.pFecha));
            telefono = parametros.getString(getResources().getString(R.string.pTelefono));
            correo = parametros.getString(getResources().getString(R.string.pEmail));
            descripcion = parametros.getString(getResources().getString(R.string.pDescripcion));

            TextView tvNombre = (TextView)findViewById(R.id.etNombre);
            TextView tvFecha = (TextView)findViewById(R.id.etFecha);
            TextView tvTel = (TextView)findViewById(R.id.etTelefono);
            TextView tvMail = (TextView)findViewById(R.id.etEmail);
            TextView tvDesc = (TextView)findViewById(R.id.etDescripcion);

            tvNombre.setText(nombre);
            tvFecha.setText(fecha);
            tvTel.setText(telefono);
            tvMail.setText(correo);
            tvDesc.setText(descripcion);
        }
        mDisplayDate = (EditText) findViewById(R.id.etFecha);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EditarDatos.this,
                        AlertDialog.THEME_HOLO_LIGHT,
                        mdateSetListener,
                        year, month, day);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setTitle("Set Date               Fecha de Nacimiento");
                dialog.show();

            }


        });


        mdateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tvNombre = (TextView)findViewById(R.id.etNombre);
                TextView tvFecha = (TextView)findViewById(R.id.etFecha);
                TextView tvTel = (TextView)findViewById(R.id.etTelefono);
                TextView tvMail = (TextView)findViewById(R.id.etEmail);
                TextView tvDesc = (TextView)findViewById(R.id.etDescripcion);

                Intent intent = new Intent(view.getContext(), DetalleDatos.class);
                intent.putExtra(getResources().getString(R.string.pNombre), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pFecha), tvFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.pTelefono), tvTel.getText().toString());
                intent.putExtra(getResources().getString(R.string.pEmail), tvMail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pDescripcion),tvDesc.getText().toString());

                startActivity(intent);
                finish();
            }
        });



    }
}