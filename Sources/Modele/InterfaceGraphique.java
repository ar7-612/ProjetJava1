package Sources.Modele;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import Sources.Vue.BtnMenuListener;
import Sources.Vue.Vuejeu;

public class InterfaceGraphique {
    Plateau plateau;
    static Vuejeu vueJeu;
    JTextField userSize;

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
        Box barre = Box.createVerticalBox();
        barre.add(Box.createGlue());
        for (int i = 0; i < 2; i++) {
            barre.add(new JLabel("Type du joueur " + (i + 1)));
            JToggleButton but = new JToggleButton("IA");
            // but.addActionListener(new AdaptateurJoueur(param));
            barre.add(but);
        }
        barre.add(Box.createGlue());
        barre.add(new JLabel("Nombre de coup : "));
        userSize = new JTextField("0");
        userSize.setFocusable(false);
        userSize.setMaximumSize(new Dimension(userSize.getMaximumSize().width, userSize.getMinimumSize().height));
        barre.add(userSize);
        barre.add(Box.createGlue());

        barre.add(new JLabel("Tour du joueur " + plateau.quiJoue()));
        barre.add(Box.createGlue());
        fenetreDuJeu.add(barre, BorderLayout.LINE_END);

    }
}
