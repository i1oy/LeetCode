public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.findPoisonedDuration(new int[]{1}, 2));
        System.out.println(app.findPoisonedDuration(new int[]{1, 2}, 2));
        System.out.println(app.findPoisonedDuration(new int[]{1, 2}, 9));
        System.out.println(app.findPoisonedDuration(new int[]{1, 2, 9}, 9));
        System.out.println(app.findPoisonedDuration(new int[]{1, 2, 12}, 9));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int startTime = -1, endTime = -1;
        for (int t : timeSeries) {
            if (endTime < t) {
                res += (endTime - startTime);
                startTime = t;
                endTime = t + duration;
            } else if (endTime < t + duration) {
                endTime = t + duration;
            }
        }
        res += (endTime - startTime);
        return res;
    }
}
