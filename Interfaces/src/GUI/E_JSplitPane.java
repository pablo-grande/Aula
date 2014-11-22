package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class E_JSplitPane {
    static JFrame ventana= new JFrame();
    static JSplitPane jsplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    static JLabel etiqueta1 = new JLabel("AREA 1");
    static JLabel etiqueta2 = new JLabel("AREA 2");

    public static void main(String[] args) {
        ventana.setTitle("EJEMPLO JSplitPane");
        ventana.setSize(300,200);

        //CARGANDO JSplitPane CON DOS COMPONENTES
        jsplitPane.add(etiqueta1);
        jsplitPane.add(etiqueta2);

        //CARGANDO LA VENTANA CON EL JSplitPane
        ventana.getContentPane().add(jsplitPane,BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        ventana.setVisible(true);
    }
}