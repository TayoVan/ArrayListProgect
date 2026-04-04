public class InvalidBlockSize extends RuntimeException {

    private final int blockSize;

    public InvalidBlockSize(int blockSize) {
        super("Невірний розмір блоку: " + blockSize +
                ". Розмір блоку має бути цілим числом, більшим за 0.");
        this.blockSize = blockSize;
    }

    public int getBlockSize() { return blockSize; }
}
