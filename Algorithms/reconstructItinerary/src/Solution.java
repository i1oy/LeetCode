import java.util.*;

/**
 * 在处理单向节点的时候（例如：[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]），
 * 遇到困难，直接看了题解，采用了深度优先搜索算法来处理。
 */

public class Solution {
    Map<String, Queue<String>> departure2Arrivals = new HashMap<>();
    List<String> ans = new LinkedList<>();

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList(new String[]{"JFK", "KUL"}));
        tickets.add(Arrays.asList(new String[]{"JFK", "NRT"}));
        tickets.add(Arrays.asList(new String[]{"NRT", "JFK"}));

        System.out.println(Arrays.toString((new SolutionOfficial()).findItinerary(tickets).toArray()));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> records = new HashMap<>();
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            if (!records.containsKey(departure)) {
                records.put(departure, new ArrayList<String>());
            }

            records.get(departure).add(arrival);
        }

        for (String depart : records.keySet()) {
            Collections.sort(records.get(depart));
        }

        for (String departure : records.keySet()) {
            departure2Arrivals.put(departure, new ArrayDeque());
            for (String arrival : records.get(departure)) {
                departure2Arrivals.get(departure).offer(arrival);
            }
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String airport) {
        while (departure2Arrivals.containsKey(airport) && departure2Arrivals.get(airport).size() > 0) {
            String tmp = departure2Arrivals.get(airport).poll();
            dfs(tmp);
        }
        ans.add(airport);
    }

}
