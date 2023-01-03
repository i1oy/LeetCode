public class Solution {
    /**
     * 1732. Find the Highest Altitude
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int res = 0, altitude = 0;
        for (int a : gain) {
            altitude += a;
            res = res < altitude ? altitude : res;
        }
        return res;
    }
}
