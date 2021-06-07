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

    //Função que lê e verifica validade de atributo

    public int leAtributo(String atributo){
        int atr = this.ins.nextInt();
        while(atr > 99 || atr < 1){
            System.out.println(atributo+ "Inválido");
            atr = this.ins.nextInt();
        }
        return  atr;
    }

    public void criarJogador(){
        System.out.println("Insira o tipo de jogador que pretende criar");
        System.out.println("1 - Guarda - Redes");
        System.out.println("2 - Defesa");
        System.out.println("3 - Lateral");
        System.out.println("4 - Medio");
        System.out.println("5 - Avançado");
        int sel = this.ins.nextInt();

        String nome = "";
        int numero = 0;
        int velocidade = 0;
        int resistencia = 0;
        int destreza = 0;
        int impulsao = 0;
        int jogoAereo = 0;
        int remate = 0;
        int passe = 0;
        int elasticidade = 0;
        int reflexos = 0;

        System.out.println("Insira o nome do jogador");
        nome = this.ins.next();
        System.out.println("Insira o numero do jogador (0-99)");
        numero = leAtributo("Numero");
        System.out.println("Insira o velocidade do jogador (0-99)");
        velocidade = leAtributo("Velocidade");
        System.out.println("Insira o valor de resistencia (0-99)");
        resistencia = leAtributo("Resistencia");
        System.out.println("Insira o valor da destreza (0-99)");
        destreza = leAtributo("Destreza");
        System.out.println("Insira o valor da impulsao (0-99)");
        impulsao = leAtributo("Impulsao");
        System.out.println("Insira o valor do jogo aereo (0-99)");
        jogoAereo = leAtributo("Jogo Aereo");
        System.out.println("Insira o valor do remate (0-99)");
        remate = leAtributo("Remate");
        System.out.println("Insira o valor do passe (0-99)");
        passe = leAtributo("Passe");

        switch(sel){
            case 1:

                break;

            case 2:

                break;

            case 3 :

                break;

            case 4:

                break;

            case 5:

                break;

        }
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
                    criarJogador();
                    break;
            }



        }







    }







}
