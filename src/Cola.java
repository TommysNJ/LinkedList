import javax.swing.*;
import java.util.Stack;

public class Cola extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    Stack<String>pila1 = new Stack<>();


    public Cola(){
        setContentPane(panel1);
    }
}