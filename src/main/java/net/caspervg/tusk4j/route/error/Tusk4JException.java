package net.caspervg.tusk4j.route.error;

public class Tusk4JException extends RuntimeException {

    public Tusk4JException() {
        super();
    }

    public Tusk4JException(String message) {
        super(message);
    }

    public Tusk4JException(String message, Throwable cause) {
        super(message, cause);
    }
}
