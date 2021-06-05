import java.util.List;
import java.util.Map;

public class FmModel {

    private Map<String,Jogador>  jogadores; //Par (nome,jogador)
    private Map<String,Equipa> equipas; // Par(nome, equipa)
    private List<Jogo> jogos; //Lista de jogos


    
    public
    
    
    

    public void criaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo, int remate,
                          int passe, int elasticiadde, int reflexos){

        Jogador jog = new GuardaRedes(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe,  elasticiadde, reflexos);
    }

    
    





}
