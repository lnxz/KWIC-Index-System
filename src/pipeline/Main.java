package pipeline;

public class Main {
	
	
	public static void main(String[] args) {
		
		// list of strings to ignore
		String[] ignoreList = {"is", "the", "of", "and", "as", "a", "after"};
		
		input(ignoreList);
	}
	
	/** 
	 * Filter 1 - Input
	 * Process input into data structure ( array )
	 * 
	 * @param ignoreList 	strings to ignore
	 * @return 				array containing the strings input
	 */
	private static String[] input(String[] ignoreList)
	{
		String[] wordList = new String[256];
		
		// TODO get input
		return wordList;
	}
	
	/** 
	 * Filter 2 - Circular Shift
	 * Performs circular shift on the array
	 * 
	 * @param wordList		input string from previous filter
	 * @param ignoreList 	strings to ignore
	 * @return 				unordered array of different combinations after circular shifts
	 */
	private static String[] circularShift(String[] ignoreList, String[] wordList)
	{
		// TODO implement circular shift logic
		return wordList;
	}
	
	/** 
	 * Filter 3 - Alphabetize
	 * Reorders the shifted list of items
	 * 
	 * @param shiftedList	shifted array from circular shift filter 
	 * @param ignoreList 	strings to ignore
	 * @return 				array after circular shift
	 */
	private static String[] alphabetizer(String[] ignoreList, String[] shiftedList)
	{
		// TODO implement alphabetizer logic
		return shiftedList;
	}
	
	/** 
	 * Filter 4 - Output
	 * Process output of the array from previous filter
	 * 
	 * @param alphabetizedList		input string from previous filter	 
	 */
	private static void output(String[] alphabetizedList)
	{
		// TODO implement output logic 
	}
}
