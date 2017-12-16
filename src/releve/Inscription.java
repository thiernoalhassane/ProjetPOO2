package releve;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static releve.Etudiant.flag;

/**
 *
 * @author barry
 */
public class Inscription extends javax.swing.JPanel {

    public Inscription() {
        initComponents();
        remplirecombo();

    }

    public void remplirecombo() {
        String requete = "Select distinct  AnneeLicence   from grade";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while (resultat.next()) {
                comboannee.addItem(resultat.getString("AnneeLicence"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ECUE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboannee = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combosemestre = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboecue = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Inscription = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CodeEcue = new javax.swing.JTextField();
        codeEtudiant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PrenomEtudiant = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        NomEtudiant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NomEcue = new javax.swing.JTextField();
        Inscrit = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Inscription");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(333, 333, 333))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("ANNEE LICENCE");

        comboannee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboanneeItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("SEMESTRE");

        combosemestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combosemestreItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setText("CHOIX ECUE");

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboannee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combosemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboecue, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboannee, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(combosemestre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboecue)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Inscription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Inscription.setColumnSelectionAllowed(true);
        Inscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InscriptionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Inscription);
        Inscription.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jButton2.setText("Inscrire");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("CodeEcue");

        jLabel6.setText("CodeEtudiant");

        jLabel7.setText("Prénom Etudiant");

        jLabel11.setText("Nom Etudiant");

        jLabel12.setText("Nom Ecue");

        jLabel8.setText("Inscrit");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(CodeEcue, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PrenomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NomEcue, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Inscrit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(675, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(177, 177, 177)
                    .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(507, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CodeEcue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrenomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomEcue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inscrit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(256, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(61, 61, 61)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(264, Short.MAX_VALUE)
                    .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(54, 54, 54)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboanneeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboanneeItemStateChanged
        String s = comboannee.getSelectedItem().toString();
        String requete = "Select NomSemestre from semestre n , grade g  where g.AnneeLicence='" + s + "' and g.GradeidSemestre = n.idSemestre";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while (resultat.next()) {
                combosemestre.addItem(resultat.getString("NomSemestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeUe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboanneeItemStateChanged

    private void combosemestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combosemestreItemStateChanged
        String s = combosemestre.getSelectedItem().toString();
        String requete = "Select NomEcue from semestre se , avoir a , ecue e where se.NomSemestre='" + s + "' and  se.idSemestre = a.SemestreidSemestre and a.EcueCodeEcue = e.CodeEcue ";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while (resultat.next()) {
                comboecue.addItem(resultat.getString("NomEcue"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeUe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combosemestreItemStateChanged

    public void recherchecombobox(String champ, String valeur) {
        int i = 0;
        Object[][] dater = null;
        try {

            String requete = " select CodeEtudiant , NomEtudiant , PrenomEtudiant , CodeEcue  , NomEcue  from semestre , est , etudiant , avoir , ecue  where " + champ + " = '" + valeur + "'  and semestre.idSemestre = est.EstidSemestre and est.EtudiantCodeEtudiant = etudiant.CodeEtudiant and semestre.idSemestre = avoir.SemestreidSemestre and avoir.EcueCodeEcue = ecue.CodeEcue ";
            ResultSet resultat;
            resultat = connection.interroger(requete);
            while (resultat.next()) { //permet de parcourir tout le tableau
                i++;
            }

            dater = new Object[i][6];
            int k = 0;
            resultat.beforeFirst();// me positionne avant la premiere ligne de mon resultat            
            while (resultat.next()) {
                dater[k][0] = resultat.getInt("CodeEtudiant");
                dater[k][1] = resultat.getInt("CodeEcue");
                dater[k][2] = resultat.getString("NomEtudiant");
                dater[k][3] = resultat.getString("PrenomEtudiant");
                dater[k][4] = resultat.getString("NomEcue");
                dater[k][5] = new Boolean(false);
                //data[k][3] = resultat.getString("PrenomEtudiant");                
                k++;
            }
        } catch (SQLException e) {
            System.out.println("La copie de la table dans data a échoué");
        }

        Object[][] data = dater;
        String title[] = {"Code Etudiant", "Code Ecue", " Nom Etudiant", " Prenom  Etudiant", "Nom Ecue", "inscrire"};
        ZModel model = new ZModel(data, title);
        System.out.println("Nombre de colonne : "
                + model.getColumnCount());
        System.out.println("Nombre de ligne : " + model.getRowCount());

        Inscription.setModel(model);
        Inscription.createDefaultColumnsFromModel();

    }

    public int selectionligne() {
        int ligne = Inscription.getSelectedRow();
        if (ligne == -1) {
            JOptionPane.showMessageDialog(null, "vous n'avez pas selectionner de ligne");
            flag = false;
            return ligne;
        } else {
            int CodeEtudiant = Integer.parseInt(Inscription.getValueAt(ligne, 0).toString());
            codeEtudiant.setText("" + CodeEtudiant);
            int Codeecue = Integer.parseInt(Inscription.getValueAt(ligne, 1).toString());
            CodeEcue.setText("" + Codeecue);
            String Nom = Inscription.getValueAt(ligne, 2).toString();
            NomEtudiant.setText(Nom);
            String Prenom = Inscription.getValueAt(ligne, 3).toString();
            PrenomEtudiant.setText(Prenom);
            String ecue = Inscription.getValueAt(ligne, 4).toString();
            NomEcue.setText(ecue);
            Boolean inscription = Boolean.parseBoolean(Inscription.getValueAt(ligne, 5).toString());
            Inscrit.setText("" + inscription);
            flag = true;
            return ligne;
        }
    }

//    public void insertion() {
//        int i = 0;
//        Object[][] dater = null;
//        try {
//
//            
//            ResultSet resultat;
//            resultat = connection.interroger(requete);
//            while (resultat.next()) { //permet de parcourir tout le tableau
//                i++;
//            }
//
//            dater = new Object[i][6];
//            int k = 0;
//            resultat.beforeFirst();// me positionne avant la premiere ligne de mon resultat            
//            while (resultat.next()) {
//                dater[k][0] = resultat.getInt("CodeEtudiant");
//                dater[k][1] = resultat.getInt("CodeEcue");
//                dater[k][2] = resultat.getString("NomEtudiant");
//                dater[k][3] = resultat.getString("PrenomEtudiant");
//                dater[k][4] = resultat.getString("NomEcue");
//                dater[k][5] = new Boolean(false);
//                //data[k][3] = resultat.getString("PrenomEtudiant");                
//                k++;
//            }
//        } catch (SQLException e) {
//            System.out.println("La copie de la table dans data a échoué");
//        }
//        
//        
//        int j;
//        for (j = 0; j <= i; j++) {
//            int ligne = Inscription.getSelectedRow();
//            Boolean inscription = Boolean.parseBoolean(Inscription.getValueAt(ligne, 5).toString());
//            inscription = false;
//            if (inscription = true) {
//                int CodeEtudiant = Integer.parseInt(Inscription.getValueAt(ligne, 0).toString());                
//                int Codeecue = Integer.parseInt(Inscription.getValueAt(ligne, 1).toString());                
//                String Nom = Inscription.getValueAt(ligne, 2).toString();                
//                String Prenom = Inscription.getValueAt(ligne, 3).toString();                
//                String ecue = Inscription.getValueAt(ligne, 4).toString();                
//                
//                String requete = "insert into etudiant values(null,'" + nomeleve + "','" + prenomeleve + "','" + datenaissance + "','"
//                        + lieueleve + "','" + nationaliteeleve + "','" + teleleve + "','" + sexeeleve + "','" + adresseeleve + "')";
//                int a = connection.maj(requete);
//            }
//
//        }
//    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String classeeleve = String.valueOf(combosemestre.getSelectedItem());
        this.recherchecombobox("NomSemestre", classeeleve);
//        Fenetre fe = new Fenetre(this);
//        fe.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int nombreligne = Inscription.getRowCount() -1;
        int i;
        System.out.println("Ligne"+ Inscription.getRowCount());
        for (i = 0; i <= nombreligne; i++) {
             
            Boolean inscription = Boolean.parseBoolean(Inscription.getValueAt(i, 5).toString());
            if (inscription == true) {
                int CodeEtudiant = Integer.parseInt(Inscription.getValueAt(i, 0).toString());
                int Codeecue = Integer.parseInt(Inscription.getValueAt(i, 1).toString());
                int inscrit = 1;
                String requete = "insert into inscription values('" + Codeecue + "','" + CodeEtudiant + "','" + inscrit + "')";
                int a = connection.maj(requete);
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void InscriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InscriptionMouseClicked
        if (evt.getClickCount() == 1) {
            selectionligne();
        }
    }//GEN-LAST:event_InscriptionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodeEcue;
    private javax.swing.JTable Inscription;
    private javax.swing.JTextField Inscrit;
    private javax.swing.JTextField NomEcue;
    private javax.swing.JTextField NomEtudiant;
    private javax.swing.JTextField PrenomEtudiant;
    private javax.swing.JTextField codeEtudiant;
    private javax.swing.JComboBox<String> comboannee;
    private javax.swing.JComboBox<String> comboecue;
    private javax.swing.JComboBox<String> combosemestre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
