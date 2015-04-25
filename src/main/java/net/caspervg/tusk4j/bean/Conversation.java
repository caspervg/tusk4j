package net.caspervg.tusk4j.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Conversation {

    private String title;

    @SerializedName("users")
    private List<String> participants;

    public String getTitle() {
        return title;
    }

    public List<String> getParticipants() {
        return participants;
    }
}
