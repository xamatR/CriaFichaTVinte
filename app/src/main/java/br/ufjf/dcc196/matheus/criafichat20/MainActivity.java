package br.ufjf.dcc196.matheus.criafichat20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
            add(new Personagem("T.E.S.L.A","Barbaro","Golen"," "," ",20,14,16,8,8,10));
        }};
        recyclerViewFichas = findViewById(R.id.recyclerViewFichas);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFichas.setLayoutManager(layoutManager);
        pesonagemAdapter= new PersonagemAdapter(fichas);
        recyclerViewFichas.setAdapter(pesonagemAdapter);
        buttonCria=findViewById(R.id.buttonCria);
    }
}