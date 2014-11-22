package GUI;

import java.awt.*;
import javax.swing.*;
public class E_Font {
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        ventana.setTitle("EJEMPLO CLASE Font");
        ventana.setSize(180,200);
        ventana.setLayout(new FlowLayout());
        JLabel etiqueta1 = new JLabel("Times");
        etiqueta1.setFont(new Font("Times", Font.PLAIN, 20));JLabel etiqueta2 = new JLabel("Arial");
        etiqueta2.setFont(new Font("Arial", Font.BOLD, 32));
        JLabel etiqueta3 = new JLabel("Comic Sans MS");
        etiqueta3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        JLabel etiqueta4 = new JLabel("MS Gothic");
        etiqueta4.setFont(new Font("MS Gothic", Font.BOLD,20));
        JLabel etiqueta5 = new JLabel("Brodway");
        etiqueta5.setFont(new Font("Brodway", Font.BOLD | Font.ITALIC, 28));
        ventana.add(etiqueta1); ventana.add(etiqueta2); ventana.add(etiqueta3);
ventana.add(etiqueta4); ventana.add(etiqueta5);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}