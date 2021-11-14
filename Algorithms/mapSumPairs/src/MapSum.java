import java.util.HashMap;
import java.util.Set;

class MapSum {
    private HashMap<String, Integer> kv = new HashMap<>();
    public MapSum() {

    }

    public void insert(String key, int val) {
        kv.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        Set<String> strings = kv.keySet();
        for (String str : strings) {
            if (str.startsWith(prefix)) {
                res += kv.get(str);
            }
        }
        return res;
    }
}
