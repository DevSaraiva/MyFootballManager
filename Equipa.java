import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Equipa implements Serializable
{
    private String NomeDaEquipa;
    private String Treinador;
    private List<Jogador> Plantel;

    public Equipa(){
        this.NomeDaEquipa = "";
        this.Treinador = "";
        this.Plantel = new ArrayList<Jogador>();
    }

    public Equipa(String NomeDaEquipa, String Treinador, List<Jogador> Plantel){
        this.NomeDaEquipa = NomeDaEquipa;
        this.Treinador = Treinador;
        this.Plantel = Plantel;
    }

    public Equipa (Equipa e){
        this.NomeDaEquipa = e.getNomeDaEquipa();
        this.Treinador = e.getTreinador();
        this.Plantel = e.getPlantel();
    }

    // gets e sets

    public String getNomeDaEquipa() {
        return this.NomeDaEquipa;
    }

    public String getTreinador() {
        return this.Treinador;
    }

    public List<Jogador> getPlantel() {
        List<Jogador> aux = new ArrayList<>();
        for (Jogador  t : this.Plantel)
            aux.add(t.clone());
        return aux;
    }

    public void setNomeDaEquipa(String nomeDaEquipa) {
        this.NomeDaEquipa = nomeDaEquipa;
    }

    public void setTreinador(String treinador) {
        this.Treinador = treinador;
    }

    public void setPlantel(List<Jogador> plantel) {
        this.Plantel = plantel;
    }


    public Equipa clone (){
        Equipa aux = new Equipa (this);
        return aux;
    }

    public Equipa(String nomeE){
        this.NomeDaEquipa = nomeE;
        this.Treinador = "";
        this.Plantel = new ArrayList<Jogador>();
    }
    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador (Jogador j){
        int i;
        for (i = j.getNumeroJogador(); containsNum(i); i++);
        if (i != j.getNumeroJogador()) j.setNumero(i);
        this.Plantel.add(j);
    }

    public void removeJogador (Jogador j) {
        this.Plantel.remove(j);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Equipa: ");sb.append(this.NomeDaEquipa);
        List<Jogador> sorted = this.Plantel.stream().sorted().collect(Collectors.toList());
        for (Jogador j : sorted){
            sb.append("\n\t");
            if (j instanceof GuardaRedes) sb.append("GR->");
            if (j instanceof Defesa) sb.append("D ->");
            if (j instanceof Lateral) sb.append("L ->");
            if (j instanceof Medio) sb.append("M ->");
            if (j instanceof Avancado) sb.append("A ->");
            sb.append(j.getHabilidade());sb.append(" ");
            sb.append(j.getNome());
        }
        return sb.toString();
    }

    public boolean containsNum (int num){
        boolean r = false;
        for (Jogador j : this.Plantel){
            if (j.getNumeroJogador() == num)
                r = true;
        }
        return r;
    }

    // supondo que aa equipa tem obrigatoriamente este num
    public Jogador get1Jogador (int num){
        Jogador aux = null;
        for (Jogador j : this.Plantel){
            if (j.getNumeroJogador() == num)
                aux = j.clone();
        }
        return aux;
    }

    public List<Jogador> get11Jogs (List<Integer> nums){
        List<Jogador> aux = new ArrayList<>();
        for (int j : nums){
            aux.add(get1Jogador(j));
        }
        return aux;
    }

     // FIXME yah a insere equipa yah :

}




