package br.ufjf.dcc196.matheus.criafichat20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CriaActivity extends AppCompatActivity {
    private Button button;
    private TextView textViewMudaValor;
    private TextView textViewMenosFor;
    private TextView textViewMenosDes;
    private TextView textViewMenosCon;
    private TextView textViewMenosInt;
    private TextView textViewMenosSab;
    private TextView textViewMenosCar;
    private TextView textViewNumberFor;
    private TextView textViewNumberDes;
    private TextView textViewNumberCon;
    private TextView textViewNumberInt;
    private TextView textViewNumberSab;
    private TextView textViewNumberCar;
    private TextView textViewPlusFor;
    private TextView textViewPlusDes;
    private TextView textViewPlusCon;
    private TextView textViewPlusInt;
    private TextView textViewPlusSab;
    private TextView textViewPlusCar;
    private static final int[] valorAtributo={-2,-1,0,1,2,3,4,6,8,11,14};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria);
        //Numeros que mudam
        textViewNumberFor=findViewById(R.id.textViewNumberFor);
        textViewNumberDes=findViewById(R.id.textViewNumberDes);
        textViewNumberCon=findViewById(R.id.textViewNumberCon);
        textViewNumberInt=findViewById(R.id.textViewNumberInt);
        textViewNumberSab=findViewById(R.id.textViewNumberSab);
        textViewNumberCar=findViewById(R.id.textViewNumberCar);
        textViewMudaValor=findViewById(R.id.textViewMudaValor);
        //subtrai
        textViewMenosFor=findViewById(R.id.textViewMenosFor);
        textViewMenosFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(verificaIncremento((int) Float.parseFloat(textViewNumberFor.getText().toString()))){
                    textViewMudaValor.setText((int)Float.parseFloat(textViewMudaValor.getText().toString())-decrementa((int) Float.parseFloat(textViewNumberFor.getText().toString())));
                    textViewNumberFor.setText(String.valueOf((int) Float.parseFloat(textViewNumberFor.getText().toString())-1));
                }
            }
        });
        textViewMenosDes=findViewById(R.id.textViewMenosDes);
        textViewMenosCon=findViewById(R.id.textViewMenosCon);
        textViewMenosInt=findViewById(R.id.textViewMenosInt);
        textViewMenosSab=findViewById(R.id.textViewMenosSab);
        textViewMenosCar=findViewById(R.id.textViewMenosCar);
        //Soma
        textViewPlusFor=findViewById(R.id.textViewPlusFor);
        textViewPlusFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberFor.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf(x-incrementa(y)));
                    textViewNumberFor.setText(String.valueOf(y+1));
                }
            }
        });
        textViewPlusDes=findViewById(R.id.textViewPlusDes);
        textViewPlusCon=findViewById(R.id.textViewPlusCon);
        textViewPlusInt=findViewById(R.id.textViewPlusInt);
        textViewPlusSab=findViewById(R.id.textViewPlusSab);
        textViewPlusCar=findViewById(R.id.textViewPlusCar);
        button=findViewById(R.id.buttonAtributosProx);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("teste","teste");
                setResult(RESULT_OK,intent);
                            }
        });

    }
    public boolean verificaIncremento(int valor){
        if (valor+1<=18){
            return true;
        }else {
            Toast.makeText(this, "Não pode incrementar o valor acima de 18.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public Boolean verificaDecremento(int valor){
        if (valor-1>=8){
            return true;
        }else {
            Toast.makeText(this, "Não pode diminuir o valor abaixo de 8.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public int incrementa(int valor){
        return valorAtributo[valor-8];
    }
    public int decrementa(int valor){
            return valorAtributo[valor-8];
    }
}