package shareddata;

import java.util.ArrayList;

public class CircularShift {
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
