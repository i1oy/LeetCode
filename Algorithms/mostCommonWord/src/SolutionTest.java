import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app = null;
    @org.junit.jupiter.api.BeforeEach
    void init() {
        if (app == null) app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void mostCommonWord() {
        assertEquals("ball",
                app.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                        new String[]{"hit"}));
    }

    @org.junit.jupiter.api.Test
    void mostCommonWord2() {
        assertEquals("a",
                app.mostCommonWord("a.",
                        new String[]{"hit"}));
    }

    @org.junit.jupiter.api.Test
    void mostCommonWord3() {
        assertEquals("b",
                app.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}