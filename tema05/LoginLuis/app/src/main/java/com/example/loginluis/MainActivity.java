package com.example.loginluis;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {

    private static final String CORREO_VALIDO = "luis@correo.com";
    private static final String CONTRASENA_VALIDA = "1234";

    private EditText etCorreo;
    private EditText etContrasena;
    private MaterialSwitch swRecordar;
    private Button btnContinuar;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        swRecordar = findViewById(R.id.swRecordar);
        btnContinuar = findViewById(R.id.btnContinuar);
        tvMensaje = findViewById(R.id.tvMensaje);

        btnContinuar.setOnClickListener(v -> comprobarAcceso());
    }

    private void comprobarAcceso() {
        String correo = etCorreo.getText().toString();
        String contrasena = etContrasena.getText().toString();

        boolean hayVacios = false;
        if (correo.isEmpty()) {
            etCorreo.setError(getString(R.string.error_correo));
            hayVacios = true;
        }
        if (contrasena.isEmpty()) {
            etContrasena.setError(getString(R.string.error_contrasena));
            hayVacios = true;
        }
        if (hayVacios) {
            return;
        }

        if (correo.equals(CORREO_VALIDO) && contrasena.equals(CONTRASENA_VALIDA)) {
            tvMensaje.setTextColor(getColor(R.color.verde));
            if (swRecordar.isChecked()) {
                tvMensaje.setText(R.string.msg_correcto_recordar);
            } else {
                tvMensaje.setText(R.string.msg_correcto);
            }
        } else {
            tvMensaje.setTextColor(getColor(R.color.rojo));
            tvMensaje.setText(R.string.msg_incorrecto);
        }
    }
}