package net.caspervg.tusk4j.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Provides information about a conversation
 */
public class Conversation {

    private String title;

    @SerializedName("users")
    private List<String> participants;

    /**
     * Retrieves the title of the conversation
     * @return Title of the conversation
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves a list of all active (enabled) participants of the conversation
     * @return Participants of the conversation
     */
    public List<String> getParticipants() {
        return participants;
    }
}
