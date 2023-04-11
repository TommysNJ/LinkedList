import javax.swing.*;
import java.util.Stack;

public class Cola extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextArea AreaDatos;
    private JButton ButtonMostrarDatos;
    private JButton ButtonRobin;
    private JTextArea AreaInsertarDatos;
    private JButton ButtonInsertarDatos;
    private JTextArea AreaRobin;
    private JButton ButtonInsertarNuevo;
    private JTextArea AreaNuevo;
    private JTextField FieldID;
    private JTextField FieldCedula;
    private JTextField FieldTiempo;
    private JTextField FieldQuantum;
    private JButton ButtonQuantum;
    private JTextArea AreaQuantum;
    private JButton ButtonUltimo;
    private JButton ButtonHistorial;
    private JButton ButtonBorrar;
    private JTextArea AreaHistorial;
    Stack<String>pila1 = new Stack<>();


    public Cola(){
        setContentPane(panel1);
    }
}