import java.util.HashSet;
import java.util.Stack;
import java.util.Map.Entry;

class GraphTraverser {

    private Graph graph;

    public GraphTraverser(Graph g) {
        graph = g;
    }

    public int getDistanceOfRoute(String path) {
        if (path == null) {
            return 0;
        }
        int dist = 0; 
        Node node = graph.getNode(path.charAt(0));
        for (int i = 1; i < path.length(); i++) { 
            char next = path.charAt(i);
            if (node.neighbors.containsKey(next)) {
                Path nextpath = node.neighbors.get(next);             
                node = nextpath.dest;
                dist += nextpath.dist;
            } else {
                return -1;
            }
        }
        return dist;
    }

    public int getNumRouteMax(String path, int max) {
        int numways = 0;
        char start = path.charAt(0);
        char end = path.charAt(1);
        HashSet<Node> seen = new HashSet<Node>();
        Stack<Node> fringe = new Stack<Node>();
        Node startNode = graph.getNode(start);
        startNode.depth = 0;
        if (startNode != null) {
            while (!fringe.empty()) {
                Node node = fringe.pop();
                int newdepth = node.depth + 1;
                for (Entry<Character, Path> neighbor: node.neighbors.entrySet()) {
                    Node neighnode = neighbor.getValue().dest;
                    if (neighnode.value == end && newdepth <= max) {
                        numways++;
                    } 
                    if (!seen.contains(neighnode)) {
                        neighnode.depth = newdepth;
                        fringe.push(neighnode);
                        seen.add(neighnode);
                    }
                }
            }
        }
        return numways;
    }

    public int getNumRouteExact(String path, int exact) {
    }

}
