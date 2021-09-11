package br.ufjf.dcc196.matheus.criafichat20;

public class Personagem {
    static final private int[] valorModificadores = {-5,-4,-4,-3,-3,-2,-2,-1,-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};

    private String nome;
    private String classe;
    private String raca;
    private String origem;
    private String divindade;
    private int nivel;
    private int pontosvida;
    private int pontosMana;
    private int forca;
    private int destreza;
    private int constituição;
    private int inteligencia;
    private int sabedoria;
    private int carisma;

    // Modificadores de atributo
    private int modForca;
    private int modDestreza;
    private int modConstituição;
    private int modInteligencia;
    private int modSabedoria;
    private int modCarisma;

    //Lista de poderes por classe ,raça e origem
    String poderesClasse;
    String poderesRaca;
    String poderesOrigem;
    String poderesDivindade;

/*
    //pericias
    private int acrobacia;
    private int adestramento;
    private int atletismo;
    private int atuacao;
    private int cavalgar;
    private int conhecimento;
    private int cura;
    private int diplomacia;
    private int enganacao;
    private int fortitude;
    private int furtividade;
    private int guerra;
    private int iniciativa;
    private int intimidacao;
    private int intuicao;
    private int investigacao;
    private int jogatina;
    private int ladinagem;
    private int luta;
    private int misticismo;
    private int nobreza;
    private int oficio;
    private int percepcao;
    private int pilotagem;
    private int pontaria;
    private int reflexos;
    private int religiao;
    private int sobrevivencia;
    private int vontade;

    //treinamento em pericia
    private boolean tAcrobacia;
    private boolean tAdestramento;
    private boolean tAtletismo;
    private boolean tAtuacao;
    private boolean tCavalgar;
    private boolean tConhecimento;
    private boolean tCura;
    private boolean tDiplomacia;
    private boolean tEnganação;
    private boolean tFortitude;
    private boolean tFurtividade;
    private boolean tGuerra;
    private boolean tIniciativa;
    private boolean tIntimidacao;
    private boolean tIntuicao;
    private boolean tInvestigacao;
    private boolean tJogatina;
    private boolean tLadinagem;
    private boolean tLuta;
    private boolean tMisticismo;
    private boolean tNobreza;
    private boolean tOficio;
    private boolean tPercepcao;
    private boolean tPilotagem;
    private boolean tPontaria;
    private boolean tReflexos;
    private boolean tReligiao;
    private boolean tSobrevivencia;
    private boolean tVontade;
*/
    public Personagem(String nome, String classe,String raca, String origem, String divindade, int forca, int destreza, int constituição,
                      int inteligencia, int sabedoria, int carisma) {
        this.nome = nome;
        this.classe = classe;
        this.raca= raca;
        this.origem = origem;
        this.divindade = divindade;
        this.nivel = 1;
        this.forca = forca;
        this.destreza = destreza;
        this.constituição = constituição;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.modForca = calculaModificador(forca);
        this.modDestreza = calculaModificador(destreza);
        this.modConstituição = calculaModificador(constituição);
        this.modInteligencia = calculaModificador(inteligencia);
        this.modSabedoria = calculaModificador(sabedoria);
        this.modCarisma = calculaModificador(carisma);
        calculaVidaInicial();
        calculaManaInicial();
        setPoderesClasse();
        setPoderesRaca();
        setPoderesOrigem();
        setPoderesDivindade();
    }
/*
    protected void setPericias(){
       this.acrobacia = setadorDePericia(istAcrobacia());
       this.adestramento = setadorDePericia(istAdestramento());
       this.atletismo = setadorDePericia(istAtletismo());
       this.atuacao = setadorDePericia(istAtuacao());
       this.cavalgar = setadorDePericia(istCavalgar());
       this.conhecimento = setadorDePericia(istConhecimento());
       this.cura = setadorDePericia(istCura());
       this.diplomacia = setadorDePericia(istDiplomacia());
       this.enganacao = setadorDePericia(istEnganação());
       this.fortitude = setadorDePericia(istFortitude());
       this.furtividade = setadorDePericia(istFurtividade());
       this.guerra = setadorDePericia(istGuerra());
       this.iniciativa = setadorDePericia(istIniciativa());
       this.intimidacao = setadorDePericia(istIntimidacao());
       this.intuicao = setadorDePericia(istIntuicao());
       this.investigacao = setadorDePericia(istInvestigacao());
       this.jogatina = setadorDePericia(istJogatina());
       this.ladinagem = setadorDePericia(istLadinagem());
       this.luta = setadorDePericia(istLuta());
       this.misticismo = setadorDePericia(istMisticismo());
       this.nobreza = setadorDePericia(istNobreza());
       this.oficio = setadorDePericia(istOficio());
       this.percepcao = setadorDePericia(istPercepcao());
       this.pilotagem = setadorDePericia(istPilotagem());
       this.pontaria = setadorDePericia(istPontaria());
       this.reflexos = setadorDePericia(istReflexos());
       this.religiao = setadorDePericia(istReligiao());
       this.sobrevivencia = setadorDePericia(istSobrevivencia());
       this.vontade = setadorDePericia(istVontade());
    }

    protected int setadorDePericia(boolean treinada){
        int pericia=0;
        if(treinada){
            if (this.nivel%2==0){
                return pericia = (nivel/2)+2;
            }else{
                return pericia = (nivel/2)+1;
            }
        } else {
            if (this.nivel%2==0){
                return pericia = (nivel/2);
            }else{
                return pericia = (nivel/2);
            }
        }
    }*/

    protected int calculaModificador(int atributo){
        int modficador=valorModificadores[atributo+1];
        return modficador;
    };

    protected void calculaVidaInicial(){
        switch (this.classe){
            case "Arcanista Mago":
            case "Arcanista Bruxo":
            case "Arcanista Feiriceiro":
                this.pontosvida = 8+this.modConstituição;
                break;
            case "Barbaro":
                this.pontosvida = 24+this.modConstituição;
                break;
            case "Bardo":
                this.pontosvida = 12+this.modConstituição;
                break;
            case "Bucaneiro":
                this.pontosvida = 16+this.modConstituição;
                break;
            case "Caçador":
                this.pontosvida = 16+this.modConstituição;
                break;
            case "Cavaleiro":
                this.pontosvida = 20+this.modConstituição;
                break;
            case "Clerigo":
                this.pontosvida = 16+this.modConstituição;
                break;
            case "Druida":
                this.pontosvida = 16+this.modConstituição;
                break;
            case "Guerreiro":
                this.pontosvida = 20+this.modConstituição;
                break;
            case "Inventor":
                this.pontosvida = 12+this.modConstituição;
                break;
            case "Ladino":
                this.pontosvida = 12+this.modConstituição;
                break;
            case "Lutador":
                this.pontosvida = 20+this.modConstituição;
                break;
            case "Nobre":
                this.pontosvida = 16+this.modConstituição;
                break;
            case "Paladino":
                this.pontosvida = 20+this.modConstituição;
                break;
            default:
                this.pontosvida = 0;
        }
    }
    protected void calculaManaInicial(){
        switch (this.classe){
            case "Arcanista Mago":
            case "Arcanista Bruxo":
                this.pontosMana = 6+this.modInteligencia;
                break;
            case "Arcanista Feiriceiro":
                this.pontosMana = 6+this.modCarisma;
                break;
            case "Barbaro":
                this.pontosMana = 3;
                break;
            case "Bardo":
                this.pontosMana = 4+this.modCarisma;
                break;
            case "Bucaneiro":
                this.pontosMana = 3;
                break;
            case "Caçador":
                this.pontosMana = 4;
                break;
            case "Cavaleiro":
                this.pontosMana = 3;
                break;
            case "Clerigo":
                this.pontosMana = 5+this.modSabedoria;
                break;
            case "Druida":
                this.pontosMana = 4+this.modSabedoria;
                break;
            case "Guerreiro":
                this.pontosMana = 3;
                break;
            case "Inventor":
                this.pontosMana = 4;
                break;
            case "Ladino":
                this.pontosMana = 4;
                break;
            case "Lutador":
                this.pontosMana = 3;
                break;
            case "Nobre":
                this.pontosMana = 4;
                break;
            case "Paladino":
                this.pontosMana = 3+this.modCarisma;
                break;
            default:
                this.pontosMana = 0;
                break;
        }
    }


    protected void setPoderesClasse(){
        switch (this.classe){
            case "Arcanista Mago":
            case "Arcanista Bruxo":
            case "Arcanista Feiriceiro":
                this.poderesClasse = "Caminho do Arcanista, Magias (pg37)";
                break;
            case "Barbaro":
                this.poderesClasse = "Fúria (pg41)";
                break;
            case "Bardo":
                this.poderesClasse = "Inspiração, Magias (pg44)";
                break;
            case "Bucaneiro":
                this.poderesClasse = "Audácia, Insolência (pg41)";
                break;
            case "Caçador":
                this.poderesClasse = "Marca da presa, Rastreador (pg50)";
                break;
            case "Cavaleiro":
                this.poderesClasse = "Baluarte, Código de honra (pg53)";
                break;
            case "Clerigo":
                this.poderesClasse = "Devoto, Magias (pg57)";
                break;
            case "Druida":
                this.poderesClasse = "Devoto, Empatia selvagem, Magias (pg62)";
                break;
            case "Guerreiro":
                this.poderesClasse = "Ataque especial (pg66)";
                break;
            case "Inventor":
                this.poderesClasse = "Engenhosidade, Protótipo (pg68)";
                break;
            case "Ladino":
                this.poderesClasse = "Ataque furtivo ,Especialista (pg73)";
                break;
            case "Lutador":
                this.poderesClasse = "Briga, Golpe relâmpago (pg76)";
                break;
            case "Nobre":
                this.poderesClasse = "Autoconfiança, Espólio, Orgulho (pg79)";
                break;
            case "Paladino":
                this.poderesClasse = "Abençoado, código do herói,golpe divino (pg82)";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.classe);
        }
    }

    protected void setPoderesRaca(){
        switch (this.raca){
            case "Humano":
                this.poderesRaca = "+2 em Três Atributods Diferentes, Versátil (pg19)";
                break;
            case "Anão":
                this.poderesRaca = " Constituição +4, Sabedoria +2, Destreza –2 ,Conhecimento das Rochas,Devagar e Sempre, Duro como Pedra, Tradição de Heredrimm (pg20)";
                break;
            case "Dahllan":
                this.poderesRaca = "Sabedoria +4, Destreza +2, Inteligência –2, Amiga das Plantas, Armadura de Allihanna, Empatia Selvagem (pg21)";
                break;
            case "Elfo":
                this.poderesRaca = "Inteligência +4, Destreza +2,Constituição –2, Graça de Glórienn, Herança Feérica, Sentidos Élficos (pg22)";
                break;
            case "Goblin":
                this.poderesRaca = "Destreza +4, Inteligência +2, Carisma –2, Engenhoso ,Espelunqueiro, Peste esguia , Rato das Ruas (pg23)";
                break;
            case "Lefou":
                this.poderesRaca = "+2 em Três Atributos Diferentes(exceto Carisma), Carisma –2, Cria da Tormenta, Deformidade (pg24)";
                break;
            case "Minotauro":
                this.poderesRaca = "Força +4, Constituição +2, Sabedoria –2, Chifres, Couro Rígido, Faro , Medo de Altura (pg25)";
                break;
            case "Qareen":
                this.poderesRaca = "Carisma +4, Inteligência +2, Sabedoria –2, Desejos, Resistência Elemental, Tatuagem Mística (pg26)";
                break;
            case "Golem":
                this.poderesRaca = "Força +4, Constituição +2,Carisma –2, Canalizar Reparos, Chassi, Criatura Artificial, Espírito Elemental, Sem Origem (pg27)";
                break;
            case "Hynne":
                this.poderesRaca = "Destreza +4, Carisma +2, Força –2, Arremessador, Pequeno e Rechonchudo, Sorte Salvadora (pg27-28)";
                break;
            case "Kliren":
                this.poderesRaca = "Inteligência +4, Carisma +2, Força –2,Híbrido , Lógica Gnômica, Ossos Frágeis, Vanguardista (pg28)";
                break;
            case "Medusa":
                this.poderesRaca = "Destreza +4, Carisma +2 ,Cria de Megalokk, Natureza Venenosa, Olhar Atordoandte (pg28-29)";
                break;
            case "Osteon":
                this.poderesRaca = "+2 em Três Atributos Diferentes (exceto Constituição),Constituição –2, Armadura Óssea,Memória Póstuma, Natureza Esquelética, Preço da Não Vida (pg29)";
                break;
            case "Sereia/tritão":
                this.poderesRaca = "+2 em Três Atributos Diferentes , Canção dos Mares, Mestre do Tridente , Transformação Anfíbia (pg29-30)";
                break;
            case "Sílfide":
                this.poderesRaca = "Carisma +4, Destreza +2, Força –4, Asas de Borboleta, Espírito da Natureza , Magia das Fadas (pg30)";
                break;
            case "Aggelus":
                this.poderesRaca = "Sabedoria +4, Carisma +2 , Herança Divina, Luz Sagrada (pg30-31)";
                break;
            case "Sulfure":
                this.poderesRaca = "Destreza +4, Inteligência +2, Herança Divina, Sombras Profanas (pg30-31)";
                break;
            case "Trog":
                this.poderesRaca = "Constituição +4, Força +2, Inteligência –2 , Mau Cheiro, Mordida , Reptiliano, Sangue Frio (pg31)";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.raca);
        }
    }

    protected void setPoderesOrigem() {
        this.poderesOrigem="Escolha dois dos seguintes benefícios: ";
        switch ( this.origem ) {
            case "Acólito":
                this.poderesOrigem+="Cura, Religião, Vontade; Medicina, Membro da Igreja, Vontade de Ferro. (pg86)";
                break;
            case "Amigo dos Animais":
                this.poderesOrigem+="Cura, Religião, Vontade; Medicina, Membro da Igreja, Vontade de Ferro. (pg86)";
                break;
            case "Amnésico":
                this.poderesOrigem="Em vez de dois benefícios de uma lista, você recebe uma perícia e um poder escolhidos pelo mestre e o poder Lembranças Graduais. (pg86)";
                break;
            case "Aristocrata":
                this.poderesOrigem+="Diplomacia, Enganação, Nobreza ; Comandar, Sangue Azul. (pg86)";
                break;
            case "Artesão":
                this.poderesOrigem+="Ofício, Vontade; Frutos do Trabalho, Sortudo. (pg86)";
                break;
            case "Artista":
                this.poderesOrigem+="Atuação, Enganação; Atraente, Dom Artístico, Sortudo, Torcida. (pg86-87)";
                break;
            case "Assistente de Laboratório":
                this.poderesOrigem+="Ofício (alquimia), Misticismo; Esse Cheiro..., Venefício, um poder da Tormenta a sua escolha. (pg87-88)";
                break;
            case "Batedor":
                this.poderesOrigem+=" Furtividade, Percepção, Sobrevivência; À Prova de Tudo, Estilo de Disparo, Sentidos Aguçados. (pg88)";
                break;
            case "Capanga":
                this.poderesOrigem+="Luta, Intimidação; Confissão, um poder de combate a sua escolha . (pg88)";
                break;
            case "Charlatão":
                this.poderesOrigem+="Enganação, Jogatina; Alpinista Social, Aparência Inofensiva, Sortudo. (pg88-89)";
                break;
            case "Circense":
                this.poderesOrigem+="Acrobacia, Atuação, Reflexos; Acrobático, Torcida, Truque de Mágica. (pg90)";
                break;
            case "Criminoso":
                this.poderesOrigem+="Enganação, Furtividade, Ladinagem; Punguista, Venefício. (pg90)";
                break;
            case "Curandeiro":
                this.poderesOrigem+="Cura, Vontade; Medicina, Médico de Campo, Venefício. (pg90)";
                break;
            case "Eremita":
                this.poderesOrigem+="Misticismo, Religião, Sobrevivência; Busca Interior, Lobo Solitário. (pg90)";
                break;
            case "Escravo":
                this.poderesOrigem+="Atletismo, Fortitude, Furtividade; Desejo de Liberdade, Vitalidade. (pg90-91)";
                break;
            case "Estudioso":
                this.poderesOrigem+="Conhecimento, Guerra, Misticismo; Aparência Inofensiva, Palpite Fundamentado. (pg91)";
                break;
            case "Fazendeiro":
                this.poderesOrigem+="Adestramento, Cavalgar, Ofício (fazendeiro), Sobrevivência; Água no Feijão, Ginete. (pg91)";
                break;
            case "Forasteiro":
                this.poderesOrigem+="Cavalgar, Pilotagem, Sobrevivência; Cultura Exótica, Lobo Solitário. (pg91)";
                break;
            case "Gladiador":
                this.poderesOrigem+="Atuação, Luta; Atraente, Pão e Circo, Torcida, um poder de combate a sua escolha. (pg91-92)";
                break;
            case "Guarda":
                this.poderesOrigem+="Investigação, Luta, Percepção; Detetive, Investigador, um poder de combate a sua escolha. (pg92)";
                break;
            case "Herdeiro":
                this.poderesOrigem+="Misticismo, Nobreza, Ofício; Comandar, Herança. (pg92)";
                break;
            case "Herói Camponês":
                this.poderesOrigem+="Adestramento, Ofício ;Amigo dos Plebeus, Sortudo, Surto Heroico, Torcida(pg92-93)";
                break;
            case "Marujo":
                this.poderesOrigem+="Atletismo, Jogatina, Pilotagem; Acrobático, Passagem de Navio. (pg93)";
                break;
            case "Mateiro":
                this.poderesOrigem+="Atletismo, Furtividade, Sobrevivência; Lobo Solitário, Sentidos Aguçados, Vendedor de Carcaças. (pg93)";
                break;
            case "Membro de Guilda":
                this.poderesOrigem+="Diplomacia, Enganação, Misticismo, Ofício; Foco em Perícia, Rede de Contatos. (pg93)";
                break;
            case "Mercador":
                this.poderesOrigem+="Diplomacia, Intuição, Ofício; Negociação, Proficiência, Sortudo. (pg94)";
                break;
            case "Minerador":
                this.poderesOrigem+="Atletismo, Fortitude, Ofício (minerador); Ataque Poderoso, Escavador, Sentidos Aguçados. (pg94)";
                break;
            case "Nômade":
                this.poderesOrigem+="Cavalgar, Pilotagem, Sobrevivência; Lobo Solitário, Mochileiro, Sentidos Aguçados. (pg94)";
                break;
            case "Pivete":
                this.poderesOrigem+="Furtividade, Iniciativa, Ladinagem; Acrobático, Aparência Inofensiva, Quebra-Galho. (pg94)";
                break;
            case "Refugiado":
                this.poderesOrigem+="Fortitude, Reflexos, Vontade; Estoico, Vontade de Ferro. (pg94-95)";
                break;
            case "Seguidor":
                this.poderesOrigem+="Adestramento, Ofício; Antigo Mestre, Proficiência, Surto Heroico. (pg95)";
                break;
            case "Selvagem":
                this.poderesOrigem+="Percepção, Reflexos, Sobrevivência; Lobo Solitário, Vida Rústica, Vitalidade. (pg95)";
                break;
            case "Soldado":
                this.poderesOrigem+="Fortitude, Guerra, Luta, Pontaria; Influência Militar, um poder de combate a sua escolha. (pg95)";
                break;
            case "Taverneiro":
                this.poderesOrigem+="Diplomacia, Jogatina, Ofício (culinária); Gororoba, Proficiência, Vitalidade. (pg95-96)";
                break;
            case "Trabalhador":
                this.poderesOrigem+="Atletismo, Fortitude; Atlético, Esforçado. (pg96)";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.origem);
        }

    }

    protected void setPoderesDivindade(){
        if (this.divindade!= null){

        }
        else {
            this.poderesDivindade="Não segue a nenhuma divindade.";
        }

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDivindade() {
        return divindade;
    }

    public void setDivindade(String divindade) {
        this.divindade = divindade;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontosvida() {
        return pontosvida;
    }

    public void setPontosvida(int pontosvida) {
        this.pontosvida = pontosvida;
    }

    public int getPontosMana() {
        return pontosMana;
    }

    public void setPontosMana(int pontosMana) {
        this.pontosMana = pontosMana;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituição() {
        return constituição;
    }

    public void setConstituição(int constituição) {
        this.constituição = constituição;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getModForca() {
        return modForca;
    }

    public void setModForca(int modForca) {
        this.modForca = modForca;
    }

    public int getModDestreza() {
        return modDestreza;
    }

    public void setModDestreza(int modDestreza) {
        this.modDestreza = modDestreza;
    }

    public int getModConstituição() {
        return modConstituição;
    }

    public void setModConstituição(int modConstituição) {
        this.modConstituição = modConstituição;
    }

    public int getModInteligencia() {
        return modInteligencia;
    }

    public void setModInteligencia(int modInteligencia) {
        this.modInteligencia = modInteligencia;
    }

    public int getModSabedoria() {
        return modSabedoria;
    }

    public void setModSabedoria(int modSabedoria) {
        this.modSabedoria = modSabedoria;
    }

    public int getModCarisma() {
        return modCarisma;
    }

    public void setModCarisma(int modCarisma) {
        this.modCarisma = modCarisma;
    }
/*
    public int getAcrobacia() {
        return acrobacia;
    }

    public void settAcrobacia(int tAcrobacia) {
        this.acrobacia = tAcrobacia;
    }

    public int getAdestramento() {
        return adestramento;
    }

    public void settAdestramento(int tAdestramento) {
        this.adestramento = tAdestramento;
    }

    public int getAtletismo() {
        return atletismo;
    }

    public void settAtletismo(int tAtletismo) {
        this.atletismo = tAtletismo;
    }

    public int getAtuacao() {
        return atuacao;
    }

    public void settAtuacao(int tAtuacao) {
        this.atuacao = tAtuacao;
    }

    public int getCavalgar() {
        return cavalgar;
    }

    public void settCavalgar(int tCavalgar) {
        this.cavalgar = tCavalgar;
    }

    public int getConhecimento() {
        return conhecimento;
    }

    public void settConhecimento(int tConhecimento) {
        this.conhecimento = tConhecimento;
    }

    public int getCura() {
        return cura;
    }

    public void settCura(int tCura) {
        this.cura = tCura;
    }

    public int getDiplomacia() {
        return diplomacia;
    }

    public void settDiplomacia(int tDiplomacia) {
        this.diplomacia = tDiplomacia;
    }

    public int getEnganacao() {
        return enganacao;
    }

    public void settEnganação(int tEnganação) {
        this.enganacao = tEnganação;
    }

    public int getFortitude() {
        return fortitude;
    }

    public void settFortitude(int tFortitude) {
        this.fortitude = tFortitude;
    }

    public int getFurtividade() {
        return furtividade;
    }

    public void settFurtividade(int tFurtividade) {
        this.furtividade = tFurtividade;
    }

    public int getGuerra() {
        return guerra;
    }

    public void settGuerra(int tGuerra) {
        this.guerra = tGuerra;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void settIniciativa(int tIniciativa) {
        this.iniciativa = tIniciativa;
    }

    public int getIntimidacao() {
        return intimidacao;
    }

    public void settIntimidacao(int tIntimidacao) {
        this.intimidacao = tIntimidacao;
    }

    public int getIntuicao() {
        return intuicao;
    }

    public void settIntuicao(int tIntuicao) {
        this.intuicao = tIntuicao;
    }

    public int getInvestigacao() {
        return investigacao;
    }

    public void settInvestigacao(int tInvestigacao) {
        this.investigacao = tInvestigacao;
    }

    public int getJogatina() {
        return jogatina;
    }

    public void settJogatina(int tJogatina) {
        this.jogatina = tJogatina;
    }

    public int getLadinagem() {
        return ladinagem;
    }

    public void settLadinagem(int tLadinagem) {
        this.ladinagem = tLadinagem;
    }

    public int getLuta() {
        return luta;
    }

    public void settLuta(int tLuta) {
        this.luta = tLuta;
    }

    public int getMisticismo() {
        return misticismo;
    }

    public void settMisticismo(int tMisticismo) {
        this.misticismo = tMisticismo;
    }

    public int getNobreza() {
        return nobreza;
    }

    public void settNobreza(int tNobreza) {
        this.nobreza = tNobreza;
    }

    public int getOficio() {
        return oficio;
    }

    public void settOficio(int tOficio) {
        this.oficio = tOficio;
    }

    public int getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }

    public int getPilotagem() {
        return pilotagem;
    }

    public void settPilotagem(int tPilotagem) {
        this.pilotagem = tPilotagem;
    }

    public int getPontaria() {
        return pontaria;
    }

    public void settPontaria(int tPontaria) {
        this.pontaria = tPontaria;
    }

    public int getReflexos() {
        return reflexos;
    }

    public void settReflexos(int tReflexos) {
        this.reflexos = tReflexos;
    }

    public int getReligiao() {
        return religiao;
    }

    public void setReligiao(int religiao) {
        this.religiao = religiao;
    }

    public int getSobrevivencia() {
        return sobrevivencia;
    }

    public void settSobrevivencia(int tSobrevivencia) {
        this.sobrevivencia = tSobrevivencia;
    }

    public int getVontade() {
        return vontade;
    }

    public void settVontade(int tVontade) {
        this.vontade = tVontade;
    }

    public boolean istAcrobacia() {
        return tAcrobacia;
    }

    public void setAcrobacia(boolean acrobacia) {
        tAcrobacia = acrobacia;
    }

    public boolean istAdestramento() {
        return tAdestramento;
    }

    public void setAdestramento(boolean adestramento) {
        tAdestramento = adestramento;
    }

    public boolean istAtletismo() {
        return tAtletismo;
    }

    public void setAtletismo(boolean atletismo) {
        tAtletismo = atletismo;
    }

    public boolean istAtuacao() {
        return tAtuacao;
    }

    public void setAtuacao(boolean atuacao) {
        tAtuacao = atuacao;
    }

    public boolean istCavalgar() {
        return tCavalgar;
    }

    public void setCavalgar(boolean cavalgar) {
        tCavalgar = cavalgar;
    }

    public boolean istConhecimento() {
        return tConhecimento;
    }

    public void setConhecimento(boolean conhecimento) {
        tConhecimento = conhecimento;
    }

    public boolean istCura() {
        return tCura;
    }

    public void setCura(boolean cura) {
        tCura = cura;
    }

    public boolean istDiplomacia() {
        return tDiplomacia;
    }

    public void setDiplomacia(boolean diplomacia) {
        tDiplomacia = diplomacia;
    }

    public boolean istEnganação() {
        return tEnganação;
    }

    public void setEnganacao(boolean enganacao) {
        tEnganação = enganacao;
    }

    public boolean istFortitude() {
        return tFortitude;
    }

    public void setFortitude(boolean fortitude) {
        tFortitude = fortitude;
    }

    public boolean istFurtividade() {
        return tFurtividade;
    }

    public void setFurtividade(boolean furtividade) {
        tFurtividade = furtividade;
    }

    public boolean istGuerra() {
        return tGuerra;
    }

    public void setGuerra(boolean guerra) {
        tGuerra = guerra;
    }

    public boolean istIniciativa() {
        return tIniciativa;
    }

    public void setIniciativa(boolean iniciativa) {
        tIniciativa = iniciativa;
    }

    public boolean istIntimidacao() {
        return tIntimidacao;
    }

    public void setIntimidacao(boolean intimidacao) {
        tIntimidacao = intimidacao;
    }

    public boolean istIntuicao() {
        return tIntuicao;
    }

    public void setIntuicao(boolean intuicao) {
        tIntuicao = intuicao;
    }

    public boolean istInvestigacao() {
        return tInvestigacao;
    }

    public void setInvestigacao(boolean investigacao) {
        tInvestigacao = investigacao;
    }

    public boolean istJogatina() {
        return tJogatina;
    }

    public void setJogatina(boolean jogatina) {
        tJogatina = jogatina;
    }

    public boolean istLadinagem() {
        return tLadinagem;
    }

    public void setLadinagem(boolean ladinagem) {
        tLadinagem = ladinagem;
    }

    public boolean istLuta() {
        return tLuta;
    }

    public void setLuta(boolean luta) {
        tLuta = luta;
    }

    public boolean istMisticismo() {
        return tMisticismo;
    }

    public void setMisticismo(boolean misticismo) {
        tMisticismo = misticismo;
    }

    public boolean istNobreza() {
        return tNobreza;
    }

    public void setNobreza(boolean nobreza) {
        tNobreza = nobreza;
    }

    public boolean istOficio() {
        return tOficio;
    }

    public void setOficio(boolean oficio) {
        tOficio = oficio;
    }

    public boolean istPercepcao() {
        return tPercepcao;
    }

    public void settPercepcao(boolean tPercepcao) {
        this.tPercepcao = tPercepcao;
    }

    public boolean istPilotagem() {
        return tPilotagem;
    }

    public void setPilotagem(boolean pilotagem) {
        tPilotagem = pilotagem;
    }

    public boolean istPontaria() {
        return tPontaria;
    }

    public void setPontaria(boolean pontaria) {
        tPontaria = pontaria;
    }

    public boolean istReflexos() {
        return tReflexos;
    }

    public void setReflexos(boolean reflexos) {
        tReflexos = reflexos;
    }

    public boolean istReligiao() {
        return tReligiao;
    }

    public void settReligiao(boolean tReligiao) {
        this.tReligiao = tReligiao;
    }

    public boolean istSobrevivencia() {
        return tSobrevivencia;
    }

    public void setSobrevivencia(boolean sobrevivencia) {
        tSobrevivencia = sobrevivencia;
    }

    public boolean istVontade() {
        return tVontade;
    }

    public void setVontade(boolean vontade) {
        tVontade = vontade;
    }

 */
}
