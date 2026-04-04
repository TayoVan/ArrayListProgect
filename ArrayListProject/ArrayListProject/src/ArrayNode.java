public class ArrayNode {
    Object[] data;
    int count;
    ArrayNode next;
    ArrayNode prev;

    public ArrayNode(int capacity) {
        this.data = new Object[capacity];
        this.count = 0;
        this.next = null;
        this.prev = null;
    }
    public ArrayNode() {
    }
}
