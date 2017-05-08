package dumpItJSON;

public class Main {

	static verb v1 = new verb("correr");

	public static void main(String[] args) throws Exception {
		URLReader ur = new URLReader();
		v1.baseVerb = "correr";
		// v1.verbMatrix[sorteOrd.Indicativo.ordinal()][rodeOrd.Indicativo_presente.ordinal()]
		// [resultat.yo.ordinal()] = "corro";
		// v1.verbMatrix[sorteOrd.Indicativo.ordinal()][rodeOrd.Indicativo_presente.ordinal()]
		// [resultat.tú.ordinal()] = "corres";

		v1.verbMatrix[0][0][0] = "corro";

		ur.run();
	}

}
