/*
题目：Reconstruct Itinerary
算法：Hierholzer（欧拉路径）+ 最小堆
思路：每个机场的目的地放进最小堆，DFS 每次飞字典序最小的，用掉就删
      某个机场没有票可飞时，把它加到行程最前面（后序）

步骤：
1. 建图：graph[from] = 最小堆，存所有目的地
2. dfs("JFK")
3. dfs(airport)：
   - 只要这个机场还有票：poll 出最小的目的地，dfs 过去
   - 票用完了 → route.addFirst(airport)
4. 返回 route

复杂度：时间 O(E log E)，空间 O(E)
易错：加入行程要在 while 循环之后（后序）；用 addFirst，不然要最后反转
*/
class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");
        return route;
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }
        route.addFirst(airport);
    }
}