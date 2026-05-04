public class InvalidIndex extends RuntimeException {
    private final int index;
    private final int size;
    public InvalidIndex(int index, int size) {
        super("Невірний індекс: " + index +
                ". Допустимий діапазон: [0, " + (size - 1) +
                "] (розмір списку: " + size + ").");
        this.index = index;
        this.size  = size;
    }

    public int getIndex() { return index; }
    public int getSize()  { return size; }
}

