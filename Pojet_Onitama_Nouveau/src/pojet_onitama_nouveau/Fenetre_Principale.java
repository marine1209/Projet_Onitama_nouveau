/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pojet_onitama_nouveau;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author nicol
 */
public class Fenetre_Principale extends javax.swing.JFrame {
    
    GrilleDeJeu grille;
    int i;
    ArrayList<Cartes2> cartesTirees;
    private Pions PionSelectionné;
    Cartes2 carteSelectionnée;

    /**
     * Constructeur de la fenêtre principale.
     * Initialise les composants graphiques, la grille de jeu, et configure les interactions des boutons de la grille.
     */
    public Fenetre_Principale() {
        initComponents();
        // coordonneesPionSelectionnée=null;
        //carteSelectionnée=null;
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(4);
        test.add(test2);

        tirageCartes();
        affichageCartes();
        this.grille = new GrilleDeJeu();
        PanneauGrille.setLayout(new GridLayout(5, 5));
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 5 * 40, 5 * 40));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                CaseGrilleGraphique bouton_case = grille.matriceCellules[i][j];
                bouton_case.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PionSelectionné = bouton_case.onClick();

                    }
                });
                PanneauGrille.add(bouton_case); // ajout au Jpanel PanneauGrille
            }
        }

        PanneauCartesHaut.setLayout(new GridLayout(1, 2));
        getContentPane().add(PanneauCartesHaut, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70));
        PanneauCartesBas.setLayout(new GridLayout(1, 2));
        getContentPane().add(PanneauCartesBas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 2 * 40, 1 * 40));

    }


    /**
     * Méthode qui tire 5 cartes aléatoirement
     * @return un arraylist contenant les 5 cartes
     */
    public void tirageCartes() {
        ArrayList<Cartes2> cartesTirees = new ArrayList<Cartes2>();
        ArrayList<String> nomCartes = new ArrayList<String>();
        nomCartes.add("boar");
        nomCartes.add("cobra");
        nomCartes.add("crab");
        nomCartes.add("crane");
        nomCartes.add("dragon");
        nomCartes.add("eel");
        nomCartes.add("elephant");
        nomCartes.add("frog");
        nomCartes.add("goose");
        nomCartes.add("horse");
        nomCartes.add("mantis");
        nomCartes.add("monkey");
        nomCartes.add("ox");
        nomCartes.add("rabbit");
        nomCartes.add("rooster");
        nomCartes.add("tiger");
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            int nombreTireAuHasard = random.nextInt(16 - j);
            String nomCarteTiree = nomCartes.get(nombreTireAuHasard);
            cartesTirees.add(new Cartes2(nomCarteTiree));
            nomCartes.remove(nombreTireAuHasard);
        }
        this.cartesTirees = cartesTirees;
    }

    /**
     * Méthode qui Affiche les cartes tirées sur les composants graphiques appropriés.
     * Utilise les icônes d'images spécifiées par le nom de chaque carte.
     * 
     */
    public void affichageCartes() {

        for (int j = 0; j < cartesTirees.size(); j++) {

            ImageIcon Icon = createImageIcon("/image/" + this.cartesTirees.get(j).nom + ".jpg");
            switch (j) {
                case 0:
                    JBcarte1.setIcon(Icon);
                    break;
                case 1:
                    JBcarte2.setIcon(Icon);
                    break;
                case 2:
                    JRcarte1.setIcon(Icon);
                    break;
                case 3:
                    JRcarte2.setIcon(Icon);
                    break;
                case 4:
                    Bcartecote.setIcon(Icon);
                    break;
                default:
                    break;
            }
        }

    }

    private ImageIcon createImageIcon(String path) {
        URL imageURL = getClass().getResource(path);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.println("Impossible de trouver le fichier : " + path);
            return null;
        }
    }

    /**
     * Allume (met en évidence) les cellules de la grille aux coordonnées spécifiées.
     * @param CoordonneePossible
     */
    /*public void Allumer(ArrayList<ArrayList<Integer>> CoordonneePossible) {
        int l, c;
        for (int i = 0; i < CoordonneePossible.size(); i++) {
            l = CoordonneePossible.get(i).get(0);
            c = CoordonneePossible.get(i).get(1);
            Graphics Graphics;
            grille.matriceCellules[l][c].mettreEnEvidence(CoordonneePossible);
        }
    }*/
    
    public void FinDePartie(Pions pion) {
        if (pion.estEleve() == false && pion.estMort() == true) {
            if (pion.getCouleur() == "bleu") {
                this.AfficherTout(false);
                Bcartecote.setVisible(true);
                Bcartecote.setText("Victoire des rouges !");
            } else if (pion.getCouleur() == "rouge") {
                this.AfficherTout(false);
                Bcartecote.setVisible(true);
                Bcartecote.setText("Victoire des bleus !");
            }
        }
        if (pion.estEleve() == false) {
            if (pion.getCouleur() == "bleu" && (pion.getPosition_ligne() == 0 && pion.getPosition_colonne() == 2)) {
                this.AfficherTout(false);
                Bcartecote.setVisible(true);
                Bcartecote.setText("Victoire des bleus !");
            } else if (pion.getCouleur() == "rouge" && (pion.getPosition_ligne() == 4 && pion.getPosition_colonne() == 2)) {
                this.AfficherTout(false);
                Bcartecote.setVisible(true);
                Bcartecote.setText("Victoire des rouges !");
            }
        }
    }
    
    public void AfficherTout (boolean etat) {
        PanneauGrille.setVisible(etat);
        PanneauCartesHaut.setVisible(etat);
        PanneauCartesBas.setVisible(etat);
        PanneauInfoJR.setVisible(etat);
        PanneauInfoJB.setVisible(etat);
        Bcartecote.setVisible(etat);
    }

    /**
     * Met en évidence les cellules de la grille aux coordonnées spécifiées en les entourant d'un carré vert.
     * @param CoordonneePossible
     */
    public void mettreEnEvidence(ArrayList<ArrayList<Integer>> CoordonneePossible){
        int ligne;
        int colonne;
        int ancienneLigne;
        int ancienneColonne;
        for (int i = 0; i<CoordonneePossible.size(); i++){
           ligne = CoordonneePossible.get(i).get(0);
           colonne = CoordonneePossible.get(i).get(1);
           ancienneLigne = PionSelectionné.getPosition_ligne();
           ancienneColonne = PionSelectionné.getPosition_colonne();
           grille.matriceCellules[ligne][colonne].setBackground(GREEN);
           seDeplacer(ligne, colonne, ancienneLigne, ancienneColonne);
        }
    }

    
    public void seDeplacer (int ligne, int colonne, int ancienneLigne, int ancienneColonne){
        grille.matriceCellules[ligne][colonne].addActionListener(new ActionListener() {
                // Utilisez des variables finales temporaires
                final int finalLigne = ligne;
                final int finalColonne = colonne;
                final int finalancienneLigne = ancienneLigne;
                final int finalancienneColonne = ancienneColonne;

                @Override
                public void actionPerformed(ActionEvent e) {
                    // Déplacez le pion lorsqu'une case est cliquée
                    System.out.println(finalancienneLigne);
                    System.out.println(finalLigne);
                    grille.matriceCellules[finalancienneLigne][finalancienneColonne].caseGrilleAssociee.setEtat(false);
                    grille.matriceCellules[finalancienneLigne][finalancienneColonne].mettreAJour();
                    grille.matriceCellules[finalLigne][finalColonne].caseGrilleAssociee.setPion_associe(PionSelectionné);
                    grille.matriceCellules[finalLigne][finalColonne].ChangementDeCase(finalLigne, finalColonne);
                    for (int i = 0 ; i<5 ; i++) {
                        for (int j = 0 ; j<5 ; j++) {
                            grille.matriceCellules[i][j].setBackground(GRAY);
                        }
                    }
                }
            });
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauCartesBas = new javax.swing.JPanel();
        JBcarte1 = new javax.swing.JButton();
        JBcarte2 = new javax.swing.JButton();
        Bcartecote = new javax.swing.JButton();
        PanneauInfoJR = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PanneauInfoJB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PanneauCartesHaut = new javax.swing.JPanel();
        JRcarte2 = new javax.swing.JButton();
        JRcarte1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1273, 1300));

        PanneauGrille.setBackground(new java.awt.Color(204, 255, 204));
        PanneauGrille.setMinimumSize(new java.awt.Dimension(0, 0));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(235, 235));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        PanneauCartesBas.setBackground(new java.awt.Color(51, 153, 255));
        PanneauCartesBas.setAlignmentX(50.0F);
        PanneauCartesBas.setAlignmentY(0.0F);
        PanneauCartesBas.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        PanneauCartesBas.setMinimumSize(new java.awt.Dimension(613, 188));
        PanneauCartesBas.setPreferredSize(new java.awt.Dimension(610, 192));

        JBcarte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcarte1ActionPerformed(evt);
            }
        });

        JBcarte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcarte2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanneauCartesBasLayout = new javax.swing.GroupLayout(PanneauCartesBas);
        PanneauCartesBas.setLayout(PanneauCartesBasLayout);
        PanneauCartesBasLayout.setHorizontalGroup(
            PanneauCartesBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauCartesBasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBcarte1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBcarte2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanneauCartesBasLayout.setVerticalGroup(
            PanneauCartesBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauCartesBasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneauCartesBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBcarte1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(JBcarte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanneauInfoJR.setBackground(new java.awt.Color(255, 102, 102));
        PanneauInfoJR.setMinimumSize(new java.awt.Dimension(50, 50));
        PanneauInfoJR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Infos Joueur Rouge");
        PanneauInfoJR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setText("Nom Joueur:");
        PanneauInfoJR.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        PanneauInfoJR.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel5.setText("Elèves : 4");
        PanneauInfoJR.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel7.setText("Sensei : 1");
        PanneauInfoJR.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        PanneauInfoJB.setBackground(new java.awt.Color(0, 153, 255));
        PanneauInfoJB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setText("Infos Joueur Bleu");
        PanneauInfoJB.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setText("Nom Joueur");
        PanneauInfoJB.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        PanneauInfoJB.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel8.setText("Elèves : 4");
        PanneauInfoJB.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel9.setText("Sensei : 1");
        PanneauInfoJB.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        PanneauCartesHaut.setBackground(new java.awt.Color(255, 102, 102));
        PanneauCartesHaut.setAlignmentX(50.0F);
        PanneauCartesHaut.setAlignmentY(100.0F);
        PanneauCartesHaut.setPreferredSize(new java.awt.Dimension(610, 192));
        PanneauCartesHaut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JRcarte2.setPreferredSize(new java.awt.Dimension(100, 80));
        JRcarte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRcarte2ActionPerformed(evt);
            }
        });
        PanneauCartesHaut.add(JRcarte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 3, 300, 190));

        JRcarte1.setPreferredSize(new java.awt.Dimension(100, 80));
        JRcarte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRcarte1ActionPerformed(evt);
            }
        });
        PanneauCartesHaut.add(JRcarte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 3, 300, 185));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanneauCartesBas, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanneauCartesHaut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanneauInfoJB, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanneauInfoJR, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(Bcartecote, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanneauInfoJR, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(PanneauCartesHaut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Bcartecote, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanneauCartesBas, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanneauInfoJB, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void JRcarte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRcarte2ActionPerformed
        carteSelectionnée = cartesTirees.get(3); // carte qui correspond
        System.out.println("Coordonnées du pion : " + PionSelectionné);
        ArrayList<ArrayList<Integer>> déplacementPossibles = new ArrayList<ArrayList<Integer>>();
        déplacementPossibles = carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_rouge(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne());
        System.out.println(carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_rouge(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()));

        mettreEnEvidence(déplacementPossibles);
    }//GEN-LAST:event_JRcarte2ActionPerformed

    private void JRcarte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRcarte1ActionPerformed
        carteSelectionnée = cartesTirees.get(2); // carte qui correspond
        System.out.println("Coordonnées du pion : " + PionSelectionné);
        ArrayList<ArrayList<Integer>> déplacementPossibles = new ArrayList<ArrayList<Integer>>();
        déplacementPossibles = carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_rouge(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne());
        System.out.println(carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_rouge(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()));

        mettreEnEvidence(déplacementPossibles);
    }//GEN-LAST:event_JRcarte1ActionPerformed

    private void JBcarte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcarte1ActionPerformed
        carteSelectionnée = cartesTirees.get(0); // carte qui correspond
        System.out.println("Coordonnées du pion : " + PionSelectionné);
        ArrayList<ArrayList<Integer>> déplacementPossibles = new ArrayList<ArrayList<Integer>>();
        déplacementPossibles = carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_bleu(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne());
        System.out.println(carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_bleu(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()));

        mettreEnEvidence(déplacementPossibles);
    }//GEN-LAST:event_JBcarte1ActionPerformed

    private void JBcarte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcarte2ActionPerformed
        carteSelectionnée = cartesTirees.get(1); // carte qui correspond
        System.out.println("Coordonnées du pion : " + PionSelectionné);
        ArrayList<ArrayList<Integer>> déplacementPossibles = new ArrayList<ArrayList<Integer>>();
        déplacementPossibles = carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_bleu(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne());
        System.out.println(carteSelectionnée.deplacementVraimentsPossibles(carteSelectionnée.deplacement_possible_bleu(PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()), PionSelectionné.getPosition_ligne(), PionSelectionné.getPosition_colonne()));

        mettreEnEvidence(déplacementPossibles);
    }//GEN-LAST:event_JBcarte2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre_Principale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcartecote;
    private javax.swing.JButton JBcarte1;
    private javax.swing.JButton JBcarte2;
    private javax.swing.JButton JRcarte1;
    private javax.swing.JButton JRcarte2;
    private javax.swing.JPanel PanneauCartesBas;
    private javax.swing.JPanel PanneauCartesHaut;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JPanel PanneauInfoJB;
    private javax.swing.JPanel PanneauInfoJR;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
