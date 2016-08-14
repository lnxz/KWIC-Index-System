package pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) {
		
		// list of strings to ignore
		List<String> ignoreList = new ArrayList<String>();
		Collections.addAll(ignoreList,"is", "the", "of", "and", "as", "a", "after");
		Input.inputPipe(ignoreList);
		
	}
}
