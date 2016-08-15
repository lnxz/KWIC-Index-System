package shareddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
    public static ArrayList<Pair> alphabetize(ArrayList<Pair> list) {
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                String[] lineOne = Main.wordList.get(p1.getLine()).split(" ");
                String[] lineTwo = Main.wordList.get(p2.getLine()).split(" ");
                
                //Compare the next word if the first word is the same
                if (lineOne[p1.getIndex()].equalsIgnoreCase(lineTwo[p2.getIndex()])) {
                    int indexOne = (p1.getIndex() + 1) % lineOne.length;
                    int indexTwo = (p2.getIndex() + 1) % lineTwo.length;
                    return compare(new Pair(p1.getLine(), indexOne), new Pair(p2.getLine(), indexTwo));
                } else {
                    return lineOne[p1.getIndex()].compareToIgnoreCase(lineTwo[p2.getIndex()]);
                }
            }
        });
        
        return list;
    }
}
