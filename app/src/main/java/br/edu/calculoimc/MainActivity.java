package br.edu.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editPeso, editAltura;
    TextView info, info2;
    Button btnCalcular;
    Funcao funcao;

    // cria o override e as três primeiras linhas sozinho depois de indicar a tela ativa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        funcao      = new Funcao();
        info        = findViewById(R.id.info);
        info2       = findViewById(R.id.info2);
        editPeso    = findViewById(R.id.editPeso);
        editAltura  = findViewById(R.id.editAltura);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validar campos
                if (editPeso.getText().toString().isEmpty()) {
                    funcao.mensagem(MainActivity.this, "ALERTA", "Insira seu peso atual.");
                    return;
                }

                if (editAltura.getText().toString().isEmpty()) {
                    funcao.mensagem(MainActivity.this, "ALERTA", "Insira sua altura.");
                    return;
                }

                // instanciando as variáveis
                double valorPeso   = 0;
                double valorAltura = 0;

                // não aceitar valores inválidos
                try {
                    valorPeso = Double.parseDouble(editPeso.getText().toString());
                }
                catch (Exception ex) {
                    funcao.mensagem(MainActivity.this, "ATENÇÃO", "Insira seu peso.");
                    return;
                }

                try {
                    valorAltura = Double.parseDouble(editAltura.getText().toString());
                }
                catch (Exception ex) {
                    funcao.mensagem(MainActivity.this, "ATENÇÃO", "Insira sua altura");
                    return;
                }

                double resultado = (valorPeso / (valorAltura * valorAltura));

                // resultado
                if (resultado >40) {
                    funcao.mensagem(MainActivity.this, "De acordo com os valores informados, seu IMC se é de",
                            resultado + ", isso consta em estado de obesidade grave (maior que 40).");
                }
                else if (resultado >30) {
                    funcao.mensagem(MainActivity.this, "De acordo com os valores informados, seu IMC se é de",
                            resultado + ", isso consta em estado de obesidade (entre 30 e 39.9).");
                }
                else if (resultado >25) {
                    funcao.mensagem(MainActivity.this, "De acordo com os valores informados, seu IMC se é de",
                            resultado + ", isso consta em estado sobrepeso (entre 25 e 29.9).");
                }
                else if (resultado >=18.5) {
                    funcao.mensagem(MainActivity.this, "De acordo com os valores informados, seu IMC se é de",
                            resultado + ", isso consta em estado normal (entre 18.5 e 24.9).");
                }
                else {
                    funcao.mensagem(MainActivity.this, "De acordo com os valores informados, seu IMC se é de",
                            resultado + ", isso consta em estado de magreza (menor que 18.5).");
                }
            }
        });
    }
}