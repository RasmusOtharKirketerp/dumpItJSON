package dumpItJSON;

public class verb {
	public enum sorteOrd {
		Indicativo, Condicional, Subjuntivo, Imperativo, Gerundio, Participio
	};

	public enum rodeOrd {
		  Indicativo_presente
		, Indicativo_pret�rito_perfecto_compuesto
		, Indicativo_pret�rito_imperfecto
		, Indicativo_pret�rito_pluscuamperfecto
		, Indicativo_pret�rito_perfecto_simple
		, Indicativo_pret�rito_anterior
		, Indicativo_futuro
		, Indicativo_futuro_perfecto
	};

	public enum resultat {
		yo, t�, �l_ella, nosotros_as, vosotros_as, ellos_ellas
	};

	public String[][][] verbMatrix =  new String[10][10][10];
	String baseVerb;
	public verb(String baseVerb) {
		super();
		this.baseVerb = baseVerb;
	}
	
	

}
