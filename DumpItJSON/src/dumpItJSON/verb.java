package dumpItJSON;

public class verb {
	public enum sorteOrd {
		Indicativo, Condicional, Subjuntivo, Imperativo, Gerundio, Participio
	};

	public enum rodeOrd {
		  Indicativo_presente
		, Indicativo_pretérito_perfecto_compuesto
		, Indicativo_pretérito_imperfecto
		, Indicativo_pretérito_pluscuamperfecto
		, Indicativo_pretérito_perfecto_simple
		, Indicativo_pretérito_anterior
		, Indicativo_futuro
		, Indicativo_futuro_perfecto
	};

	public enum resultat {
		yo, tú, él_ella, nosotros_as, vosotros_as, ellos_ellas
	};

	public String[][][] verbMatrix =  new String[10][10][10];
	String baseVerb;
	public verb(String baseVerb) {
		super();
		this.baseVerb = baseVerb;
	}
	
	

}
