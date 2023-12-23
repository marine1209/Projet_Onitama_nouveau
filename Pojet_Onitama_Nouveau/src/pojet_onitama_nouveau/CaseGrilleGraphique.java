/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojet_onitama_nouveau;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author nicol
 */
public class CaseGrilleGraphique extends JButton {
    CaseGrille caseGrilleAssociee;

    /**
     *Constructeur
     * @param caseGrilleAssociee
     */
    public CaseGrilleGraphique(CaseGrille caseGrilleAssociee) {
        this.caseGrilleAssociee= caseGrilleAssociee;
    }

    /**
     *renvoie la case grille associée
     * @return
     */
    public CaseGrille getCaseGrille (){
        return this.caseGrilleAssociee;
    }

    
    /**
     * Cette méthode est appelée automatiquement chaque fois que le composant doit être redessiné.
     * Elle est responsable du dessin du composant en fonction de l'état de la case associée.
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int longueur = this.getWidth();
        int hauteur = this.getHeight();
        if (caseGrilleAssociee.estOccupee()) {
            Pions pion = caseGrilleAssociee.getPion_associe();
            if (pion != null) {
                if ("rouge".equals(pion.getCouleur())) {
                    if (pion.estEleve() == true) {
                        g.setColor(Color.red);
                        g.fillOval(2, 2, longueur - 4, hauteur-4);
                    } else {
                        g.setColor(Color.red); // Par exemple, utiliser la couleur bleue
                        g.fillRect(8, 8, longueur - 15, hauteur - 15);
                    }
                } else if ("bleu".equals(pion.getCouleur())) {
                    if (pion.estEleve() == true) {
                        g.setColor(Color.blue);
                        g.fillOval(2, 2, longueur - 4, hauteur-4);
                    } else {
                        g.setColor(Color.blue); // Par exemple, utiliser la couleur bleue
                        g.fillRect(8, 8, longueur - 15, hauteur - 15);
                    }
                }
            }
        } else {
            g.setColor(Color.gray);
            g.fillOval(2, 2, longueur - 4, hauteur - 4);
        }
    }
    
    /**
     *Elle est appelée à chauqe fois qu'un pion est déplaceé, afin de mettre la grille à jour
     */
    public void mettreAJour(){
        Graphics g=this.getGraphics();
        super.paintComponent(g);
        int longueur = this.getWidth();
        int hauteur = this.getHeight();
        if (caseGrilleAssociee.estOccupee()) {
            Pions pion = caseGrilleAssociee.getPion_associe();
            if (pion != null) {
                if ("rouge".equals(pion.getCouleur())) {
                    if (pion.estEleve() == true) {
                        g.setColor(Color.red);
                        g.fillOval(2, 2, longueur - 4, hauteur-4);
                    } else {
                        g.setColor(Color.red); // Par exemple, utiliser la couleur bleue
                        g.fillRect(8, 8, longueur - 15, hauteur - 15);
                    }
                } else if ("bleu".equals(pion.getCouleur())) {
                    if (pion.estEleve() == true) {
                        g.setColor(Color.blue);
                        g.fillOval(2, 2, longueur - 4, hauteur-4);
                    } else {
                        g.setColor(Color.blue); // Par exemple, utiliser la couleur bleue
                        g.fillRect(8, 8, longueur - 15, hauteur - 15);
                    }
                }
            }
        } else {
            g.setColor(Color.gray);
            g.fillOval(2, 2, longueur - 4, hauteur - 4);
        }
    }

    
    /**
     * Méthode appelée après un clic sur un élément graphique associé à un pions .
     * Renvoie l'objet Pions associé à la case de la grille au moment du clic.
     * @return
     */
    public Pions onClick() {
        Pions pionSelectionne=caseGrilleAssociee.getPion_associe();
        return pionSelectionne;
    }
    
    /**
     *Permet de changer un pion de case
     * @param ligne
     * @param colonne
     */
    public void ChangementDeCase(int ligne, int colonne){
        caseGrilleAssociee.activerCase(); //nouvelle case activée
        caseGrilleAssociee.getPion_associe().changement_coord(ligne, colonne);//la nouvelle case récupère le pion de l'ancienne case
        mettreAJour();//mise à jour de la grille
        repaint();
    } 

    /**
     * Permet de manger un pion et le faire disparaitre
     * @param pionAttaque
     * @param pionAttaquant
     */
    public void Manger(Pions pionAttaque, Pions pionAttaquant) {    
        if (pionAttaque.getCouleur()!= pionAttaquant.getCouleur()){
            pionAttaque.estMort(); //change l'etat du pion attaqué
            caseGrilleAssociee.setEtat(false); 
            caseGrilleAssociee.setPion_associe(pionAttaquant); //associe le pion attaquant à la case attaquée
        } 
        
    }       
        
    }






    
    
    
