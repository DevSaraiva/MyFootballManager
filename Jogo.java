import java.time.LocalDate;
import java.util.Objects;

public class Jogo {
    private int tempo;
    private LocalDate data;
    private Equipa equipaVisitada;
    private Equipa equipaVisitante;
    private boolean pausa;
    private int golosCasa;
    private int golosFora;

    public Jogo(){
        this.tempo = 0;
        this.equipaVisitada = new Equipa();
        this.equipaVisitante = new Equipa();
        this.pausa = false;
        this.golosCasa = 0;
        this.golosFora = 0;
    }

    public Jogo (int tempo,Equipa equipaVisitada,Equipa equipaVisitante,boolean pausa,int golosCasa,int golosFora){
        this.tempo = tempo;
        this.equipaVisitada = equipaVisitada.clone();
        this.equipaVisitante = equipaVisitante.clone();
        this.pausa = pausa;
        this.golosCasa = golosCasa;
        this.golosFora = golosFora;
    }

    public Jogo (Jogo j){
        this.tempo = j.getTempo();
        this.equipaVisitada = j.getEquipaVisitada();
        this.equipaVisitante = j.getEquipaVisitante();
        this.pausa = j.getPausa();
        this.golosCasa = j.getGolosCasa();
        this.golosFora = j.getGolosFora();
    }

    // gets e sets

    public int getTempo() {
        return this.tempo;
    }

    public Equipa getEquipaVisitada() {
        return this.equipaVisitada.clone();
    }

    public Equipa getEquipaVisitante() {
        return this.equipaVisitante.clone();
    }

    public boolean getPausa() {
        return this.pausa;
    }

    public int getGolosCasa() {
        return this.golosCasa;
    }

    public int getGolosFora() {
        return this.golosFora;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setEquipaVisitada(Equipa equipaVisitada) {
        this.equipaVisitada = equipaVisitada;
    }

    public void setEquipaVisitante(Equipa equipaVisitante) {
        this.equipaVisitante = equipaVisitante;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return this.tempo == jogo.getTempo() && this.equipaVisitada.equals(jogo.getEquipaVisitada()) && this.equipaVisitante.equals(jogo.getEquipaVisitante()) &&
                this.pausa == jogo.getPausa() && this.golosCasa == jogo.getGolosCasa() && this.golosFora == jogo.getGolosFora();
    }

    public String toString() {
        return "Jogo{" +
                "tempo=" + this.tempo +
                ", equipaVisitada=" + this.equipaVisitada.toString() +
                ", equipaVisitante=" + this.equipaVisitante.toString() +
                ", pausa=" + this.pausa +
                ", golosCasa=" + this.golosCasa +
                ", golosFora=" + this.golosFora +
                '}';
    }
}
