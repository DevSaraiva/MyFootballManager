import java.io.EOFException;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws Jogo.EquipaNaoExisteException, FmModel.JogadorInexistenteException {

        FmModel model = new FmModel();
        FmController controller = new FmController(model);
        FmView view = new FmView(controller);
        view.run();
    }


}
