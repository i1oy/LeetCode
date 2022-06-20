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
        assertEquals("1[.]1[.]1[.]1",
                app.defangIPaddr("1.1.1.1"));
    }

    @Test
    void test2() {
        assertEquals("255[.]100[.]50[.]0",
                app.defangIPaddr("255.100.50.0"));
    }
}