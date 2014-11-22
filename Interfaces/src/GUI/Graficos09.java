package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

class Rectangulo extends JComponent {

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRoundRect(10, 10, 200, 100,20,20);
    }
}

public class Graficos09 {
  public static void main(String[] a) {
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(300, 300);
    ventana.getContentPane().add(new Rectangulo());
    ventana.setVisible(true);
  }
}