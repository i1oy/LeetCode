import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @Test
    void test() {
        int[] arr = new int[]{
                1, 0, 2, 3, 0, 4, 5, 0
        };
        app.duplicateZeros(arr);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4},
                arr);
    }

    @Test
    void test2() {
        int[] arr = new int[]{
                1, 2, 3
        };
        app.duplicateZeros(arr);
        assertArrayEquals(new int[]{1, 2, 3},
                arr);
    }

    @Test
    void test3() {
        int[] arr = new int[]{
                0, 0, 0
        };
        app.duplicateZeros(arr);
        assertArrayEquals(new int[]{0, 0, 0},
                arr);
    }
}