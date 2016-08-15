package shareddata;

import java.util.ArrayList;

/*
 * Author: Bevin Seetoh Jia Jin;
 * Matric: A0134234R;
 */

public class Main {
    
    static ArrayList<String> ignoreList;
    static ArrayList<String> wordList;
    
    public static void main(String[] args) {
        Input.read();
        ArrayList<Pair> shiftIndexes = CircularShift.shift();
        ArrayList<Pair> alphabetizedIndexes = Alphabetizer.alphabetize(shiftIndexes);
        Output.print(alphabetizedIndexes);
    }
}
