import java.util.List;
import java.util.ArrayList;
public class Equipa
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
        this.Plantel = Plantel; // duvida aqui
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

    public void setPlantel(List<Jogador> plantel) { // duvida
        this.Plantel = plantel;
    }

   //DEFINIR CLONE
    public Equipa clone (){
        Equipa aux = new Equipa (this);
        return aux;
    }
}
