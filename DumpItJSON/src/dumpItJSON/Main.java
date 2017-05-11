package dumpItJSON;

import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

	public static ArrayList<String> locateStr(String Str, String splitStr) {
		ArrayList<String> retVar = new ArrayList<String>();

		for (String retval : Str.split(splitStr)) {
			retVar.add(retval);
		}
		return retVar;

	}

	public static String cleanStr(String str) {
		String retVal = str.replace(" ", "");

		retVal = retVal.replace("divclass", "");
		retVal = retVal.replace("conj-person", "#");
		retVal = retVal.replace("conj-result", "#");
		retVal = retVal.replace("=", "");
		retVal = retVal.replace("<", "");
		retVal = retVal.replace(">", "");
		retVal = retVal.replace("div", "#");
		retVal = retVal.replace("/", "");
		retVal = retVal.replace("\"", "");
		retVal = retVal.replace("##", "#");

		int cutStart = retVal.indexOf("##");
		if (cutStart > 0)
			retVal = retVal.substring(0, cutStart);
		cutStart = retVal.indexOf("###");
		if (cutStart > 0)
			retVal = retVal.substring(0, cutStart);

		retVal.substring(0, retVal.length() - 2);
		return retVal;

	}

	public static String KeepOneDiv(String str) {
		String retVal = str;
		int cutStart = retVal.indexOf("div>");
		if (cutStart > -1)
			retVal = retVal.substring(0, cutStart - 2);

		retVal = retVal.replace("person\">", "lvl3in:");
		retVal = retVal.replace("result\">", "lvl3out:");

		retVal = retVal.replace("block container result-block", "lvl1:");
		retVal = retVal.replace("tense-block-header", "lvl2:");

		retVal = retVal.replace("<h3>", "");
		retVal = retVal.replace("\">", "");
		retVal = retVal.replace("</h3", "");
		retVal = retVal.replace("  ", "");
		retVal = retVal.replace("div class=", "");
		retVal = retVal.replace("><\"", "");
		retVal = retVal.replace(">", "");

		return retVal;
	}

	public static ArrayList<String> cleanStrPerfectDiv(String str) {
		ArrayList<String> splitDiv = new ArrayList<String>();
		ArrayList<String> retVal = new ArrayList<String>();

		splitDiv = locateStr(str, "conj-");

		for (String string : splitDiv) {
			if (string.indexOf("person") > -1 || string.indexOf("result") > -1 || string.indexOf("h3>") > -1) {
				string = KeepOneDiv(string);
				retVal.add(string);
			}
		}

		return retVal;

	}


	public static void main(String[] args) throws Exception {
		URLReader ur = new URLReader();

		ArrayList<String> allebojninger = new ArrayList<String>();
		ArrayList<String> par = new ArrayList<String>();

		ArrayList<String> strukturListe = new ArrayList<String>();
		
		String word = "correr";

		allebojninger = locateStr(ur.run(word), "conj-item");

		for (String string : allebojninger) {
			par = locateStr(string, "conj-person\\>");
			for (String stringpar : par) {
				strukturListe.addAll(cleanStrPerfectDiv(stringpar));
			}

		}

		for (String string : strukturListe) {
			System.out.println(string);
		}

		FileWriter writer = new FileWriter(".\\outputLine_" + word + ".txt");

		writer.write("DumpItJSON : " + word);
		writer.write("\r\n");

		for (String str : strukturListe) {
			str = str.toString();
			writer.write(str);
			writer.write("\r\n");
		}
		writer.close();

	}

}
