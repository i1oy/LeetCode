import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void arrayRankTransform() {
        assertArrayEquals(new int[]{4, 1, 2, 3},
                app.arrayRankTransform(new int[]{40, 10, 20, 30}));
    }

    @org.junit.jupiter.api.Test
    void arrayRankTransform2() {
        assertArrayEquals(new int[]{1, 1, 1},
                app.arrayRankTransform(new int[]{10, 10, 10}));
    }

    @org.junit.jupiter.api.Test
    void arrayRankTransform3() {
        assertArrayEquals(new int[]{1, 1, 2},
                app.arrayRankTransform(new int[]{10, 10, 50}));
    }

    @org.junit.jupiter.api.Test
    void arrayRankTransform4() {
        assertArrayEquals(new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3},
                app.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}));
    }

    @org.junit.jupiter.api.Test
    void arrayRankTransform5() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5},
                app.arrayRankTransform(new int[]{-1000000000, 10, 20, 30, 1000000000}));
    }
}