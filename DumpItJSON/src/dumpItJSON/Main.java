package dumpItJSON;

import dumpItJSON.verb.resultat;
import dumpItJSON.verb.rodeOrd;
import dumpItJSON.verb.sorteOrd;

public class Main {
	
	static verb correr = new verb();
	
	public static void main(String[] args) {
		correr.baseVerb = "correr";
		correr.verbMatrix[sorteOrd.Indicativo.ordinal()]
				[rodeOrd.Indicativo_presente.ordinal()]
				[resultat.yo.ordinal()] = "";

	}

}
