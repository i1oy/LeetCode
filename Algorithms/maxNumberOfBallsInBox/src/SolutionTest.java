import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void countBalls() {
        assertEquals(2, app.countBalls(1, 10));
    }

    @org.junit.jupiter.api.Test
    void countBalls2() {
        assertEquals(2, app.countBalls(5, 15));
    }

    @org.junit.jupiter.api.Test
    void countBalls3() {
        assertEquals(2, app.countBalls(19, 28));
    }


}