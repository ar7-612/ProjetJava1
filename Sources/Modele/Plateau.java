package Sources.Modele;

public class Plateau {
    int[][] plateau;
    int nombredeligne, nombredecolonne;
    int joueur = 1;
    boolean fini;

    Plateau(int nbl, int nbc) {
        plateau = new int[nbl][nbc];
        nombredeligne = nbl;
        nombredecolonne = nbc;
        initialiseplat();
    }

    void initialiseplat() {
        plateau[0][0] = 2;
    }

    boolean Jouercoup(int ligne, int colonne) {
        boolean possible = false;
        for (int l = 0; l < nombredeligne; l++) {
            for (int c = 0; c < nombredecolonne; c++) {
                if (l >= ligne && c >= colonne) {
                    if (plateau[l][c] != 1) {
                        plateau[l][c] = 1;
                        possible = true;
                    }
                }
            }
        }
        return possible;
    }

    int contenu(int l, int c) {
        return plateau[l][c];
    }

    public int lignes() {
        return nombredeligne;
    }

    public int colonnes() {
        return nombredecolonne;
    }

    public boolean fini() {
        boolean finis = true;
        for (int l = 0; l < nombredeligne; l++) {
            for (int c = 0; c < nombredecolonne; c++) {
                if (plateau[l][c] == 0) {

                    finis = false;
                }
            }
        }
        return finis;
    }

    public int quiJoue() {
        return joueur;
    }

    public void changeJoueur() {
        if (joueur == 1) {
            joueur = 2;
        } else {
            joueur = 1;
        }
    }

}
