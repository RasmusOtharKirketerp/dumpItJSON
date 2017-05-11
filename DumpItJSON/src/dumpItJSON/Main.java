package dumpItJSON;

import java.util.ArrayList;

public class Main {

	public static ArrayList<String> locateStr(String Str, String splitStr, boolean debug) {
		ArrayList<String> retVar = new ArrayList<String>();

		for (String retval : Str.split(splitStr)) {
			if (debug)
				System.out.println(retval);
			retVar.add(retval);
		}

		// ystem.out.println("Count : " + retVar.size());
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
		// System.out.println(retVal);

		retVal.substring(0, retVal.length() - 2);
		return retVal;

	}

	public static String KeepOneDiv(String str) {
		String retVal = str;

		// person">yo</div> <div class="
		int cutStart = retVal.indexOf("div>");
		if (cutStart > -1)
			retVal = retVal.substring(0, cutStart-2);
		
		retVal = retVal.replace("person\">", "in:");
		retVal = retVal.replace("result\">", "out:");

		
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

	public static void cleanStrPerfectDiv(String str) {

		// "> <div class="conj-person">yo</div> <div
		// class="conj-result">corro</div> </div> <div class="

		ArrayList<String> splitDiv = new ArrayList<String>();

		splitDiv = locateStr(str, "conj-", false);

		for (String string : splitDiv) {
			// System.out.println("SplitDiv : " + string);
			if (string.indexOf("person") > -1 || string.indexOf("result") > -1 || string.indexOf("h3>") > -1)
			{
				//System.out.println("keep Line : " + string);
				string = KeepOneDiv(string);
				System.out.println(string);
			}
		}

	}

	static verb v1 = new verb("correr");

	public static void main(String[] args) throws Exception {
		URLReader ur = new URLReader();

		ArrayList<String> allebojninger = new ArrayList<String>();
		ArrayList<String> par = new ArrayList<String>();

		v1.baseVerb = "correr";

		v1.verbMatrix[0][0][0] = "corro";

		allebojninger = locateStr(ur.run(), "conj-item", false);

		int i = -1;
		for (String string : allebojninger) {
			par = locateStr(string, "conj-person\\>", false);
			for (String stringpar : par) {
				i++;
				cleanStrPerfectDiv(stringpar);
			}

		}

	}

}
