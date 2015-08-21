package net.caspervg.tusk4j.bean.result;

import net.caspervg.tusk4j.auth.Auth;
import net.caspervg.tusk4j.bean.input.UserInput;

/**
 * Provides the result for a requested session
 * @see net.caspervg.tusk4j.route.UserRoute#getSession(UserInput)
 */
public class SessionResult extends ApiResult {

    private String session;

    /**
     * Retrieves the requested session
     * @return Session identifier
     */
    public String getSession() {
        return session;
    }

    /**
     * Converts the session result to an authentication token.
     *
     * @param username Name of the user that the session belongs to
     * @return Authentication token for the session
     * @see Auth
     */
    public Auth asAuth(String username) {
        return new Auth(username, session);
    }
}
