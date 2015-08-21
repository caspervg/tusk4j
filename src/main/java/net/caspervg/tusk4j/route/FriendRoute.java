package net.caspervg.tusk4j.route;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.caspervg.tusk4j.auth.Auth;
import net.caspervg.tusk4j.bean.result.ApiResult;
import net.caspervg.tusk4j.bean.result.RegistrationResult;
import net.caspervg.tusk4j.log.Tusk4JLogger;
import net.caspervg.tusk4j.route.error.Tusk4JException;

import java.util.logging.Level;

/**
 * Provides endpoints related to Tusk friendships
 */
public class FriendRoute {

    private Auth auth;
    private Gson gson = new Gson();

    private FriendRoute() {
        // Authentication is required
    }

    /**
     * Creates a new FriendRoute with an authentication
     *
     * @param auth Authentication to use for future requests (cannot be null)
     * @see Auth
     */
    public FriendRoute(Auth auth) {
        if (auth == null) {
            throw new IllegalArgumentException("Authentication cannot be null");
        }

        this.auth = auth;
    }

    /**
     * Post a friend request to the specified user
     *
     * @param friendName Username of the person that should receive the friend request
     * @return ApiResult that may contain errors that were encountered during the execution
     * @throws Tusk4JException if the execution fails
     */
    public ApiResult postFriendRequest(String friendName) {
        try {
            HttpResponse<String> response = Unirest.post(Route.FRIEND_REQUEST.url(friendName))
                    .header("content-type", "application/json")
                    .asString();
            return gson.fromJson(response.getBody(), ApiResult.class);
        } catch (UnirestException e) {
            throw new Tusk4JException("Could not add friend request", e);
        }
    }
}
