import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FmController
{
    private FmModel model;

    public FmController(FmModel m){
        this.model = m;
    }


    public void criaNovosDados() throws IOException {

        this.model = new FmModel();


    }

    public void save(String pasta){
        try {
            this.model.saveData(pasta);
        } catch (IOException e) {
            System.out.println("Erro ao gravar o ficheiro");
        }
    }

    //Função que de acordo com o input do utilizador decide a forma como faz o load

    public void loadDataController(int i, String nomePasta) throws LinhaIncorretaException, IOException ,ClassNotFoundException{ // if i  == 1 load custom files else load given text file


        if(i == 1) this.model.loadData(nomePasta);

        if (i == 2) {

            Parser.parse(model);
            model.atualizaHistóricoEquipas();
        }

        if(i == 3) criaNovosDados();

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

        return this.model.getJogos().get(selection - 1).toString();
    }

    // Devolve os nomes dos jogadores para serem apresentados na view

    public List<String> getJogadores(){

        List<String> nomesJogadores = new ArrayList<>();

        for(Jogador j: this.model.getJogadores().values()){
                nomesJogadores.add(j.getNome() +"\nHabilidade: "+ j.getHabilidade());

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
            String vs = j.getEquipaVisitada().getNomeDaEquipa() + " vs  " + j.getEquipaVisitante().getNomeDaEquipa() + " Data: " + j.getData().toString();
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

        return this.model.getGuardaRedes().stream().map(g -> g.getNome() +"\nHabilidade: "+g.getHabilidade()).collect(Collectors.toList());

    }

    //Devolve Nomes dos Defesas

    public List<String> getDefesas(){

        return this.model.getDefesas().stream().map(g -> g.getNome() +"\nHabilidade: "+g.getHabilidade()).collect(Collectors.toList());

    }

    //Devolve Nomes dos Laterais

    public List<String> getLaterais(){

        return this.model.getLaterais().stream().map(g -> g.getNome() +"\nHabilidade: "+g.getHabilidade()).collect(Collectors.toList());

    }

    //Devolve nome dos medios
    public List<String> getMedios(){

        return this.model.getMedios().stream().map(g -> g.getNome() +"\nHabilidade: "+g.getHabilidade()).collect(Collectors.toList());

    }

    //Devolve nome dos Avançados
    public List<String> getAvancados(){

        return this.model.getAvancados().stream().map(g -> g.getNome() +"\nHabilidade: "+g.getHabilidade()).collect(Collectors.toList());


    }


    public void adicionaJogadores(String selection, String NomeDaEquipa, String posicao) throws Jogo.EquipaNaoExisteException, FmModel.JogadorInexistenteException {

        String[] sels = selection.split(",");
        List<Jogador> jogs = new ArrayList<>();
        if(posicao.compareTo("Guarda-Redes") == 0) jogs = this.model.getGuardaRedes();
        if(posicao.compareTo("Defesa") == 0) jogs = this.model.getDefesas();
        if(posicao.compareTo("Lateral") == 0) jogs = this.model.getLaterais();
        if(posicao.compareTo("Medio") == 0) jogs = this.model.getMedios();
        if(posicao.compareTo("Avancado") == 0) jogs = this.model.getAvancados();


        for(String s : sels){
            int index =  Integer.parseInt(s);
            Jogador add = jogs.get(index - 1);
            transfereEquipa(NomeDaEquipa,add.getNome());
        }


    }

    //Verifica se uma equipa se encontra no sistema

    public  boolean existeEquipa(String nome){
        return this.model.existeEquipa(nome);
    }

    public void transfereEquipa (String equipaDestino, String nome) throws Jogo.EquipaNaoExisteException, FmModel.JogadorInexistenteException {
        this.model.transfereEquipa(equipaDestino,nome);
    }


    //Funções que devolvem os jogadores de determinada posição e equipa

    public List<String> getRedesEquipa(String e){

        return this.model.getEquipas().get(e).getGuardaRedes().stream().map(j->j.getNome() +"\nHabilidade: "+j.getHabilidade()).collect(Collectors.toList());

    }

    public List<String> getDefesasEquipa(String e){

        return this.model.getEquipas().get(e).getDefesas().stream().map(j->j.getNome()+"\nHabilidade: "+j.getHabilidade()).collect(Collectors.toList());

    }
    public List<String> getLateraisEquipa(String e){

        return this.model.getEquipas().get(e).getLaterais().stream().map(j->j.getNome()+"\nHabilidade: "+j.getHabilidade()).collect(Collectors.toList());

    }
    public List<String> getMediosEquipa(String e){

        return this.model.getEquipas().get(e).getMedios().stream().map(j->j.getNome()+"\nHabilidade: "+j.getHabilidade()).collect(Collectors.toList());

    }
    public List<String> getAvancadosEquipa(String e){

        return this.model.getEquipas().get(e).getAvancado().stream().map(j->j.getNome()+"\nHabilidade: "+j.getHabilidade()).collect(Collectors.toList());

    }

    // Função e excepção que válida um comando
    public class ComandoInvalidoException extends Exception {
        public ComandoInvalidoException(){
            super();
        }

        public ComandoInvalidoException(String s){
            super(s);
        }
    }

    public int validaComando (String s) throws ComandoInvalidoException{
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9');
            else throw new ComandoInvalidoException(s);
        }
        return Integer.parseInt(s);
    }

    //Função que verifica se seleção de jogdores é válida

    public boolean verificaSelecaoJogadores(String selection, int quantidade, int tam, int modo){

        String[] nums = selection.split(",");
        if(modo == 1) if(nums.length != quantidade) return false;
        if(modo == 2) if(nums.length < quantidade) return false;
        for(String s : nums){
            try {
                validaComando(s);
            } catch (ComandoInvalidoException e) {
                return false;
            }
            int iguais = 0;
            for(String s2 : nums){
                if(s.compareTo(s2) == 0) iguais++;
                if(Integer.parseInt(s2)>tam) return false;
            }
            if(iguais > 1 ) return  false;
        }
        return true;
    }


    //Função que adiciona a seleção a uma Lista de inteiros (titulares)


    public List<Integer> adicionaTitulares(String selection, List<Integer> titulares, String equipa ,String posicao, int quantidade, int tam) {
        List<Integer> save = titulares.stream().collect(Collectors.toList());
        List<Jogador> jogadores = new ArrayList<>();
        Equipa e = this.model.getEquipas().get(equipa);

        if (posicao.compareTo("Guarda-Redes") == 0) jogadores = e.getGuardaRedes();
        if (posicao.compareTo("Defesas") == 0) jogadores = e.getDefesas();
        if (posicao.compareTo("Medios") == 0) jogadores = e.getMedios();
        if (posicao.compareTo("Laterais") == 0) jogadores = e.getLaterais();
        if (posicao.compareTo("Avancados") == 0) jogadores = e.getAvancado();


        if(!verificaSelecaoJogadores(selection,quantidade,tam,1)) return save;

        String[] splited = selection.split(",");
        for(String s : splited){
            int num = Integer.parseInt(s);
            Jogador jogSelected =  jogadores.get(num - 1);
            if(titulares.contains(jogSelected.getNumeroJogador())) return save;
            else titulares.add(jogSelected.getNumeroJogador());
        }

        return titulares;
    }

    //Função que verifica se as substituições são validadas

    public boolean validaSubs(String e, List<Integer> titulares, Map<Integer,Integer> subs){

        Equipa equipa = this.model.getEquipas().get(e);
        boolean r = true;
        if (subs.size() < 3){

            for(Map.Entry sub : subs.entrySet()) {

                // jogador que vai sair tem que estar no 11
                if (!titulares.contains(sub.getKey())) return false;
                // jogador que vai entrar tem que pertencer a equipa
                if (!equipa.getPlantel().contains(sub.getValue())) return false;
                //jogador a entrar nao pode estar no 11
                if(titulares.contains(sub.getValue())) return false;
                // se o jogador que vai entrar ja tiver saido
                if (subs.keySet().contains(sub.getValue())) return false;

                // Validar se joga ou não na linha
                if (equipa.get1Jogador((int)sub.getKey()) instanceof Lateral){
                    if (!(equipa.get1Jogador((int)sub.getValue()) instanceof Lateral))
                        return false;
                }
                else {
                    if ((equipa.get1Jogador((int)sub.getKey()) instanceof Lateral)) return false;
                }
            }

        } else r = false;
        return r;
    }

    public String criaCalculaResultadoJogo(String ec, String ef, LocalDate d, List<Integer> jc, Map<Integer , Integer> sc, List<Integer> jf, Map<Integer, Integer> sf, String taticaCasa, String taticaFora){

        Equipa equipaCasa = this.model.getEquipas().get(ec);
        Equipa equipaFora = this.model.getEquipas().get(ef);
        Jogo jogo = this.model.criaAddJogo(equipaCasa, equipaFora, d,  jc,  sc,  jf,sf,taticaCasa, taticaFora);
        jogo.calculaResultado();
        return jogo.toString();
    }

}
