package br.ufjf.dcc196.matheus.criafichat20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContinuacaoCriaPersonagem extends AppCompatActivity {
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

    private AutoCompleteTextView autoCompleteTextViewRaca;
    private AutoCompleteTextView autoCompleteTextViewOrigem;
    private AutoCompleteTextView autoCompleteTextViewDivindade;
    private AutoCompleteTextView autoCompleteTextViewClasse;
    private Button buttonTermina;
    private EditText nomePersonagem;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuacao_cria_personagem);

        nomePersonagem=findViewById(R.id.editTextTextNomePersonagem);

        ArrayAdapter<String> adapterClasse = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, classe);
        autoCompleteTextViewClasse = findViewById(R.id.autoCompleteTextViewClasse);
        autoCompleteTextViewClasse.setAdapter(adapterClasse);

        ArrayAdapter<String> adapterRaca = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, raca);
        autoCompleteTextViewRaca = findViewById(R.id.autoCompleteTextViewRaca);
        autoCompleteTextViewRaca.setAdapter(adapterRaca);

        ArrayAdapter<String> adapterOrigem = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, origem);
        autoCompleteTextViewOrigem = findViewById(R.id.autoCompleteTextViewOrigem);
        autoCompleteTextViewOrigem.setAdapter(adapterOrigem);

        ArrayAdapter<String> adapterDivindade = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, divindade);
        autoCompleteTextViewDivindade = findViewById(R.id.autoCompleteTextViewDivindade);
        autoCompleteTextViewDivindade.setAdapter(adapterDivindade);

        buttonTermina=findViewById(R.id.buttonTermina);
        buttonTermina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //if (verificaCampoClasse()&&verificaCampoOrigem()&&verificaCampoRaca()&&verificaCampoDivindade()&&verificaCampoNome()){
                    Intent intent3= new Intent(getApplicationContext(),CriaActivity.class);
                    intent3.putExtra("NOME",nomePersonagem.getText().toString());
                    intent3.putExtra("CLASSE",autoCompleteTextViewClasse.getText().toString());
                    intent3.putExtra("ORIGEM",autoCompleteTextViewOrigem.getText().toString());
                    intent3.putExtra("RACA",autoCompleteTextViewRaca.getText().toString());
                    intent3.putExtra("DIVINDADE",autoCompleteTextViewDivindade.getText().toString());
                    setResult(RESULT_OK,intent3);
                    finish();
                }
            //}
        });
    }

    public boolean verificaCampoRaca(){
        for(int i=0 ;raca.length>=i; i++){
            if (raca[i].lastIndexOf(autoCompleteTextViewRaca.getText().toString())==-1){
                autoCompleteTextViewRaca.setError("Raça invalida.");
                return false;
            }
        }
        return true;
    }
    public boolean verificaCampoClasse(){
        for(int i=0 ;classe.length>=i; i++){
            if (classe[i].lastIndexOf(autoCompleteTextViewClasse.getText().toString())==-1){
                autoCompleteTextViewClasse.setError("Classe invalida.");
                return false;
            }
        }
        return true;
    }

    public boolean verificaCampoOrigem(){
        for(int i=0 ;origem.length>=i; i++){
            if (origem[i].lastIndexOf(autoCompleteTextViewOrigem.getText().toString())==-1){
                autoCompleteTextViewClasse.setError("Origem invalida.");
                return false;
            }
        }
        return true;
    }
    public boolean verificaCampoNome(){
        if (nomePersonagem.getText().toString().isEmpty()) {
            nomePersonagem.setError("Este campo é obrigatório");
            return false;
        }
        return true;
    }
    public boolean verificaCampoDivindade(){
        if(autoCompleteTextViewDivindade.getText().toString().isEmpty()){
            return true;
        }else{
            for (int i = 0; divindade.length >= i; i++) {
                if (divindade[i].lastIndexOf(autoCompleteTextViewDivindade.getText().toString()) == -1){
                    autoCompleteTextViewDivindade.setError("Divindade invalida.");
                    return false;
                }
            }
            return true;
        }

    }

}
