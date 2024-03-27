class Backgammon {
    public static void main(String[] args) {
	Partie partie_en_cours = new Partie();

	while(!partie_en_cours.estFinie()) {
	    partie_en_cours.lance_des();
	    System.out.print(partie_en_cours.affichage());
	    String prochain_coup = System.in.readLine();
	    int coup_a = 0;
	    int coup_b = 1;
	    partie_en_cours.jouer_coup(coup_a, coup_b);
	}

	String gagnant = partie_en_cours.gagnant();
	System.out.println("Partie remportée par " + gagnant);
    }
}
