package GUI;

import javax.swing.*;
public class E_JMenuBar {
    public static void main(String[] args) {
        JFrame ventana=new JFrame();
        ventana.setTitle("EJEMPLO JMenuBar");
        ventana.setSize(250,150);

        JMenuBar menuBar=new JMenuBar();
        ventana.setJMenuBar(menuBar);

        //  NOMBRE DE LOS MENUS
        JMenu menu1=new JMenu("MENU 1");
        JMenu menu2=new JMenu("MENU 2");

        // OPCIONES DEL MENU 1
        JMenuItem menuOpcion1= new JMenuItem("OPCIÓN 1");
        JMenuItem menuOpcion2= new JMenuItem("OPCIÓN 2");
        //SE AGREGAN AL MENU 1
        menu1.add(menuOpcion1);
        menu1.add(menuOpcion2);

        //  OPCIONES DEL MENU 2
        JCheckBoxMenuItem jcbMenuOpcion1= new JCheckBoxMenuItem("OPCIÓN 1");
        JCheckBoxMenuItem jcbMenuOpcion2= new JCheckBoxMenuItem("OPCIÓN 2",true);
        JRadioButtonMenuItem jcbMenuOpcion3= new
        JRadioButtonMenuItem("OPCIÓN 3",true);
        //  SE AGREGAN AL MENU 2
        menu2.add(jcbMenuOpcion1);
        menu2.add(jcbMenuOpcion2);
        menu2.addSeparator(); //Agrega un separador
        menu2.add(jcbMenuOpcion3);

        //  MENU 1 Y MENU 2 SE AGREGAN AL MENUBAR
        menuBar.add(menu1);
        menuBar.add(menu2);

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}