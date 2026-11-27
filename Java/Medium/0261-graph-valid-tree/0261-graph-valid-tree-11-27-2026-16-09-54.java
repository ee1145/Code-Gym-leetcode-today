/*
题目：Graph Valid Tree
算法：Union-Find（并查集 / DSU）
思路：树 = 正好 n-1 条边 + 无环
      n-1 条边 + 无环 ⇒ 一定连通，不用单独查连通

步骤：
1. 边数 != n-1 → false
2. 初始化 parent：每个节点的老大是自己
3. 逐条加边 [a, b]：
   - 找 a、b 的老大
   - 老大相同 → 已连通，再加就成环 → false
   - 老大不同 → 合并两个老大
4. 全部加完 → true

find(x)：
   不是老大 → 递归找最终老大，顺手把 x 挂到老大下（路径压缩）
   返回老大

复杂度：时间 O(n)，空间 O(n)
易错：节点从 0 开始，数组开 n；合并的是 root，不是 a、b 本身
*/
class Solution {
    // parent 数组（两个方法共享）
    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        // 1. 边数检查
        if (edges.length != n - 1) {
            return false;
        }

        // 2. 初始化 parent
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 3. 逐条加边
        for (int[] edge : edges) {
            // 找两个端点的老大
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);
            // 老大相同 → 成环
            if (rootA == rootB) {
                return false;
            }
            // 合并
            parent[rootA] = rootB;
        }

        // 4. 全部通过
        return true;
    }

    private int find(int x) {
        // 不是老大 → 递归找老大 + 路径压缩
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        // 返回老大
        return parent[x];
    }
}