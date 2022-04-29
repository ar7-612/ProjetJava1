package Sources.Modele;

import java.awt.event.*;

public class AdapteurSouris extends MouseAdapter {
    Plateau plat;
    Vuejeu vueJeu;
    int souries;

    public AdapteurSouris(Plateau p, Vuejeu vplat) {
        plat = p;
        vueJeu = vplat;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (plat.fini()) {
            System.out.println("Le plat est fini, J" + plat.quiJoue() + " a gagné !");
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

        }
    }
}