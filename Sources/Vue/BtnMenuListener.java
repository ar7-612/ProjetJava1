package Sources.Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Sources.Testmain;
import Sources.Modele.InterfaceGraphique;
import Sources.Modele.Plateau;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khebt
 */
public class BtnMenuListener implements ActionListener {
    JMenuItem item;
    Plateau plat;
    Vuejeu vj;

    public BtnMenuListener(JMenuItem item, Plateau jeu, Vuejeu vjeu) {
        this.item = item;
        plat = jeu;
        vj = vjeu;
    }

    public BtnMenuListener(JMenuItem newGame, InterfaceGraphique interfaceGraphique) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String labelItem = this.item.getText();
        switch (labelItem) {
            case "Refaire":
                // traitement
                break;
            case "Nouvelle Partie":
                plat.NouveauPlateau(plat.lignes(), plat.colonnes());
                vj.repaint();
                break;
            case "Sauvegarder":
                // traitement
                break;
            default:
                System.out.println("Bouton non implémenté");
                break;
        }
    }

}
