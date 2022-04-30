package Sources;

import javax.swing.*;

import Sources.Modele.InterfaceGraphique;
import Sources.Vue.BtnMenuListener;

public class Testmain implements Runnable {
    InterfaceGraphique MonInterface;
    JButton nouvellePartie;
    JFrame frame;

    public void run() {

        frame = new JFrame("Gaufre");
        MonInterface = new InterfaceGraphique();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        frame.setSize(550, 510);
        frame.setVisible(true);
        MonInterface.demarre(frame, 6, 7);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Testmain());
    }

}
