import java.util.ArrayList;
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
        System.out.println("9 - Fazer Traansferência de Jogador");
        int sel = leNumero(1,9,"Comando");

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
        selection = leNumero(1,jogadores.size(),"");
        String s = this.controller.getJogador(jogadores.get(selection - 1));
        System.out.println(s);

    }

    public void consultarEquipasExistentes(){

        int selection = -1;
        List<String> equipas = this.controller.getEquipas();
        printOpcoes(equipas);
        selection = leNumero(1,equipas.size(),"");
        String s = this.controller.getEquipa(equipas.get(selection - 1));
        System.out.println(s);

    }


    public void consultarJogosExistentes(){
        int selection = -1;
        List<String> jogos = this.controller.getJogos();
        printOpcoes(jogos);
        selection = leNumero(1,jogos.size(),"");
        String s = this.controller.getJogo(selection);
        System.out.println(s);
    }

    public void fazerTransferencia() {
        //this.ins.nextLine();
        System.out.println("Insira o nome do Jogador que pretende transferir");
        String nomeJogador = this.ins.nextLine();
        //System.out.println("Insira a equipa Origem");
        //String equipaOrigem = this.ins.nextLine();
        System.out.println("Insira a equipa Destino");
        String equipaDestino = this.ins.nextLine();


        //System.out.println(equipaOrigem+equipaDestino+nomeJogador);
        try {
            this.controller.transfereEquipa(equipaDestino,nomeJogador);
        } catch (FmModel.JogadorInexistenteEquipaException e) {
            e.printStackTrace();
        } catch (Jogo.EquipaNaoExisteException e){
            e.printStackTrace();
        }
    }

    //Função que lê e verifica validade de atributo

    public int leAtributo(String atributo){
        int atr = this.ins.nextInt();
        while(atr > 99 || atr < 1){
            System.out.println(atributo+ " Inválido");
            atr = this.ins.nextInt();
        }
        return  atr;
    }

    // Função que suporta a funcionaldidade de criar um jogador
    public void criarJogador(){
        System.out.println("Insira o tipo de jogador que pretende criar");
        System.out.println("1 - Guarda - Redes");
        System.out.println("2 - Defesa");
        System.out.println("3 - Lateral");
        System.out.println("4 - Medio");
        System.out.println("5 - Avançado");
        int sel = leNumero(1,5,"Posição");
        //this.ins.nextLine();


        List<String> equipas = new ArrayList<>();
        String equipa = "";
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
        int desarme = 0;
        int marcacao = 0;
        int agressividade = 0;
        int capacidadeCruzamento = 0;
        int drible = 0;
        int recuperacaoDeBola = 0;
        int criatividade = 0;
        int finalizacao = 0;
        int piorPe = 0;

        System.out.println("Insira a equipa do jogador ou F para nao atribuir equipa");
        equipa = this.ins.nextLine();
        while(!this.controller.existeEquipa(equipa) && equipa.compareTo("F") != 0 && equipa.compareTo("f") != 0){
            System.out.println("Equipa inválida");
            equipa = this.ins.nextLine();

        }
        equipas = new ArrayList<>();
        if(equipa.compareTo("F") != 0 && equipa.compareTo("F") != 0) equipas.add(equipa);

        System.out.println("Insira o nome do jogador");
        nome = this.ins.nextLine();
        System.out.println("Insira o numero do jogador (0-99)");
        numero = leNumero(1,99,"Número");
        System.out.println("Insira o velocidade do jogador (0-99)");
        velocidade = leNumero(1,99,"Velocidade");
        System.out.println("Insira o valor de resistencia (0-99)");
        resistencia = leNumero(1,99,"Resistencia");
        System.out.println("Insira o valor da destreza (0-99)");
        destreza = leNumero(1,99,"Destreza");
        System.out.println("Insira o valor da impulsao (0-99)");
        impulsao = leNumero(1,99,"Impulsao");
        System.out.println("Insira o valor do jogo aereo (0-99)");
        jogoAereo = leNumero(1,99,"Jogo Aereo");
        System.out.println("Insira o valor do remate (0-99)");
        remate = leNumero(1,99,"Remate");
        System.out.println("Insira o valor do passe (0-99)");
        passe = leNumero(1,99,"Passe");


        switch(sel){
            case 1:
                System.out.println("Insira o valor da elasticidade do jogador (0-99)");
                elasticidade = leNumero(1,99,"Elasticidade");
                System.out.println("Insira o valor dos reflexos do jogador (0-99)");
                reflexos = leNumero(1,99,"Reflexos");

                this.controller.criaRedes(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,elasticidade,reflexos);
                break;

            case 2:
                System.out.println("Insira o valor do desarme do jogador (0-99)");
                desarme = leNumero(1,99,"Desarme");
                System.out.println("Insira o valor da marcacao do jogador (0-99)");
                marcacao = leNumero(1,99,"Marcacao");

                this.controller.criaDefesa(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,desarme,marcacao,agressividade);
                break;

            case 3 :
                System.out.println("Insira o valor da capacidade de cruzamento do jogador (0-99)");
                capacidadeCruzamento = leNumero(1,99,"Capacidade de Cruzamento");
                System.out.println("Insira o valor da marcacao do jogador (0-99)");
                drible = leNumero(1,99,"Drible");

                this.controller.criaLateral(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,capacidadeCruzamento,drible);
                break;

            case 4:
                System.out.println("Insira o valor da recuperação de bola (0-99)");
                recuperacaoDeBola = leNumero(1,99,"Recuperacão De Bola");
                System.out.println("Insira o valor da marcacão do jogador (0-99)");
                criatividade = leNumero(1,99,"Criatividade");

                this.controller.criaMedio(nome,numero,velocidade,resistencia,destreza,impulsao,jogoAereo,remate,passe,equipas,recuperacaoDeBola,criatividade);
                break;

            case 5:

                System.out.println("Insira o valor da Finalização (0-99)");
                finalizacao = leNumero(1,99,"Finalização");
                System.out.println("Insire o valor do drible");
                drible = leNumero(1,99,"Drible");
                System.out.println("Insira o valor do pior pé (0-99)");
                piorPe = leNumero(1,99,"Pior pé");

                break;

            default:
                System.out.println("Seleção inválida");
                break;
        }
    }

    public class ComandoInvalidoException extends Exception {
        public ComandoInvalidoException(){
            super();
        }

        public ComandoInvalidoException(String s){
            super(s);
        }
    }

    public int validaComando (String s) throws ComandoInvalidoException{
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9');
            else throw new ComandoInvalidoException(s);
        }
        return Integer.parseInt(s);
    }

    public int leNumero (int limInf,int limSup,String tipo) {
        int res = 0;
        while (res == 0) {
            String comando = this.ins.nextLine();
            try {
                res = validaComando(comando);
                if (res >= limInf && res <= limSup) ;
                else {
                    System.out.println("Este número '"+ res + "' não está dentro dos parametros. Por favor insira um número entre "+limInf + " e " + limSup);
                    res = 0;
                }
            } catch (ComandoInvalidoException e) {
                System.out.println(tipo +" '" + e.getMessage() + "' é inválido! Tente novamente.");
            }
        }
        return res;
    }


    public void run(){
        List<String> opcs;
        int selection = -1;
        System.out.println("Insira 1 para carregar os seus dados");
        System.out.println("Insira 2 para carregar os dados predefinidos");


        selection = leNumero(1,2,"Comando");
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

                case 9:
                    fazerTransferencia();
                    break;

                default:
                    System.out.println("Seleção inválida");
                    break;
            }
        }
    }


}
