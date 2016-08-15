package shareddata;

import java.util.ArrayList;

/*
 * Author: Bevin Seetoh Jia Jin;
 * Matric: A0134234R;
 */

/**
 * Output module that prints the results based on the shared data storage
 */
public class Output {
    /**
     * Prints the results in circular order based on the given list of Pairs
     * 
     * @param list
     *        ArrayList of Pairs indicating line numbers and starting indexes
     */
    public static void print(ArrayList<Pair> list) {
        for (Pair pair : list) {
            StringBuilder sb = new StringBuilder();
            String[] words = Main.wordList.get(pair.getLine()).split(" ");
            int index = pair.getIndex();
            
            for (int i = 0; i < words.length; i++) {
                String word = words[index];
                
                //If first word is found in list of ignored words
                if ((pair.getIndex() == index) && isIgnored(word)) {
                    break;
                }
                
                word = capsFormatter(word);
                
                sb.append(word + " ");
                index++;
                index = index % words.length;
            }
            
            if (!sb.toString().trim().equals("")) {
                System.out.println(sb.toString().trim());
            }
        }
    }
    
    /**
     * Formats the word according to the list of ignored words
     * 
     * @param word
     *        word to format
     * @return lower case if ignored, Camel case otherwise
     */
    private static String capsFormatter(String word) {
        if (isIgnored(word)) {
            return word.toLowerCase();
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }
    
    /**
     * Checks if the word is found in the ignored list
     * 
     * @param word
     *        word to check for
     * @return whether the word is ignored
     */
    private static boolean isIgnored(String word) {
        for (String ignore : Main.ignoreList) {
            if (ignore.equalsIgnoreCase(word)) {
                return true;
            }
        }
        
        return false;
    }
}
