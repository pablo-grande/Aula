/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contesclients;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class Finestra extends javax.swing.JFrame {

    //Utilitats generals
    static final Dimension DIM = new Dimension(457, 480);
    static final Dimension DIMPETITA = new Dimension(250, 70);
    static final Dimension DIMNOUCLIENT = new Dimension(250, 95);
    static final Point LOC = new Point(500, 125);
    static final Point LOCPETITA = new Point(890, 190);
    static final JLabel quantitat = new JLabel("Quantitat:");
    static final JLabel euroLabel = new JLabel("€");
    static final JLabel saldoLabel = new JLabel("Saldo:");
    static final JLabel nomLabel = new JLabel("Nom:");
    final static JLabel lCercaClient = new JLabel("Nom o Id del client:");
    static final String capçalera = "Resultat de la cerca";
    static final String missingClient = "No s'ha trobat el client";

    public Finestra() {
    }

    //Métode que treu la finestra d'eliminació o edició del client
    int elimina(int fila) {
        Object[] options = {"Eliminar", "Cancela"};
        return JOptionPane.showOptionDialog(null,
                "Eliminar client?",
                "Elimina client",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
    }

    double modificaSaldo(double inSaldo) {
        return 0 - inSaldo;
    }

    void missatge(String missatge) {
        //capturam l'excepció de l'empty string
        if (missatge.equals("empty String")) {
            missatge = "Alguns dels camps introduits estàn buits";
        }

        Object[] options = {"Accepta"};
        JOptionPane.showOptionDialog(null,
                missatge,
                "Error",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);
    }

    void resBusquedaId(Conta conta) {
        //retorna missatges en funció de si hi ha hagut sort a la cerca de comptes per id o no.
        String missatge = "Client trobat \n Client: " + (conta.getClient().getNom()) + "\n Saldo: " + (conta.getSaldo());

        Object[] options = {"Accepta"};
        JOptionPane.showOptionDialog(null,
                missatge,
                capçalera,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
    }

    void resBusquedaNom(String missatge) {
        Object[] options = {"Accepta"};
        JOptionPane.showOptionDialog(null,
                missatge,
                capçalera,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
    }

    //comprovam valor numeric
    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public void llista(final Conta conta) {
        final ArrayList<Conta> arrayContes = new ArrayList<>();

        JFrame llista = new JFrame("Llista clients");
        llista.setSize(DIM);
        llista.setLocation(LOC);
        llista.setResizable(true);
        llista.getContentPane().setLayout(new FlowLayout());

        //Lista
        final JTable tabla;
        tabla = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        final DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        modelo.addColumn("Nom Usuari");
        modelo.addColumn("Id conta");
        modelo.addColumn("saldo");

        //Botóns: Nou usuari, eliminar, fica i treu saldo i cercar
        final JButton bNouClient = new JButton("Nou client");
        final JButton bCerca = new JButton("Cerca");
        bCerca.setEnabled(false);

        bNouClient.addActionListener(new ActionListener() {  //Agregamos un oyente de evento al botón
            public void actionPerformed(ActionEvent evento) { //Tratamiento del evento
                final Conta conta = new Conta();

                //Crea una nova finestra;
                final JFrame fNouClient = new JFrame("Nou client");
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                //camps i botons
                final JTextField cNouClient = new JTextField(15);
                final JTextField cSaldoClient = new JTextField(5);
                final JButton bAcceptaClient = new JButton("Accepta");

                bAcceptaClient.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        try {
                            if (tryParseInt(cNouClient.getText())) {
                                missatge("No s'admeten caràcters numèrics al nom d'usuari");
                            } else if (Double.parseDouble(cSaldoClient.getText()) < 0.0) {
                                missatge("No s'admet un saldo negatiu");
                            } else {
                                //nom del client
                                conta.getClient().setNom(cNouClient.getText());
                                //id conta del client
                                conta.setNumero_conta(cNouClient.hashCode());
                                //saldo del client
                                conta.setSaldo(Double.parseDouble(cSaldoClient.getText()));
                                //agafam els camps introduits a la classe
                                final Object[] fila = new Object[3];
                                fila[0] = conta.getClient().getNom();
                                fila[1] = conta.getNumero_conta();
                                fila[2] = Double.toString(conta.getSaldo());
                                arrayContes.add(conta);
                                modelo.addRow(fila); // Añade una fila al final
                                //añadimos esta cuenta a la lista
                                bCerca.setEnabled(true);
                            }
                            tabla.clearSelection();
                            fNouClient.dispose();
                        } catch (Exception e) {
                            missatge(e.getMessage().toString());
                        }
                    }
                });

                cNouClient.setToolTipText("Se li aplicará un hash per obtenir el seu nº de compta");
                cNouClient.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

                fNouClient.getContentPane().add(nomLabel);
                fNouClient.getContentPane().add(cNouClient);
                fNouClient.getContentPane().add(saldoLabel);
                fNouClient.getContentPane().add(cSaldoClient);
                fNouClient.getContentPane().add(euroLabel);
                fNouClient.getContentPane().add(new JLabel("          ")); //truco para separar botón aceptar del resto
                fNouClient.getContentPane().add(bAcceptaClient);

                fNouClient.setSize(DIMNOUCLIENT);
                fNouClient.setLocation(LOCPETITA);
                fNouClient.setResizable(false);
                fNouClient.getContentPane().setLayout(new FlowLayout());
                fNouClient.setVisible(true);
                //fi de la finestra d'input
            }
        });

        bCerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) { //Tratamiento del evento

                //Crea una nova finestra;
                final JFrame fCerca = new JFrame("Cerca de client");
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                //camps i botons
                final JTextField cCercaClient = new JTextField(10);
                final JButton bCercaClient = new JButton("Cerca");

                bCercaClient.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        try {
                            //cream una conta auxiliar per a poder comparar les dades
                            Conta aux = new Conta();
                            String campo_aux = cCercaClient.getText();
                            //comprovam si es un numero
                            if (tryParseInt(campo_aux)) {
                                //es una id
                                aux.setNumero_conta(Integer.parseInt(campo_aux));
                                //recorrem l'array de contes
                                int i = 0;
                                while (arrayContes.get(i).getNumero_conta() != aux.getNumero_conta()) {
                                    i++;
                                }
                                if (arrayContes.get(i).getNumero_conta() == aux.getNumero_conta()) {
                                    //si l'hem trobada per nom
                                    resBusquedaId(arrayContes.get(i));
                                } else {
                                    //sino
                                    missatge(missingClient);
                                }
                            } else {
                                //cogemos el nombre del campo
                                aux.getClient().setNom(campo_aux);
                                //creamos un indice
                                int[] coincidencies = new int[arrayContes.size()];
                                int j = 0; //indice del contador;
                                //recorremos el array de cuentas
                                for (int i = 0; i < arrayContes.size(); i++) {
                                    /*
                                     * si encontramos una coincidencia, quiere decir que el nombre indotroducido se encuentra en la lista
                                     * para listar todas esta cuentas posteriormente, metemos en la lista auxiliar los elementos que vayamos encontrando
                                     */
                                    //mostramos todos los nombres de clientes
//                                    System.out.println("Todos los clientes: "+arrayContes.get(i).getClient().getNom());
//                                    System.out.println();
                                    if (arrayContes.get(i).getClient().getNom().equals(aux.getClient().getNom())) {
//                                        System.out.println("array: "+arrayContes.get(i).getClient().getNom());
//                                        System.out.println("auxiliar: "+aux.getClient().getNom());
                                        coincidencies[j] = i; //guardamos el indice de la cuenta con el mismo nombre.
                                        j++;
                                    }
                                }

                                if (j == 0) {
                                    //vol dir que no ha hagut coincidences.
                                    missatge(missingClient);
                                } else {
                                    String mensj = "";
                                    for (int i = 0; i < j; i++) {
                                        mensj += ("Id cont: " + arrayContes.get(coincidencies[i]).getNumero_conta() + " Saldo: " + arrayContes.get(coincidencies[i]).getSaldo() + "\n");
                                    }
                                    resBusquedaNom(mensj);
                                }
                            }
                            tabla.clearSelection();
                            fCerca.dispose();

                        } catch (Exception e) {
                            missatge(e.getMessage().toString());
                        }
                    }
                });

                fCerca.getContentPane().add(lCercaClient);
                fCerca.getContentPane().add(cCercaClient);
                fCerca.getContentPane().add(bCercaClient);

                fCerca.setSize(DIMPETITA);
                fCerca.setLocation(LOCPETITA);
                fCerca.setResizable(false);
                fCerca.getContentPane().setLayout(new FlowLayout());
                fCerca.setVisible(true);
                //fi de la finestra
            }
        });

        //mouse listener
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                final int fila = tabla.rowAtPoint(e.getPoint());
                int columna = tabla.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
//                    elimina(fila);

                    if (columna != 2) {
                        //eliminam(fila)
                        if (elimina(fila) == 0) {
                            arrayContes.remove(fila);
                            modelo.removeRow(fila); // Borra la primera fila
                            //si no queden clients a la llista, llavors hem de deshabilitar els botons
                            if (arrayContes.isEmpty()) {
                                bCerca.setEnabled(false);
                            }
                        }
                    } else {

                        //TreuSaldo
                        final JFrame saldo = new JFrame("Introduiu quantitat");
                        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                        //camps i botons
                        final JButton extreuSaldo = new JButton("Extreu");
                        final JButton ingresaSaldo = new JButton("Ingresa");
                        final JTextField quantitatSaldo = new JTextField(10);

                        //utilitats per treure saldo
                        final double clientSaldo = arrayContes.get(fila).getSaldo();

                        extreuSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                try {
                                    final double inSaldo = Double.parseDouble(quantitatSaldo.getText());
                                    if (arrayContes.get(fila).getSaldo() - inSaldo < 0.0) {
                                        missatge("No pot quedar un saldo negatiu");
                                    } else {
                                        arrayContes.get(fila).setSaldo(modificaSaldo(inSaldo));
                                        modelo.setValueAt(arrayContes.get(fila).getSaldo(), fila, 2); // Cambia el valor de la fila 1, columna 2.
                                        saldo.dispose();
                                        tabla.clearSelection();
                                    }
                                } catch (Exception e) {
                                    missatge(e.getMessage().toString());
                                }
                            }
                        });

                        ingresaSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                try {
                                    final double inSaldo2 = Double.parseDouble(quantitatSaldo.getText());
                                    System.out.println(inSaldo2);
                                    arrayContes.get(fila).setSaldo(inSaldo2);
                                    modelo.setValueAt(arrayContes.get(fila).getSaldo(), fila, 2); // Cambia el valor de la fila 1, columna 2.
                                    saldo.dispose();
                                    tabla.clearSelection();
                                } catch (Exception e) {
                                    missatge(e.getMessage().toString());
                                }
                            }
                        });

                        saldo.getContentPane().add(quantitat);
                        saldo.getContentPane().add(quantitatSaldo);
                        saldo.getContentPane().add(euroLabel);
                        saldo.getContentPane().add(extreuSaldo);
                        saldo.getContentPane().add(ingresaSaldo);

                        saldo.setSize(DIMPETITA);
                        saldo.setLocation(LOCPETITA);
                        saldo.setResizable(false);
                        saldo.getContentPane().setLayout(new FlowLayout());
                        saldo.setVisible(true);
                        //FiTreuSaldo
                    }


                }
            }
        });

        //Añadimos los botones
        JPanel sitioBoton = new JPanel();
        sitioBoton.add(bNouClient);
        sitioBoton.add(bCerca);

        //Añadimos los elementos
        llista.getContentPane().add(sitioBoton);
        llista.getContentPane().add(new JScrollPane(tabla));
        llista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // AL CERRAR LA VENTANA SE TERMINARÁ LA APLICACIÓN
        llista.dispose();
        llista.setVisible(true);

    }
}
