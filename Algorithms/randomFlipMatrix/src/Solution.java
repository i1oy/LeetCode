import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int m = 6, n = 1;
        Solution app = new Solution(m, n);
        for (int i = 0; i < m * n; i++) {
            int[] flip = app.flip();
            System.out.format("[%s, %s]\n", flip[0], flip[1]);
        }
        System.out.println("RESET");
        app.reset();
        for (int i = 0; i < (m * n) >> 1; i++) {
            int[] flip = app.flip();
            System.out.format("[%s, %s]\n", flip[0], flip[1]);
        }
        System.out.println("RESET");
        app.reset();
        for (int i = 0; i < m * n; i++) {
            int[] flip = app.flip();
            System.out.format("[%s, %s]\n", flip[0], flip[1]);
        }

    }

    private int m;
    private int n;
    private int size;
    private Random random = new Random();
    private Map<Integer, Integer> flipMap = new HashMap<>();
    // private int[] arr;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.size = m * n;
        // this.arr = new int[this.size];
        reset();
    }

    public int[] flip() {
        int rnd = this.random.nextInt(this.size--);
        int index = this.flipMap.getOrDefault(rnd, rnd);
        this.flipMap.put(rnd, this.flipMap.getOrDefault(this.size, this.size));
        return new int[]{index / n, index % n};

        /**
         * Memory Limit Exceeded
         */
        // if (this.size < 0) return null;
        // int rnd = random.nextInt(this.size);
        // int index = arr[rnd];
        // this.arr[rnd] = this.arr[this.size - 1];
        // --this.size;
        // return new int[]{index / n, index % n};
    }

    public void reset() {
        this.size = m * n;
        this.flipMap.clear();

        /**
         * Memory Limit Exceeded
         */
        // this.size = m * n;
        // for (int i = 0; i < this.size; i++) {
        //     this.arr[i] = i;
        // }
    }

}
