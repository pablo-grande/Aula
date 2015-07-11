// CALCULADORA

package Mates;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc extends JFrame implements ActionListener {
// implements ActionListener IMPLICA LA SUBSCRIPCIÓN DE LOS EVENTOS SOBRE EL JFrame.
// LO ÚNICO QUE GESTIONAMOS SON LOS CLICKS EN LOS BOTONES DEL TECLADO.

    private JTextField display; //display de la calculadora
    char op = ' '; //operador
    String nump = "", num = ""; //nump significa número precedente

    public Calc() {
        setTitle("CALCULADORA");
        setSize(350, 500);
        setDefaultCloseOperation(Calc.EXIT_ON_CLOSE);
        inicializacion();
    }

    private void inicializacion() {
        //SE DEFINEN DOS PANELES (UNO PARA LOS BOTONES Y OTRO PARA EL DISPLAY DE LA CALCULADORA
        JPanel teclado = new JPanel();
        teclado.setLayout(new GridLayout(0, 4));
        String jlbBotones[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1",
            "2", "3", "-", "0", ".", "=", "+", "C"};
        for (int i = 0; i < jlbBotones.length; i++) {
            JButton boton = new JButton(jlbBotones[i]);
            boton.addActionListener(this);
            boton.setFont(new Font("arial", 0, 50));
            teclado.add(boton);
        }
        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("arial", 2, 25));
        JPanel ventana = (JPanel) getContentPane();
        ventana.setLayout(new BorderLayout());
        ventana.add(display, BorderLayout.NORTH);
        ventana.add(teclado, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent evt) {
        char c = ((JButton) evt.getSource()).getText().charAt(0);

        //CONSTRUCCIÓN DEL NÚMERO
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':   if (num.equals("")) {
                            display.setText(num);
                        }
                        num = num + c;
                        display.setText(num);
                        break;
            case '.':   if (num.equals("")) {
                            num = "0.";
                            display.setText(num);
                        } else if (!num.contains(".")) {
                            num = num + ".";
                            display.setText(num);
                        }
                        break;
            case 'C':   nump = "";
                        num = "";
                        op = ' ';
                        display.setText(num);
                        break;
            case '=':   if (!nump.equals("") || !num.equals("")) {
                            calc();
                        }
                        break;
            default:   if ((c=='-') && (op == ' ') && num.equals("")) {
                            display.setText(num);
                            num = num + c;
                            display.setText(num);
                        }
                        else if(op == ' ')  {
                            op = c;
                            if (!num.equals("")) {
                            nump = num;
                            }
                            num = "";
                        } else {
                            calc();
                            op = c;
                        }
                        break;
        }
    }

    private void calc() {
        if (!num.equals("") && !nump.equals("")) {
            double a = Double.parseDouble(nump);
            double b = Double.parseDouble(num);
            double r = 0;
            switch (op) {
                case '+': r=a+b;
                          break;
                case '-': r=a-b;
                          break;
                case '*': r=a*b;
                          break;
                case '/': r = a / (b != 0 ? b : 1);
                          break;
            }
            nump = Double.toString(r);
            display.setText(nump);
        }
        num = "";
    }

    public static void main(String[] args) {
        new Calc().setVisible(true);
    }
}