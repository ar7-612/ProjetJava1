package Sources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
    Testmain window;

    public BtnMenuListener(JMenuItem item, Testmain m) {
        this.item = item;
        window = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String labelItem = this.item.getText();
        switch (labelItem) {
            case "Refaire":
                // traitement
                break;
            case "Nouvelle Partie":
                // traitement
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
