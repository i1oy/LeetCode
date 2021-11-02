import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] candyType = new int[] {1,1,2,2,3,3};
        int[] candyType2 = new int[]{1,2,3,4,5,6};
        int[] candyType3 = new int[]{6,6,6,6,6,};
        Solution app = new Solution();
        System.out.println(app.distributeCandies(candyType));
        System.out.println(app.distributeCandies(candyType2));
        System.out.println(app.distributeCandies(candyType3));
    }

    public int distributeCandies(int[] candyType) {
        int half = candyType.length / 2;
        Set<Integer> candySet = new HashSet<>();
        for (int candy : candyType) {
            candySet.add(candy);
        }
        return candySet.size() >= half ? half : candySet.size();
    }
}
