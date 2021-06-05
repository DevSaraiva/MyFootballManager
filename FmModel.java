import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class FmModel {

    private Map<String,Jogador>  jogadores; //Par (nome,jogador)
    private Map<String,Equipa> equipas; // Par(nome, equipa)
    private List<Jogo> jogos; //Lista de jogos

    public FmModel() throws java.lang.ClassNotFoundException {
        
        try
        {
            FileInputStream fis = new FileInputStream("/Files/Jogadores");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.jogadores = (Map<String,Jogador>) ois.readObject();
            ois.close();
        }
        catch (java.io.IOException ioe)
        {
            this.jogadores = new HashMap<>();
        }
        
        
        try
        {
            FileInputStream fis2 = new FileInputStream("/Files/Equipas");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            this.equipas = (Map<String,Equipa>) ois2.readObject();
            ois2.close();
        
        }
        catch (java.io.IOException ioe)
        {
            this.equipas = new HashMap<>();
        }
        
        
             try
        {
            FileInputStream fis3 = new FileInputStream("/Files/Jogos");
            ObjectInputStream ois3 = new ObjectInputStream(fis3);
            this.jogos = (List<Jogo>) ois3.readObject();
            ois3.close();
        }
        catch (java.io.IOException ioe)
        {
            this.jogos = new ArrayList();
        }
    }
    
    public void saveJogadores() throws java.io.IOException {
        
        FileOutputStream fos = new FileOutputStream("/Files/Jogadores");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.jogadores);
        oos.flush();
        oos.close();
        
    }
    
    public void saveEquipas() throws java.io.IOException {
        
        FileOutputStream fos = new FileOutputStream("/Files/Equipas");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.equipas);
        oos.flush();
        oos.close();
        
    }
    
    public void saveJogos() throws java.io.IOException {
        
        FileOutputStream fos = new FileOutputStream("/Files/Jogos");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.jogos);
        oos.flush();
        oos.close();
        
    }
    

    public void criaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo, int remate,
                          int passe, int elasticiadde, int reflexos){

        Jogador jog = new GuardaRedes(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe,  elasticiadde, reflexos);
        this.jogadores.put(nome, jog);
    }

    
    public void criaDefesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe,int desarme,int marcaçao,int agressividade){

        Jogador jog = new Defesa(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                    remate, passe, desarme, marcaçao, agressividade);
        this.jogadores.put(nome, jog);
    }
    
    public void criaLateral(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                         int remate, int passe, int desarme,int marcaçao,int agressividade, int capacidadeCruzamento, int drible){
                             
                            
        Jogador jog = new Lateral(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                         remate, passe, desarme, marcaçao, agressividade, capacidadeCruzamento, drible);
        this.jogadores.put(nome, jog);                 
                            
    }
    
    public void criaMedio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                   int remate, int passe, int recuperaçaoDeBola, int criatividade){
                             
                            
        Jogador jog = new Medio(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                   remate, passe, recuperaçaoDeBola, criatividade);
        this.jogadores.put(nome, jog);                 
                            
    }
    
    public void criaAvancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                     int remate, int passe, int finalizacao, int drible,
                     int piorPe){
                             
                            
        Jogador jog = new Avancado(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo,
                     remate, passe, finalizacao, drible,
                     piorPe);
        this.jogadores.put(nome, jog);                 
                            
    }
    
    





}
