public class Solution {

    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.getHint("1807", "7810"));
        System.out.println(app.getHint("1123", "0111"));
        System.out.println(app.getHint("1", "0"));
        System.out.println(app.getHint("1", "1"));
    }

    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int len = secret.length();
        int[] secretDigits = new int[10], guessDigits = new int[10];
        for (int i = 0; i < len; i++) {
            char secretChar = secret.charAt(i), guessChar = guess.charAt(i);
            if (secretChar == guessChar) {
                ++bulls;
            } else {
                secretDigits[secretChar - '0'] ++;
                guessDigits[guessChar - '0'] ++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += secretDigits[i] < guessDigits[i] ? secretDigits[i] :  guessDigits[i];
        }
        // return String.format("%dA%dB", bulls, cows);
        return new StringBuilder(4).append(bulls).append("A")
                .append(cows).append("B").toString();
    }
}
