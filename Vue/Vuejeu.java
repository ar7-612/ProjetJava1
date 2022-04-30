package Vue;

import javax.swing.*;

import Sources.Modele.Plateau;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.util.Random;

public class Vuejeu extends JComponent {
    Graphics2D drawable;
    int largeur;
    int hauteur;
    Imagegaufre gaufreM, gaufreBD, gaufreHD, gaufreBG, gaufreHG, gaufreCroqueCoin, gaufreCroqueCoinExt,
            gaufreCroqueCoteBas, gaufreCroqueCoteDroit, poison;
    Plateau plat;
    int largeurCase;
    int hauteurCase;
    Random r;

    public Vuejeu(Plateau p) {
        gaufreM = chargeImage("gaufreM");
        gaufreCroqueCoin = chargeImage("gaufreCroqueCoin");
        gaufreCroqueCoinExt = chargeImage("gaufreCroqueCoinExt");
        gaufreCroqueCoteBas = chargeImage("gaufreCroqueCoteBas");
        gaufreCroqueCoteDroit = chargeImage("gaufreCroqueCoteDroit");
        gaufreBD = chargeImage("gaufreBD");
        gaufreBG = chargeImage("gaufreBG");
        gaufreHD = chargeImage("gaufreHD");
        gaufreHG = chargeImage("gaufreHG");
        poison = chargeImage("poison");
        plat = p;
    }

    public void tracerImage(Imagegaufre img, int x, int y, int largeurCase, int hauteurCase) {
        drawable.drawImage(img.image(), x, y, largeurCase, hauteurCase, null);
    }

    private Imagegaufre chargeImage(String nom) {
        InputStream in = ClassLoader.getSystemClassLoader()
                .getResourceAsStream("Images" + File.separator + nom + ".png");
        return new Imagegaufre(in);
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

    public void tracerplateau() {
        largeurCase = largeur / plat.colonnes();
        hauteurCase = hauteur / plat.lignes();

        largeurCase = Math.min(largeurCase, hauteurCase);
        hauteurCase = largeurCase;

        int i, j;
        int x = 0;
        int y = 0;
        for (i = 0; i < plat.colonnes(); i++) {
            x = i * largeurCase;
            for (j = 0; j < plat.lignes(); j++) {
                y = j * hauteurCase;
                if (plat.contenu(j, i) == 2) {
                    tracerImage(gaufreHG, x, y, largeurCase, hauteurCase);
                    tracerImage(poison, x, y, largeurCase, hauteurCase);
                } else if (plat.contenu(j, i) == 0) {
                    if (j == 0 && i == plat.colonnes() - 1) {
                        tracerImage(gaufreHD, x, y, largeurCase, hauteurCase);
                    } else if (j == plat.lignes() - 1 && i == 0) {
                        tracerImage(gaufreBG, x, y, largeurCase, hauteurCase);
                    } else if (j == plat.lignes() - 1 && i == plat.colonnes() - 1) {
                        tracerImage(gaufreBD, x, y, largeurCase, hauteurCase);
                    } else {
                        tracerImage(gaufreM, x, y, largeurCase, hauteurCase);
                    }
                } else if (plat.contenu(j, i) == 1) {
                    if (i != 0 && j != 0 && plat.contenu(j - 1, i - 1) != 1 && plat.contenu(j, i + 1) == 1
                            && plat.contenu(j + 1, i) == 1)
                        tracerImage(gaufreCroqueCoinExt, x, y, largeurCase, hauteurCase);
                    if (i != 0 && j != 0 && plat.contenu(j, i - 1) != 1 && plat.contenu(j, i + 1) == 1)
                        tracerImage(gaufreCroqueCoteBas, x, y, largeurCase, hauteurCase);
                    if (i != 0 && j != 0 && plat.contenu(j - 1, i) != 1 && plat.contenu(j + 1, i) == 1)
                        tracerImage(gaufreCroqueCoteDroit, x, y, largeurCase, hauteurCase);
                    if (j == 0 && i == 0) {
                        tracerImage(gaufreCroqueCoin, x, y, largeurCase, hauteurCase);

                    } else {
                        if (i == 0) {
                            tracerImage(gaufreCroqueCoteBas, x, y, largeurCase, hauteurCase);
                            if (plat.contenu(j - 1, i) != 1) {
                                tracerImage(gaufreCroqueCoteDroit, x, y, largeurCase, hauteurCase);
                            }
                        }
                        if (j == 0) {
                            tracerImage(gaufreCroqueCoteDroit, x, y, largeurCase, hauteurCase);
                            if (plat.contenu(j, i - 1) != 1) {
                                tracerImage(gaufreCroqueCoteBas, x, y, largeurCase, hauteurCase);
                            }
                        }
                    }

                }
            }
        }
        x = 0;

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
