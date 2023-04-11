import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
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

    Queue<Proceso> cola = new LinkedList<>();
    Stack<String> pila = new Stack<>();
    Proceso p1 = new Proceso ("P1","043534523", 100);
    Proceso p2 = new Proceso ("P2","096785654", 90);
    Proceso p3 = new Proceso ("P3","049873455", 70);
    Proceso p4 = new Proceso ("P4","075464565", 50);
    Proceso p5 = new Proceso ("P5","053673455", 40);
    Proceso p6 = new Proceso ("P6","023565466", 20);

    public Cola(){
        setContentPane(panel1);
        ButtonInsertarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.offer(p1);
                cola.offer(p2);
                cola.offer(p3);
                cola.offer(p4);
                cola.offer(p5);
                cola.offer(p6);
                for (Proceso imprimir:cola){
                    AreaInsertarDatos.append(imprimir+"\n");
                }
            }
        });
        ButtonInsertarNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 cola.offer(new Proceso (FieldID.getText(),FieldCedula.getText(),Integer.parseInt(FieldTiempo.getText())));
                for (Proceso imprimir:cola){
                    AreaNuevo.append(imprimir+"\n");
                }
            }
        });
    }
}