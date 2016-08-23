package pipeline;

import java.util.ArrayList;

/*
 * Author: Lee Wei Jie Shaun
 * Matric: A0125497W;
 */

/**
 * Main class which starts the pipeline
 */

public class PipeAndFilter {
	public ArrayList<String> start(String inputFile, String ignoreFile) {

		// Calls the first filter of the pipe
		return Input.inputFilter(inputFile, ignoreFile);
	}
}
