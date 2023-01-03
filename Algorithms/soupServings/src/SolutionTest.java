import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void soupServings() {
        assertEquals(0.5, app.soupServings(0), 10e-5);
    }

    @org.junit.jupiter.api.Test
    void soupServings2() {
        assertEquals(0.625, app.soupServings(50), 10e-5);
    }

    @org.junit.jupiter.api.Test
    void soupServings3() {
        assertEquals(0.71875, app.soupServings(100), 10e-5);
    }
}