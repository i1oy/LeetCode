import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @Test
    void test() {
        assertEquals(1, app.largestAltitude(
                new int[]{-5, 1, 5, 0, -7}
        ));
    }

    @Test
    void test2() {
        assertEquals(0, app.largestAltitude(
                new int[]{-4, -3, -2, -1, 4, 3, 2}
        ));
    }
}