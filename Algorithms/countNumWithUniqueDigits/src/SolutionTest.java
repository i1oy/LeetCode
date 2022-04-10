import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void countNumbersWithUniqueDigits() {
        assertEquals(1, app.countNumbersWithUniqueDigits(0));
        assertEquals(10, app.countNumbersWithUniqueDigits(1));
        assertEquals(91, app.countNumbersWithUniqueDigits(2));
        assertEquals(739, app.countNumbersWithUniqueDigits(3));
    }
}