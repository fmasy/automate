class Javanais {
    public static void main(String[] args) {
	/*
	  L'alphabet est un tableau de ClassesDeSymbole.
	 */
	ClasseDeSymboles[] alphabet = new ClasseDeSymboles[4];
	alphabet[0] = new ClasseDeSymboles(new char[]{'a'});
	alphabet[1] = new ClasseDeSymboles(new char[]{'v'});
	alphabet[2] = new ClasseDeSymboles(new char[]{'a','e','i','o','u','y'});
	alphabet[3] = new ClasseDeSymboles(new char[]{'b','c','d','e','f','g','h','i','j','k','l',
					     'm','n','o','p','q','r','s','t','v','w','x','z'});
	
	/*
	  index de la première dimension = etat
	  index de la seconde  dimension = index du symbole dans le tableau alphabet
	  
	 */
	Liste[][] delta = new Liste[4][4];
	delta[0][0] = new Liste(1, null);
	delta[0][3] = new Liste(0, null);
	delta[1][1] = new Liste(2, null);
	delta[2][0] = new Liste(3, null);
	delta[2][2] = new Liste(3, null);
	delta[3][2] = new Liste(3, null);
	delta[3][3] = new Liste(0, null);
	delta[3][1] = new Liste(0, null);
	
	Liste finaux = new Liste(0, new Liste(3, null));
	Automate a = new Automate(alphabet, 0, delta, finaux);

	System.out.println("accepter = " + Automate.accepter(args[0], a));
    }
}