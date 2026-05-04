public class BlockAllocation extends RuntimeException {
    private final int currentCapacity;
    private final int maxCapacity;

    public BlockAllocation(int currentCapacity, int maxCapacity) {
        super("Неможливо виділити новий блок: поточна місткість " +
                currentCapacity + " досягла максимуму " + maxCapacity + " елементів.");
        this.currentCapacity = currentCapacity;
        this.maxCapacity     = maxCapacity;
    }

    public int getCurrentCapacity() { return currentCapacity; }
    public int getMaxCapacity()     { return maxCapacity; }
}
