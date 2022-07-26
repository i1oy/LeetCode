import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void asteroidCollision() {
        assertArrayEquals(new int[]{5, 10},
                app.asteroidCollision(new int[]{5, 10, -5}));
    }

    @org.junit.jupiter.api.Test
    void asteroidCollision2() {
        assertArrayEquals(new int[]{},
                app.asteroidCollision(new int[]{8, -8}));
    }

    @org.junit.jupiter.api.Test
    void asteroidCollision3() {
        assertArrayEquals(new int[]{10},
                app.asteroidCollision(new int[]{10, 2, -8}));
    }

    @org.junit.jupiter.api.Test
    void asteroidCollision5() {
        assertArrayEquals(new int[]{-2, -1, 1, 2},
                app.asteroidCollision(new int[]{-2, -1, 1, 2}));
    }

    @org.junit.jupiter.api.Test
    void asteroidCollision6() {
        assertArrayEquals(new int[]{-2, -2, -2},
                app.asteroidCollision(new int[]{-2, -2, 1, -2}));
    }
}