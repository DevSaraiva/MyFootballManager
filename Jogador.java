import java.io.Serializable;
import java.util.Objects;

public abstract class Jogador implements Serializable
{
    private String nome;
    private int numero;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoAereo;
    private int remate;
    private int passe;
    private int Habilidade;
    private List<String>equipas;

    public Jogador(){
        this.nome = "";
        this.numero = 0;
        this.velocidade =0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogoAereo = 0;
        this.remate = 0;
        this.passe =0;
        this.Habilidade = 0;
        this.equipas = new ArrayList<>();
    }

    public Jogador (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                    int remate, int passe, String equipas){
        this.nome = nome;
        this.numero = numero;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoAereo = jogoAereo;
        this.remate = remate;
        this.passe = passe;
        this.Habilidade = 0;
        this.equipas = equipas;
    }

    public Jogador (Jogador j){
        this.nome = j.getNome();
        this.numero = j.getNumeroJogador();
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogoAereo = j.getJogoAereo();
        this.remate = j.getRemate();
        this.passe = j.getPasse();
        this.Habilidade = j.getHabilidade();
        this.equipas = j.getEquipas();

    }

    // Gets e Sets
    public String getNome() {
        return this.nome;
    }

    public int getNumeroJogador() {
        return this.numero;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public int getDestreza() {
        return this.destreza;
    }

    public int getImpulsao() {
        return this.impulsao;
    }

    public int getJogoAereo() {
        return this.jogoAereo;
    }

    public int getRemate() {
        return this.remate;
    }

    public int getPasse() {
        return this.passe;
    }

    public int getHabilidade() {
        return this.Habilidade;
    }

    public List<String> getEquipas() {
        return this.equipas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public void setJogoAereo(int jogoAereo) {
        this.jogoAereo = jogoAereo;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public void setHabilidadeAtacante(int habilidade) {
        this.Habilidade = habilidade;
    }

    public void setEquipas(List<String> equipas) {
        this.equipas = equipas;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return this.numero == jogador.getNumeroJogador()  && this.nome.equals(jogador.getNome());
    }

    public String toString() {
        return "Jogador{" +
                "nome='" + this.nome + '\'' +
                ", numero=" + this.numero +
                ", velocidade=" + this.velocidade +
                ", resistencia=" + this.resistencia +
                ", destreza=" + this.destreza +
                ", impulsao=" + this.impulsao +
                ", jogoAereo=" + this.jogoAereo +
                ", remate=" + this.remate +
                ", passe=" + this.passe +
                ", Habilidade=" + this.Habilidade +
                ", Equipas=" + this.equipas +
                '}';
    }

    public abstract Jogador clone();

}

