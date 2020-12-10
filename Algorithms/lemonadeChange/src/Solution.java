public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.lemonadeChange(new int[]{
                        5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5
                })
        );
        System.out.println(
                app.lemonadeChange(new int[]{
                        5, 5, 5, 10, 20
                })
        );
        System.out.println(
                app.lemonadeChange(new int[]{
                        5, 5, 10
                })
        );

    }

    public boolean lemonadeChange(int[] bills) {
        int[] balances = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                balances[0]++;
            } else if (bill == 10) {
                if (balances[0] > 0) {
                    balances[1]++;
                    balances[0]--;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (balances[0] > 0 && balances[1] > 0) {
                    balances[0]--;
                    balances[1]--;
                } else if (balances[0] >= 3) {
                    balances[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
