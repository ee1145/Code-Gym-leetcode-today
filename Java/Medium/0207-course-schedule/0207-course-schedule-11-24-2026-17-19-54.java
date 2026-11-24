/*
题目：Course Schedule
思路：判断有向图有没有环 → 拓扑排序（BFS / Kahn 算法）
      入度为 0 的课可以直接学，学完后它的后续课入度 -1

步骤：
1. 建图：[a, b] 表示 b → a（先 b 后 a）
   graph[b] 存 b 的后续课，indegree[a]++
2. 所有入度为 0 的课入队
3. BFS：
   - 取出一门课，taken++
   - 它的每门后续课入度 -1
   - 入度变 0 → 入队
4. taken == numCourses → true，否则有环 → false

复杂度：时间 O(V+E)，空间 O(V+E)
易错：边的方向是 b → a，不要反了
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int taken = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            taken++;
            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return taken == numCourses;
    }
}