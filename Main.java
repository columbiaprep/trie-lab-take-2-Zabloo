import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        try {
            File file = new File("names.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
                t.insert(reader.nextLine());
            System.out.println(t.search("Spencer brod"));
            System.out.println(t.search("Bejarano Jack"));
            System.out.println(t.search("John Doe"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
