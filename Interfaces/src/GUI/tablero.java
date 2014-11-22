package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

class Rectangulo extends JComponent {

    public void paint (Graphics g) {
        g.setColor(Color.red);
        for (int i=0; i<8; i++) {
            for (int j=0; j<2; j++) {
                g.drawRect(100+(25*i),100+(25*j),125+(25*i),125+(25*j));
            }
        }


    }
}
public class tablero {
  public static void main(String[] a) {
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(300, 300);
    ventana.getContentPane().setBackground(Color.black);
    ventana.getContentPane().add(new Rectangulo());
    ventana.setVisible(true);
  }
}