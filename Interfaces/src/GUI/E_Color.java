package GUI;

import java.awt.*;
import javax.swing.*;
public class E_Color {
    public static void main(String[] args) {
        JFrame ventana=new JFrame();
        ventana.setTitle("Colores");
        ventana.setSize(200,150);
        ventana.getContentPane().setLayout(new FlowLayout());
        JLabel etiqueta1=new JLabel("PRIMERA ETIQUETA");
        JLabel etiqueta2=new JLabel("SEGUNDA ETIQUETA");

        ventana.getContentPane().add(etiqueta1);
        ventana.getContentPane().add(etiqueta2);

        etiqueta1.setForeground(new Color(255,0,0));
        etiqueta2.setForeground(Color.BLUE);

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}