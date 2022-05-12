import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void minDeletionSize() {
        String[] strs = new String[]{
                "cba", "daf", "ghi"
        };
        assertEquals(1, app.minDeletionSize(strs));
    }

    @org.junit.jupiter.api.Test
    void minDeletionSize2() {
        String[] strs = new String[]{
                "a", "b"
        };
        assertEquals(0, app.minDeletionSize(strs));
    }

    @org.junit.jupiter.api.Test
    void minDeletionSize3() {
        String[] strs = new String[]{
                "zyx", "wvu", "tsr"
        };
        assertEquals(3, app.minDeletionSize(strs));
    }
}