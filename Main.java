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
            System.out.println(t.predict("Spen"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
