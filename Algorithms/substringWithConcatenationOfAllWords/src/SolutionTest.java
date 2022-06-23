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
    void findSubstring() {
        assertArrayEquals(
                new Integer[]{0, 9},
                (app.findSubstring("barfoothefoobarman",
                        new String[]{"foo", "bar"})).toArray());
    }

    @Test
    void findSubstring2() {
        assertArrayEquals(
                new Integer[]{},
                (app.findSubstring("wordgoodgoodgoodbestword",
                        new String[]{"word", "good", "best", "word"}).toArray())
        );
    }

    @Test
    void findSubstring3() {
        // "barfoofoobarthefoobarman"
        // ["bar","foo","the"]
        assertArrayEquals(
                new Integer[]{6,9,12},
                (app.findSubstring("barfoofoobarthefoobarman",
                        new String[]{"bar","foo","the"}).toArray())
        );
    }

    @Test
    void findSubstring4() {
        // "wordgoodgoodgoodbestword"
        // ["word","good","best","good"]
        assertArrayEquals(
                new Integer[]{8},
                (app.findSubstring("wordgoodgoodgoodbestword",
                        new String[]{"word","good","best","good"}).toArray())
        );
    }

    @Test
    void findSubstring5() {
        // "lingmindraboofooowingdingbarrwingmonkeypoundcake"
        // ["fooo","barr","wing","ding","wing"]
        assertArrayEquals(
                new Integer[]{13},
                (app.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                        new String[]{"fooo","barr","wing","ding","wing"}).toArray())
        );
    }

    @Test
    void findSubstring6() {
        assertArrayEquals(
                new Integer[]{0},
                (app.findSubstring("a",
                        new String[]{"a"}).toArray())
        );
    }

    @Test
    void findSubstring7() {
        assertArrayEquals(
                new Integer[]{},
                (app.findSubstring("a",
                        new String[]{"a", "a"}).toArray())
        );
    }

}