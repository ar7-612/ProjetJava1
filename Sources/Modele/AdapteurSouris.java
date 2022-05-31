package Sources.Modele;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Sources.Vue.Vuejeu;

public class AdapteurSouris extends MouseAdapter {
    Plateau plat;
    Vuejeu vueJeu;
    int souries;
    JFrame frame;

    public AdapteurSouris(Plateau p, Vuejeu vplat) {
        plat = p;
        vueJeu = vplat;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (plat.fini()) {
            JOptionPane.showMessageDialog(frame, "Joueur " + plat.quiJoue() + " a gagné!", "Partie terminée", 1);
            return;
        }
        int colonne = e.getX() / vueJeu.largeurCase();
        int ligne = e.getY() / vueJeu.hauteurCase();
        if (!plat.Jouercoup(ligne, colonne)) {
            System.out.println("Clic hors de la zone de plat !\n");
        } else {
            plat.Jouercoup(ligne, colonne);
            plat.changeJoueur();
            vueJeu.repaint();
            if (plat.fini()) {
                JOptionPane.showMessageDialog(frame, "Joueur " + plat.quiJoue() + " a gagné!", "Partie terminée", 1);
                return;
            }
        }
    }
}