import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FmController
{
    private FmModel model;

    public FmController(FmModel m){
        this.model = m;
    }


    //Função que de acordo com o input do utilizador decide a forma como faz o load

    public void loadDataController(int i){ // if i  == 0 load custom files else load given text file

            if( i == 0) {
                try {
                    this.model.loadData();

                } catch (IOException e) {

                    e.printStackTrace();

                } catch (ClassNotFoundException e) {

                    e.printStackTrace();
                }
            }else{

                try {
                    Parser.parse(model);

                } catch (LinhaIncorretaException e) {
                    e.printStackTrace();
                }
            }

    }

    // Devolve os nomes dos jogadores para serem apresentados na view

    public List<String> getJogadores(){

        List<String> nomesJogadores = new ArrayList<>();

        for(Jogador j: this.model.getJogadores().values()){
                nomesJogadores.add(j.getNome());

        }

        return  nomesJogadores;
    }

    // Devolve os nomes das equipas para serem apresentadas na view

    public List<String> getEquipas(){

        List<String> nomesEquipas = new ArrayList<>();

        for(Equipa e: this.model.getEquipas().values()){
            nomesEquipas.add(e.getNomeDaEquipa());
        }

        return  nomesEquipas;

    }



}
