import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.largestPerimeter(new int[]{
                2, 1, 2
        }));
        System.out.println(app.largestPerimeter(new int[]{
                1, 2, 1
        }));
        System.out.println(app.largestPerimeter(new int[]{
                3, 2, 3, 4
        }));
        System.out.println(app.largestPerimeter(new int[]{
                3, 6, 2, 3
        }));
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 1] + A[i - 2] > A[i])
                return A[i - 1] + A[i - 2] + A[i];
        }
        return 0;
    }
}
