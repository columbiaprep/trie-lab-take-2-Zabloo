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


    public static int indexOfChar(char c) {
        int cint = (int) Character.toLowerCase(c);
        if (cint >= 97 && cint <= 122)
            return cint - 97;
        if (c == ' ')
            return 26;
        if (c == '-')
            return 27;
        if (c == '\'')
            return 28;
        if (c == '.')
            return 29;
        if (c == '\u2019')
            return 30;
        System.out.println("char cant be converted to index: " + Character.toString(c));
        return -1;
    }

    public static char charOfIndex(int a) { // inverse of method above
        if (a >= 0 && a <= 25)
            return (char) (a + 97);
        if (a == 26)
            return ' ';
        if (a == 27)
            return '-';
        if (a == 28)
            return '\'';
        if (a == 29)
            return '.';
        if (a == 30)
            return '\u2019';
        System.out.println("index " + a + " is not associated with a valid char");
        return '\u0000';
    }



    // only accepts lowercase a-z, spaces, -, and ' and .
    public void addCharAsChildNode(char c, boolean isEndOfWord) {
        children[indexOfChar(c)] = new TrieNode(isEndOfWord);
    }

    public TrieNode getChildNode(char c) { // if returns null, then Node doesnt have the child
        return children[indexOfChar(c)];
    }
};