import jdk.jshell.execution.LoaderDelegate;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FmModel implements  Serializable {

    private Map<String,Jogador>  jogadores; //Par (nome,jogador)
    private Map<String,Equipa> equipas; // Par(nome, equipa)
    private List<Jogo> jogos; //Lista de jogos


    public  FmModel(){

        this.jogadores = new HashMap<>();
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();

    }

    public void loadJogadores() throws IOException, ClassNotFoundException {

            File toRead = new File("Files/Jogadores/jogadores.txt");
            FileInputStream fis = new FileInputStream(toRead);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.jogadores = (HashMap<String,Jogador>) ois.readObject();


            ois.close();
            fis.close();

    }

    public void loadEquipas() throws IOException, ClassNotFoundException{

        File toRead = new File("Files/Equipas/equipas.txt");
        FileInputStream fis = new FileInputStream(toRead);
        ObjectInputStream ois = new ObjectInputStream(fis);

        this.equipas = (HashMap<String,Equipa>) ois.readObject();


        ois.close();
        fis.close();
    }

    public void loadJogos() throws IOException, ClassNotFoundException{

        File toRead = new File("Files/Jogos/jogos.txt");
        FileInputStream fis = new FileInputStream(toRead);
        ObjectInputStream ois = new ObjectInputStream(fis);

        this.jogos = (ArrayList<Jogo>) ois.readObject();


        ois.close();
        fis.close();
    }


    public void loadData() throws IOException, ClassNotFoundException {

        loadJogadores();
        loadEquipas();
        loadJogos();
    }
    
    public void saveJogadores() throws java.io.IOException {


            File file=new File("Files/Jogadores/jogadores.txt");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(this.jogadores);
            oos.flush();
            oos.close();
            fos.close();

        
    }
    
    public void saveEquipas() throws java.io.IOException {

        File file=new File("Files/Equipas/equipas.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.equipas);
        oos.flush();
        oos.close();
        fos.close();
        
    }
    
    public void saveJogos() throws java.io.IOException {

        File file=new File("Files/Jogos/jogos.txt");
        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(this.jogos);
        oos.flush();
        oos.close();
        fos.close();
        
    }

    public  void saveData() throws java.io.IOException{

        saveJogos();
        saveEquipas();
        saveJogadores();

    }
    

    //Função que cria um Guarde - Redes  e adiciona ao sistema

    public void criaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo, int remate,
                          int passe,List<String> equipas, int elasticiadde, int reflexos){

        Jogador jog = new GuardaRedes(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe,equipas,  elasticiadde, reflexos);
        this.jogadores.put(nome, jog);
        if(equipas.size() > 0){
            this.equipas.get(equipas.get(equipas.size() - 1)).getPlantel().add(jog);
        }
    }

    
    public void criaDefesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe, List<String> equipas, int desarme,int marcaçao,int agressividade){

        Jogador jog = new Defesa(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                    remate, passe, equipas, desarme, marcaçao, agressividade);
        this.jogadores.put(nome, jog);
        if(equipas.size() > 0){
            this.equipas.get(equipas.get(equipas.size() - 1)).getPlantel().add(jog);
        }
    }
    
    public void criaLateral(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                         int remate, int passe, List<String> equipas, int capacidadeCruzamento, int drible){
                             
                            
        Jogador jog = new Lateral(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                         remate, passe, equipas, capacidadeCruzamento, drible);
        this.jogadores.put(nome, jog);
        if(equipas.size() > 0){
          this.equipas.get(equipas.get(equipas.size() - 1)).getPlantel().add(jog);
        }

    }
    
    public void criaMedio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                   int remate, int passe, List<String> equipas, int recuperaçaoDeBola, int criatividade){
                             
                            
        Jogador jog = new Medio(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                   remate, passe, equipas, recuperaçaoDeBola, criatividade);
        this.jogadores.put(nome, jog);
        if(equipas.size() > 0){
           this.equipas.get(equipas.get(equipas.size() - 1)).getPlantel().add(jog);
        }
                            
    }
    
    public void criaAvancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                     int remate, int passe, List<String> equipas, int finalizacao, int drible,
                     int piorPe){
                             
                            
        Jogador jog = new Avancado(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                     remate, passe, equipas, finalizacao, drible,
                     piorPe);
        this.jogadores.put(nome, jog);
        if(equipas.size() > 0){
           this.equipas.get(equipas.get(equipas.size() - 1)).getPlantel().add(jog);
        }
                            
    }

    public void criaEquipa(String NomeDaEquipa, String Treinador, List<Jogador> Plantel){
        Equipa e = new Equipa(NomeDaEquipa, Treinador, Plantel);
        this.equipas.put(NomeDaEquipa,e);
    }

    //Após a leitura dos logs em texto é necessário colocar no histórico de cada jogador a equipa onde se encontra no momento
    //este metodo serve exatamente para isso

    public void atualizaHistóricoEquipas(){
        Map<String,Equipa> equipas = this.getEquipas();
        for(Equipa e: equipas.values()){
            String nome = e.getNomeDaEquipa();
            for(Jogador j: e.getPlantel()){
                List<String> historico = j.getEquipas();
                historico.add(nome);
                j.setEquipas(historico);
            }
        }

        this.setEquipas(equipas);
    }

    public class JogadorInexistenteException extends Exception {
        public JogadorInexistenteException(){
            super();
        }

        public JogadorInexistenteException(String s){
            super(s);
        }
    }

    public void transfereEquipa(String d, String nome) throws JogadorInexistenteException , Jogo.EquipaNaoExisteException {


        if (this.jogadores.containsKey(nome)){
            //Jogador j = this.jogadores.get(nome);
            if (this.equipas.containsKey(d)){
                Jogador j = this.jogadores.get(nome);
                if (j.getEquipas().size() > 0) {
                    if (!j.getEquipaAtual().equals(d)){
                        Equipa equipa_atual = this.equipas.get(j.getEquipaAtual());
                        equipa_atual.removeJogador(j);
                        this.equipas.get(d).insereJogador(j);
                        j.insereNovoClube(d);
                    }
                }
                else {
                    this.equipas.get(d).insereJogador(j);
                    j.insereNovoClube(d);
                }
            }
            else throw new Jogo.EquipaNaoExisteException();
        }
        else throw new JogadorInexistenteException(nome);

    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas;
    }

    public void setJogadores(Map<String, Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<Jogo> getJogos() {
        return this.jogos.stream().map(j -> j.clone()).collect(Collectors.toList());
    }

    public Map<String, Equipa> getEquipas() {
        return this.equipas.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }

    public Map<String, Jogador> getJogadores() {
        return this.jogadores.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }

    public List<Jogador> getGuardaRedes(){

        return this.getJogadores().values().stream().
                filter(v -> v instanceof GuardaRedes).
                map(v -> (Jogador) v.clone()).
                collect(Collectors.toList());



    }
    public List<Jogador> getDefesas(){

        return this.getJogadores().values().stream().
                filter(v -> v instanceof Defesa).
                map(v -> (Jogador) v.clone()).
                collect(Collectors.toList());

    }

    public List<Jogador> getLaterais(){

        return this.getJogadores().values().stream().
                filter(v -> v instanceof Lateral).
                map(v -> (Jogador) v.clone()).
                collect(Collectors.toList());


    }

    public List<Jogador> getMedios(){

        return this.getJogadores().values().stream().
                filter(v -> v instanceof Medio).
                map(v -> (Jogador) v.clone()).
                collect(Collectors.toList());


    }

    public List<Jogador> getAvancados(){

        return this.getJogadores().values().stream().
                filter(v -> v instanceof Avancado).
                map(v -> (Jogador) v.clone()).   // v ´é antes do cast do tipo Veiculo
                collect(Collectors.toList());


    }

    public  boolean existeEquipa(String nome){
        System.out.println(nome);
        return this.equipas.containsKey(nome);

    }
}
