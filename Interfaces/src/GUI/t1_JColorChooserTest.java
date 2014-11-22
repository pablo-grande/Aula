package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class t1_JColorChooserTest extends JFrame {
    private JButton botonCambiarColor;
    private Color color = Color.LIGHT_GRAY;
    private Container contenedor;

    // configurar GUI
    public t1_JColorChooserTest() {
        super( "JColorChooserTest" );
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        // configurar cambiarColorBoton y registrar su manejador de eventos
        botonCambiarColor = new JButton( "CAMBIAR COLOR" );
        botonCambiarColor.addActionListener(new ActionListener(){
            // mostrar JColorChooser cuando el usuario haga clic en el botón
            public void actionPerformed( ActionEvent evento ) {
                color = JColorChooser.showDialog(
                t1_JColorChooserTest.this, "Seleccione un color", color );
                // establecer color predeterminado, si no se devuelve un color si se pulsa el botón Cancelar
                if ( color == null ) color = Color.RED;
                // cambiar color de fondo del panel de contenido
                contenedor.setBackground( color );
            }
        });

        contenedor.add( botonCambiarColor );
        setSize( 400, 130 );
        setVisible( true );
    } // fin del constructor

    public static void main( String args[] ) {
        t1_JColorChooserTest aplicacion = new t1_JColorChooserTest();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}