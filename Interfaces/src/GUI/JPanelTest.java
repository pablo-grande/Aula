package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JPanelTest extends JFrame {
	private JPanel panelBotones;
	private PanelPersonalizado miPanel;
	private JButton botonCirculo, botonCuadrado;
	// configurar GUI
	public JPanelTest() {
		super( "JPanelTest" );
		// crear área personalizada de dibujo
		miPanel = new PanelPersonalizado();
		miPanel.setBackground( Color.BLACK );
		// establecer botonCuadrado
		botonCuadrado = new JButton( "Cuadrado" );
		botonCuadrado.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent evento ) {
				miPanel.dibujar( PanelPersonalizado.CUADRADO);
			}
		});
		botonCirculo = new JButton( "Círculo" );
		botonCirculo.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent evento ) {
				miPanel.dibujar( PanelPersonalizado.CIRCULO );
			}
		});
		/*JPANEL PARA AGRUPAR COMPONENTES*/
		// establecer panel con botones
		panelBotones = new JPanel();
		panelBotones.setLayout( new GridLayout( 1, 2 ) );
		panelBotones.add( botonCirculo );
		panelBotones.add( botonCuadrado );
		/* adjuntar panel de botones y área personalizada de dibujo al panel de contenido*/
		Container contenedor = getContentPane();
		contenedor.add( miPanel, BorderLayout.CENTER );
		contenedor.add( panelBotones, BorderLayout.SOUTH );
		setSize(300,150);
		setVisible(true);
	} // fin del constructor JPanelTest

	public static void main( String args[] ) {
		JPanelTest aplicacion = new JPanelTest();
		aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}