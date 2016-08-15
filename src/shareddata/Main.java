package shareddata;

import java.util.ArrayList;

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
