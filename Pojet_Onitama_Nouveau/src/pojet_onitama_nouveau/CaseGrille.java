/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojet_onitama_nouveau;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author marin
 */
public class CaseGrille {

    private CaseGrilleGraphique caseGraphique;
    boolean etat;
    Pions pion_associe;
    
    /**
     * Constructeur de CaseGrille avec un pion associe
     * @param etat
     * @param pion_associe
     */
    public CaseGrille(boolean etat, Pions pion_associe) {
        this.etat = etat;
        this.pion_associe = pion_associe;
    }

    /**
     * Constructeur de la classe CaseGrille sans pion associé.
     * @param etat
     */
    public CaseGrille(boolean etat) {
        this.etat = etat;
        this.pion_associe = null; // Pas de pion associé dans ce cas
    }
    
    /**
     * Passe l'etat de la case de false à true et inversement
     */
    public void activerCase() {
        if (etat == false) {
            etat = true;
        } else {
            etat = false;
        }
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
    
    /**
     * Renvoie true si la case est occupée, false si elle est inoccupée.
     * @return
     */
    public boolean estOccupee() {
        if (etat == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Récupère l'état de la case.
     * @return
     */
    public boolean getEtat() {
        return etat;
    }

    public void setPion_associe(Pions pion_associe) {
        this.pion_associe = pion_associe;
    }
    

    /**
     * Récupère le pion associé à la case.
     * @return
     */
    public Pions getPion_associe() {
        return pion_associe;
    }
    
    

    private Graphics getGraphics() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getWidth() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

    
