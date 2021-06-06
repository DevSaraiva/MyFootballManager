import java.io.Serializable;
import java.util.Objects;


public class Medio extends Jogador implements Serializable {
 
    private int recuperaçaoDeBola;
    private int criatividade;
    
    public Medio(){
        super();
        this.recuperaçaoDeBola =0;
        this.criatividade = 0;
    }

    public Medio (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                   int remate, int passe, int recuperaçaoDeBola, int criatividade){
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe);
        this.recuperaçaoDeBola  = recuperaçaoDeBola;
        this.criatividade = criatividade;
    }

    public Medio (Medio m){
        super(m);
        this.recuperaçaoDeBola = m.getRecuperaçaoDeBola();
        this.criatividade = m.getCriatividade();
    }

    // gets e sets

    public int getRecuperaçaoDeBola() {
        return this.recuperaçaoDeBola;
    }

    public int getCriatividade() {
        return this.criatividade;
    }

    public void setRecuperaçaoDeBola(int recuperaçaoDeBola) {
        this.recuperaçaoDeBola = recuperaçaoDeBola;
    }

    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medio medios = (Medio) o;
        return super.equals(o) && this.recuperaçaoDeBola == medios.getRecuperaçaoDeBola() && this.criatividade == medios.getCriatividade();
    }

    public String toString() {
        return "Medios{" +
                "recuperaçaoDeBola=" + this.recuperaçaoDeBola +
                ", criatividade=" + this.criatividade +
                "} " + super.toString();
    }

    public Jogador clone() {
        return new Medio(this);
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0],
                Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                50);
    }
}
