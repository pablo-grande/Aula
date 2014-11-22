package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class E_Mouse extends JFrame {
    private int xPos, yPos;
    private JLabel etiqueta;
    public E_Mouse(){
        super( "Clics y botones del ratón" );
        Container contenedor= getContentPane();
        addMouseListener(new ManejadorClicsRaton());
        etiqueta= new JLabel("");
        contenedor.add(etiqueta);
        setSize(450,300);
        setVisible(true);
    } // fin del constructor

    // clase interna para manejar eventos de ratón
    private class ManejadorClicsRaton extends MouseAdapter {
        // manejar evento de clic del ratón y determinar cuál botón se oprimió
        public void mouseClicked(MouseEvent evento){
            xPos = evento.getX();
            yPos = evento.getY();
            String titulo = "Se hizo clic " + evento.getClickCount() + " Veces" ;
            String titulo2 = "Se hizo clic en: [" + xPos + ", " + yPos + "]";
            if (evento.isMetaDown())
                titulo += " con el botón derecho del ratón"; // botón derecho del ratón
            else if (evento.isAltDown())
                    titulo += " con el botón central del ratón"; // botón de en medio del ratón
                else
                    titulo += " con el botón izquierdo del ratón"; // botón izquierdo del ratón
            etiqueta.setText(titulo2);
            setTitle( titulo ); // establecer barra de título de la ventana
        } // fin del método mouseClicked
    } // fin de la clase interna privada ManejadorClicsRaton

    public static void main(String args[]) {
        E_Mouse aplicacion = new E_Mouse();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}