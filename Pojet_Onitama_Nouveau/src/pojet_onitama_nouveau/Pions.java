/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojet_onitama_nouveau;

/**
 *
 * @author marin
 */
public class Pions {
     CaseGrille [][] matriceCellules;
    private int position_ligne;
    private int position_colonne; 
    private boolean eleve;
    private boolean Mort;
    private String couleur;  //R pour rouge et B pour bleu

    /**
     * Constructeur de Pions, initialise la positions des pions
     * @param position_ligne
     * @param position_colonne
     * @param eleve
     * @param couleur
     */
    public Pions(int position_ligne, int position_colonne, boolean eleve, String couleur) {
        this.position_ligne = position_ligne;
        this.position_colonne = position_colonne;
        this.eleve = eleve;
        this.Mort= false;
        this.couleur=couleur;
  
    }

    /**
     * Récupère la position en ligne du pion.
     * @return
     */
    public int getPosition_ligne() {
        return position_ligne;
    }

    /**
     * Récupère la position en colonne du pion.
     * @return
     */
    public int getPosition_colonne() {
        return position_colonne;
    }

    /**
     * Vérifie si le pion est un eleve.
     * @return
     */
    public boolean estEleve() {
        return eleve;
    }

    public boolean estMort() {
        return Mort;
    }
    
    /**
     * Récupère la couleur du pion
     * @return
     */
    public String getCouleur() {
        return couleur;
    }
    
    //CREER LA METHODE POUR CHECKER QU'UNE CASE VOULUE EST BIEN DANS LA GRILLE
    /*public boolean verifierCaseDansGrille(int position_ligne, int position_colonne, Cartes carte) {
        String animal = carte.nom;
        
    }*/
    
    /**
     * Vérifie si les coordonnées spécifiées se trouvent dans les limites de la grille de jeu. 
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean verif_position(int ligne, int colonne){
        if (ligne>4 || colonne>4 || ligne<0 || colonne<0){
            return false;
        }
        else
            return true;
    }
    
    /**
     * Change les coordonnées du pion en les mettant à jour avec les nouvelles valeurs spécifiées
     * @param ligne
     * @param colonne
     */
    public void changement_coord (int ligne, int colonne){
        if (verif_position(ligne, colonne)==true){
            this.position_colonne=colonne;
            this.position_ligne=ligne;
        }   
    }
    
    /**
     * Marque le pion comme étant mort.
     */
    public void MortDuPion(){
        this.Mort=true;
    }
    
    /**
     * Vérifie si le pion peut se déplacer vers les coordonnées spécifiées.
     * @param pion
     * @param ligne_visee
     * @param colonne_visee
     * @return
     */
    public boolean VerifierSiPeutSeDeplacer (Pions pion, int ligne_visee, int colonne_visee) {
        if (verif_position(ligne_visee, colonne_visee) == true) {
            if (matriceCellules[ligne_visee][colonne_visee].pion_associe == null) {
                return true;
            } else if(matriceCellules[ligne_visee][colonne_visee].pion_associe != null) {
                if (matriceCellules[ligne_visee][colonne_visee].pion_associe.getCouleur() != pion.getCouleur()) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

}
    

    
