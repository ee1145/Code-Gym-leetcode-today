/*
题目：Course Schedule II
思路：拓扑排序（BFS / Kahn），出队的顺序就是学习顺序

步骤：
1. 建图：[a, b] 表示 b → a，graph[b] 加 a，indegree[a]++
2. 所有入度为 0 的课入队
3. BFS：
   - 取出一门课，放进 order[index]，index++
   - 它的每门后续课入度 -1，变 0 就入队
4. index == numCourses → 返回 order；否则有环 → 返回空数组

复杂度：时间 O(V+E)，空间 O(V+E)
易错：有环返回 new int[0]，不是 null
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index] = current;
            index++;
            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (index == numCourses) {
            return order;
        }
        return new int[0];
    }
}