package pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Author: Lee Wei Jie Shaun
 * Matric: A0125497W;
 */

/**
 * Filter 3 - Alphabetize : Reorders the shifted list of items; Calls next filter
 * (Output) when done with this filter
 * 
 * @param shiftedList
 *            shifted array from circular shift filter
 * @param ignoreList
 *            strings to ignore
 */
public class Alphabetize {

	/**
	 * Reorders the shifted list of items in alphabetical order
	 * 
	 * @param ignoreList
	 *            List of words to ignore, not used in this filter but needed in next filter
	 * @param shiftedList
	 *            List of shifted sentences after circularShift has been
	 *            performed
	 */
	public static ArrayList<String> alphabetizerFilter(List<String> ignoreList, List<String> shiftedList) {

		// Remove duplicates
		shiftedList = shiftedList.stream().distinct().collect(Collectors.toList());
		
		// Simple alphabetical order sort using Collections
		Collections.sort(shiftedList);
		
		// Need to pass the ignoreList for output to differentiate between
		// keywords and ignored words
		return Output.outputFilter(ignoreList, shiftedList);
	}
}
