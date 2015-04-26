package net.caspervg.tusk4j.route;

public enum Route {

    REGISTER("/user"),
    SESSION("/session"),
    CONVERSATION("/conversation"),
    CONVERSATION_ONE("/conversation/%s");

    private static final String base = "https://www.pielambr.be/tusk";
    private String url;

    /**
     * Creates a new Route with given url
     *
     * @param url Url for the route
     */
    Route(String url) {
        this.url = url;
    }

    /**
     * Returns the url for the Route
     *
     * @return Url of the Route
     */
    @Override
    public String toString() {
        return url();
    }

    /**
     * Returns the url for the Route
     *
     * @return Url of the Route
     */
    public String url() {
        return base + url;
    }

    /**
     * Returns the url for the Route, with an identifier inserted
     *
     * @param number Identifier to insert
     * @return Url of the Route
     */
    public String url(String number) {
        return String.format(url(), number);
    }

}
