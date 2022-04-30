package Sources.Modele;

import java.awt.Component;

import javax.swing.*;

import Vue.Vuejeu;

public class InterfaceGraphique {
    Plateau plateau;
    static Vuejeu vueJeu;
    JFrame f;

    public void demarre(JFrame fenetreDuJeu, int nbLignes, int nbColonnes) {

        plateau = new Plateau(10, 10);
        vueJeu = new Vuejeu(plateau);
        vueJeu.addMouseListener(new AdapteurSouris(plateau, vueJeu));
        f = fenetreDuJeu;
        fenetreDuJeu.add((Component) vueJeu);

    }
}
