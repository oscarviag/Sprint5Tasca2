package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain;


public class TiradaDaus {

	/*static int cares = 6;
	static Random rand;*/
	
	public static Integer tirada(){
		
		/*Integer resultat = rand.nextInt(cares)+1;
		System.out.println("dau "+ resultat);
		return resultat;*/
		return (int) Math.floor(Math.random()*6+1);
	}
}
