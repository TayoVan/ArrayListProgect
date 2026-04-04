public class NullElement extends RuntimeException{

    public NullElement() {
        super("Неможливо додати null-елемент до списку. " +
                "Усі елементи мають бути ненульовими значеннями.");
    }
}

