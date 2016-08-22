package shareddata;

import java.util.ArrayList;

/*
 * Author: Bevin Seetoh Jia Jin;
 * Matric: A0134234R;
 */

public class SharedData {
    
    static ArrayList<String> ignoreList;
    static ArrayList<String> wordList;
    
    public ArrayList<String> start(String inputFile, String ignoreFile) {
        Input.read(inputFile, ignoreFile);
        ArrayList<Pair> shiftIndexes = CircularShift.shift();
        ArrayList<Pair> alphabetizedIndexes = Alphabetizer.alphabetize(shiftIndexes);
        ArrayList<String> result = Output.print(alphabetizedIndexes);
        return result;
    }
}
