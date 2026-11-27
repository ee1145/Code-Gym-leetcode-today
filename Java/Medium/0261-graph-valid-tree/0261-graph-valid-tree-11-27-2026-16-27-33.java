class Solution {
    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        //first check:
        if (edges.length != n - 1) {
            return false;
        }

        //create parent connect:
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

    private int find(int node) {
        //two situations here
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
}