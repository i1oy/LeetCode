import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private Solution app;

    @BeforeEach
     void init() {
        app = new Solution();
    }

    @Test
    void test1() {
        int[] nums = new int[]{2,2,1};
        assertEquals(1, app.singleNumber(nums));
    }

    @Test
    void test2() {
        int[] nums = new int[]{4,1,2,1,2};
        assertEquals(4, app.singleNumber(nums));
    }

    @Test
    void test3() {
        int[] nums = new int[]{1};
        assertEquals(1, app.singleNumber(nums));
    }
}