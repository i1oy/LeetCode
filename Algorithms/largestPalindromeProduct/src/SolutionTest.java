import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;
    @org.junit.jupiter.api.BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void largestPalindrome() {
        assertEquals(9, app.largestPalindrome(1));
        assertEquals(987, app.largestPalindrome(2));
        assertEquals(677, app.largestPalindrome(5));
    }
}