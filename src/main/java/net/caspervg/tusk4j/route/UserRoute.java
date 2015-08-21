package net.caspervg.tusk4j.route;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.caspervg.tusk4j.bean.input.UserInput;
import net.caspervg.tusk4j.bean.result.RegistrationResult;
import net.caspervg.tusk4j.bean.result.SessionResult;
import net.caspervg.tusk4j.log.Tusk4JLogger;

import java.util.logging.Level;

/**
 * Provides endpoints related to Tusk users
 */
public class UserRoute {

    private Gson gson = new Gson();

    /**
     * Creates a new user with given username, password and e-mail address
     *
     * @param username Username of the new user
     * @param password Password of the new user
     * @param email E-mail address of the new user
     * @return the result returned by the Tusk API
     * @see RegistrationResult
     * @see UserInput
     */
    public RegistrationResult postRegistration(String username, String password, String email) {
        return postRegistration(new UserInput(username, password, email));
    }

    /**
     * Creates a new user with given username, password and e-mail address
     *
     * @param user Information about the new user
     * @return the result returned by the Tusk API
     * @see RegistrationResult
     * @see UserInput
     * @see UserInput#UserInput(String, String, String)
     */
    public RegistrationResult postRegistration(UserInput user) {
        try {
            HttpResponse<String> response = Unirest.post(Route.REGISTER.url())
                    .header("content-type", "application/json")
                    .body(gson.toJson(user))
                    .asString();
            return gson.fromJson(response.getBody(), RegistrationResult.class);
        } catch (UnirestException e) {
            Tusk4JLogger.log(Level.SEVERE, "Could not register user", e);
            return null;
        }
    }

    /**
     * Creates a new session for a user with given username and password
     *
     * @param username Username of the user
     * @param password Password of the user
     * @return the result returned by the Tusk API
     * @see SessionResult
     * @see UserInput
     */
    public SessionResult getSession(String username, String password) {
        return getSession(new UserInput(username, password));
    }

    /**
     * Creates a new session for a user with given username and password
     *
     * @param user Information about the user requesting a session
     * @return the result returned by the Tusk API
     * @see SessionResult
     * @see UserInput#UserInput(String, String)
     */
    public SessionResult getSession(UserInput user) {
        try {
            HttpResponse<String> response = Unirest.post(Route.SESSION.url())
                    .header("content-type", "application/json")
                    .body(gson.toJson(user))
                    .asString();
            return gson.fromJson(response.getBody(), SessionResult.class);
        } catch (UnirestException e) {
            Tusk4JLogger.log(Level.SEVERE, "Could not register user", e);
            return null;
        }
    }
}
