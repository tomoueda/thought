import java.util.Hashtable;

class Graph {

    /** 
     * The graph representation, any node on the graph could reached
     * with a call using the letter of the node as key.
     */
    private Hashtable<Character, Node> graph;

    /**
     * Generates an instance of graph.
     * @param stringNodes - Each element node will be in the following format.
     * XYZ, where X is the starting node, and the Y is the destination node,
     * and Z is the cost to get from X to Y.
     */
    public Graph(String[] stringNodes) {
        for (int i = 0; i < stringNodes.length; i++) {
            String path = stringNodes[i];
            char start = path.charAt(0);
            char end = path.charAt(1);
            int cost = Integer.parseInt(new Character(path.charAt(2)).
                    toString()); 
            Node startNode = null;
            Node endNode = null;
            if (graph.containsKey(start)) {
                startNode = graph.get(start);
            } else {
                startNode = new Node(start);
                graph.put(start, startNode); 
            }
            if (graph.containsKey(end)) {
                endNode = graph.get(end);
            } else {
                endNode = new Node(end);
                graph.put(end, endNode);
            }
            Path neigh = new Path(endNode, cost);
            startNode.neighbors.put(end, neigh);
        }
    }

    public Node getNode(char key) {
        if (graph.containsKey(key)) {
            return graph.get(key);
        }
        return null;
    }
}
