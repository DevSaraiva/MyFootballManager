import java.util.List;

public class FmView
{
    FmController controller;

    public FmView(FmController controller){

            this.controller = controller;
    }

    public void menu(){



    }

    public void printOpcoes(List<String> ops){

        int i = 1;
        for(String s: ops){

            System.out.println(i + ": " + s);
            i++;

        }


    }

    public void run(){

        this.controller.loadDataController(0);
        List<String> opcs = controller.getJogadores();
        printOpcoes(opcs);

    }







}
