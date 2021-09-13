package br.ufjf.dcc196.matheus.criafichat20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonagemAdapter.OnPersonagemClickListener{
    private Button buttonCria;
    private RecyclerView recyclerViewFichas;
    private List<Personagem> fichas;
    private LinearLayoutManager layoutManager;
    private PersonagemAdapter pesonagemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fichas= new ArrayList<Personagem>(){{
            add(new Personagem("Luna","Clerigo","Humano","Acólito","Tenebra",12,8,14,16,18,16));
            add(new Personagem("T.E.S.L.A.","Barbaro","Golen"," "," ",20,14,16,8,8,10));
        }};
        recyclerViewFichas = findViewById(R.id.recyclerViewFichas);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFichas.setLayoutManager(layoutManager);
        pesonagemAdapter= new PersonagemAdapter(fichas,this);
        recyclerViewFichas.setAdapter(pesonagemAdapter);
        buttonCria=findViewById(R.id.buttonCria);
    }

    @Override
    public void onPersonagemClick(View view, int position){
        Intent intent = new Intent(getApplicationContext(), FichaPersonagemDetalhada.class);
        intent.putExtra("nome", fichas.get(position).getNome());
        intent.putExtra("classe", fichas.get(position).getClasse());
        intent.putExtra("origem", fichas.get(position).getOrigem());
        intent.putExtra("raca", fichas.get(position).getRaca());
        intent.putExtra("divindade", fichas.get(position).getDivindade());
        intent.putExtra("nivel", fichas.get(position).getNivel());
        intent.putExtra("pontosvida", fichas.get(position).getPontosvida());
        intent.putExtra("pontosMana", fichas.get(position).getPontosMana());
        intent.putExtra("forca", fichas.get(position).getForca());
        intent.putExtra("destreza", fichas.get(position).getDestreza());
        intent.putExtra("constituição", fichas.get(position).getConstituição());
        intent.putExtra("inteligencia", fichas.get(position).getInteligencia());
        intent.putExtra("sabedoria", fichas.get(position).getSabedoria());
        intent.putExtra("carisma", fichas.get(position).getCarisma());
        intent.putExtra("modForca", fichas.get(position).getModForca());
        intent.putExtra("modDestreza", fichas.get(position).getModDestreza());
        intent.putExtra("modConstituição", fichas.get(position).getModConstituição());
        intent.putExtra("modInteligencia", fichas.get(position).getModInteligencia());
        intent.putExtra("modSabedoria", fichas.get(position).getModSabedoria());
        intent.putExtra("modCarisma", fichas.get(position).getModCarisma());
        intent.putExtra("poderesClasse", fichas.get(position).getPoderesClasse());
        intent.putExtra("poderesRaca", fichas.get(position).getPoderesRaca());
        intent.putExtra("poderesOrigem", fichas.get(position).getPoderesOrigem());
        intent.putExtra("poderesDivindade", fichas.get(position).getPoderesDivindade());
        intent.putExtra("energiaDivindade", fichas.get(position).getEnergiaDivindade());
        intent.putExtra("armaDivindade",fichas.get(position).getArmaDivindade());
        startActivity(intent);
    }
}