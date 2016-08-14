package pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter 1 - Input : processes input into data structure ( list )
 * 
 * @param ignoreList
 *            strings to ignore
 * @return array containing the strings input
 */
public class Input {
	public static void inputPipe(List<String> ignoreList) {
		List<String> wordList = new ArrayList<String>();

		// TODO get input
		
		CircularShift.circularShiftPipe(ignoreList, wordList);
	};
}
