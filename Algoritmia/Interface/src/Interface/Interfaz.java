/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author pablo
 */
//import static alumnescursoscodi.Gestor.llistaCursos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {

    Gestor g = new Gestor();
    
    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane7 = new javax.swing.JTabbedPane();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextFieldNombreAltaCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextFieldCAlta = new javax.swing.JTextField();
        AltaCurso = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxCAlta = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBajaCurso = new javax.swing.JTextField();
        ButtonBajaCurso = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        codcursoLista = new javax.swing.JTextField();
        CursoListarAsignaturas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TACurso = new javax.swing.JTextArea();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        AltaCodigoCursoAsignatura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        AltaNombreAsignatura = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        AltaCodigoAsignatura = new javax.swing.JTextField();
        BotonAltaAsignatura = new javax.swing.JButton();
        AltaCredits = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        AltaAssTipo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldBajaAsignatura = new javax.swing.JTextField();
        BajaAsignatura = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        TextFieldCListar = new javax.swing.JTextField();
        AssListarCurs = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TALista = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TAListaTipus = new javax.swing.JTextArea();
        jComboBoxListarTipos = new javax.swing.JComboBox();
        jButtonListarTipos = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre del curso a dar de alta:");

        jLabel2.setText("Código del curso a dar de alta:");

        AltaCurso.setText("Dar de ALTA");
        AltaCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AltaCursoMouseClicked(evt);
            }
        });

        jLabel14.setText("Tipo de curso:");

        jComboBoxCAlta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "primer", "segon", "mecànica", "electrònica", "informàtica" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(AltaCurso))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel2)))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldNombreAltaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextFieldNombreAltaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(AltaCurso)
                .addGap(100, 100, 100))
        );

        jTabbedPane2.addTab("Dar de ALTA un curso", jPanel1);

        jLabel3.setText("Introduzca código del curso que desea dar de baja:");

        ButtonBajaCurso.setText("Dar de BAJA");
        ButtonBajaCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonBajaCursoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addGap(54, 54, 54)
                        .addComponent(jTextFieldBajaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(ButtonBajaCurso)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBajaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(ButtonBajaCurso)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dar de BAJA un curso", jPanel2);

        jLabel12.setText("Introduzca el código del curso:");

        CursoListarAsignaturas.setText("Listar");
        CursoListarAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CursoListarAsignaturasMouseClicked(evt);
            }
        });

        TACurso.setColumns(20);
        TACurso.setRows(5);
        jScrollPane3.setViewportView(TACurso);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel12)
                .addGap(121, 121, 121)
                .addComponent(codcursoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(CursoListarAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(codcursoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CursoListarAsignaturas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Listar Asignaturas", jPanel6);

        jTabbedPane1.addTab("Cursos", jTabbedPane2);

        jLabel9.setText("Código del curso de la asignatura:");

        jLabel10.setText("Nombre de la asignatura:");

        AltaNombreAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaNombreAsignaturaActionPerformed(evt);
            }
        });

        jLabel11.setText("Código de la asignatura:");

        BotonAltaAsignatura.setText("Dar de ALTA");
        BotonAltaAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAltaAsignaturaMouseClicked(evt);
            }
        });

        jLabel15.setText("Num crèdits (si en té):");

        jLabel16.setText("Tipus:");

        AltaAssTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------", "teòrica", "pràctica" }));
        AltaAssTipo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                AltaAssTipoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AltaAssTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AltaCodigoCursoAsignatura)
                                .addComponent(AltaNombreAsignatura)
                                .addComponent(AltaCodigoAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(AltaCredits, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(BotonAltaAsignatura)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(AltaCodigoCursoAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(AltaNombreAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(AltaCodigoAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(AltaCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AltaAssTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(51, 51, 51)
                .addComponent(BotonAltaAsignatura)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Dar de ALTA una asignatura", jPanel4);

        jLabel13.setText("Introduzca el código de la asignatura que desea dar de baja:");

        BajaAsignatura.setText("Dar de BAJA");
        BajaAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BajaAsignaturaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(BajaAsignatura))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel13)
                        .addGap(32, 32, 32)
                        .addComponent(jTextFieldBajaAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldBajaAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(BajaAsignatura)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Dar de BAJA una asignatura", jPanel3);

        jLabel8.setText("Introduzca el código de la asignatura:");

        AssListarCurs.setText("Listar");
        AssListarCurs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssListarCursMouseClicked(evt);
            }
        });

        TALista.setColumns(20);
        TALista.setRows(5);
        jScrollPane2.setViewportView(TALista);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel8)
                .addGap(95, 95, 95)
                .addComponent(TextFieldCListar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(AssListarCurs)
                .addGap(69, 69, 69))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextFieldCListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AssListarCurs))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Listar curso", jPanel5);

        TAListaTipus.setColumns(20);
        TAListaTipus.setRows(5);
        jScrollPane4.setViewportView(TAListaTipus);

        jComboBoxListarTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "optativa", "obligatòria" }));
        jComboBoxListarTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListarTiposActionPerformed(evt);
            }
        });

        jButtonListarTipos.setText("Listar");
        jButtonListarTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarTiposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jComboBoxListarTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jButtonListarTipos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxListarTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListarTipos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Listar Tipos", jPanel7);

        jTabbedPane1.addTab("Assignatures", jTabbedPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BajaAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BajaAsignaturaMouseClicked
        String codigo = jTextFieldBajaAsignatura.getText();
        if (isNumeric(codigo)) {
            JOptionPane.showConfirmDialog(null, "Se dará de baja la asignatura de"
                    + " código: " + codigo + ".");
            int codAss = Integer.parseInt(codigo);
            if(g.cursOk(g.CercaCursAssignatura(codAss))){
                g.BaixaAssignatura(codAss);
            }else{
                JOptionPane.showMessageDialog(null, "El curso o la asignatura que"
                        + " ha introducido no existen, por favor, inténtelo de nuevo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código "
                    + "incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_BajaAsignaturaMouseClicked

    private void AssListarCursMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssListarCursMouseClicked
        String codigo = TextFieldCListar.getText();
        if (isNumeric(codigo)) {
            if (g.LlistaCursosOK()) {
                String lista = g.llistarCursAssignatura(Integer.parseInt(codigo));
                if (!lista.isEmpty()) {
                    TALista.setText(lista);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado "
                            + "ninguna asignatura con el codigo introducido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aún no ha dado de alta "
                        + "ningún curso ni asignatura.");
            }
        } else {
            codigoIncorrecto();
        }
    }//GEN-LAST:event_AssListarCursMouseClicked

    private void BotonAltaAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAltaAsignaturaMouseClicked
        String codCurso=AltaCodigoCursoAsignatura.getText();
        String nomAsign=AltaNombreAsignatura.getText();
        String codAsign=AltaCodigoAsignatura.getText();
        String credits=AltaCredits.getText();
        String tipo = AltaAssTipo.getSelectedItem().toString();
        if(isNumeric(codCurso)&&isNumeric(codAsign)){
            if(g.LlistaCursosOK()){
                if(g.cursOk(Integer.parseInt(codCurso))){
                    if(!credits.isEmpty() && ((tipo.equalsIgnoreCase("teòrica")) || (tipo.equalsIgnoreCase("pràctica")))){
                        //no es possible
                        JOptionPane.showMessageDialog(null, "Una asignatura no "
                                + "puede tener créditos y tipo de contenido a la vez");
                    }else if (!credits.isEmpty()){
                        g.AltaAss(Integer.parseInt(codCurso), nomAsign, Integer.parseInt(codAsign), Integer.parseInt(credits));
                        AltaCodigoCursoAsignatura.setText("");
                        AltaNombreAsignatura.setText("");
                        AltaCodigoAsignatura.setText("");
                        AltaCredits.setText("");
                        
                    }else{
                        g.AltaAss(Integer.parseInt(codCurso), nomAsign, Integer.parseInt(codAsign), tipo);
                        AltaCodigoCursoAsignatura.setText("");
                        AltaNombreAsignatura.setText("");
                        AltaCodigoAsignatura.setText("");
                        AltaAssTipo.setSelectedIndex(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el "
                            + "curso introducido, por favor, intentelo de nuevo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para dar de alta una "
                        + "asignatura necesitamos, al menos, un curso");
            }
        } else {
            codigoIncorrecto();
        }
    }//GEN-LAST:event_BotonAltaAsignaturaMouseClicked

    private void AltaNombreAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaNombreAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AltaNombreAsignaturaActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked

    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void CursoListarAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursoListarAsignaturasMouseClicked
        String codigo = codcursoLista.getText();
        String lista="";
        TACurso.setText(null);
        if(isNumeric(codigo)){
            if(g.LlistaCursosOK()){
                int cod = Integer.parseInt(codigo);
                if(g.cursOk(cod)){
                    lista=lista+g.llistarAssignatures(cod);
                    TACurso.setText(lista);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado "
                            + "ningun curso con el codigo introducido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha dado de alta ningún "
                        + "curso, por favor, de de alta uno antes de listar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código "
                    + "incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_CursoListarAsignaturasMouseClicked

    public static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
    public void codigoIncorrecto(){
        JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
    }
    
    private void ButtonBajaCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBajaCursoMouseClicked
        String codigo=jTextFieldBajaCurso.getText();
        //Añadir codigo para comprobar si el código introducido corresponde, o no, con un curso existente.
        if(isNumeric(codigo)){
            JOptionPane.showMessageDialog(null, "Se dará de baja el curso de código " +codigo+".");
            g.BaixaCurs(Integer.parseInt(codigo));
        } else {
            codigoIncorrecto();
        }
    }//GEN-LAST:event_ButtonBajaCursoMouseClicked

    private void AltaCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AltaCursoMouseClicked
        String nombre=TextFieldNombreAltaCurso.getText();
        String tipo = jComboBoxCAlta.getSelectedItem().toString();
        String codigo=TextFieldCAlta.getText();
        if(isNumeric(codigo)){
            try {
               g.AltaCurs(nombre, Integer.parseInt(codigo), tipo);
               TextFieldNombreAltaCurso.setText("");
               TextFieldCAlta.setText("");
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            codigoIncorrecto();
        }
    }//GEN-LAST:event_AltaCursoMouseClicked

    private void AltaAssTipoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_AltaAssTipoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_AltaAssTipoPropertyChange

    private void jButtonListarTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarTiposActionPerformed
        String tipo = jComboBoxListarTipos.getSelectedItem().toString();
        TAListaTipus.setText(g.llistarAssignaturesTipus(tipo));
    }//GEN-LAST:event_jButtonListarTiposActionPerformed

    private void jComboBoxListarTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListarTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxListarTiposActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AltaAssTipo;
    private javax.swing.JTextField AltaCodigoAsignatura;
    private javax.swing.JTextField AltaCodigoCursoAsignatura;
    private javax.swing.JTextField AltaCredits;
    private javax.swing.JButton AltaCurso;
    private javax.swing.JTextField AltaNombreAsignatura;
    private javax.swing.JButton AssListarCurs;
    private javax.swing.JButton BajaAsignatura;
    private javax.swing.JButton BotonAltaAsignatura;
    private javax.swing.JButton ButtonBajaCurso;
    private javax.swing.JButton CursoListarAsignaturas;
    private javax.swing.JTextArea TACurso;
    private javax.swing.JTextArea TALista;
    private javax.swing.JTextArea TAListaTipus;
    private javax.swing.JTextField TextFieldCAlta;
    private javax.swing.JTextField TextFieldCListar;
    private javax.swing.JTextField TextFieldNombreAltaCurso;
    private javax.swing.JTextField codcursoLista;
    private javax.swing.JButton jButtonListarTipos;
    private javax.swing.JComboBox jComboBoxCAlta;
    private javax.swing.JComboBox jComboBoxListarTipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextField jTextFieldBajaAsignatura;
    private javax.swing.JTextField jTextFieldBajaCurso;
    // End of variables declaration//GEN-END:variables
}
