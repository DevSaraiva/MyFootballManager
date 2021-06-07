import java.util.List;
import java.util.Objects;

/**
 * Write a description of class laterais here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lateral extends Jogador
{
    private int capacidadeCruzamento;
    private int drible;

    public Lateral (){
        super();
        this.capacidadeCruzamento = 0;
        this.drible = 0;
    }

    public Lateral (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe, List<String> equipas, int capacidadeCruzamento, int drible){

        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe, equipas);
        this.capacidadeCruzamento = capacidadeCruzamento;
        this.drible = drible;
        super.setHabilidade(this.calculaHabilidadeJogador());
    }

    public Lateral (Lateral l){
        super(l);
        this.capacidadeCruzamento = l.getCapacidadeCruzamento();
        this.drible = l.getDrible();
    }

    //gets e sets

    public int getCapacidadeCruzamento() {
        return this.capacidadeCruzamento;
    }

    public int getDrible() {
        return this.drible;
    }

    public void setCapacidadeCruzamento(int capacidadeCruzamento) {
        this.capacidadeCruzamento = capacidadeCruzamento;
    }

    public void setDrible(int drible) {
        this.drible = drible;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lateral lateral = (Lateral) o;
        return super.equals(o) && this.capacidadeCruzamento == lateral.getCapacidadeCruzamento() && this.drible == lateral.getDrible();
    }

    public String toString() {
        return "Laterais{" +
                "capacidadeCruzamento=" + this.capacidadeCruzamento +
                ", drible=" + this.drible +
                "} " + super.toString();
    }
    public Jogador clone() {
        return new Lateral(this);
    }

    public int calculaHabilidadeJogador() {
        return (int) (0.20 * this.capacidadeCruzamento + 0.10 * this.drible +
                0.15 * super.getVelocidade() +
                0.15 * super.getResistencia() +
                0.05 * super.getDestreza() +
                0.05 * super.getImpulsao() +
                0.05 * super.getJogoAereo() +
                0.10 * super.getRemate() +
                0.15 * super.getPasse());
    }
}

