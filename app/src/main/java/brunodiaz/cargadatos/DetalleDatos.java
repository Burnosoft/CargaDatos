package brunodiaz.cargadatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleDatos extends AppCompatActivity {

    private Button btnEditar;
    private String nombre;
    private String fecha;
    private String telefono;
    private String correo;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_datos);

        Bundle parametros = getIntent().getExtras();

        nombre = parametros.getString(getResources().getString(R.string.pNombre));
        fecha = parametros.getString(getResources().getString(R.string.pFecha));
        telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        correo = parametros.getString(getResources().getString(R.string.pEmail));
        descripcion = parametros.getString(getResources().getString(R.string.pDescripcion));


        TextView tvNombre = (TextView)findViewById(R.id.tvNombre);
        TextView tvFecha = (TextView)findViewById(R.id.tvFechaNacimiento);
        TextView tvTel = (TextView)findViewById(R.id.tvTelefono);
        TextView tvMail = (TextView)findViewById(R.id.tvEmail);
        TextView tvDesc = (TextView)findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTel.setText(telefono);
        tvMail.setText(correo);
        tvDesc.setText(descripcion);

        btnEditar = (Button)findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), EditarDatos.class);
                intent.putExtra(getResources().getString(R.string.pNombre), nombre);
                intent.putExtra(getResources().getString(R.string.pFecha), fecha);
                intent.putExtra(getResources().getString(R.string.pTelefono), telefono);
                intent.putExtra(getResources().getString(R.string.pEmail), correo);
                intent.putExtra(getResources().getString(R.string.pDescripcion), descripcion);
                startActivity(intent);
                finish();
            }
        });
    }
}
