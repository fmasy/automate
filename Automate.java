class ClasseDeSymboles {
    private char[] valeurs;
    public ClasseDeSymboles(char[] valeurs) {
	this.valeurs = valeurs;
    }
    
    public boolean appartient(char v){
	for(int i=0; i<valeurs.length;i++){
	    if(valeurs[i] == v){
		return true;
	    }
	}
	return false;
    }
}

/**
 */
class Liste {
    int etat; //
    Liste suivant; //la liste des états de transition
    Liste(int e, Liste x) {
	etat = e;
	suivant = x;
    }

    public static int longueur(Liste x){
	if( x == null) {
	    return 0;
	}
	else {
	    return 1 + longueur(x.suivant);
	}
    }

    public static int kieme(Liste x, int k) {
	if( k == 1) {
	    return x.etat;
	}
	else {
	    return kieme(x.suivant, k-1);
	}
    }

    public static boolean estDans(Liste x, int e){
	if(x == null){
	    return false;
	}
	else {
	    return x.etat == e || estDans(x.suivant,e);
	}
    }
}

class Automate {
    ClasseDeSymboles[] alphabet;
    int q0; //etat initial
    Liste[][] delta; //fonction de transition
    Liste finaux; //etats finaux
    Automate(ClasseDeSymboles[] alpha, int q, Liste[][] d, Liste f) {
	alphabet = alpha;
	q0 = q;
	delta = d;
	finaux = f;
    }

    public static boolean accepter(String mot, Automate a) {
	return accepter(mot,a, 0, a.q0);
    }

    public static boolean accepter(String mot, Automate a, int i, int etat){
	if( i == mot.length() ) {
	    return Liste.estDans(a.finaux, etat);
	} 
	else {
	    boolean resultat = false;
	    int c = mot.charAt(i);
	    int code = a.codeDuSymbole(c);
	    for(Liste nv_q = a.delta[etat][code]; nv_q != null; nv_q = nv_q.suivant) {
		resultat = resultat || accepter(mot, a, i+1, nv_q.etat);
	    }
	    return resultat;
	}
    }

    public int codeDuSymbole(int c){
	for(int i=0;i<alphabet.length;i++){
	    if(alphabet[i].appartient((char)c)){
		return i;
	    }
	}
	return -1;
    }

}

