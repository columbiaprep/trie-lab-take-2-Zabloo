import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        Scanner in = null;
        try {
            in = new FileInputSream("names.txt");
            String n;
            while (n = in.read() != "")
                t.insert(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
