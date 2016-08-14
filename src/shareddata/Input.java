package shareddata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Input {
    public static void readInput() {
        Main.ignoreList = readFile("ignore.txt");
        Main.wordList = readFile("input.txt");
    }
    
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
                sentence = sentence.trim();
                lines.add(sentence);
            }
        }
        
	    return lines;
	}
}
