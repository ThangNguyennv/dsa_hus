package Hw2_23001938_NguyenVanThang.bai4;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word) {
        this.word = word;
        count = 1;
    }

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void upCount() {
        count++;
    }

    @Override
    public String toString() {
        return "[" + word + ": " + count + "]";
    }

    public boolean equals(Object o) {
        if(o == null)
            return false;
        if( o == this)
            return true;
        if(o instanceof WordCount) {
            WordCount ow = (WordCount) o;
            if(ow.word.compareTo(word) == 0)
                return true;
            else
                return false;
        }
        return false;
    }
}
