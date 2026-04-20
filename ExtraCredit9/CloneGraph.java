// LeetCode #133 - Clone Graph (Medium)
// https://leetcode.com/problems/clone-graph/

/*
Overview: We're given one node of a connected undirected graph and need to return a deep copy. Since the graph has cycles, we use a
HashMap to remember which nodes we've already cloned. For each node, if it's in the map we return the existing clone. Otherwise we
create a clone, store it in the map bedore recursing (so we can avoid infinite loops on cycles), then recurse on its neighbors and attach
them. Every node gets visited exactly once.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {  // Already cloned
            return visited.get(node);
        }

        Node clone = new Node(node.val);  // Create clone with same value, empty neighbors list
        visited.put(node, clone);  // Record mapping before recursing
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}