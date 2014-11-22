package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

class Rectangulo extends JComponent {

    public void paint (Graphics g) {
        g.setColor(Color.green);
        g.fillRect(20,20,300,200);
        g.clearRect(75,75,100,100);
    }
}

public class Graficos05 {
  public static void main(String[] a) {
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(300, 300);
    ventana.getContentPane().setBackground(Color.black);
    ventana.getContentPane().add(new Rectangulo());
    ventana.setVisible(true);
  }
}