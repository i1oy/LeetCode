import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @Test
    void sortPeople() {
        Assertions.assertArrayEquals(new String[] {"Mary","Emma","John"}, app.sortPeople(
                new String[] {"Mary","John","Emma"},
                new int[] {180,165,170}
        ));
    }
}