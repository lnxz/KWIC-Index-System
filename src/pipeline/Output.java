package pipeline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Author: Lee Wei Jie Shaun
 * Matric: A0125497W;
 */

/**
 * Filter 4 - Output : Process output of the array from previous filter; Final
 * filter in the pipe
 * 
 * @param alphabetizedList
 *            alphabetized list from previous filter
 */
public class Output {

	/**
	 * Formats the output of the sentences ; Keywords start with upper case and
	 * the rest lower case ; Ignored words are in full lower case
	 * 
	 * @param ignoreList
	 *            List of words to ignore, words in this list will be set to
	 *            full lower case
	 * @param alphabetizedList
	 *            List of strings from previous filter to be processed
	 */
	public static ArrayList<String> outputFilter(List<String> ignoreList, List<String> alphabetizedList) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> newList = new LinkedList<String>();
		ArrayList<String> result = new ArrayList<String>();
		 
		// Split the line into a LinkedList of words
		for (int i = 0; i < alphabetizedList.size(); i++) {
			StringTokenizer st = new StringTokenizer(alphabetizedList.get(i));
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			// Check if each individual word is a keyword or ignored
			for (int j = 0; j < list.size(); j++) {
				boolean isIgnored = false;
				for (int k = 0; k < ignoreList.size(); k++) {
					if (list.get(j).equalsIgnoreCase(ignoreList.get(k))) {
						isIgnored = true;
					}
				}
				// If ignored, all to lower case
				if (isIgnored) {
					newList.add(list.get(j).toLowerCase());
				} else {
					// If not ignored, first letter upper case and the rest
					// lower case
					String tempString = "";
					tempString = list.get(j).substring(0, 1).toUpperCase();
					tempString = tempString + list.get(j).substring(1, list.get(j).length()).toLowerCase();
					newList.add(tempString);
				}
			}
			
			// Recombines the linkedList into a string
			String recombinedLine = "";
			for (int k = 0; k < newList.size(); k++) {
				recombinedLine = recombinedLine + newList.get(k);
				if (k != newList.size() - 1) {
					recombinedLine = recombinedLine + " ";
				}
			}
			result.add(recombinedLine);
			
			// Clears the list after each "sentence"
			newList.clear();			
			list.clear();
			
		}
		return result;
	}
}
