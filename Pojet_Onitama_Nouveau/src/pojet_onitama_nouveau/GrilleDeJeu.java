/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojet_onitama_nouveau;

/**
 *
 * @author marin
 */
public class GrilleDeJeu {
    CaseGrilleGraphique[][] matriceCellules;
    
    /**
     *Créer la grille de jeu. Contient 25 caseGrilleGraphique 
     */
    public GrilleDeJeu() {
      
        matriceCellules=new CaseGrilleGraphique[5][5];
        // Création d'un nouvel objet de type case graphique pour chaque cellule
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
              // création d'une ligne de pions rouges  
              if (i==0 && j==2){  
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true, new Pions (i, j, false, "rouge")));
              //création du sensei rouge  
              }else
              if (0==i && j!=2){
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true, new Pions (i, j, true, "rouge")));
              //création d'une ligne de pions bleus    
              }else
              if (i==4 && j==2){  
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true, new Pions (i, j, false, "bleu")));
               //création du sensei bleus  
              }else
              if (i==4 && j!=2){
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true,  new Pions (i, j, true, "bleu")));
              //cases innocupée   
              }
              else{
                  this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(false));
              }
              
              
              
    }   

}
}
    }


    

