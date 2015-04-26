package net.caspervg.tusk4j.auth;

/**
 * Provides authorization for Tusk API requests that require
 * HTTP Basic authentication based on a username and session
 */
public class Auth {

    private String username;
    private String session;

    /**
     * Creates a new Auth object with given username and password
     *
     * @param username Username for the authentication (cannot be null)
     * @param session Session for the authentication (cannot be null).
     * @see net.caspervg.tusk4j.route.UserRoute#getSession(String, String)
     * UserRoute#getSession to retrieve a session
     */
    public Auth(String username, String session) {
        if (username == null || session == null) {
            throw new IllegalArgumentException("Username and session cannot be null");
        }

        this.username = username;
        this.session = session;
    }

    /**
     * Retrieves the username
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the session
     * @return Session
     */
    public String getSession() {
        return session;
    }
}
