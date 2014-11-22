/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package llistesescolarsref;

/**
 *
 * @author ech390
 */
//import static alumnescursoscodi.Gestor.llistaCursos;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {

    int codigoUltimoCurso=-1;
    int numCursos=-1;
    
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
        TextFieldNAlta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextFieldCAlta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        AltaCurso = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        AltaAsignatura = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        ButtonBajaCurso = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        codcursoLista = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TACurso = new javax.swing.JTextArea();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        CCAA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        NAA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CAA = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        TextFieldCListar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TALista = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

        jLabel4.setText("Dar de alta una asignatura para el último curso introducido");

        jLabel6.setText("Nombre de la asignatura:");

        jLabel7.setText("Código de la asignatura:");

        AltaAsignatura.setText("Dar de ALTA esta asignatura");
        AltaAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AltaAsignaturaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(164, 164, 164)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextFieldNAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(TextFieldCAlta)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(106, 106, 106)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addComponent(AltaCurso))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(AltaAsignatura)))
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextFieldNAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AltaCurso)
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(AltaAsignatura)
                .addContainerGap(78, Short.MAX_VALUE))
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
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(ButtonBajaCurso)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(ButtonBajaCurso)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dar de BAJA un curso", jPanel2);

        jLabel12.setText("Introduzca el código del curso:");

        jButton3.setText("Listar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Listar Asignaturas y Alumnos de un Curso", jPanel6);

        jTabbedPane1.addTab("Cursos", jTabbedPane2);

        jLabel9.setText("Codigo del curso del cual se quiere dar de alta la asignatura:");

        jLabel10.setText("Nombre de la asignatura:");

        NAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NAAActionPerformed(evt);
            }
        });

        jLabel11.setText("Código de la asignatura:");

        jButton2.setText("Dar de ALTA");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel9))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)))))
                .addGap(88, 88, 88)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CCAA)
                    .addComponent(NAA)
                    .addComponent(CAA, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CCAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(NAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jButton2)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Dar de ALTA una asignatura", jPanel4);

        jLabel8.setText("Introduzca el código de la asignatura:");

        jButton1.setText("Listar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(jButton1)
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
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Listar curso y alumnos de una asignatura", jPanel5);

        jLabel13.setText("Introduzca el código de la asignatura que desea dar de baja:");

        jButton4.setText("Dar de BAJA");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel13)
                        .addGap(127, 127, 127)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jButton4)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jButton4)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Dar de BAJA una asignatura", jPanel3);

        jTabbedPane1.addTab("Assignatures", jTabbedPane3);

        jLabel14.setText("Código de la asignatura en la cual se desea matricular el alumno: ");

        jLabel15.setText("Nombre del alumno:");

        jLabel16.setText("DNI (sin la letra final):");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton5.setText("Dar de ALTA");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel14)
                        .addGap(139, 139, 139)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(115, 115, 115)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jButton5)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(jButton5)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Matricular alumno en una asignatura", jPanel7);

        jLabel17.setText("Introduzca DNI (sin la letra final) del alumno a listar:");

        jButton6.setText("Listar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel17)
                .addGap(103, 103, 103)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton6)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Listar cursos y asignaturas matriculadas de un alumno", jPanel8);

        jTabbedPane1.addTab("Alumnes", jTabbedPane4);

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

    private void ButtonBajaCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBajaCursoMouseClicked
        String codigo=jTextField1.getText();
        //Añadir codigo para comprobar si el código introducido corresponde, o no, con un curso existente.
        if(isNumeric(codigo)){
            JOptionPane.showMessageDialog(null, "Se dará de baja el curso de código " +codigo+".");
            Gestor.BaixaCurs(Gestor.cercaCurs(Integer.parseInt(codigo)));
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_ButtonBajaCursoMouseClicked

    private void AltaAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AltaAsignaturaMouseClicked
        String nombre=jTextField2.getText();
        String codigo=(jTextField3.getText());
        boolean codigoFalse=isNumeric(codigo);
        if(codigoFalse||codigoUltimoCurso!=-1){
            JOptionPane.showMessageDialog(null, "Se va a dar de alta la signatura " + nombre + " y código " + codigo + ", en el curso de código " + codigoUltimoCurso + ".");
            int cod=Integer.parseInt(codigo);
            Gestor.AltaAss(codigoUltimoCurso, nombre, cod);
        }else{
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_AltaAsignaturaMouseClicked

    private void AltaCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AltaCursoMouseClicked
        String nombre=TextFieldNAlta.getText();
        String codigo=TextFieldCAlta.getText();
        int cod;
        boolean existe=false;
        if(isNumeric(codigo)){
            cod = Integer.parseInt(codigo);
            if (cod > 0) {
                numCursos++;
                if (LlistaCursos.inIn(cod)) {
                    codigoUltimoCurso = Integer.parseInt(codigo);
                    Gestor.AltaCurs(nombre, codigoUltimoCurso);
                    System.out.println(curs);
                } else {
                    numCursos--;
                    JOptionPane.showMessageDialog(null, "El código o el nombre de curso que ha introducido ya están en uso, por favor, inténtelo de nuevo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, ha de ser mayor que 0. Por favor inténtelo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_AltaCursoMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked

    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String codigo = TextFieldCListar.getText();
        String lista="";
        if(isNumeric(codigo)){
            if(numCursos!=-1){
                int cod = Integer.parseInt(codigo);
                int indCurso=Gestor.CercaCursAssignatura(cod);
                int indAss=Gestor.CercaAssignatura(cod);
//                for(int p=0; p<Gestor.llistaCursos.size(); p++){
//                    for(int i=0; i<Gestor.llistaCursos.get(p).getListaAss().size(); i++){
//                        
//                        if(cod==Gestor.llistaCursos.get(p).getListaAss().get(i).getCodiAssignatura()){
//                            j=i;
//                            k=p;
//                            i=Gestor.llistaCursos.get(p).getListaAss().size();
//                            p=Gestor.llistaCursos.size();
//                        }
//                    }
//                }
                if(indCurso!=-1&&indAss!=-1){
                    lista="Curso: \n";
//                    lista=lista+Gestor.llistaCursos.printCursCod(indCurso);
//                    lista=lista+Gestor.llistaCursos.get(indCurso).getListaAss().get(indAss).getLlistaAl().printLlista();
                    TALista.setText(lista);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna asignatura con el codigo introducido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha dado de alta ningún curso, por favor, de de alta uno antes de ejecutar este metodo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void NAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NAAActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String codCurso=CCAA.getText();
        String nomAsign=NAA.getText();
        String codAsign=CAA.getText();
        if(isNumeric(codCurso)&&isNumeric(codAsign)){
            if(numCursos!=-1){
                int cod = Integer.parseInt(codCurso);
                int p=Gestor.CercaCurs(cod);
                if(p!=-1){
                    Gestor.AltaAss(p,nomAsign,Integer.parseInt(codAsign));
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el curso introducido, por favor, intentelo de nuevo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para dar de alta una asignatura, necesitamos, al menos, que haya creado un curso antes");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        String codigo = codcursoLista.getText();
        String lista="";
        TACurso.setText(null);
        if(isNumeric(codigo)){
            if(numCursos!=-1){
                int cod = Integer.parseInt(codigo);
                int p=Gestor.CercaCurs(cod);
                if(p!=-1){
                    lista=lista+Gestor.LlistarAssignaturesIAlumnes(p);
                    TACurso.setText(lista);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ningun curso con el codigo introducido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha dado de alta ningún curso, por favor, de de alta uno antes de listar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        String codigo=jTextField1.getText();
        boolean codigoFalse=isNumeric(codigo);
        if(codigoFalse){
            int cod=Integer.parseInt(codigo);
            JOptionPane.showConfirmDialog(null, "Se dará de baja la asignatura de código: " +cod+".");
            int a = Gestor.CercaCursAssignatura(cod);
            int b = Gestor.CercaAssignatura(cod);
            if((a==-1)||(b==-1)){
                llistaCursos.get(a).getListaAss().remove(b);
            } else {
            JOptionPane.showMessageDialog(null, "El curso o la asignatura que ha introducido no existen, por favor, inténtelo de nuevo");
        }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        String codAss=jTextField6.getText();
        String nomAlu=jTextField7.getText();
        String codAlu=jTextField8.getText();
        if(isNumeric(codAss)&&isNumeric(codAlu)){
            int cod = Integer.parseInt(codAss);
            int b = Gestor.CercaAssignatura(cod);
            int a = Gestor.CercaCursAssignatura(cod);
            if(b!=-1){
                Gestor.AltaAlumne(nomAlu, codAlu, cod);
            } else {
                JOptionPane.showMessageDialog(null, "La asignatura que ha introducido no existe, por favor, inténtelo de nuevo");
            }
        } else {
            
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        String codigo = jTextField9.getText();
        String lista="";
        if(isNumeric(codigo)){
            if(numCursos!=-1){
                int cod = Integer.parseInt(codigo);
                int l=-1; //Alumno
                int k=-1; //Curso
                int j=-1; //Asignatura
                for(int p=0; p<Gestor.llistaCursos.size(); p++){
                    for(int i=0; i<Gestor.llistaCursos.get(p).getListaAss().size(); i++){
                        for(int h=0; h<Gestor.llistaCursos.get(p).getListaAss().get(i).getLlistaAl().size();h++){
                            if(cod==Gestor.llistaCursos.get(p).getListaAss().get(i).getLlistaAl().get(h).getDni()){
                                lista=lista+Gestor.llistaCursos.printCursCod(p);
                                lista=lista+Gestor.llistaCursos.get(p).getListaAss().printAssignatura(i);
                                lista=lista+"----\n";
                                j=i;
                                k=p;
                                l=h;
                            }
                        }
                        if(cod==Gestor.llistaCursos.get(p).getListaAss().get(i).getCodiAssignatura()){
                            j=i;
                            k=p;
                            p=Gestor.llistaCursos.size();
                            i=Gestor.llistaCursos.get(p).getListaAss().get(i).getCodiAssignatura();
                        }
                    }
                }
                if(j!=-1&&k!=-1&&l!=-1){
                    lista=lista+Gestor.llistaCursos.printCursCod(k);
                    lista=lista+Gestor.llistaCursos.get(k).getListaAss().get(j).getLlistaAl().printLlista();
                    jTextArea1.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ningun alumno con el codigo introducido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha dado de alta ningún curso, por favor, de de alta uno antes de ejecutar este metodo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha introducido un código incorrecto, por favor inténtelo de nuevo");
        }
    }//GEN-LAST:event_jButton6MouseClicked

    public static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
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
    private javax.swing.JButton AltaAsignatura;
    private javax.swing.JButton AltaCurso;
    private javax.swing.JButton ButtonBajaCurso;
    private javax.swing.JTextField CAA;
    private javax.swing.JTextField CCAA;
    private javax.swing.JTextField NAA;
    private javax.swing.JTextArea TACurso;
    private javax.swing.JTextArea TALista;
    private javax.swing.JTextField TextFieldCAlta;
    private javax.swing.JTextField TextFieldCListar;
    private javax.swing.JTextField TextFieldNAlta;
    private javax.swing.JTextField codcursoLista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
