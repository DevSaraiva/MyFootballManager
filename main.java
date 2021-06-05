
public class main {
    public static void main(String[] args) {


        try {
            Parser.parse();
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }


    }
}