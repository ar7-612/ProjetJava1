package Sources.Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Vuejeu extends JComponent {
    Graphics2D drawable;
    int largeur;
    int hauteur;

    Plateau plat;
    int largeurCase;
    int hauteurCase;
    Random r;

    public Vuejeu(Plateau p) {
        plat = p;
    }

    @Override
    public void paintComponent(Graphics g) {
        drawable = (Graphics2D) g;
        largeur = getSize().width;
        hauteur = getSize().height;
        drawable.clearRect(0, 0, largeur, hauteur);
        tracerplateau();
        r = new Random();
    }

    public void tracerJeu() {
        int i = 0;
        int j = 0;
        while (i < plat.lignes()) {
            j = 0;
            while (j < plat.colonnes()) {
                if (plat.contenu(i, j) == 1) {
                    tracerCroix(j * largeurCase, i * largeurCase, largeurCase, hauteurCase);
                }
                if (plat.contenu(i, j) == 2) {
                    tracerOvale(j * largeurCase, i * largeurCase, largeurCase, hauteurCase);
                }
                j++;
            }
            i++;
        }
    }

    public void tracerplateau() {
        largeurCase = largeur / plat.colonnes();
        hauteurCase = hauteur / plat.lignes();

        largeurCase = Math.min(largeurCase, hauteurCase);
        hauteurCase = largeurCase;

        int i, j;
        int x = 0;
        int y = 0;
        int tailleColonnes = hauteurCase * plat.lignes();
        int tailleLignes = largeurCase * plat.colonnes();

        for (i = 0; i < plat.colonnes(); i++) {
            x = i * largeurCase;
            for (j = 0; j < plat.lignes(); j++) {
                y = j * hauteurCase;
                tracerCase(x, y, x + largeurCase - 1, y + hauteurCase - 1, plat.contenu(j, i));
            }
        }
        x = 0;
    }

    public void tracerCase(int x, int y, int largeurCase, int hauteurCase, int content) {
        if (content == 1) {
            drawable.setColor(new Color(255, 255, 255));
            drawable.drawRect(x, y, largeurCase, hauteurCase);
            drawable.fillRect(x, y, largeurCase + 1, hauteurCase + 1);
            drawable.setColor(new Color(218, 165, 32));
            drawable.drawRect(x, y, largeurCase, hauteurCase);
        } else if (content == 2) {
            drawable.setColor(new Color(218, 165, 32));
            drawable.drawRect(x, y, largeurCase, hauteurCase);
            drawable.setColor(new Color(139, 69, 19));
            drawable.fillRect(x, y, largeurCase, hauteurCase);
            drawable.setColor(new Color(0, 128, 0));
            drawable.fillOval(x, y + 2, largeurCase - 4, hauteurCase - 4);
        } else {

            drawable.setColor(new Color(139, 69, 19));
            drawable.fillRect(x, y, largeurCase, hauteurCase);
            drawable.setColor(new Color(218, 165, 32));
            drawable.drawRect(x, y, largeurCase + 1, hauteurCase + 1);
        }
    }

    public void tracerCroix(int x, int y, int largeurCase, int hauteurCase) {
        drawable.setColor(new Color(0, 0, 0));
        drawable.drawLine(x + 2, y + 2, x + largeurCase - 2, y + hauteurCase - 2);
        drawable.drawLine(x + 2, y + hauteurCase - 2, x + largeurCase - 2, y + 2);
    }

    public void tracerOvale(int x, int y, int largeurCase, int hauteurCase) {
        drawable.setColor(new Color(0, 0, 0));
        drawable.drawOval(x + 2, y + 2, largeurCase - 5, hauteurCase - 5);
    }

    public int largeurCase() {
        return largeurCase;
    }

    public int hauteurCase() {
        return hauteurCase;
    }

    public int largeur() {
        return largeur;
    }

    public int hauteur() {
        return hauteur;
    }

}
