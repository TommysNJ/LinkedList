import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.EmptyStackException;
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

    private int quantum;
    private int acumulado;
    Queue<Proceso> cola = new LinkedList<>();
    Stack<Proceso> pila = new Stack<>();
    Stack<Proceso> pila2 = new Stack<>();
    Proceso p1 = new Proceso ("P1","043534523", 100);
    Proceso p2 = new Proceso ("P2","096785654", 90);
    Proceso p3 = new Proceso ("P3","049873455", 70);
    Proceso p4 = new Proceso ("P4","075464565", 50);
    Proceso p5 = new Proceso ("P5","053673455", 40);
    Proceso p6 = new Proceso ("P6","023565466", 20);

    public Cola(){
        setContentPane(panel1);
        ButtonMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaDatos.setText("");
                for (Proceso imprimir:cola){
                    AreaDatos.append(imprimir+"\n");
                }
            }
        });
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
        ButtonQuantum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FieldQuantum.getText().isEmpty()){
                    quantum=35;
                    AreaQuantum.setText("El nuevo valor del quantum es: " + quantum);
                } else {
                    quantum=0;
                    quantum=Integer.parseInt(FieldQuantum.getText());
                    AreaQuantum.setText("El nuevo valor del quantum es: " + quantum);
                }
            }
        });
        ButtonRobin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int acumulado=0;
                while (!cola.isEmpty()) {
                    Proceso procesoActual = cola.poll();
                    int tiempo = procesoActual.getTiempo();
                    AreaRobin.append("Tiempo " + acumulado + ": El proceso " + procesoActual.getId() + " entra en ejecución.\n");
                    if (tiempo > 0 && tiempo > quantum) {
                        tiempo -= quantum; //tiempo=100-20
                        acumulado+=quantum;
                        procesoActual.setTiempo(tiempo);
                        cola.offer(procesoActual);
                        AreaRobin.append("Tiempo " + acumulado + ": El proceso " + procesoActual.getId() + " tiene " + tiempo + " de tiempo restante.\n");
                    } else {
                        acumulado+=tiempo;
                        AreaRobin.append("Tiempo " + acumulado + ": El proceso " + procesoActual.getId() + " ha finalizado.\n");
                        pila.push(procesoActual);
                    }
                }
                AreaRobin.append("Tiempo " + acumulado + ": Todos los procesos han finalizado.\n");
                AreaRobin.append("Tiempo total ejecutado: " + acumulado);
            }
        });

        ButtonHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pila.isEmpty()){
                    try{
                        pila.peek();
                        pila.pop();
                    } catch (EmptyStackException em){
                        //AreaHistorial.setText("");
                    }
                } else{
                    AreaHistorial.setText("");
                    do{
                        AreaHistorial.append(pila.peek().getId() + "\n" + pila.peek().getCedula() + "\n\n");
                        pila2.push(pila.pop());

                    } while (!pila.isEmpty());
                }
            }
        });
        ButtonUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaHistorial.setText("");
                if (pila2.isEmpty()){
                    try{
                        pila2.peek();
                        pila2.pop();
                    } catch (EmptyStackException em){
                        //AreaHistorial.setText("");
                    }
                } else{
                    AreaHistorial.setText(pila2.peek().getId() + "\n" + pila2.peek().getCedula() + "\n\n");
                    do {
                        pila.push(pila2.pop());
                    } while (!pila2.isEmpty());
                }
            }
        });
        ButtonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaHistorial.setText("");
                pila.clear();
                pila2.clear();
                AreaHistorial.setText("El Historial se ha borrado.");
            }
        });
    }
}