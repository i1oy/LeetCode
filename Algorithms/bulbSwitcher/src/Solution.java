public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.bulbSwitch(0));
        System.out.println(app.bulbSwitch(1));
        System.out.println(app.bulbSwitch(3));
        System.out.println(app.bulbSwitch(4));
        System.out.println(app.bulbSwitch(5));
    }
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
        //if (n <= 1) return n;
        //int res = 0;
        //boolean[] bulbs = new boolean[n];
        //for (int i = 0; i < n; i++) {
        //    bulbs[i] = true;
        //}
        //for (int i = 2; i <= n; i++) {
        //    for (int j = i; j <= n; j += i) {
        //        bulbs[j - 1] = !bulbs[j - 1];
        //    }
        //}
        //for (int i = 0; i < n; i++) {
        //    if (bulbs[i]) ++res;
        //}
        //return res;
    }
}
