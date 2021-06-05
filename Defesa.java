import java.util.Objects;

public class Defesa extends Jogador{

    private int desarme;
    private int marcaçao;
    private int agressividade;

    public Defesa (){
        super();
        this.desarme = 0;
        this.marcaçao = 0;
        this.agressividade = 0;
    }

    public Defesa (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe,int desarme,int marcaçao,int agressividade){

        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe);
        this.desarme = desarme;
        this.marcaçao = marcaçao;
        this.agressividade = agressividade;
    }

    public Defesa (Defesa d){
        super(d);
        this.desarme = d.getDesarme();
        this.marcaçao = d.getMarcaçao();
        this.agressividade = d.getAgressividade();
    }


    // gets e sets
    public int getDesarme(){
        return this.desarme;
    }

    public int getMarcaçao() {
        return this.marcaçao;
    }

    public int getAgressividade() {
        return this.agressividade;
    }

    public void setDesarme(int desarme) {
        this.desarme = desarme;
    }

    public void setMarcaçao(int marcaçao) {
        this.marcaçao = marcaçao;
    }

    public void setAgressividade(int agressividade) {
        this.agressividade = agressividade;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defesa defesas = (Defesa) o;
        return super.equals(o) && this.desarme == defesas.getDesarme() && this.marcaçao == defesas.getMarcaçao()
                        && this.agressividade == defesas.getAgressividade();
    }

    public String toString() {
        return "Defesas{" +
                "desarme=" + this.desarme +
                ", marcaçao=" + this.marcaçao +
                ", agressividade=" + this.agressividade +
                "} " + super.toString();
    }

    public Jogador clone() {
        return new Defesa(this);
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                50,50,50);
    }
}
