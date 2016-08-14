package shareddata;

import java.util.ArrayList;

public class Main {
    
    static ArrayList<String> ignoreList;
    static ArrayList<String> wordList;
    
    public static void main(String[] args) {
        Input.readInput();
        
        for (String s : ignoreList)
            System.out.println("|" + s + "|");
        
        for (String s : wordList)
            System.out.println("|" + s + "|");
    }
}
