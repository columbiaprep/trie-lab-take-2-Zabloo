// trie node
public class TrieNode
{
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 31;

    private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    // 0-25 is a-z
    // 26 is space
    // 27 is -
    // 28 is ' (left quote)
    // 29 is .
    // 30 is ’ (right single quote)

    // isEndOfWord is true if the node represents
    // end of a word
    public boolean isEndOfWord;

    public TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    // only accepts lowercase a-z, spaces, -, and ' and .
    public void addCharAsChildNode(char c, boolean isEndOfWord) {
        int cint = (int) Character.toLowerCase(c);
        if (cint >= 97 && cint <= 122)
            children[cint - 97] = new TrieNode(isEndOfWord);
        else if (c == ' ') // space
            children[26] = new TrieNode(isEndOfWord);
        else if (c == '-') // dash
            children[27] = new TrieNode(isEndOfWord);
        else if (c == '\'') // apostrophe
            children[28] = new TrieNode(isEndOfWord);
        else if (c == '.') // period
            children[29] = new TrieNode(isEndOfWord);
        else if (c == '\u2019')
            children[30] = new TrieNode(isEndOfWord);
        else
            System.out.println("cant add character: " + Character.toString(c));
    }

    public TrieNode getChildNode(char c) { // if returns null, then Node doesnt have the child
        int cint = (int) Character.toLowerCase(c);
        if (cint >= 97 && cint <= 122)
            return children[cint - 97];
        else if (c == ' ')
            return children[26];
        else if (c == '-')
            return children[27];
        else if (c == '\'')
            return children[28];
        else if (c == '.')
            return children[29];
        else if (c == '\u2019')
            return children[30];
        System.out.println("bad character input: " + c);
        return null;
    }
};