import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {
        // Inicia la interfaz de usuario
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainUIFrame ui = new MainUIFrame();
                ui.setVisible(true);
            }
        });
    }
}
