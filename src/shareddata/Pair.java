package shareddata;

/*
 * Author: Bevin Seetoh Jia Jin;
 * Matric: A0134234R;
 */

/**
 * Pair class that indicates the line number and starting index of the data
 */
public class Pair {
    private int line;
    private int index;
    
    public Pair(int line, int index) {
        this.line = line;
        this.index = index;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
