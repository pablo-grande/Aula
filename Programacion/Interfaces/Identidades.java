package Interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Identidades extends JFrame {
    private JList listaNombres, listaIdentidades, listaCopia;
    private JButton botonCopiar;
    private JScrollPane jsp1, jsp2, jsp3;
    private final String nombres[] = {"Toni Alarcon", "Pablo Riutort", "Alfredo Ucendo"
                 };
        private final String identidades[] = {"Me gusta :|", "Cereal Guy", "Fuck Yeah"
                 };
    public Identidades() {
        //Pasa el mensaje al constructor del JFrame
        super("Listas de selección múltiple");
        getContentPane().setLayout(new FlowLayout());

        // establecer objeto JList listaNombres
        listaNombres = new JList(nombres);
        listaNombres.setVisibleRowCount(3); //Mostrados en el JScrollPane
        //listaNombres.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jsp1= new JScrollPane(listaNombres);
        getContentPane().add(jsp1);

       // establecer objeto JList listaIdentidades
        listaIdentidades = new JList(identidades);
        listaIdentidades.setVisible(false);
        listaIdentidades.setVisibleRowCount(3); //Mostrados en el JScrollPane
        listaIdentidades.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jsp1= new JScrollPane(listaIdentidades);



        // crear botón copiar y registrar su componente de escucha
        botonCopiar = new JButton("Desvelar identidad >>>");

        getContentPane().add( botonCopiar );
        botonCopiar.addActionListener(new ActionListener() {
            // manejador del evento del botón
            public void actionPerformed( ActionEvent evento) {

                           listaIdentidades.setSelectedIndices(listaNombres.getSelectedIndices());
                       listaCopia.setListData(listaIdentidades.getSelectedValues());

               // colocar valores seleccionados en listaCopia
                                                           //listaCopia.setListData(listaNombres.getSelectedValues());
             // fin de clase interna anónima
        }});  // fin de la llamada a addActionListener

        // establecer objeto JList listaCopia
        listaCopia = new JList();
        listaCopia.setVisibleRowCount(3);
        listaCopia.setFixedCellWidth(100);
        listaCopia.setFixedCellHeight(15);
        listaCopia.setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION );
        jsp2= new JScrollPane(listaCopia);
        getContentPane().add(jsp2);
        setSize(400,150);
        setVisible( true );
    } // fin constructor JScrollPaneTest1

    public static void main(String args[]){
        Identidades aplicacion = new Identidades();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}