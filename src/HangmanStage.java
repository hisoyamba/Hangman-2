public enum HangmanStage {
    ATTEMPT_1("""
            |
            |
            |
            |
            |
            |
            """),
    ATTEMPT_2("""
             ___
            |/  |
            |
            |
            |
            |
            |
            """),
    ATTEMPT_3("""
             ___
            |/  |
            |   *
            |
            |
            |
            |
            """),
    ATTEMPT_4("""
             ___
            |/  |
            |   *
            |  /||
            |
            |
            |
            """),
    ATTEMPT_5("""
             ___
            |/  |
            |   *
            |  /||
            |   |
            |
            |
            """),
    ATTEMPT_6("""
             ___
            |/  |
            |   *
            |  /||
            |   /|
            |
            |
            """);

    private final String hangman;

    HangmanStage(String hangman) {
        this.hangman = hangman;
    }

    public String getHangmanStage() {
        return this.hangman;
    }
}
