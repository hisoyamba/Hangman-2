import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DictionaryLoader {
    private static List<String> dictionary;

    private static void parseDictionary() {
        File file = new File("words.txt");
        dictionary = new ArrayList();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                dictionary.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }

    public static String getRandomWord() {
        if (dictionary == null) {
            parseDictionary();
        }

        Random random = new Random();
        int randomInt = random.nextInt(dictionary.size());
        return dictionary.get(randomInt);
    }
}