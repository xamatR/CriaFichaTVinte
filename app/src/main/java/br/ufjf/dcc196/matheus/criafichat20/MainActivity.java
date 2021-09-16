package br.ufjf.dcc196.matheus.criafichat20;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private static final String[] raca = new String[] { "Humano","Anão", "Dahllan", "Italy", "Goblin", "Lefou","Minotauro","Qareen","Golem","Hynne","Kliren",
            "Medusa", "Osteon","Sereia/tritão","Sílfide","Aggelus","Sulfure","Trog" };

    private static final String[] classe= new String[]{"Arcanista Mago","Arcanista Bruxo","Arcanista Feiriceiro","Barbaro","Bardo","Bucaneiro","Caçador","Cavaleiro",
            "Clerigo","Druida","Guerreiro","Inventor","Ladino","Lutador","Nobre","Paladino"};

    private static final String[] origem = new String[]{"Acólito","Amigo dos Animais","Bardo","Amnésico","Aristocrata","Artesão",
            "Artista","Assistente de Laboratório","Batedor","Capanga","Charlatão","Circense","Criminoso","Curandeiro","Eremita",
            "Escravo","Estudioso","Fazendeiro","Forasteiro","Gladiador",
            "Guarda","Herdeiro","Herói Camponês","Marujo","Membro de Guilda","Mercador","Minerador",
            "Pivete","Refugiado","Seguidor","Selvagem","Soldado","Taverneiro","Trabalhador"};

    private static final String[] divindade = new String[] { "Aharadak","Allihanna", "Arsenal", "Azgher", "Hyninn", "Kallyadranoch","Khalmyr","Lena","Lin-Wu"
            ,"Marah","Megalokk","Nimb", "Sszzaas","Tanna-Toh","Tenebra","Thwor","Valkaria","Wynna" };

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
            add(new Personagem("Adedanha?","Barbaro","Golem"," "," ",20,14,16,8,8,10));
            add(new Personagem("Boteko","Cavaleiro","Humano","Nômade"," ",18,12,14,12,12,12));
            add(new Personagem("Furry","Bucaneiro","Qareen","Nômade"," ", 11,14,11,18,11,13));
            add(new Personagem("Pisquei Morri","Ladino", "Goblin", "Pivete", "Hynne",10,16,14,10,12,12));
            add(new Personagem("Traqkinas","Nobre","Humano","Herdeiro","Sszzaas",12,8,14,14,14,16));
            //add(new Personagem("Pouca Telha","Paladino","Humano","Acólito",))
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
                fichas.remove(viewHolder.getAdapterPosition());
                pesonagemAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
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