package grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Classe que crea la barra d'opcions que permet triar la casella inicial i el número de fitxes que es col·locaran automàticament.
 * @author pablo
 */
public class ferOpcions extends JPanel implements ActionListener {

    private JPanel oest;
    private int alums;
    private int reis;
    private int cavs;
    private int torres;
    private int alfs;
    private int profs;
    private int reines;
    private int xIni;
    private int yIni;
    /**
     * Constructor de la classe ferOpcions. Crea els ComboBox que permeten a l'usuari triar la casella inicial i les fitxes que es col·locaran
     * automàticament. L'ús de ComboBox evita que l'usuari introdueixi un valor incorrecta.
     * @param dim Dimensió del tauler.
     */
    public ferOpcions(int dim) {
        oest = new JPanel();
        oest.setLayout(new GridLayout(22, 1));
        String[] opcions = new String[(dim * dim) + 1];
        for (int i = 0; i < opcions.length; i++) {
            opcions[i] = Integer.toString(i);
        }
        String[] coordOpcions = new String[dim];
        for (int i = 0; i < coordOpcions.length; i++) {
            coordOpcions[i] = Integer.toString(i);
        }
        JComboBox comboRei = new JComboBox(opcions);
        comboRei.setSelectedIndex(0);
        JComboBox comboReina = new JComboBox(opcions);
        comboReina.setSelectedIndex(0);
        JComboBox comboCav = new JComboBox(opcions);
        comboCav.setSelectedIndex(0);
        JComboBox comboTorre = new JComboBox(opcions);
        comboTorre.setSelectedIndex(0);
        JComboBox comboAlf = new JComboBox(opcions);
        comboAlf.setSelectedIndex(0);
        JComboBox comboProf = new JComboBox(opcions);
        comboProf.setSelectedIndex(0);
        JComboBox comboAlum = new JComboBox(opcions);
        comboAlum.setSelectedIndex(0);
        JComboBox comboX = new JComboBox(coordOpcions);
        comboX.setSelectedIndex(0);
        JComboBox comboY = new JComboBox(coordOpcions);
        comboY.setSelectedIndex(0);
        JLabel fitx = new JLabel("            TRIAU FITXES");
        JLabel numReis = new JLabel("Número de reis:");
        JLabel numReines = new JLabel("Número de reines:");
        JLabel numCavalls = new JLabel("Número de cavalls:");
        JLabel numTorres = new JLabel("Número de torres:");
        JLabel numAlfils = new JLabel("Número d'alfils:");
        JLabel numProfs = new JLabel("Número d'àguiles:");
        JLabel numAlums = new JLabel("Número d'escuts:");
        JLabel espai = new JLabel(" ");
        JLabel casIni = new JLabel("   TRIAU CASELLA INICIAL:");
        JLabel coordx = new JLabel("Coordenada horitzontal:");
        JLabel coordy = new JLabel("Coordenada vertical:");
        oest.add(casIni);
        oest.add(coordx);
        oest.add(comboX);
        oest.add(coordy);
        oest.add(comboY);
        oest.add(espai);
        oest.add(fitx);
        oest.add(numReis);
        oest.add(comboRei);
        oest.add(numReines);
        oest.add(comboReina);
        oest.add(numCavalls);
        oest.add(comboCav);
        oest.add(numTorres);
        oest.add(comboTorre);
        oest.add(numAlfils);
        oest.add(comboAlf);
        oest.add(numProfs);
        oest.add(comboProf);
        oest.add(numAlums);
        oest.add(comboAlum);
        comboAlum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                alums = Integer.parseInt(tria);
            }
        });
        comboRei.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                reis = Integer.parseInt(tria);
            }
        });
        comboCav.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                cavs = Integer.parseInt(tria);
            }
        });
        comboTorre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                torres = Integer.parseInt(tria);
            }
        });
        comboAlf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                alfs = Integer.parseInt(tria);
            }
        });
        comboProf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                profs = Integer.parseInt(tria);
            }
        });
        comboReina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                reines = Integer.parseInt(tria);
            }
        });
        comboX.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                xIni = Integer.parseInt(tria);
            }
        });
        comboY.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tria = (String) cb.getSelectedItem();
                yIni = Integer.parseInt(tria);
            }
        });
        this.add(oest);
    }
    /**
     * Funció que indica el número d'un tipus de fitxes que l'usuari ha triat.
     * @param i Índex que permet saber de quin tipus de fitxa es vol saber el número.
     * @return El número de fitxes que ha triat l'usuari.
     */
    public int getTria(int i) {
        int[] seleccio = {alums, reis, cavs, torres, alfs, profs, reines};
        return seleccio[i];
    }
    /**
     * Funció que indica el número total de fitxes que s'hauran de col·locar automàticament.
     * @return El número total de fitxes que s'hauran de col·locar automàticament.
     */
    public int getDimTria() {
        int seleccio = alums + reis + cavs + torres + alfs + profs + reines;
        return seleccio;
    }
    /**
     * Funció que indica la casella inicial triada per l'usuari.
     * @param i Índex que permet triar quina coordenada de la casella inicial es vol saber.
     * @return La coordenada triada de la casella inicial.
     */
    public int getCasIni(int i){
        int[] tria = {yIni, xIni};
        return tria[i];
    }
    /**
     * No s'utilitza.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
