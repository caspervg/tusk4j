package net.caspervg.tusk4j.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Provides some basic information about a conversation
 */
public class BasicConversation {

    @SerializedName("_id")
    private String id;

    private String title;

    @SerializedName("users")
    private List<String> participants;

    /**
     * Retrieves the unique identifier of the conversation
     * @return Identifier of the conversation
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the title of the conversation
     * @return Title of the conversation
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves a list of all participants of the conversation
     * @return Participants of the conversation
     */
    public List<String> getParticipants() {
        return participants;
    }
}
