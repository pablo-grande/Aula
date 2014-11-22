package GUI;


import java.awt.*;
import javax.swing.*;


public class E_JTabbedPane extends JFrame {
    public E_JTabbedPane() {
        super("JTabbedPane");
        JLabel etiqueta1 = new JLabel("PANEL PRIMERO", SwingConstants.CENTER);
        JLabel etiqueta2 = new JLabel("PANEL SEGUNDO", SwingConstants.CENTER);
        JLabel etiqueta3 = new JLabel("PANEL TERCERO", SwingConstants.CENTER);

        // CREACIÓN OBJETO JTabbedPane
        JTabbedPane Multipaneles = new JTabbedPane();

        // ESTABLECIMIENTO DEL PANEL panel1
        JPanel panel1 = new JPanel();
        panel1.add(etiqueta1);

        // INTRODUCCIÓN DEL PANEL panel1 al MULTIPANELES
        // addTab(String title, Icon icon, Component component, String tip)
        Multipaneles.addTab("PANEL 1", null, panel1, "PRIMER PANEL");

        // ESTABLECIMIENTO DEL PANEL panel2 E INCORPORACIÓN AL MULTIPANELES
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        panel2.add(etiqueta2);
        Multipaneles.addTab("PANEL 2", null, panel2, "SEGUNDO PANEL");

        // ESTABLECIMIENTO DEL PANEL panel3 E INCORPORACIÓN AL MULTIPANELES
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add( new JButton("Norte"), BorderLayout.NORTH );
        panel3.add( new JButton("Sur"), BorderLayout.SOUTH );
        panel3.add( new JButton("Oeste"), BorderLayout.WEST );
        panel3.add( new JButton("Este"), BorderLayout.EAST );
        panel3.add( etiqueta3, BorderLayout.CENTER );
        Multipaneles.addTab("PANEL 3", null, panel3, "TERCER PANEL");

        // INSERCIÓN DEL MULTIPANEL AL CONTENEDOR
        getContentPane().add(Multipaneles);
        setSize(300, 200);
        setVisible( true );
    }   // FIN DEL CONSTRUCTOR

    public static void main(String args[]) {
        E_JTabbedPane demoMultipaneles = new E_JTabbedPane();
        demoMultipaneles.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
