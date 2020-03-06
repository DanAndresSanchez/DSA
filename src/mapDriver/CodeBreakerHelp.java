package mapDriver;

import map.*;
import set.*;
import sort.QuickSort;
import list.*;
import java.io.*;

public class CodeBreakerHelp {
	static Map<String, Set<String>> map = new HashMap<String, Set<String>>();
	
	public static void main(String[] args) {
		buildMap();
		System.out.println("Done.");
		getWords("niaiuanmrisotzrtiiocm");
		getWords("fo");
		getWords("uealcisonlesm");
		getWords("npesoaw");
		getWords("tpso");
		getWords("nialtrenosotiaertuc");
	}
	
	// get a list of English words from a text file
	private static List<String> getWords() {
		List<String> strings = new ArrayList<String>();
		try {
			File wordFile = new File("words.txt");
			java.util.Scanner scanner = new java.util.Scanner(wordFile);
			String word;
			while (scanner.hasNextLine())
				strings.add(scanner.nextLine());
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		return strings;
	}

	/**
	 * @return the given string, with letters in alphabetic order If str is "pots"
	 *         the result should be "opst"
	 */
	private static String sort(String str) {
		List<Character> chars = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++)
			chars.add(str.charAt(i));
		//////////
		///////// Call a sorting algorithm, or sort the list of chars here.
		/////////
		QuickSort<Character> qs = new QuickSort<Character>();
		qs.sort(chars);
		String result = "";
		Iterator<Character> itty = chars.iterator();
		while (itty.hasNext())
			result += itty.next();
		return result;
	}
	
	private static void buildMap() {
		List<String> words = getWords();
		Iterator<String> itty = words.iterator();
		while(itty.hasNext()) {
			String w = itty.next();
			String s = w;
			sort(s);
			if(!(map.containsKey(s))) {
				Set<String> value = new HashSet<String>();
				value.add(w);
				map.put(s, value);
			}
			else 
				map.get(s).add(w);
		}
	}
	
	private static String getWords(String s) {
		for(int i = 0; i < map.size(); i++) {
			if(map.containsKey(s))
				return map.get(s).toString();
		}
		return "no";
	}

}