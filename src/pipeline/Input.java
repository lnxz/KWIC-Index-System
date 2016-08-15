package pipeline;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;

import java.util.StringTokenizer;
/*
 * Author: Lee Wei Jie Shaun
 * Matric: A0125497W;
 */

/**
 * Filter 1 - Input : processes input into data structure ( list ) ; Calls next
 * filter (CircularShift) after parsing input
 */
public class Input {
	public static void inputFilter() {

		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<String> ignoreList = new ArrayList<String>();

		parseInputFile("ignore.txt", ignoreList, 1);
		parseInputFile("input.txt", wordList, 2);

		CircularShift.circularShiftFilter(ignoreList, wordList);
	}

	/**
	 * Parses input from the ignore and input files into their respective
	 * arrayLists. Option is given as a way of allowing future additions of
	 * differently formatted input
	 * 
	 * @param path
	 *            path of the input file
	 * @param wordList
	 *            the arrayList to save the parsed input into
	 * @param option
	 *            parses the input differently depending on the option type.
	 *            Option 1 - parses ignore words in the format "X, X, X, X" into
	 *            [X][X][X][X] Option 2 - parses word list in the format
	 *            "XX XX XX, XX XX XX, XX XX XX" into [XX XX XX][XX XX XX][XX XX
	 *            XX]
	 */
	private static void parseInputFile(String path, ArrayList<String> wordList, int option) {
		ArrayList<String> tempList = new ArrayList<String>();
		String currLine;
		try {
			// Read each line of input and add it into the temporary arrayList
			BufferedReader br = new BufferedReader(new FileReader(path));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				tempList.add(currentLine);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Option 1 - parses ignore words in the format "X, X, X, X" into
		// [X][X][X][X]
		if (option == 1) {
			for (int i = 0; i < tempList.size(); i++) {
				currLine = tempList.get(i).replaceAll(",", "");
				StringTokenizer st = new StringTokenizer(currLine);
				while (st.hasMoreTokens()) {
					wordList.add(st.nextToken().toLowerCase());
				}
			}
			// Option 2 - parses word list in the format "XX XX XX, XX XX XX, XX
			// XX XX" into [XX XX XX][XX XX XX][XX XX XX]
		} else if (option == 2) {
			for (int i = 0; i < tempList.size(); i++) {
				StringTokenizer st = new StringTokenizer(tempList.get(i), ",");
				while (st.hasMoreTokens()) {
					currLine = st.nextToken();
					if (currLine.substring(0, 1).equals(" ")) {
						currLine = currLine.substring(1, currLine.length());
					}
					wordList.add(currLine);
				}
			}
		}
	}
}
