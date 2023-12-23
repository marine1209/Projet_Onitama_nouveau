/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojet_onitama_nouveau;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author marin
 */
public class Cartes2 {
    String nom;

    /**
     * Constructeur de Cartes2
     *
     * @param nom
     */
    public Cartes2(String nom) {
        this.nom = nom;
    }

    /**
     * Calcule les coordonnées de déplacement possibles pour un pion bleu en
     * fonction de son nom.
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public ArrayList deplacement_possible_bleu(int ligne, int colonne) {
        ArrayList<ArrayList<Integer>> déplacementPossibles = new ArrayList<ArrayList<Integer>>();

        switch (this.nom) {
            case "boar":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                break;

            case "cobra":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                break;

            case "crab":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 2);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 2);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                break;

            case "crane":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;

            case "dragon":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 2);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 2);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;

            case "eel":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                break;

            case "elephant":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;

            case "frog":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 2);
                break;

            case "goose":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                break;

            case "horse":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                break;

            case "mantis":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;

            case "monkey":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;

            case "ox":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                break;

            case "tiger":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne - 2, colonne);
                break;

            case "rabbit":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 2);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;

            case "rooster":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;
        }
        return déplacementPossibles;
    }

    /**
     * Calcule les coordonnées de déplacement possibles pour un pion rouge en
     * fonction de son nom.
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public ArrayList deplacement_possible_rouge(int ligne, int colonne) {
        ArrayList<ArrayList<Integer>> déplacementPossibles = new ArrayList<ArrayList<Integer>>();

        switch (this.nom) {
            case "boar":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                break;

            case "cobra":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                break;

            case "crab":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 2);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 2);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                break;

            case "crane":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;

            case "dragon":
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 2);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 2);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;

            case "eel":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                break;

            case "elephant":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;

            case "frog":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 2);
                break;

            case "goose":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                break;

            case "horse":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                break;

            case "mantis":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;

            case "monkey":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;

            case "ox":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                break;

            case "tiger":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne);
                ajouterCoordonnees(déplacementPossibles, ligne + 2, colonne);
                break;

            case "rabbit":
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 2);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                break;

            case "rooster":
                ajouterCoordonnees(déplacementPossibles, ligne, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne, colonne + 1);
                ajouterCoordonnees(déplacementPossibles, ligne + 1, colonne - 1);
                ajouterCoordonnees(déplacementPossibles, ligne - 1, colonne + 1);
                break;
        }
        return déplacementPossibles;
    }

    /**
     * retourne les coordonnées possible pour un pion en fonction  de sa position et de la carte choisie
     * @param déplacements
     * @param ligne
     * @param colonne
     * @return
     */
    public ArrayList deplacementVraimentsPossibles(ArrayList<ArrayList<Integer>> déplacements, int ligne, int colonne) {
        ArrayList<ArrayList<Integer>> coordonneesValides = new ArrayList<>();
        for (int i = 0; i < déplacements.size(); i++) {
            int l= déplacements.get(i).get(0);
            int c = déplacements.get(i).get(1);
            if ( l>=0 && l<5 && c>=0 && c<5){
            coordonneesValides.add(déplacements.get(i));//si la coordonnée est valide, l'indice correspondant s'ajoute à une nouvelle liste, les coordonnées valides
            }

        }
        return coordonneesValides;
    }

    private void ajouterCoordonnees(ArrayList<ArrayList<Integer>> déplacementPossibles, int nouvelleLigne, int nouvelleColonne) {
        ArrayList<Integer> coordonnees = new ArrayList<>();
        coordonnees.add(nouvelleLigne);
        coordonnees.add(nouvelleColonne);
        déplacementPossibles.add(coordonnees);

    }

    Cartes2 get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void set(int i, Cartes2 get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    ImageIcon getImageIcon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setImageIcon(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setIcon(ImageIcon createImageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

    

