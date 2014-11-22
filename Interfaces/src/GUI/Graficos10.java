
package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

class Elipse extends JComponent {

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(10, 10, 200, 100);
    }
}

public class Graficos10 {
  public static void main(String[] a) {
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(300, 300);
    ventana.getContentPane().add(new Elipse());
    ventana.setVisible(true);
  }
}