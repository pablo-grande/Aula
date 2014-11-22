package grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Classe que crea els botons d'iniciar i aturar.
 * @author pablo
 */
public class ferBotons extends JPanel {

    private JPanel sud;
    private JButton botoIni;
    private JButton botoStop;
    private boolean iniTriat;
    private boolean stopTriat;

    /**
     * Constructor de la classe ferBotons. Crea els botons i els assigna un ActionListener.
     */
    public ferBotons() {
        sud = new JPanel();
        botoIni = new JButton("Iniciar");
        botoStop = new JButton("Sortir");
        botoIni.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                iniTriat = true;
                stopTriat = false;
                botoIni.setEnabled(false);
            }
        });
        botoStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stopTriat = true;
                iniTriat = false;
            }
        });
        sud.add(botoIni, BorderLayout.WEST);
        sud.add(botoStop, BorderLayout.EAST);
        this.add(sud);
    }

    /**
     * Funció que indica si s'ha pitjat el botó d'iniciar.
     * @return S'ha pitjat el botó d'iniciar (o no).
     */
    public boolean getIni() {
        return iniTriat;
    }

    /**
     * Mètode que modifica l'estat del botó d'iniciar.
     * @param bool El valor que se li vol assignar.
     */
    public void setIni(boolean bool) {
        iniTriat = bool;
        botoIni.setEnabled(!bool);
    }

    /**
     * Funció que indica si s'ha pitjat el botó d'aturar.
     * @return S'ha pitjat el botó d'aturar (o no).
     */
    public boolean getStop() {
        return stopTriat;
    }
}
