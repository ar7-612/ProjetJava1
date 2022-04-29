package Sources.Modele;

import javax.swing.*;

public class Testmain implements Runnable {
    InterfaceGraphique MonInterface;
    JButton nouvellePartie;
    JFrame frame;

    public void run() {

        frame = new JFrame("TestJeu");
        MonInterface = new InterfaceGraphique();
        MonInterface.demarre(frame, 6, 7);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 510);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Testmain());
    }

}
