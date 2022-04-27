import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void sortArrayByParity() {
        assertArrayEquals(new int[]{4, 2, 1, 3},
                app.sortArrayByParity(new int[]{
                        3, 1, 2, 4
                }));
    }

    @org.junit.jupiter.api.Test
    void sortArrayByParity2() {
        assertArrayEquals(new int[]{0},
                app.sortArrayByParity(new int[]{0}));
    }
}