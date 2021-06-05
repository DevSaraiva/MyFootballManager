import java.util.Objects;

/**
 * Write a description of class guardaRedes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuardaRedes extends Jogador
{
    private int elasticidade;
    private int reflexos;

    public GuardaRedes (){
        super();
        this.elasticidade = 0;
        this.reflexos = 0;
    }

    public GuardaRedes (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                         int remate, int passe,int elasticidade,int reflexos){

        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe);
        this.elasticidade = elasticidade;
        this.reflexos = reflexos;
    }

    public GuardaRedes (GuardaRedes gr){
        super(gr);
        this.elasticidade = gr.getElasticidade();
        this.reflexos = gr.getReflexos();
    }

    // Gets e Sets
    public int getElasticidade(){
        return this.elasticidade;
    }

    public int getReflexos() {
        return this.reflexos;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }

    public void setReflexos(int reflexos) {
        this.reflexos = reflexos;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuardaRedes that = (GuardaRedes) o;
        return super.equals(o) && this.elasticidade == that.getElasticidade() && this.reflexos == that.getReflexos();
    }

    public String toString() {
        return "GuardaRedes{" +
                "elasticidade=" + this.elasticidade +
                ", reflexos=" + this.reflexos +
                "} " + super.toString();
    }

    public Jogador clone() {
        return new GuardaRedes(this);
    }
}
