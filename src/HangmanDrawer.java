public class HangmanDrawer {
    private static HangmanStage[] hangman = HangmanStage.values();

    public static void draw(int attempt) {
        if (attempt > 0 && attempt <= hangman.length) {
            System.out.println(hangman[attempt - 1].getHangmanStage());
        }

    }
}
