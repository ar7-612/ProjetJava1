package Sources.Modele;

import java.awt.Component;

import javax.swing.*;

import Sources.Vue.BtnMenuListener;
import Sources.Vue.Vuejeu;

public class InterfaceGraphique {
    Plateau plateau;
    static Vuejeu vueJeu;

    public void demarre(JFrame fenetreDuJeu, int nbLignes, int nbColonnes) {
        plateau = new Plateau(20, 20);

        vueJeu = new Vuejeu(plateau);
        fenetreDuJeu.add((Component) vueJeu);
        JMenuBar menuBar = new JMenuBar();

        JMenu loadSave = new JMenu("Partie");
        JMenuItem save = new JMenuItem("Sauvegarder");
        JMenuItem newGame = new JMenuItem("Nouvelle Partie");
        loadSave.add(newGame);
        loadSave.add(save);

        JMenu rep = new JMenu("Historique");
        JMenuItem redo = new JMenuItem("Refaire");
        rep.add(redo);

        menuBar.add(loadSave);
        menuBar.add(rep);
        fenetreDuJeu.setJMenuBar(menuBar);

        redo.addActionListener(new BtnMenuListener(redo, plateau, vueJeu));
        newGame.addActionListener(new BtnMenuListener(newGame, plateau, vueJeu));
        save.addActionListener(new BtnMenuListener(save, plateau, vueJeu));
        vueJeu.addMouseListener(new AdapteurSouris(plateau, vueJeu));

    }
}
