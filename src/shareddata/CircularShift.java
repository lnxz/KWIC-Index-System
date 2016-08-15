package shareddata;

import java.util.ArrayList;

/*
 * Author: Bevin Seetoh Jia Jin;
 * Matric: A0134234R;
 */

/**
 * Circular Shift module that generates pairs of indexes based on the shared data storage
 */
public class CircularShift {
    /**
     * Performs circular shift based on the ArrayList in the shared data storage
     * 
     * @return an ArrayList of Pairs that indicates the line number and starting index to read from
     */
    public static ArrayList<Pair> shift() {
        ArrayList<Pair> shiftedList = new ArrayList<Pair>();
        
        for (int i = 0; i < Main.wordList.size(); i++) {
            String[] words = Main.wordList.get(i).split(" ");
            
            for (int j = 0; j < words.length; j++) {
                shiftedList.add(new Pair(i,j));
            }
        }
        
        return shiftedList;
    }
}
