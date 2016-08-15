package shareddata;

import java.util.ArrayList;

public class Output {
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
    
    private static String capsFormatter(String word) {
        if (isIgnored(word)) {
            return word.toLowerCase();
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }
    
    private static boolean isIgnored(String word) {
        for (String ignore : Main.ignoreList) {
            if (ignore.equalsIgnoreCase(word)) {
                return true;
            }
        }
        
        return false;
    }
}
