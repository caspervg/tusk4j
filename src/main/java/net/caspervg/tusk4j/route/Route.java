package net.caspervg.tusk4j.route;

public enum Route {

    REGISTER("/user"),
    SESSION("/session"),
    CONVERSATION("/conversation"),
    CONVERSATION_ONE("/conversation/%s");

    private static final String base = "https://www.pielambr.be/tusk";
    private String url;

    Route(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url();
    }

    public String url() {
        return base + url;
    }

    public String url(String number) {
        return String.format(url(), number);
    }

}
