import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Integer> kv = new HashMap<>();
        kv.put("Hello", 1);
        kv.put("Hello", 10);
        System.out.println(kv.get("Hello"));

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
