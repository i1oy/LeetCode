import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void maxRotateFunction() {
        assertEquals(26,
                app.maxRotateFunction(
                        new int[]{
                                4, 3, 2, 6
                        }
                ));
    }
}