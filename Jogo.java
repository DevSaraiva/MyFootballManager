import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Jogo implements Serializable {
    private int tempo;
    private LocalDate data;
    private String equipaVisitada;
    private String equipaVisitante;
    private boolean pausa;
    private int golosCasa;
    private int golosFora;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substitucoesFora = new HashMap<>();
    
    

    public Jogo(){
        this.tempo = 0;
        this.equipaVisitada = "";
        this.equipaVisitante = "";
        this.pausa = true;
        this.golosCasa = 0;
        this.golosFora = 0;
    }
    
    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        this.tempo = 0;
        this.pausa = true;
        this.equipaVisitada = ec;
        this.equipaVisitante = ef;
        this.golosCasa = gc;
        this.golosFora = gf;
        this.data = d;
        this.jogadoresCasa = new ArrayList<>(jc);
        this.jogadoresFora = new ArrayList<>(jf);
        this.substituicoesCasa = new HashMap<>(sc);
        this.substitucoesFora = new HashMap<>(sf);
    }

    /*public Jogo (int tempo,Equipa equipaVisitada,Equipa equipaVisitante,boolean pausa,int golosCasa,int golosFora){
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
    }*/

    // gets e sets

   public int getTempo() {
        return this.tempo;
    }

    public String getEquipaVisitada() {
        return this.equipaVisitada;
    }

    public String getEquipaVisitante() {
        return this.equipaVisitante;
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

    /*public void setTempo(int tempo) {
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
    }*/

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    /*public boolean equals(Object o) {
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
    }*/
    
    public String toString() {
        return  "Jogo:" + this.equipaVisitada + " - " + this.equipaVisitante;
                //+ " -> " + substituicoesCasa.toString()
                //+ " -> " + substitucoesFora.toString();
    }
    
    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                        LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        jc, subsC, jf, subsF);
    }
}
