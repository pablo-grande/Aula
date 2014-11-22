package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

class Linea extends JComponent {

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(20,20,200,200);
    }
}

public class Graficos02 {
  public static void main(String[] a) {
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(300, 300);
    ventana.getContentPane().setBackground(Color.black);
    ventana.getContentPane().add(new Linea());
    ventana.setVisible(true);
  }
}