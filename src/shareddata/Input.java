package shareddata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * Author: Bevin Seetoh Jia Jin;
 * Matric: A0134234R;
 */

/**
 * Input module that reads text files into the shared data storage.
 */
public class Input {
    /**
     * Parses input from the text files into their respective
     * arrayLists. 
     */
    public static void read() {
        Main.ignoreList = readFile("ignore.txt");
        Main.wordList = readFile("input.txt");
    }
    
    /**
     * The words or sentences in the files are separated by the ',' character
     * 
     * @param path
     *        path of the input file
     * @return an ArrayList of Strings read from the file
     */
	public static ArrayList<String> readFile(String path) {
	    ArrayList<String> tempList = new ArrayList<String>();
        
        try {
            // Read each line of input and add it into the temporary arrayList
            BufferedReader br = new BufferedReader(new FileReader(path));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                tempList.add(currentLine);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ArrayList<String> lines = new ArrayList<String>();
        for (String line : tempList) {
            String[] sentences = line.split(",");
            
            for (String sentence : sentences) {
                sentence = sentence.toLowerCase().trim();
                
                if (!lines.contains(sentence)) {
                    lines.add(sentence);
                }
            }
        }
        
	    return lines;
	}
}
