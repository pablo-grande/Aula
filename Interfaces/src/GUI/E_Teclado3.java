package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E_Teclado3 extends JFrame {
    private String linea1 = "", linea2 = "", linea3 = "";
    private JTextArea areaTexto;
    public E_Teclado3() {
        super("EJEMPLOS EVENTOS DEL TECLADO");
        // establecer objeto JTextArea
        areaTexto = new JTextArea(10,15);
        areaTexto.setText("PULSE UNA TECLA");
        getContentPane().add(areaTexto);

        // GESTIÓN DE EVENTOS DEL TECLADO
        areaTexto.addKeyListener(new KeyListener() {
            // getKeyText(int codigo_de_tecla) RETORNA UN STRING DEL NOMBRE DE LA TECLA CORRESPONDIENTE
            //                                 AL CÓDIGO (EJEMPLO: "A", "f1", ...)
            // getKeyCode() RETORNA EL ENTERO (ASCII) CORRESPONDIENTE AL CÓDIGO DE LA TECLA ASOCIADO A ESTE EVENTO.
            // getKeyChar() RETORNA EL CARACTER ASOCIADO CON LA TECLA (EJEMPLO: System.out.println(evento.getKeyChar());)

            // GESTIÓN DEL EVENTO DE PULSACIÓN DE CUALQUIER TECLA
            public void keyPressed(KeyEvent evento) {
                linea1 = "Se oprimió tecla: " + evento.getKeyText(evento.getKeyCode());
                establecerLineas2y3(evento);
            }

            // GESTIÓN DEL EVENTO DE SOLTAR (DEJAR DE PULSAR) CUALQUIER TECLA
            public void keyReleased(KeyEvent evento) {
                linea1 = "Se soltó tecla: " + evento.getKeyText(evento.getKeyCode());
                establecerLineas2y3(evento);
            }

            // GESTIÓN DEL EVENTO DE PULSACIÓN DE UNA TECLA DE ACCIÓN
            public void keyTyped(KeyEvent evento) {
                // no hay nada
            }

            // ESTABLECIMIENTO DE LA SEGUNDA Y TERCERA LINEA DE VISUALIZACIÓN
            // VISUALIZACIÓN DE TODAS LAS LÍNEAS
            private void establecerLineas2y3(KeyEvent evento) {
                //TECLAS DE ACCIÓN --> F1-F12, ImpPant, Inicio, Supr, etc..
                linea2 = "ESTA TECLA " + (evento.isActionKey() ? "" : "NO ") + "ES UNA TECLA DE ACCIÓN";
                String temp = evento.getKeyModifiersText(evento.getModifiers());
                //TECLAS MODIFICADORAS --> Ctrl, Shift, Alt, Ctrl+Alt
                linea3 = "TECLAS MODIFICADORAS PULSADAS: " + (temp.equals("") ? "NINGUNA" : temp);
                areaTexto.setText(linea1 + "\n" + linea2 + "\n" + linea3 + "\n");
            }
        });

        setSize(400, 100 );
        setVisible( true );
    } // FIN DEL CONSTRUCTOR

    public static void main( String args[] ) {
        E_Teclado3 aplicacion = new E_Teclado3 ();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}