package net.caspervg.tusk4j.auth;

public class Auth {
    private String username;
    private String session;

    public Auth(String username, String session) {
        if (username == null || session == null) {
            throw new IllegalArgumentException("Username and session cannot be null");
        }

        this.username = username;
        this.session = session;
    }

    public String getUsername() {
        return username;
    }

    public String getSession() {
        return session;
    }
}
