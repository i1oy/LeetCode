import org.junit.jupiter.api.Assertions;
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
        assertEquals(true, app.isIdealPermutation(
                new int[] { 1, 0, 2 }
        ));
    }

    @Test
    void test2() {
        assertEquals(false, app.isIdealPermutation(
                new int[] { 1, 2, 0 }
        ));
    }
}