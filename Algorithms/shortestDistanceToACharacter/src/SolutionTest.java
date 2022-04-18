import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void shortestToChar() {
        assertArrayEquals(
                new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0},
                app.shortestToChar("loveleetcode", 'e')
        );
    }

    @org.junit.jupiter.api.Test
    void shortestToChar2() {
        assertArrayEquals(
                new int[]{3, 2, 1, 0},
                app.shortestToChar("aaab", 'b')
        );
    }
}