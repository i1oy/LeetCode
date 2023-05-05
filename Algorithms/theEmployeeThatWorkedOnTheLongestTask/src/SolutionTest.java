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
    void Test() {
        assertEquals(1, app.hardestWorker(10, new int[][]{
                {0, 3}, {2, 5}, {0, 9}, {1, 15}
        }));
    }

    @Test
    void Test2() {
        assertEquals(3, app.hardestWorker(26, new int[][]{
                {1, 1}, {3, 7}, {2, 12}, {7, 17}
        }));
    }

    @Test
    void Test3() {
        assertEquals(0, app.hardestWorker(2, new int[][]{
                {0, 10}, {1, 20}
        }));
    }

}