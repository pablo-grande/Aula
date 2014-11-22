package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class E_Teclado1 extends JFrame implements KeyListener {
    private String linea1 = "", linea2 = "", linea3 = "";
    private JTextArea areaTexto;
    public E_Teclado1() {
        super("EJEMPLOS EVENTOS DEL TECLADO");

        // ESTABLECIMIENTO OBJETO JTextArea
        areaTexto = new JTextArea(10,15);
        areaTexto.setText("PULSE UNA TECLA");
        areaTexto.setEnabled(false);
        areaTexto.setDisabledTextColor(Color.blue);
        getContentPane().add(areaTexto);
        // EVENTOS DEL TECLADO PARA EL AREA JTextArea
        addKeyListener(this);
        setSize(400, 100);
        setVisible(true);
        } // FIN DEL CONSTRUCTOR

    // GESTIÓN DEL EVENTO DE PULSACIÓN DE CUALQUIER TECLA
    public void keyPressed(KeyEvent evento) {
        // getKeyText(int codigo_de_tecla) RETORNA UN STRING DEL NOMBRE DE LA TECLA CORRESPONDIENTE
        //                                 AL CÓDIGO (EJEMPLO: "A", "f1", ...)
        // getKeyCode() RETORNA EL ENTERO (ASCII) CORRESPONDIENTE AL CÓDIGO DE LA TECLA ASOCIADO A ESTE EVENTO.
        // getKeyChar() RETORNA EL CARACTER ASOCIADO CON LA TECLA (EJEMPLO: System.out.println(evento.getKeyChar());)
        linea1 = "SE PULSÓ LA TECLA: " + evento.getKeyText(evento.getKeyCode());
        establecerLineas2y3(evento);
    }

    // GESTIÓN DEL EVENTO DE SOLTAR (DEJAR DE PULSAR) CUALQUIER TECLA
    public void keyReleased(KeyEvent evento) {
        linea1 = "SE SOLTÓ LA TECLA: " + evento.getKeyText(evento.getKeyCode());
        establecerLineas2y3(evento);
    }

    // GESTIÓN DEL EVENTO DE PULSACIÓN DE UNA TECLA DE ACCIÓN
    public void keyTyped(KeyEvent evento) {
        // no hay nada
    }

    // ESTABLECIMIENTO DE LA SEGUNDA Y TERCERA LINEA DE VISUALIZACIÓN
    // VISUALIZACIÓN DE TODAS LAS LÍNEAS
    private void establecerLineas2y3(KeyEvent evento) {
        // TECLAS DE ACCIÓN  F1-F12, ImpPant, Inicio, Supr, etc..
        linea2 = "Esta tecla " + (evento.isActionKey() ? "" : "NO ") + "ES UNA TECLA DE ACCIÓN";
        String temp = evento.getKeyModifiersText(evento.getModifiers());
        // TECLAS MODIFICADORAS  Ctrl, Shift, Alt, Ctrl+Alt
        linea3 = "Teclas modificadoras oprimidas: " + (temp.equals("") ? "NINGUNA" : temp);
        areaTexto.setText(linea1 + "\n" + linea2 + "\n" + linea3 + "\n");
    }

    public static void main(String args[]) {
        E_Teclado1 aplicacion = new E_Teclado1();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}