import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void findKthNumber() {
        assertEquals(3, app.findKthNumber(3, 3, 5));
    }

    @org.junit.jupiter.api.Test
    void findKthNumber2() {
        assertEquals(6, app.findKthNumber(2, 3, 6));
    }
}