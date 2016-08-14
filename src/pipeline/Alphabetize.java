package pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter 3 - Alphabetize : Reorders the shifted list of items
 * 
 * @param shiftedList
 *            shifted array from circular shift filter
 * @param ignoreList
 *            strings to ignore
 * @return array after circular shift
 */
public class Alphabetize {

	public static void alphabetizerPipe(List<String> ignoreList, List<String> shiftedList) {
		
		// TODO implement alphabetizer logic
		
		List<String> alphabetizedList = new ArrayList<String>();
		Output.outputPipe(alphabetizedList);
	}
}
