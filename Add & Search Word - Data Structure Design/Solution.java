import java.util.ArrayList;
import java.util.List;

class WordDictionary {

    List<String> wordList;

    /** Initialize your data structure here. */
    public WordDictionary() {
        wordList = new ArrayList<String>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        wordList.add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        for (String wl : wordList) {
            if(wl.matches(word))
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad")); 
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */