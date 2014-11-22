
package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

class Poligono extends JComponent {

    public void paint (Graphics g) {
        g.setColor(Color.RED);
 	int[] x={100, 150, 200, 250, 300, 350,400,450,500,550,600,650,700};
        int[] y={100, 200, 100, 200, 100, 200,100,200,100,200,100,200,100};
	g.drawPolygon(x, y, x.length);
        int[] x2={150, 200, 250, 300, 350,400,450,500,550,600,650};
        int[] y2={205, 105, 205, 105, 205,105,205,105,205,105,205};
	g.drawPolygon(x2, y2, x2.length);
    }
}

public class Graficos14 {
  public static void main(String[] a) {
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(600, 600);
    ventana.getContentPane().add(new Poligono());
    ventana.setVisible(true);
  }
}