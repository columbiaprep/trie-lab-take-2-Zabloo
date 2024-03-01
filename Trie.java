// Java implementation of search and insert operations
// on Trie
//Stolen and modified from Baeldung

public class Trie {
    //base of the trie
    private TrieNode root;

    public Trie() {
        root = new TrieNode(false);
    }

    public TrieNode getRoot() {
        return root;
    }


    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    public void insert(String key) {
        if (key.length() == 0) return;
        key = key.toLowerCase();
        TrieNode selectedNode = root;
        for (int a = 0; a < key.length(); a++) {
            char c = key.charAt(a);
            TrieNode next = selectedNode.getChildNode(c);
            if (next != null) { // if already contains character
                selectedNode = next;
                continue;
            } else { // create new character node and move to it
                selectedNode.addCharAsChildNode(c, false);
                selectedNode = selectedNode.getChildNode(c);
            }
        }
        selectedNode.isEndOfWord = true;
    }


    public boolean search(String n) {
        TrieNode selectedNode = root;
        n = n.toLowerCase();
        for (int a = 0; a < n.length(); a++) {
            char c = n.charAt(a);
            selectedNode = selectedNode.getChildNode(c);
            if (selectedNode == null) return false;
        }
        // when reach final node, it should be an end of word if the trie contains our input
        return selectedNode.isEndOfWord;
    }

    
    // returns null if no prediction available
    public char[] predict(String n) {
        TrieNode selectedNode = root;
        for (int a = 0; a < n.length(); a++) { // go to the node where incomplete string ends
            selectedNode = selectedNode.getChildNode(n.charAt(a));
            if (selectedNode == null)
                return null;
        }
        String result = "";
        while (!selectedNode.isEndOfWord) {
            // find the first index of the selectedNode's children that exists (not null)
            // basiclaly find the first child
            int firstValidIndex = 0;
            while (selectedNode.getChildByIndex(firstValidIndex) == null) // while each child is null
                firstValidIndex++;
            selectedNode = selectedNode.getChildByIndex(firstValidIndex);
            result += TrieNode.charOfIndex(firstValidIndex);
        }

        return result.toCharArray();
    }
}