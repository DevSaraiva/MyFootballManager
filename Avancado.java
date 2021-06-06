import java.io.Serializable;
import java.util.Objects;

public class Avancado extends Jogador implements Serializable
{
   private int finalizacao;
   private int drible;
   private int piorPe;

   public Avancado(){
      super();
      this.finalizacao = 0;
      this.drible = 0;
      this.piorPe = 0;
   }

   public Avancado (String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoAereo,
                     int remate, int passe, int finalizacao, int drible,
                     int piorPe){
      super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoAereo, remate, passe);
      this.finalizacao = finalizacao;
      this.drible = drible;
      this.piorPe = piorPe;
   }

   public Avancado (Avancado a){
      super(a);
      this.finalizacao = a.getFinalizacao();
      this.drible = a.getDrible();
      this.piorPe = a.getPiorPe();
   }

   // gets e sets

   public int getFinalizacao() {
      return this.finalizacao;
   }

   public int getDrible() {
      return this.drible;
   }

   public int getPiorPe() {
      return this.piorPe;
   }

   public void setFinalizacao(int finalizacao) {
      this.finalizacao = finalizacao;
   }

   public void setDrible(int drible) {
      this.drible = drible;
   }

   public void setPiorPe(int piorPe) {
      this.piorPe = piorPe;
   }

   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Avancado avancados = (Avancado) o;
      return super.equals(o) && this.finalizacao == avancados.getFinalizacao() && this.drible == avancados.getDrible() && this.piorPe == avancados.getPiorPe();
   }

   public String toString() {
      return "Avancados{" +
              "finalizacao=" + this.finalizacao +
              ", drible=" + this.drible +
              ", piorPe=" + this.piorPe +
              "} " + super.toString();
   }


   @Override
   public Jogador clone() {
      return new Avancado(this);
   }

   public static Avancado parse(String input){
      String[] campos = input.split(",");
      return new Avancado(campos[0],
              Integer.parseInt(campos[1]),
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
