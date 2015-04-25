package net.caspervg.tusk4j.route;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.caspervg.tusk4j.bean.result.RegistrationResult;
import net.caspervg.tusk4j.bean.result.SessionResult;
import net.caspervg.tusk4j.bean.input.UserInput;
import net.caspervg.tusk4j.log.Tusk4JLogger;

import java.util.logging.Level;

public class UserRoute {

    private Gson gson = new Gson();

    public RegistrationResult postRegistration(String username, String password, String email) {
        return postRegistration(new UserInput(username, password, email));
    }

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

    public SessionResult getSession(String username, String password) {
        return getSession(new UserInput(username, password));
    }

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
