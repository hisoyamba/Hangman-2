import java.util.*;

public class GameLogic {
    private String currentWord;
    private StringBuilder hiddenWord;
    private List<Character> usedLetters = new ArrayList<Character>();
    private Scanner scanner = new Scanner(System.in);
    private int attempt;
    private static final char HIDDEN_CHAR = '*';
    private static final String NEW_GAME = "N";
    private static final String EXIT_GAME = "E";
    private boolean isGameOver;


    private void consctructHiddenWord() {
        currentWord = DictionaryLoader.getRandomWord();
        hiddenWord = new StringBuilder(String.valueOf(HIDDEN_CHAR).repeat(currentWord.length()));

    }

    public void play() {
        System.out.println("[N]ew game or [E]xit");
        while (!isGameOver) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(NEW_GAME)) {
                attempt = 0;
                usedLetters.clear();
                consctructHiddenWord();
                while (attempt < 6 && !currentWord.equals(hiddenWord.toString())) {
                    guessingLetter();
                }
                if (currentWord.equals(hiddenWord.toString())) {
                    System.out.println("Вы выиграли!" + "\nЗагаданное слово: " + currentWord);
                } else {
                    System.out.println("Вы проиграли!" + "\n Загаданное слово: " + currentWord);
                    System.out.println(currentWord);
                }
            } else if (input.equalsIgnoreCase(EXIT_GAME)) {
                isGameOver = true;
            }
        }
    }

    private void guessingLetter() {
        System.out.println("Введите букву");
        boolean found = false;
        char letter = scanner.next().toLowerCase().charAt(0);
        if (!((letter >= 'а' && letter <= 'я') || letter == 'ё')) {
            System.out.println("Ошибка: введите русскую букву!");
            return;
        }
        if (usedLetters.contains(letter)) {
            System.out.println("Вы уже использовали эту букву!");
        } else {
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == letter) {
                    hiddenWord.setCharAt(i, letter);
                    found = true;
                }
            }
            usedLetters.add(letter);
            System.out.println("Вы использовали буквы: " + usedLetters);
            if (!found) {
                System.out.println("Такой буквы нет в загаданном слове!");
                attempt++;
                System.out.println("У вас осталось " + (6 - attempt) + " попыток");
                HangmanDrawer.draw(attempt);
            }
        }
        System.out.println(hiddenWord);
    }

}



