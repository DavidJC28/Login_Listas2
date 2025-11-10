package com.example.login_listas1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private EditText tCorreo;
    private EditText tContraseña;
    private Switch sRecordar;
    private Button bContinuar;
    private TextView textCorrecto;
    

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


        tCorreo = findViewById(R.id.etCorreo);
        tContraseña = findViewById(R.id.etContrseña);
        sRecordar = findViewById(R.id.sRecordar);
        bContinuar = findViewById(R.id.bContinuar);
        textCorrecto = findViewById(R.id.textCorrecto);


        bContinuar.setOnClickListener(view -> {
            String correo = tCorreo.getText().toString();
            String contraseña = tContraseña.getText().toString();
            boolean recordar = sRecordar.isChecked();
                
            if (correo.equals("correo@correo.com") && contraseña.equals("123")) {
                if (recordar) {
                    textCorrecto.setText("Usuario y contraseña correctos ycorr guardados");
                } else {
                    textCorrecto.setText("Usuario y contraseña correctos");
                }
                textCorrecto.setTextColor(Color.GREEN);
            } else {
                textCorrecto.setText("Usuario y contraseña incorrectos");
                textCorrecto.setTextColor(Color.RED);
            }
        });
    }
}
