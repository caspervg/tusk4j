package net.caspervg.tusk4j.bean.input;

/**
 * Provides an input object for user requests
 * @see net.caspervg.tusk4j.route.UserRoute#getSession(UserInput)
 * @see net.caspervg.tusk4j.route.UserRoute#postRegistration(UserInput)
 */

public class UserInput {

    private String username;
    private String password;
    private String email;

    /**
     * Creates a new user input object for registration requests
     *
     * @param username Username of the new user
     * @param password Password of the new user
     * @param email E-mail address of the new user
     * @see net.caspervg.tusk4j.route.UserRoute#postRegistration(UserInput)
     */
    public UserInput(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Creates a new user input object for session requests
     *
     * @param username Username of the user
     * @param password Password of the user
     * @see net.caspervg.tusk4j.route.UserRoute#getSession(UserInput)
     */
    public UserInput(String username, String password) {
        this(username, password, null);
    }

    /**
     * Retrieves the username
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the e-mail address
     * @return E-mail address
     */
    public String getEmail() {
        return email;
    }
}
