package vue;
public interface CollecteurEvenements {
  //implementee dans Controleur/Mediateur
  void souris (int x, int y, int bouton);
  void clavier (String bouton);
}
