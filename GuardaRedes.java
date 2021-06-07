import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuardaRedes extends Jogador implements Serializable
{
    private int elasticidade;
    private int reflexos;

    public GuardaRedes (){
        super();
        this.elasticidade = 0;
        this.reflexos = 0;
    }

    public GuardaRedes (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                        int remate, int passe, List<String> equipas, int elasticidade, int reflexos){

        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe,equipas);
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

    public static GuardaRedes parse(String input){
        List<String> equipas = new ArrayList<>();
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                equipas,
                Integer.parseInt(campos[9]),
                50);
    }





}
