import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//public class Main {
    //public static void main(String[] args) {
        //add: te bota un error si es que nos excedemos el límite de elementos
        //offer: no te bota error
        //poll: te bota error
        //remove: no bota error
        //handshake:
    //}
//}
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Cola();
                frame.setSize(800, 550);
                frame.setVisible(true);
            }
        });
    }

}