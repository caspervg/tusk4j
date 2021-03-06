package net.caspervg.tusk4j.route;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.caspervg.tusk4j.auth.Auth;
import net.caspervg.tusk4j.bean.BasicConversation;
import net.caspervg.tusk4j.bean.input.ConvoInput;
import net.caspervg.tusk4j.bean.result.CreateConvoResult;
import net.caspervg.tusk4j.bean.result.GetConvoResult;
import net.caspervg.tusk4j.log.Tusk4JLogger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;

/**
 * Provides endpoints related to Tusk conversations
 */
public class ConvoRoute {

    private Auth auth;
    private Gson gson = new Gson();

    private ConvoRoute() {
        // Authentication is required
    }

    /**
     * Creates a new ConvoRoute with an authentication
     *
     * @param auth Authentication to use for future requests (cannot be null)
     * @see Auth
     */
    public ConvoRoute(Auth auth) {
        if (auth == null) {
            throw new IllegalArgumentException("Authentication cannot be null");
        }

        this.auth = auth;
    }

    /**
     * Creates a new conversation with given title and list of participants
     *
     * @param title Title of the new conversation
     * @param participants List of participants
     * @return the result returned by the Tusk API
     * @see CreateConvoResult
     * @see ConvoInput
     */
    public CreateConvoResult createConvo(String title, List<String> participants) {
        return createConvo(new ConvoInput(title, participants));
    }

    /**
     * Creates a new conversation with given title and list of participants. Authentication is required.
     *
     * @param convo Conversation information for the new conversation
     * @return the result returned by the Tusk API
     * @see CreateConvoResult
     * @see ConvoInput
     */
    public CreateConvoResult createConvo(ConvoInput convo) {
        try {
            HttpResponse<String> response = Unirest.post(Route.CONVERSATION.url())
                    .header("content-type", "application/json")
                    .basicAuth(auth.getUsername(), auth.getSession())
                    .body(gson.toJson(convo))
                    .asString();
            return gson.fromJson(response.getBody(), CreateConvoResult.class);
        } catch (UnirestException e) {
            Tusk4JLogger.log(Level.SEVERE, "Could not create conversation", e);
            return null;
        }
    }

    /**
     * Retrieves a list of all conversations that the user has access to. Authentication is required.
     *
     * @return list of conversations as returned by the Tusk API
     * @see BasicConversation
     * @see List
     */
    public List<BasicConversation> getConvos() {
        try {
            HttpResponse<String> response = Unirest.get(Route.CONVERSATION.url())
                    .basicAuth(auth.getUsername(), auth.getSession())
                    .asString();
            return gson.fromJson(response.getBody(), new ParameterizedList<BasicConversation>(BasicConversation.class));
        } catch (UnirestException e) {
            Tusk4JLogger.log(Level.SEVERE, "Could not create conversation", e);
            return null;
        }
    }

    /**
     * Retrieves a single conversation. Authentication is required.
     *
     * @return the result returned by the Tusk API
     * @see GetConvoResult
     */
    public GetConvoResult getConvo(String id) {
        try {
            HttpResponse<String> response = Unirest.get(Route.CONVERSATION_ONE.url(id))
                    .basicAuth(auth.getUsername(), auth.getSession())
                    .asString();
            return gson.fromJson(response.getBody(), GetConvoResult.class);
        } catch (UnirestException e) {
            Tusk4JLogger.log(Level.SEVERE, "Could not create conversation", e);
            return null;
        }
    }

    private final class ParameterizedList<X> implements ParameterizedType {
        private Class<?> wrapped;

        public ParameterizedList(Class<X> wrapped) {
            this.wrapped = wrapped;
        }

        public Type[] getActualTypeArguments() {
            return new Type[] {wrapped};
        }

        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }

}
