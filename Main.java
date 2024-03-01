import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        try {
            File file = new File("names.txt");
            Scanner reader = new Scanner(file);
            String f = reader.nextLine();
            System.out.println("First name: " + f);
            t.insert(f);
            System.out.println(t.search("Spencer brod"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
