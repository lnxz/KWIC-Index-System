package pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter 2 - Circular Shift : Performs circular shift on the array
 * 
 * @param wordList
 *            input string from previous filter
 * @param ignoreList
 *            strings to ignore
 * @return unordered array of different combinations after circular shifts
 */

public class CircularShift {

	public static void circularShiftPipe(List<String> ignoreList, List<String> wordList) {
		// TODO implement circular shift logic
		
		List<String> shiftedList = new ArrayList<String>();
		Alphabetize.alphabetizerPipe(ignoreList, shiftedList);
	}
}
