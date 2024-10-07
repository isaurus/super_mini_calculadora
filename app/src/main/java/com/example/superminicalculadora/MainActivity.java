package com.example.superminicalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables de los campos de texto para introducir dos valores
    EditText edtNumOne;
    EditText edtNumTwo;

    // Etiqueta para mostrar el resultado de la operación
    TextView txtResult;

    // Variables para recoger (y parsear) el valor introducido en los Edit Text
    int numOne;
    int numTwo;

    // Variable para recoger el resultado de las operaciones
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // No hace falta declarar los objetos (¿POR QUÉ?)
        findViewById(R.id.btnSum).setOnClickListener(v -> calcular(1));
        findViewById(R.id.btnRes).setOnClickListener(v -> calcular(2));
        findViewById(R.id.btnMul).setOnClickListener(v -> calcular(3));
        findViewById(R.id.btnDiv).setOnClickListener(v -> calcular(4));

        findViewById(R.id.btnErase).setOnClickListener(v -> borrar());

        // Instancia de los campos de texto
        edtNumOne = findViewById(R.id.edtNumOne);
        edtNumTwo = findViewById(R.id.edtNumTwo);

        // Instancia de la etiqueta
        txtResult = findViewById(R.id.txtResult);
    }

    // Método para realizar el cálculo de las operaciones
    private void calcular(int operacionId){
        numOne = Integer.parseInt(edtNumOne.getText().toString());
        numTwo = Integer.parseInt(edtNumTwo.getText().toString());
        result = 0.0;
        switch (operacionId){
            case 1: result = (double) numOne + numTwo;
                break;
            case 2: result = (double) numOne - numTwo;
                break;
            case 3: result = (double) numOne * numTwo;
                break;
            case 4: result = (double) numOne / numTwo;
                break;
        }
        txtResult.setText("" + result);
    }

    // Método para borrar el contenido de las cajas de texto al pulsar el botón BORRAR
    public void borrar(){
        edtNumOne.setText("");
        edtNumTwo.setText("");
        txtResult.setText("");
    }
}