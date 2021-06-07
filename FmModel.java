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
    

    public void criaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo, int remate,
                          int passe,List<String> equipas, int elasticiadde, int reflexos){

        Jogador jog = new GuardaRedes(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe,equipas,  elasticiadde, reflexos);
        this.jogadores.put(nome, jog);
    }

    
    public void criaDefesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe, List<String> equipas, int desarme,int marcaçao,int agressividade){

        Jogador jog = new Defesa(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                    remate, passe, equipas, desarme, marcaçao, agressividade);
        this.jogadores.put(nome, jog);
    }
    
    public void criaLateral(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                         int remate, int passe, List<String> equipas, int desarme,int marcaçao,int agressividade, int capacidadeCruzamento, int drible){
                             
                            
        Jogador jog = new Lateral(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                         remate, passe, equipas, desarme, marcaçao, agressividade, capacidadeCruzamento, drible);
        this.jogadores.put(nome, jog);                 
                            
    }
    
    public void criaMedio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                   int remate, int passe, List<String> clubes, int recuperaçaoDeBola, int criatividade){
                             
                            
        Jogador jog = new Medio(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                   remate, passe,clubes, recuperaçaoDeBola, criatividade);
        this.jogadores.put(nome, jog);                 
                            
    }
    
    public void criaAvancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                     int remate, int passe, List<String> equipas, int finalizacao, int drible,
                     int piorPe){
                             
                            
        Jogador jog = new Avancado(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                     remate, passe, equipas, finalizacao, drible,
                     piorPe);
        this.jogadores.put(nome, jog);                 
                            
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
        return jogos;
    }

    public Map<String, Equipa> getEquipas() {
        return equipas;
    }

    public Map<String, Jogador> getJogadores() {
        return jogadores;
    }
}
