import java.util.List;
import java.util.Scanner;

public class FmView {
    FmController controller;
    Scanner ins;

    public FmView(FmController controller){

            this.controller = controller;
            this.ins = new Scanner(System.in);
    }

    public int menu(){

        System.out.println("1 - Consultar jogadores existentes");
        System.out.println("2 - Consultar equipas existentes");
        System.out.println("3 - Consultar jogos");
        System.out.println(("4 - Criar Jogador"));
        System.out.println(("5 - Criar equipa"));
        System.out.println(("6 - Criar jogo"));
        System.out.println("7 - Correr Jogo");
        System.out.println("8 - Simular Jogo");
        int sel = this.ins.nextInt();

        return sel;

    }

    public void printOpcoes(List<String> ops){

        int i = 1;
        for(String s: ops){

            System.out.println(i + ": " + s);
            i++;
        }
    }

    public void consultarJogadoresExistentes(){

        int selection = -1;
        List<String> jogadores = this.controller.getJogadores();
        printOpcoes(jogadores);
        selection = this.ins.nextInt();
        String s = this.controller.getJogador(jogadores.get(selection - 1));
        System.out.println(s);

    }

    public void consultarEquipasExistentes(){

        int selection = -1;
        List<String> equipas = this.controller.getEquipas();
        printOpcoes(equipas);
        selection = this.ins.nextInt();
        String s = this.controller.getEquipa(equipas.get(selection - 1));
        System.out.println(s);

    }


    public void consultarJogosExistentes(){
        int selection = -1;
        List<String> jogos = this.controller.getJogos();
        printOpcoes(jogos);
        selection = this.ins.nextInt();
        String s = this.controller.getJogo(selection);
        System.out.println(s);
    }

    public void criarJogador(){

    }

    public void run(){

        List<String> opcs;
        int selection = -1;
        System.out.println("Insira 1 para carregar os seus dados");
        System.out.println("Insira 2 para carregar os dados predefinidos");

        selection = this.ins.nextInt();
        this.controller.loadDataController(selection);

        while(true){

            selection = menu();

            switch (selection){
                case 1:
                    consultarJogadoresExistentes();
                    break;
                case 2:
                    consultarEquipasExistentes();
                    break;

                case 3:
                    consultarJogosExistentes();
                    break;

                case 4:
                    
                    break;
            }



        }







    }







}
