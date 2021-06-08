import java.io.EOFException;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws Jogo.EquipaNaoExisteException, FmModel.JogadorInexistenteEquipaException {

        FmModel model = new FmModel();
        FmController controller = new FmController(model);
        FmView view = new FmView(controller);
        view.run();

       /*  try {
            Parser.parse(model);
            model.atualizaHistóricoEquipas();
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }
        try {
            model.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        } */
    }
}