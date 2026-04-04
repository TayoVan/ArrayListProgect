public class MyArrayList extends ArrayNode {
    private ArrayNode head;
    private ArrayNode tail;
    private final int BLOCK_SIZE = 5;
    private int totalSize;
    private final int MAX_CAPACITY = 20;

    public MyArrayList() {
        super();
        if (BLOCK_SIZE <= 0) {
            throw new InvalidBlockSize(BLOCK_SIZE);
        }
        this.head = new ArrayNode(BLOCK_SIZE);
        this.tail = head;
        this.totalSize = 0;
    }

    public int size() {
        return totalSize;
    }

    public int capacity() {
        int blocksCount = 0;
        ArrayNode current = head;
        while (current != null) {
            blocksCount++;
            current = current.next;
        }
        return blocksCount * BLOCK_SIZE;
    }

    public void add(Object value) {
        if (value == null) {
            throw new NullElement();
        }
        if (totalSize >= MAX_CAPACITY) {
            throw new BlockAllocation(totalSize, MAX_CAPACITY);
        }
        if (tail.count == BLOCK_SIZE) {
            ArrayNode newNode = new ArrayNode(BLOCK_SIZE);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        tail.data[tail.count] = value;
        tail.count++;
        totalSize++;
    }

    public void addAt(int index, Object value) {
        if (totalSize == 0 && index != 0) {
            throw new EmptyList("addAt");
        }
        if (index < 0 || index > totalSize) {
            throw new InvalidIndex(index, totalSize);
        }
        if (index == totalSize) {
            add(value);
            return;
        }
        add("temp");
        for (int i = totalSize - 1; i > index; i--) {
            set(i, get(i - 1));
        }
        set(index, value);
    }
        public Object get(int index) {
            if (totalSize == 0) {
                throw new EmptyList("get");
            }

            if (index < 0 || index >= totalSize) {
                throw new InvalidIndex(index, totalSize);
            }

            ArrayNode current = head;
            int relativeIndex = index;

            while (current != null && relativeIndex >= current.count) {
                relativeIndex -= current.count;
                current = current.next;
            }

            if (current == null) {
                throw new InvalidIndex(index, totalSize);
            }

            return current.data[relativeIndex];
    }
    public void set(int index, Object value) {
        if (totalSize == 0) {
            throw new EmptyList("set");
        }

        if (index < 0 || index >= totalSize) {
            throw new InvalidIndex(index, totalSize);
        }
        ArrayNode current = head;
        int relativeIndex = index;

        while (current != null && relativeIndex >= current.count) {
            relativeIndex -= current.count;
            current = current.next;
        }

        if (current == null) {
            throw new InvalidIndex(index, totalSize);
        }

        current.data[relativeIndex] = value;
    }
    public void remove(int index) {
        if (totalSize == 0) {
            throw new EmptyList("remove");
        }
        if (index < 0 || index >= totalSize) {
            throw new InvalidIndex(index, totalSize);
        }
        for (int i = index; i < totalSize - 1; i++) {
            set(i, get(i + 1));
        }
        tail.count--;
        totalSize--;
        if (tail.count == 0 && tail != head) {
            tail = tail.prev;
            tail.next = null;
        }
    }
    public void clear() {
        head = new ArrayNode(BLOCK_SIZE);
        tail = head;
        totalSize = 0;
    }
    public void print() {
        System.out.print("List: [ ");
        for (int i = 0; i < totalSize; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println("] (Size: " + size() + ", Capacity: " + capacity() + ")");
    }
}