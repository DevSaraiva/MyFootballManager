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
    private Equipa equipaVisitada;
    private Equipa equipaVisitante;
    private boolean pausa;
    private int golosCasa;
    private int golosFora;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substituicoesFora = new HashMap<>();
    
    

    public Jogo(){
        this.tempo = 0;
        this.equipaVisitada = new Equipa();
        this.equipaVisitante = new Equipa();
        this.pausa = true;
        this.golosCasa = 0;
        this.golosFora = 0;
        this.jogadoresCasa = new ArrayList<>();
        this.jogadoresFora = new ArrayList<>();
        this.substituicoesCasa = new HashMap<>();
        this.substituicoesFora = new HashMap<>();

    }
    
    public Jogo (Equipa ec, Equipa ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
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
        this.substituicoesFora = new HashMap<>(sf);
    }


    public Jogo (int tempo,Equipa equipaVisitada,Equipa equipaVisitante,boolean pausa,int golosCasa,int golosFora){

        this.tempo = tempo;
        this.equipaVisitada = equipaVisitada;
        this.equipaVisitante = equipaVisitante;
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

    public LocalDate getData(){
       return  this.data;
    }

    public List<Integer> getJogadoresCasa() {
        return this.jogadoresCasa;
    }

    public List<Integer> getJogadoresFora() {
        return this.jogadoresFora;
    }

    public Map<Integer, Integer> getSubstitucoesFora() {
        return this.substituicoesFora;
    }

    public Map<Integer, Integer> getSubstituicoesCasa() {
        return this.substituicoesCasa;
    }

    public void setJogadoresCasa(List<Integer> jogadoresCasa) {
        this.jogadoresCasa = jogadoresCasa;
    }

    public void setJogadoresFora(List<Integer> jogadoresFora) {
        this.jogadoresFora = jogadoresFora;
    }

    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa;
    }

    public void setSubstitucoesFora(Map<Integer, Integer> substitucoesFora) {
        this.substituicoesFora = substitucoesFora;
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


    public static class EquipaNaoExisteException extends Exception {
        public EquipaNaoExisteException(){
            super();
        }

        public EquipaNaoExisteException(String s){
            super(s);
        }
    }

    public static Jogo parse(String input,Map<String, Equipa> equipas) throws EquipaNaoExisteException{
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
        if (equipas.containsKey(campos[0]) && equipas.containsKey(campos[1])){
            return new Jogo(equipas.get(campos[0]), equipas.get(campos[1]), Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                    LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                    jc, subsC, jf, subsF);
        }
        else throw new EquipaNaoExisteException();

    }

    public class SubstituicaoInvalidaException extends Exception {
        public SubstituicaoInvalidaException(){
            super();
        }

        public SubstituicaoInvalidaException(String s){
            super(s);
        }
    }

    public boolean validaSubstituicaoCasa (int nEntra, int nSai) {
        boolean r = true;
        if (this.substituicoesCasa.size() < 3){
            // jogador que vai sair tem que estar no 11
            if (!this.jogadoresCasa.contains(nSai)) return false;
            // jogador que vai entrar tem que pertencer a equipa
            if (!this.getEquipaVisitada().containsNum(nEntra)) return false;
            // se o jogador que vai entrar ja tiver saido FALSE (substituicao MAP <sai , entra>)
            if (this.substituicoesCasa.containsKey(nEntra)) return false;
        }
        else r = false;
        return r;
    }

    public void efectuaSubstituicaoCasa (int nEntra, int nSai) throws SubstituicaoInvalidaException{
        if (validaSubstituicaoCasa(nEntra,nSai)){
            for (int j : this.getJogadoresCasa()){
                if (j == nSai)
                    j = nSai;
            }
        }
        else throw new SubstituicaoInvalidaException();

    }

    public boolean validaSubstituicaoFora (int nEntra, int nSai) {
        boolean r = true;
        if (this.substituicoesFora.size() < 3){
            // jogador que vai sair tem que estar no 11
            if (!this.jogadoresFora.contains(nSai)) return false;
            // jogador que vai entrar tem que pertencer a equipa
            if (!this.getEquipaVisitante().containsNum(nEntra)) return false;
            // se o jogador que vai entrar ja tiver saido FALSE (substituicao MAP <sai , entra>)
            if (this.substituicoesFora.containsKey(nEntra)) return false;
        }
        else r = false;
        return r;
    }

    public void efectuaSubstituicaoFora (int nEntra, int nSai) throws SubstituicaoInvalidaException{
        if (validaSubstituicaoFora(nEntra,nSai)){
            for (int j : this.getJogadoresCasa()){
                if (j == nSai)
                    j = nSai;
            }
        }
        else throw new SubstituicaoInvalidaException();
    }


}
