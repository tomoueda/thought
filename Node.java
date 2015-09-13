import java.util.Hashtable;

class Node {
    public char value;
    public Hashtable<Character, Path> neighbors;
    public int depth;

    /**
     * Generates a new instance of Node.
     * @param value - the key of the node. 
     */
    public Node(char value) {
        this.value = value;
        this.neighbors = new Hashtable<Character, Path>();
    }
}
