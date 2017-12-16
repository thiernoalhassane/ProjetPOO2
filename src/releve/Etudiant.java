package releve;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author barry
 */
public class Etudiant extends javax.swing.JPanel {

    static boolean flag;

    public Etudiant() {
        initComponents();
        actualiser();
        initialiser();
        fillcombograde();
        fillcombosemestre();

    }

    public void fillcombograde() {
        String requete = "Select distinct  AnneeLicence   from grade";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while (resultat.next()) {
                nomgrade.addItem(resultat.getString("AnneeLicence"));
                combolicence.addItem(resultat.getString("AnneeLicence"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillcombosemestre() {
        String requete = "Select NomSemestre   from semestre";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while (resultat.next()) {

                combo3.addItem(resultat.getString("NomSemestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Object[][] affichagedonnee() {
        int i = 0;
        Object[][] data = null;
        try {

            String requete = "select  CodeEtudiant,  NomEtudiant , PrenomEtudiant , DateNaiss , LieuNaiss , Nationalite , Telephone , Sexe , Adresse , NomSemestre , AnneeLicence from etudiant e , est est , semestre s , grade g where e.CodeEtudiant = est.EtudiantCodeEtudiant And est.EstidGrade = g.idGrade And g.GradeidSemestre = s.idSemestre ";
            ResultSet resultat;
            resultat = connection.interroger(requete);
            while (resultat.next()) {
                i++;//nombre de ligne de la table
            }
            data = new Object[i][11];
            resultat.beforeFirst();// me positionne avant la premiere ligne de mon resultat
            int k = 0;
            while (resultat.next()) {
                data[k][0] = resultat.getInt("CodeEtudiant");
                data[k][1] = resultat.getString("NomEtudiant");
                data[k][2] = resultat.getString("PrenomEtudiant");
                data[k][3] = resultat.getString("DateNaiss");
                data[k][4] = resultat.getString("LieuNaiss");
                data[k][5] = resultat.getString("Sexe");
                data[k][6] = resultat.getString("Nationalite");
                data[k][7] = resultat.getString("Adresse");
                data[k][8] = resultat.getInt("Telephone");
                data[k][9] = resultat.getString("NomSemestre");
                data[k][10] = resultat.getString("AnneeLicence");
                k++;
            }
        } catch (SQLException e) {
            System.out.println("La copie de la table dans data a échoué");
        }
        return data;
    }

    public void actualiser() {
        Object[][] data = Etudiant.affichagedonnee();
        tble.setModel(new javax.swing.table.DefaultTableModel(data,
                new String[]{"CodeEtudiant", "Nom", "Prénoms", "Date de Naissance", "Lieu de Naissance",
                    "Sexe", "Nationalité", "Adresse", "Télephone", "Semestre", "Annee Licence"}
        ));
        //Code Etudiant",
    }

    public void initialiser() {
        txtnom.setText("");
        txtprenom.setText("");
        txtadress.setText("");
        txttel.setText("");
        txtlieu.setText("");
        txtnatio.setText("");
    }

    public int selectionligne() {
        int ligne = tble.getSelectedRow();
        if (ligne == -1) {
            JOptionPane.showMessageDialog(null, "vous n'avez pas selectionner de ligne");
            flag = false;
            return ligne;
        } else {
            String nom = tble.getValueAt(ligne, 1).toString();
            txtnom.setText(nom);
            String prenom = tble.getValueAt(ligne, 2).toString();
            txtprenom.setText(prenom);
            String naissance = tble.getValueAt(ligne, 4).toString();
            txtlieu.setText(naissance);
            combolicence.setSelectedItem(tble.getValueAt(ligne, 10));
            combo1.setSelectedItem(tble.getValueAt(ligne, 5));
            combo3.setSelectedItem(tble.getValueAt(ligne, 9));
            String nationalite = tble.getValueAt(ligne, 6).toString();
            txtnatio.setText(nationalite);
            String adresse = tble.getValueAt(ligne, 7).toString();
            txtadress.setText(adresse);
            int telephone = Integer.parseInt(tble.getValueAt(ligne, 8).toString());
            txttel.setText("" + telephone);
            String Dates = tble.getValueAt(ligne, 3).toString();
            datenaiss.setDateFormatString(Dates);
            flag = true;
            return ligne;
        }
    }

    public void recherchenom(String champ, String valeur) {
        int i = 0;
        Object[][] data = null;
        try {

            String requete = "select  CodeEtudiant,  NomEtudiant , PrenomEtudiant , DateNaiss , LieuNaiss , Nationalite , Telephone , Sexe , Adresse , NomSemestre , AnneeLicence from etudiant e , est est , semestre s , grade g where e.CodeEtudiant = est.EtudiantCodeEtudiant And est.EstidGrade = g.idGrade And g.GradeidSemestre = s.idSemestre And " + champ + " like '" + valeur + "%'  ";
            //select * from etudiant where " + champ +"  like '" + valeur + "%'
            ResultSet resultat;
            resultat = connection.interroger(requete);
            while (resultat.next()) { //permet de parcourir tout le tableau
                i++;
            }

            data = new Object[i][11];
            int k = 0;
            resultat.beforeFirst();// me positionne avant la premiere ligne de mon resultat            
            while (resultat.next()) {
                data[k][0] = resultat.getInt("CodeEtudiant");
                data[k][1] = resultat.getString("NomEtudiant");
                data[k][2] = resultat.getString("PrenomEtudiant");
                data[k][3] = resultat.getString("DateNaiss");
                data[k][4] = resultat.getString("LieuNaiss");
                data[k][5] = resultat.getString("Sexe");
                data[k][6] = resultat.getString("Nationalite");
                data[k][7] = resultat.getString("Adresse");
                data[k][8] = resultat.getString("Telephone");
                data[k][9] = resultat.getString("NomSemestre");
                data[k][10] = resultat.getString("AnneeLicence");
                k++;
            }
        } catch (SQLException e) {
            System.out.println("La copie de la table dans data a échoué");
        }

        tble.setModel(new javax.swing.table.DefaultTableModel(data,
                new String[]{"Code Etudiant", "Nom", "Prénoms", "Date de Naissance", "Lieu de Naissance",
                    "Sexe", "Nationalité", "Adresse", "Télephone", "Semestre", "Annee Licence"}
        ));
    }

    public void recherchecombobox(String champ, String valeur) {
        int i = 0;
        Object[][] data = null;
        try {

            String requete = "select  CodeEtudiant,  NomEtudiant , PrenomEtudiant , DateNaiss , LieuNaiss , Nationalite , Telephone , Sexe , Adresse , NomSemestre , AnneeLicence from etudiant e , est est , semestre s , grade g where e.CodeEtudiant = est.EtudiantCodeEtudiant And est.EstidGrade = g.idGrade And g.GradeidSemestre = s.idSemestre And " + champ + " = '" + valeur + "' ";
            ResultSet resultat;
            resultat = connection.interroger(requete);
            while (resultat.next()) { //permet de parcourir tout le tableau
                i++;
            }

            data = new Object[i][11];
            int k = 0;
            resultat.beforeFirst();// me positionne avant la premiere ligne de mon resultat            
            while (resultat.next()) {
                data[k][0] = resultat.getInt("CodeEtudiant");
                data[k][1] = resultat.getString("NomEtudiant");
                data[k][2] = resultat.getString("PrenomEtudiant");
                data[k][3] = resultat.getString("DateNaiss");
                data[k][4] = resultat.getString("LieuNaiss");
                data[k][5] = resultat.getString("Sexe");
                data[k][6] = resultat.getString("Nationalite");
                data[k][7] = resultat.getString("Adresse");
                data[k][8] = resultat.getString("Telephone");
                data[k][9] = resultat.getString("NomSemestre");
                data[k][10] = resultat.getString("AnneeLicence");
                k++;
            }
        } catch (SQLException e) {
            System.out.println("La copie de la table dans data a échoué");
        }

        tble.setModel(new javax.swing.table.DefaultTableModel(data,
                new String[]{"Code Etudiant", "Nom", "Prénoms", "Date de Naissance", "Lieu de Naissance",
                    "Sexe", "Nationalité", "Adresse", "Télephone", "Semestre", "Annee Licence"}
        ));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtlieu = new javax.swing.JTextField();
        txtnatio = new javax.swing.JTextField();
        txtadress = new javax.swing.JTextField();
        combolicence = new javax.swing.JComboBox<>();
        datenaiss = new com.toedter.calendar.JDateChooser();
        combo1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        combo3 = new javax.swing.JComboBox<>();
        BoutonSupprimer = new javax.swing.JButton();
        BoutonModifier = new javax.swing.JButton();
        BoutonValider = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nomgrade = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        jPanel4.setBackground(java.awt.Color.green);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 6, true), "Information Etudiant", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 24))); // NOI18N

        jPanel6.setBackground(java.awt.Color.green);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Nom");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Date Naissance");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Prénoms");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Lieu Naissance");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setText("Sexe");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setText("Nationalité");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setText("Adresse");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setText("Licence");

        txtnom.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N

        txtprenom.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N

        txtlieu.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N

        txtnatio.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N

        txtadress.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N

        combolicence.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combolicence.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combolicenceItemStateChanged(evt);
            }
        });
        combolicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combolicenceActionPerformed(evt);
            }
        });

        combo1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculin", "Feminin" }));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setText("Télephone");

        txttel.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setText("Semestre");

        combo3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        BoutonSupprimer.setText("SUPPRIMER");
        BoutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSupprimerActionPerformed(evt);
            }
        });

        BoutonModifier.setText("MODIFIER");
        BoutonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonModifierActionPerformed(evt);
            }
        });

        BoutonValider.setText("INSCRIRE");
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combolicence, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtadress, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnatio, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtlieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(datenaiss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtprenom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combo3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BoutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BoutonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnom)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datenaiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtadress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combolicence)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo3)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoutonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 0, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Grade");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Soumettre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nomgrade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nomgradeItemStateChanged(evt);
            }
        });
        nomgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomgradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 0, 51));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField3.setText("Rechercher en tapant le nom ou le prénom");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Rechercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prénoms", "Date de Naissance", "Lieu de Naissance", "Sexe", "Nationalité", "Adresse", "Télephone", "Semestre", "Grade"
            }
        ));
        tble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tble);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("IMPRIMER");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(91, 91, 91)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String classeeleve = String.valueOf(nomgrade.getSelectedItem());
        this.recherchecombobox("AnneeLicence", classeeleve);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        this.recherchenom("NomEtudiant", jTextField3.getText());
    }//GEN-LAST:event_jTextField3KeyReleased

    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleMouseClicked
        if (evt.getClickCount() == 1) {
            selectionligne();
        }
    }//GEN-LAST:event_tbleMouseClicked

    private void BoutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSupprimerActionPerformed
        int g = tble.getSelectedRow();
        int p = Integer.parseInt(tble.getValueAt(g, 0).toString());
        int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer?");

        if (reponse == 0) {
            String requete = "Delete from est where EtudiantCodeEtudiant = '" + p + "'";
            String requete2 = "Delete from etudiant where CodeEtudiant = '" + p + "'";
            connection.maj(requete);
            connection.maj(requete2);
            actualiser();
            initialiser();
        } else {
            JOptionPane.showMessageDialog(null, "Echec de la suppression");
        }
    }//GEN-LAST:event_BoutonSupprimerActionPerformed

    private void BoutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModifierActionPerformed
        if (flag) {

            int g = tble.getSelectedRow();
            int codeetudiant = Integer.parseInt(tble.getValueAt(g, 0).toString());
            String nomeleve = txtnom.getText();
            String prenomeleve = txtprenom.getText();
            String datenaissance = datenaiss.getCalendar().get(Calendar.YEAR) + "-" + (1 + datenaiss.getCalendar().get(Calendar.MONTH)) + "-" + datenaiss.getCalendar().get(Calendar.DATE);
            String lieueleve = txtlieu.getText();
            String sexeeleve = String.valueOf(combo1.getSelectedItem());
            String nomsemestre = String.valueOf(combo3.getSelectedItem());
            String nationaliteeleve = txtnatio.getText();
            String adresseeleve = txtadress.getText();
            int teleleve = Integer.parseInt(txttel.getText());

            String requete = "update etudiant set NomEtudiant ='" + nomeleve + "' , PrenomEtudiant = '"
                    + prenomeleve + "',DateNaiss ='" + datenaissance + "', LieuNaiss= '" + lieueleve + "' ,Nationalite='" + nationaliteeleve + "' ,Telephone='" + teleleve + "' ,Sexe='" + sexeeleve + "', Adresse='" + adresseeleve + "'  where CodeEtudiant='" + codeetudiant + "'";

            int a = connection.maj(requete);
            String requete2 = "update est where CodeEtudiant='" + codeetudiant + "'"; //Souci de la mise à jour
            int b = connection.maj(requete2);
            actualiser();
            initialiser();
            JOptionPane.showMessageDialog(null, "Modification reussi");

        } else {
            JOptionPane.showMessageDialog(null, "Vous n avez pas selectionner de ligne dans la table");
        }
    }//GEN-LAST:event_BoutonModifierActionPerformed

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        String nomeleve = txtnom.getText();
        String prenomeleve = txtprenom.getText();
        String datenaissance = datenaiss.getCalendar().get(Calendar.YEAR) + "-" + (1 + datenaiss.getCalendar().get(Calendar.MONTH)) + "-" + datenaiss.getCalendar().get(Calendar.DATE);
        String lieueleve = txtlieu.getText();
        String sexeeleve = String.valueOf(combo1.getSelectedItem());
        String nomsemestre = String.valueOf(combo3.getSelectedItem());
        String nationaliteeleve = txtnatio.getText();
        String adresseeleve = txtadress.getText();
        int teleleve = Integer.parseInt(txttel.getText());

        String requete = "insert into etudiant values(null,'" + nomeleve + "','" + prenomeleve + "','" + datenaissance + "','"
                + lieueleve + "','" + nationaliteeleve + "','" + teleleve + "','" + sexeeleve + "','" + adresseeleve + "')";
        int a = connection.maj(requete);

        String requete2 = "insert into est(EtudiantCodeEtudiant, EstidGrade , EstidSemestre) select CodeEtudiant , idGrade , idSemestre From etudiant E ,semestre S , grade G where S.NomSemestre = '" + nomsemestre + "' And S.`idSemestre` = G.`GradeidSemestre` And E.NomEtudiant = '" + nomeleve + "' ";
        int b = connection.maj(requete2);

        JOptionPane.showMessageDialog(null, "L' Etudiant '" + nomeleve + "' a été ajouté ");
        actualiser();
        initialiser();
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void nomgradeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nomgradeItemStateChanged
        /*
        String element =nomgrade.getSelectedItem().toString();
       String requete = "select distinct NomSemestre from Grade , Semestre where AnneeLicence = '"+ element +"' and Grade.GradeidSemestre = Semestre.`idSemestre`";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while(resultat.next()){
                nomsemestre.setSelectedItem(resultat.getString("NomSemestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }//GEN-LAST:event_nomgradeItemStateChanged

    private void nomgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomgradeActionPerformed
        /*   String element =nomgrade.getSelectedItem().toString();
       String requete = "select distinct NomSemestre from Grade , Semestre where AnneeLicence = '"+ element +"' and Grade.GradeidSemestre = Semestre.`idSemestre`";
        ResultSet resultat;
        resultat = connection.interroger(requete);
        try {
            while(resultat.next()){
                nomsemestre.addItem(resultat.getString("NomSemestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }//GEN-LAST:event_nomgradeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combolicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combolicenceActionPerformed
        //TODO add your handling code here:
    }//GEN-LAST:event_combolicenceActionPerformed

    private void combolicenceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combolicenceItemStateChanged

    }//GEN-LAST:event_combolicenceItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonModifier;
    private javax.swing.JButton BoutonSupprimer;
    private javax.swing.JButton BoutonValider;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo3;
    private javax.swing.JComboBox<String> combolicence;
    private com.toedter.calendar.JDateChooser datenaiss;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> nomgrade;
    private javax.swing.JTable tble;
    private javax.swing.JTextField txtadress;
    private javax.swing.JTextField txtlieu;
    private javax.swing.JTextField txtnatio;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
