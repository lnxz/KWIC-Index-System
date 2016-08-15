package pipeline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Filter 2 - Circular Shift : Performs circular shift on the array; Calls next
 * filter (Alphabetizer) when done with this filter
 * 
 * @param wordList
 *            input string from previous filter
 * @param ignoreList
 *            strings to ignore
 */

public class CircularShift {

	public static void circularShiftFilter(List<String> ignoreList, List<String> wordList) {

		List<String> shiftedList = new ArrayList<String>();
		LinkedList<String> list = new LinkedList<String>();

		// Split each sentence in the wordList into a linkedList of individual
		// words
		for (int i = 0; i < wordList.size(); i++) {
			StringTokenizer st = new StringTokenizer(wordList.get(i));
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			// Calls performShifts function
			performShifts(list, ignoreList, shiftedList);

			// Clears the list after each performShift
			list.clear();
		}
		Alphabetize.alphabetizerFilter(ignoreList, shiftedList);
	}

	/**
	 * Performs the circular shift function on the individual linkedList of
	 * words, exhaustively by removing the first word and appending it at the
	 * end of the line to create a set of circularly shifted lines. Also ignores
	 * a particular "sentence" if it begins with a ignored word
	 * 
	 * @param list
	 *            A linkedList of words to perform circular shift on
	 * @param ignoreList
	 *            List of words to ignore, circular shifts with the starting
	 *            word in the ignore list will be ignored
	 * @param shiftedList
	 *            List of shifted sentences after circularShift has been
	 *            performed
	 */
	private static void performShifts(LinkedList<String> list, List<String> ignoreList, List<String> shiftedList) {

		boolean isIgnored = false;
		for (int i = 0; i < list.size(); i++) {
			isIgnored = false;
			for (int j = 0; j < ignoreList.size(); j++) {
				// Iterates through the ignore list to check if the first word
				// of the "sentence" begins with an ignored word
				if (list.peek().equalsIgnoreCase(ignoreList.get(j))) {
					isIgnored = true;
				}
				if (!isIgnored) {
					// Recombines the words in the linkedList to form a sentence
					// and add it to shiftedList
					String recombinedLine = "";
					for (int k = 0; k < list.size(); k++) {
						// Lower case everything for alphabetical sort to work correctly
						recombinedLine = recombinedLine + list.get(k).toLowerCase();
						if (k != list.size() - 1) {
							recombinedLine = recombinedLine + " ";
						}
					}
					if (j == ignoreList.size() - 1) {
						shiftedList.add(recombinedLine);
					}
				}
			}

			// Removes first word and append to back of the linkedList
			String temp = list.pop();
			list.add(temp);
		}
	}
}
