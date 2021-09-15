package br.ufjf.dcc196.matheus.criafichat20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FichaPersonagemDetalhada extends AppCompatActivity {
    private TextView textViewNome;
    private TextView textViewRaca;
    private TextView textViewOrigem;
    private TextView textViewClasse;
    private TextView textViewDivindade;
    private TextView textViewNivel;
    private TextView textViewPontosVida;
    private TextView textViewPontosMana;
    private TextView textViewForca;
    private TextView textViewDestreza;
    private TextView textViewConstituicao;
    private TextView textViewInteligencia;
    private TextView textViewSabedoria;
    private TextView textViewCarisma;
    private TextView textViewForçaMod;
    private TextView textViewDestrezaMod;
    private TextView textViewConstituicaoMod;
    private TextView textViewInteligenciaMod;
    private TextView textViewSabedoriaMod;
    private TextView textViewCarismaMod;
    private TextView textViewPoderesClasse;
    private TextView textViewPoderesRaca;
    private TextView textViewPoderesOrigem;
    private TextView textViewPoderesDivindade;
    private TextView textViewEnergiaDivindade;
    private TextView textViewArmaDivindade;
    private TextView textViewPericias;
    private TextView textViewPericiasAdicionais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_personagem_detalhada);
        Bundle extra = getIntent().getExtras();
        textViewNome=findViewById(R.id.textViewNomeDetail);
        textViewRaca=findViewById(R.id.textViewRacaDetail);
        textViewOrigem=findViewById(R.id.textViewOrigemDetail);
        textViewClasse=findViewById(R.id.textViewClasseDetail);
        textViewDivindade=findViewById(R.id.textViewDivindadeDetail);
        textViewNivel=findViewById(R.id.textViewNivelDetail);
        textViewPontosVida=findViewById(R.id.textViewEditPVDetails);
        textViewPontosMana=findViewById(R.id.textViewEditPmDetails);
        textViewForca =findViewById(R.id.textViewForEditDetail);
        textViewDestreza=findViewById(R.id.textViewDesEditDetail);
        textViewConstituicao =findViewById(R.id.textViewConEditDetail);
        textViewInteligencia=findViewById(R.id.textViewIntEditDetail);
        textViewSabedoria=findViewById(R.id.textViewSabEditDetail);
        textViewCarisma=findViewById(R.id.textViewCarEditDetail);
        textViewForçaMod=findViewById(R.id.textViewModForEditDetail);
        textViewDestrezaMod=findViewById(R.id.textViewModDesEditDetail);
        textViewConstituicaoMod =findViewById(R.id.textViewModConEditDetail);
        textViewInteligenciaMod=findViewById(R.id.textViewModIntEditDetail);
        textViewSabedoriaMod=findViewById(R.id.textViewModSabEditDetail);
        textViewCarismaMod=findViewById(R.id.textViewModCarEditDetail);
        textViewPoderesClasse=findViewById(R.id.textViewPoderesClasseEdit);
        textViewPoderesRaca=findViewById(R.id.textViewPoderesRaçaEdit);
        textViewPoderesDivindade=findViewById(R.id.textViewPoderesDivindadeEdit);
        textViewEnergiaDivindade=findViewById(R.id.textViewEnergiaDivindadeEdit);
        textViewArmaDivindade=findViewById(R.id.textViewArmaDivindadeEdit);
        textViewPoderesOrigem=findViewById(R.id.textViewPoderesOrigemEdit);
        textViewPericias=findViewById(R.id.textViewPericias);
        textViewPericiasAdicionais=findViewById(R.id.textViewPericiasAdicionais);

        textViewNome.setText(extra.getString("nome"));
        textViewClasse.setText(extra.getString("classe")+":");
        textViewOrigem.setText(extra.getString("origem"));
        textViewRaca.setText(extra.getString("raca"));
        textViewDivindade.setText(extra.getString("divindade"));
        textViewNivel.setText(String.valueOf(extra.getInt("nivel")));
        textViewPontosVida.setText(String.valueOf(extra.getInt("pontosvida")));
        textViewPontosMana.setText(String.valueOf(extra.getInt("pontosMana")));
        textViewForca.setText(String.valueOf(extra.getInt("forca")));
        textViewDestreza.setText(String.valueOf(extra.getInt("destreza")));
        textViewConstituicao.setText(String.valueOf(extra.getInt("constituição")));
        textViewInteligencia.setText(String.valueOf(extra.getInt("inteligencia")));
        textViewSabedoria.setText(String.valueOf(extra.getInt("sabedoria")));
        textViewCarisma.setText(String.valueOf(extra.getInt("carisma")));
        textViewForçaMod.setText(String.valueOf(extra.getInt("modForca")));
        textViewDestrezaMod.setText(String.valueOf(extra.getInt("modDestreza")));
        textViewConstituicaoMod.setText(String.valueOf(extra.getInt("modConstituição")));
        textViewInteligenciaMod.setText(String.valueOf(extra.getInt("modInteligencia")));
        textViewSabedoriaMod.setText(String.valueOf(extra.getInt("modSabedoria")));
        textViewCarismaMod.setText(String.valueOf(extra.getInt("modCarisma")));
        textViewPoderesOrigem.setText(extra.getString("poderesOrigem"));
        textViewPoderesClasse.setText(extra.getString("poderesClasse"));
        textViewPoderesRaca.setText(extra.getString("poderesRaca"));
        textViewPericias.setText(extra.getString("pericias"));
        textViewPericiasAdicionais.setText("Você recebe um número de perícias treinadas acionais igual " +extra.get("modInteligencia") +". Essas perícias não precisam ser da sua classe.");
        String s = extra.getString("divindade");
        if(extra.getBoolean("temDivindade")){
            textViewDivindade.setText(extra.getString("divindade"));
            textViewPoderesDivindade.setText(extra.getString("poderesDivindade"));
            textViewEnergiaDivindade.setText("Energia: "+extra.getString("energiaDivindade"));
            textViewArmaDivindade.setText("Arma: "+extra.getString("armaDivindade"));
        }else{
            textViewDivindade.setText("Não segue nenhuma divindade.");
            textViewEnergiaDivindade.setVisibility(View.GONE);
            textViewPoderesDivindade.setVisibility(View.GONE);
            textViewArmaDivindade.setVisibility(View.GONE);
        }








    }
}