import java.util.List;
import java.util.Objects;

/**
 * Write a description of class laterais here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lateral extends Defesa
{
    private int capacidadeCruzamento;
    private int drible;

    public Lateral (){
        super();
        this.capacidadeCruzamento = 0;
        this.drible = 0;
    }

    public Lateral (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe, List<String> equipas, int desarme, int marcaçao,
                    int agressividade, int capacidadeCruzamento, int drible){

        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe, equipas,
              desarme,marcaçao,agressividade);
        this.capacidadeCruzamento = capacidadeCruzamento;
        this.drible = drible;
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
        return new Defesa(this);
    }
}

