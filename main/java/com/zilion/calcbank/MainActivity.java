package com.zilion.calcbank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import model.ContaEspecial;
import model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCliente, editTextNumeroConta, editTextSaldo, editTextDiaRendimento, editTextLimite;
    private RadioGroup radioGroupTipoConta;
    private RadioButton radioContaPoupanca, radioContaEspecial;
    private Button buttonCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCliente = findViewById(R.id.editTextCliente);
        editTextNumeroConta = findViewById(R.id.editTextNumeroConta);
        editTextSaldo = findViewById(R.id.editTextSaldo);
        editTextDiaRendimento = findViewById(R.id.editTextDiaRendimento);
        editTextLimite = findViewById(R.id.editTextLimite);
        radioGroupTipoConta = findViewById(R.id.radioGroupTipoConta);
        radioContaPoupanca = findViewById(R.id.radioContaPoupanca);
        radioContaEspecial = findViewById(R.id.radioContaEspecial);
        buttonCriarConta = findViewById(R.id.buttonCriarConta);

        radioGroupTipoConta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioContaPoupanca) {
                    editTextDiaRendimento.setVisibility(View.VISIBLE);
                    editTextLimite.setVisibility(View.GONE);
                } else if (checkedId == R.id.radioContaEspecial) {
                    editTextDiaRendimento.setVisibility(View.GONE);
                    editTextLimite.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarConta();
            }
        });
    }

    private void criarConta() {
        String cliente = editTextCliente.getText().toString();
        int numConta = Integer.parseInt(editTextNumeroConta.getText().toString());
        float saldo = Float.parseFloat(editTextSaldo.getText().toString());

        if (radioContaPoupanca.isChecked()) {
            int diaRendimento = Integer.parseInt(editTextDiaRendimento.getText().toString());
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, numConta, saldo, diaRendimento);
            Toast.makeText(this, R.string.msg_conta_poupanca_criada, Toast.LENGTH_SHORT).show();
        } else if (radioContaEspecial.isChecked()) {
            float limite = Float.parseFloat(editTextLimite.getText().toString());
            ContaEspecial contaEspecial = new ContaEspecial(cliente, numConta, saldo, limite);
            Toast.makeText(this, R.string.msg_conta_especial_criada, Toast.LENGTH_SHORT).show();
        }
    }
}
