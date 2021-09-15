package br.ufjf.dcc196.matheus.criafichat20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

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
        //Request da activity
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == ContinuacaoCriaPersonagem.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                        }
                    }
                }
        );
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
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberFor.getText().toString());
                if(verificaDecremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-decrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberFor.getText().toString()))));
                    textViewNumberFor.setText(String.valueOf(y-1));
                }
            }
        });
        textViewMenosDes=findViewById(R.id.textViewMenosDes);
        textViewMenosFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberDes.getText().toString());
                if(verificaDecremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-decrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberDes.getText().toString()))));
                    textViewNumberDes.setText(String.valueOf(y-1));
                }
            }
        });
        textViewMenosCon=findViewById(R.id.textViewMenosCon);
        textViewMenosCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberFor.getText().toString());
                if(verificaDecremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-decrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberCon.getText().toString()))));
                    textViewNumberCon.setText(String.valueOf(y-1));
                }
            }
        });
        textViewMenosInt=findViewById(R.id.textViewMenosInt);
        textViewMenosFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberInt.getText().toString());
                if(verificaDecremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-decrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberInt.getText().toString()))));
                    textViewNumberInt.setText(String.valueOf(y-1));
                }
            }
        });
        textViewMenosSab=findViewById(R.id.textViewMenosSab);
        textViewMenosSab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberSab.getText().toString());
                if(verificaDecremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-decrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberSab.getText().toString()))));
                    textViewNumberFor.setText(String.valueOf(y-1));
                }
            }
        });
        textViewMenosCar=findViewById(R.id.textViewMenosCar);
        textViewMenosCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberFor.getText().toString());
                if(verificaDecremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-decrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberCar.getText().toString()))));
                    textViewNumberCar.setText(String.valueOf(y-1));
                }
            }
        });
        //Soma
        textViewPlusFor=findViewById(R.id.textViewPlusFor);
        textViewPlusFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberFor.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-incrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberFor.getText().toString()))));
                    textViewNumberFor.setText(String.valueOf(y+1));
                }
            }
        });
        textViewPlusDes=findViewById(R.id.textViewPlusDes);
        textViewPlusDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberDes.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-incrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberDes.getText().toString()))));
                    textViewNumberDes.setText(String.valueOf(y+1));
                }
            }
        });
        textViewPlusCon=findViewById(R.id.textViewPlusCon);
        textViewPlusCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberCon.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-incrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberCon.getText().toString()))));
                    textViewNumberCon.setText(String.valueOf(y+1));
                }
            }
        });
        textViewPlusInt=findViewById(R.id.textViewPlusInt);
        textViewPlusInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberInt.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-incrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberInt.getText().toString()))));
                    textViewNumberInt.setText(String.valueOf(y+1));
                }
            }
        });
        textViewPlusSab=findViewById(R.id.textViewPlusSab);
        textViewPlusSab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberSab.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-incrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberSab.getText().toString()))));
                    textViewNumberSab.setText(String.valueOf(y+1));
                }
            }
        });
        textViewPlusCar=findViewById(R.id.textViewPlusCar);
        textViewPlusCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(textViewMudaValor.getText().toString());
                int y= Integer.parseInt(textViewNumberCar.getText().toString());
                if(verificaIncremento(y)){
                    textViewMudaValor.setText(String.valueOf((x-incrementa(y))+verificaPontoAtributo(Integer.parseInt(textViewNumberCar.getText().toString()))));
                    textViewNumberCar.setText(String.valueOf(y+1));
                }
            }
        });
        button=findViewById(R.id.buttonAtributosProx);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(getApplicationContext(), ContinuacaoCriaPersonagem.class);
                someActivityResultLauncher.launch(intent2);
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
        return valorAtributo[valor-7];
    }
    public int decrementa(int valor){
            return valorAtributo[valor-9];
    }

    public int verificaPontoAtributo(int pontoAtributo){
        return valorAtributo[pontoAtributo-8];
    }
}