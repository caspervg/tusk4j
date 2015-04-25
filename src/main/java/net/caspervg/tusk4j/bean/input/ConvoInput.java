package net.caspervg.tusk4j.bean.input;

import java.util.List;

public class ConvoInput {
    List<String> participants;
    String title;

    public ConvoInput(String title, List<String> participants) {
        if (participants == null) {
            throw new IllegalArgumentException("Participants cannot be null");
        }
        if (participants.size() < 1) {
            throw new IllegalArgumentException("Must have at least one participant");
        }
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        this.title = title;
        this.participants = participants;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getParticipants() {
        return participants;
    }
}
