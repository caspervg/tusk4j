package net.caspervg.tusk4j.bean.input;

import java.util.List;

/**
 * Provides an input object for conversation requests
 * @see net.caspervg.tusk4j.route.ConvoRoute#createConvo(ConvoInput)
 */
public class ConvoInput {

    List<String> participants;
    String title;

    /**
     * Creates a new ConvoInput object
     *
     * @param title Title of the new conversation (cannot be null)
     * @param participants List of participants (cannot be null and must contain at least one user)
     */
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

    /**
     * Retrieves the title
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the list of participants
     * @return Participants
     */
    public List<String> getParticipants() {
        return participants;
    }
}
