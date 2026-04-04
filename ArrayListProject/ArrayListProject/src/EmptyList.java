public class EmptyList extends RuntimeException {

    private final String operation;

    public EmptyList(String operation) {
        super("Неможливо виконати операцію \"" + operation +
                "\": список порожній.");
        this.operation = operation;
    }

    public String getOperation() { return operation; }
}
