/*
题目：Graph Valid Tree
思路：树 = 正好 n-1 条边 + 没有环
      边数不对直接 false；再用并查集逐条加边，两端已连通就是有环

步骤：
1. edges.length != n - 1 → false
2. parent 数组大小 n（节点从 0 开始），每个节点的老大是自己
3. 遍历每条边 [a, b]：
   - rootA == rootB → 已经连通，再连就成环 → false
   - 否则合并：parent[rootA] = rootB
4. 全部加完没成环 → true（n-1 条边 + 无环 ⇒ 一定连通）

复杂度：时间 O(n)，空间 O(n)
易错：节点从 0 开始，数组开 n；别忘了先判断边数
*/
class Solution {
    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);
            if (rootA == rootB) {
                return false;
            }
            parent[rootA] = rootB;
        }
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}