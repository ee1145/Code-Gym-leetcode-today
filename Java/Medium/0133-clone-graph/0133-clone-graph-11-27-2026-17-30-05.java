/*
题目：Clone Graph
思路：DFS + HashMap<旧节点, 新节点>
      map 既记录"新旧对应关系"，也当作 visited，防止环导致无限递归

步骤（cloneGraph(node)）：
1. node 为 null → 返回 null
2. map 里已经有 node → 克隆过了，直接返回对应的新节点
3. new 一个新节点，先放进 map（一定要在递归之前！）
4. 遍历旧节点的每个邻居：递归克隆，加进新节点的 neighbors
5. 返回新节点

复杂度：时间 O(V+E)，空间 O(V)
易错：放进 map 必须在递归邻居之前，否则有环时无限递归
*/
class Solution {
    private Map<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }

        Node copy = new Node(node.val);
        cloned.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}