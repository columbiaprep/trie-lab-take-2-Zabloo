// trie node
public class TrieNode
{
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 30;

    private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    // 0-25 is a-z
    // 26 is space
    // 27 is -
    // 28 is '
    // 29 is .

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
        else if (cint == 32)
            children[26] = new TrieNode(isEndOfWord);
        else if (cint == 189) // dash
            children[27] = new TrieNode(isEndOfWord);
        else if (cint == 222) // apostrophe
            children[28] = new TrieNode(isEndOfWord);
        else if (cint == 190) // period
            children[29] = new TrieNode(isEndOfWord);
        else
            System.out.println("cant add character: " + Character.toString(c));
    }

    public TrieNode getChildNode(char c) { // if returns null, then Node doesnt have the child
        int cint = (int) Character.toLowerCase(c);
        if (cint >= 97 && cint <= 122)
            return children[cint - 97];
        else if (cint == 32)
            return children[26];
        else if (cint == 189)
            return children[27];
        else if (cint == 222)
            return children[28];
        else if (cint == 190)
            return children[29];
        System.out.println("bad character input: " + c);
        return null;
    }
};