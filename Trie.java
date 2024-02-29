// Java implementation of search and insert operations
// on Trie
//Stolen and modified from Baeldung

public class Trie {
    //base of the trie
    private TrieNode root;

    public Trie() {
        root = new TrieNode(false);
    }


    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    public static void insert(String key) {
        if (key.length() == 0) return;
        key = key.toLowerCase();
        TrieNode selectedNode = root;
        for (int a = 0; a < key.length; a++) {
            char c = key.charAt(a);
            TrieNode next = selectedNode.getChildNode(c);
            if (next != null) { // if already contains character
                selectedNode = next;
                continue;
            } else { // create new character node and move to it
                selectedNode.addCharAsChildNode(c);
                selectedNode = selectedNode.getChildNode(c);
            }
        }
        selectedNode.isEndOfWord = true;
    }


    public static boolean search(String n) {
        TrieNode selectedNode = root;
        for (int a = 0; a < n.length; a++) {
            char c = key.charAt(a);
            TrieNode next = selectedNode.getChildNode(c);
            if (next == null) return false;
        }
        // when reach final node, it should be an end of word if the trie contains our input
        return selectedNode.isEndOfWord();
    }
}