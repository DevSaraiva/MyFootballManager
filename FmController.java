import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FmController
{
    private FmModel model;

    public FmController(FmModel m){
        this.model = m;
    }


    //Função que de acordo com o input do utilizador decide a forma como faz o load

    public void loadDataController(int i) throws LinhaIncorretaException, IOException ,ClassNotFoundException{ // if i  == 1 load custom files else load given text file

        if (i == 2) {

                Parser.parse(model);
                model.atualizaHistóricoEquipas();

        } else {

                this.model.loadData();

        }
    }
    //Devolve o jogador selecionado

    public String getJogador(String s){

        return this.model.getJogadores().get(s).toString();

    }

    //Devolve a equipa selecionada
    public String getEquipa(String s){

        return this.model.getEquipas().get(s).toString();

    }

    //Devolve o jogo selecionado

    public String getJogo(int selection){

        return this.model.getJogos().get(selection).toString();
    }

    // Devolve os nomes dos jogadores para serem apresentados na view

    public List<String> getJogadores(){

        List<String> nomesJogadores = new ArrayList<>();

        for(Jogador j: this.model.getJogadores().values()){
                nomesJogadores.add(j.getNome());

        }

        return  nomesJogadores;
    }

    // Devolve as nomes das equipas para serem apresentadas na view

    public List<String> getEquipas(){

        List<String> nomesEquipas = new ArrayList<>();

        for(Equipa e: this.model.getEquipas().values()){
            nomesEquipas.add(e.getNomeDaEquipa());
        }

        return  nomesEquipas;

    }


    // Devolve nome dos jogos

    public List<String> getJogos(){

        List<String> jogos = new ArrayList<>();

        for(Jogo j: this.model.getJogos()){
            String vs = j.getEquipaVisitada() + " vs  " + j.getEquipaVisitante() + "| Data:  " + j.getData().toString();
            jogos.add(vs);

        }

        return jogos;
    }

    public void criaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo, int remate,
                          int passe,List<String> equipas, int elasticiadde, int reflexos){

            this.model.criaRedes(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,elasticiadde,reflexos);
    }


    public void criaDefesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                           int remate, int passe, List<String> equipas, int desarme,int marcaçao,int agressividade){

        this.model.criaDefesa(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,desarme,marcaçao,agressividade);
    }

    public void criaLateral(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                            int remate, int passe, List<String> equipas,int capacidadeCruzamento, int drible){

        this.model.criaLateral(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,capacidadeCruzamento,drible);

    }

    public void criaMedio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                          int remate, int passe, List<String> equipas, int recuperaçaoDeBola, int criatividade){
            this.model.criaMedio(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,recuperaçaoDeBola,criatividade);
    }

    public void criaAvancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                             int remate, int passe, List<String> equipas, int finalizacao, int drible,
                             int piorPe){

            this.model.criaAvancado(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,finalizacao,drible,piorPe);
    }

    public void criaEquipa(String NomeDaEquipa, String Treinador, List<Jogador> Plantel){
        this.model.criaEquipa(NomeDaEquipa,Treinador,Plantel);
    }

    //Devolve Nomes GuardaRedes

    public List<String> getGuardaRedes(){

        return this.model.getGuardaRedes().stream().map(g -> g.getNome()).collect(Collectors.toList());


    }

    //Devolve Nomes dos Defesas


    //


    //


    //


    //


    public void adicionaJogador(String selection, String NomeDaEquipa, String posicao){

        List <int> sels = new ArrayList<>();
        sels = selection.split(",");
        List<Jogador> jogs = new ArrayList<>();
        if(posicao.compareTo("Guarda-Redes")) jogs = this.model.getGuardaRedes();
        if(posicao.compareTo("Defesa")) jogs = this.model.getDefesas();
        if(posicao.compareTo("Lateral")) jogs = this.model.getLaterais();
        if(posicao.compareTo("Medio")) jogs = this.model.getMedios();
        if(posicao.compareTo("Avancado")) jogs = this.model.getAvancados();


    }




    //Verifica se uma equipa se encontra no sistema

    public  boolean existeEquipa(String nome){
        return this.model.existeEquipa(nome);
    }

}
