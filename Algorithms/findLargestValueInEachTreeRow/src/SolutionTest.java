import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution app;

    @BeforeEach
    void init() {
        app = new Solution();
    }

    @Test
    void findLargestValuesTest() {
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, null, node9);
        TreeNode node32 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, node5, node32);
        TreeNode root = new TreeNode(1, node3, node2);
        assertArrayEquals(new Integer[]{1, 3, 9},
                app.largestValues(root).toArray());
    }

    @Test
    void findLargestValuesTest2() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, node2, node3);
        assertArrayEquals(new Integer[]{1, 3},
                app.largestValues(root).toArray());
    }

    @Test
    void findLargestValuesTest3() {
        TreeNode root = new TreeNode(1);
        assertArrayEquals(new Integer[]{1},
                app.largestValues(root).toArray());
    }
}