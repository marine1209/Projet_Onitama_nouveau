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
    
    public GrilleDeJeu() {
      
        matriceCellules=new CaseGrilleGraphique[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Création d'un nouvel objet de type CelluleLumineuse pour chaque cellule
              if (i==0 && j==2){  
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true, new Pions (i, j, false, "rouge")));
                
              }else
              if (0==i && j!=2){
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true, new Pions (i, j, true, "rouge")));
                   
              }else
              if (i==4 && j==2){  
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true, new Pions (i, j, false, "bleu")));
                 
              }else
              if (i==4 && j!=2){
                this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(true,  new Pions (i, j, true, "bleu")));
                 
              }
              else{
                  this.matriceCellules[i][j] = new CaseGrilleGraphique(new CaseGrille(false));
              }
              
              
              
    }   

}
}
    }
}

    

