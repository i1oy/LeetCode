import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @org.junit.jupiter.api.Test
    void areNumbersAscending() {
        assertTrue(app.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

    @org.junit.jupiter.api.Test
    void areNumbersAscending2() {
        assertFalse(app.areNumbersAscending("hello world 5 x 5"));
    }
}