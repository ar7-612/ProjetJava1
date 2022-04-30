package Sources;

import javax.swing.*;

import Sources.Modele.InterfaceGraphique;

public class Testmain implements Runnable {
    InterfaceGraphique MonInterface;
    JButton nouvellePartie;
    JFrame frame;

    public void run() {

        frame = new JFrame("Gaufre");
        MonInterface = new InterfaceGraphique();
        MonInterface.demarre(frame, 6, 7);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        frame.setSize(550, 510);
        frame.setVisible(true);
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
        frame.setJMenuBar(menuBar);

        redo.addActionListener(new BtnMenuListener(redo, this));
        newGame.addActionListener(new BtnMenuListener(newGame, this));
        save.addActionListener(new BtnMenuListener(save, this));

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Testmain());
    }

}
