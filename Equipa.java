import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
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

   //DEFINIR CLONE
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
        this.Plantel.add(j);
    }

    public String toString(){
        String r =  "Equipa:" + this.NomeDaEquipa+ "\n";
        for (Jogador j : this.Plantel){
            r += j.toString();
        }
        return r;
    }
}
