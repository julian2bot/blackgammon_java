import java.util.ArrayList;
import java.lang.StringBuffer;

class Partie {
    protected Des les_des;
    protected ArrayList<Boolean> couleurs;
    protected ArrayList<Integer> nombre_jetons;
    static int taille_plateau = 24;
    boolean tour_de_up = false;
    int jetons_sortis_down;
    int jetons_sortis_up;
    

    public Partie() {
	this.les_des = new Des();
	this.couleurs = new ArrayList<Boolean>();
	for (int i = 0; i < taille_plateau - 1; i++)
	    this.couleurs.add(false);
	this.couleurs.add(true);
	this.nombre_jetons = new ArrayList<Integer>();
	for (int i = 0; i < taille_plateau; i++)
	    this.nombre_jetons.add(0);
	this.nombre_jetons.set(0, 6);
	this.nombre_jetons.set(taille_plateau - 1, 6);
	this.jetons_sortis_up = 0;
	this.jetons_sortis_down = 0;
    }
    
    public boolean estFinie() {
	return false;
    }

    public void lance_des() {
	this.les_des.lance();
    }

    public String affichage() {
	StringBuffer res = new StringBuffer();

	res.append("--\n");
	for (int i = 0; i < couleurs.size(); i++) {
	    res.append(i + ":");
	    String symbole;
	    if(this.couleurs.get(i))
		symbole = "^";
	    else
		symbole = "v";
	    for (int j = 0; j < this.nombre_jetons.get(i); j++)
		res.append(symbole);
	    res.append("\n");
	}
	res.append("--\n");
	
	return new String(res);
    }

    protected void jouer_coup_aux(int from, int distance) {
	int jetons_depart = this.nombre_jetons.get(from);
	
	if (jetons_depart == 0)
	    return;

	if (this.couleurs.get(from) != this.tour_de_up)
	    return;

	this.nombre_jetons.set(from, jetons_depart - 1);
	int dest;

	if (tour_de_up)
	    dest = from - distance;
	else
	    dest = from + distance;

	if (dest < 0 || taille_plateau < dest)
	    if (tour_de_up)
		jetons_sortis_up += 1;
	    else
		jetons_sortis_down += 1;
	
	int jetons_arrivee = this.nombre_jetons.get(dest);
	if (jetons_arrivee > 0 && this.couleurs.get(dest) != this.tour_de_up)
	    return;
	if (jetons_arrivee == 0)
	    this.couleurs.set(dest, this.tour_de_up);
	this.nombre_jetons.set(dest, jetons_arrivee + 1);
    }
	    
	    
    public void jouer_coup(int mvt_a, int mvt_b) {
	jouer_coup_aux(mvt_a, this.les_des.resultat1());
	jouer_coup_aux(mvt_b, this.les_des.resultat2());
	this.tour_de_up = !this.tour_de_up;
    }

    public String gagnant() {
	return "^";
    }
}
