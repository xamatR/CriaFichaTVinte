package br.ufjf.dcc196.matheus.criafichat20;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonagemAdapter.OnPersonagemClickListener{
    private Button buttonCria;
    private RecyclerView recyclerViewFichas;
    private List<Personagem> fichas;
    private LinearLayoutManager layoutManager;
    private PersonagemAdapter pesonagemAdapter;
    private Button buttonDescrição;
    private ItemTouchHelper.SimpleCallback touchHelperCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
           new ActivityResultContracts.StartActivityForResult(),
           new ActivityResultCallback<ActivityResult>() {
               @Override
               public void onActivityResult(ActivityResult result) {
                 if (result.getResultCode() == CriaActivity.RESULT_OK) {
                 // There are no request codes
                    Intent data = result.getData();
                    Personagem personagem= new Personagem(data.getExtras().getString("NOME"),data.getExtras().getString("CLASSE"),
                            data.getExtras().getString("RACA"),data.getExtras().getString("ORIGEM"),data.getExtras().getString("DIVINDADE"),
                            data.getExtras().getInt("FORCA"),data.getExtras().getInt("DESTREZA"),data.getExtras().getInt("CONSTITUICAO"),
                            data.getExtras().getInt("INTELIGENCIA"),data.getExtras().getInt("SABEDORIA"),data.getExtras().getInt("CARISMA"));
                    fichas.add(personagem);
                    pesonagemAdapter.notifyItemInserted(fichas.size());
                 }
               }
           }
        );
        buttonDescrição=findViewById(R.id.buttonDescrição);
        fichas= new ArrayList<Personagem>(){{
            add(new Personagem("Luna","Clerigo","Humano","Acólito","Tenebra",12,8,14,14,16,14));
            add(new Personagem("Adedanha?","Barbaro","Golem"," "," ",16,14,14,8,8,10));
            add(new Personagem("Boteko","Cavaleiro","Humano","Nômade"," ",18,12,14,12,12,12));
            add(new Personagem("Furry","Bucaneiro","Qareen","Nômade"," ", 11,14,11,18,11,13));
            add(new Personagem("Pisquei Morri","Ladino", "Goblin", "Pivete", "Hynne",10,16,14,10,12,12));
            add(new Personagem("Traqkinas","Nobre","Humano","Herdeiro","Sszzaas",12,8,14,14,14,16));
            add(new Personagem("Pouca Telha","Paladino","Humano","Herói Camponês","Khalmyr",16,8,12,12,14,12));
            add(new Personagem("Lil Nas X","Guerreiro","Humano","Nômade"," ",16,15,14,12,12,8));
            add(new Personagem("Beta Nórdico","Guerreiro","Trog","Membro de Guilda"," ",16,12,14,10,12,8));
        }};
        recyclerViewFichas = findViewById(R.id.recyclerViewFichas);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFichas.setLayoutManager(layoutManager);
        pesonagemAdapter= new PersonagemAdapter(fichas,this);
        recyclerViewFichas.setAdapter(pesonagemAdapter);
        buttonCria=findViewById(R.id.buttonCria);
        buttonCria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), CriaActivity.class);
                someActivityResultLauncher.launch(intent);
            }
        });
        buttonDescrição.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            Intent nIntent= new Intent(getApplicationContext(),ActivityDescricao.class);
            startActivity(nIntent);
            }
        });
        touchHelperCallBack = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Exvluir").setMessage("Deseja excluir a ficha do personagem " + fichas.get(viewHolder.getAdapterPosition()).getNome() + "?")
                        .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                fichas.remove(viewHolder.getAdapterPosition());
                                pesonagemAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                pesonagemAdapter.notifyItemChanged(viewHolder.getAdapterPosition());
                            }
                        });
            }
        };
        new ItemTouchHelper(touchHelperCallBack).attachToRecyclerView(recyclerViewFichas);

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
        intent.putExtra("temDivindade",fichas.get(position).getTemDivindade());
        intent.putExtra("armaDivindade",fichas.get(position).getArmaDivindade());
        intent.putExtra("pericias",fichas.get(position).getPericiasClasse());
        startActivity(intent);
    }
}