package net.caspervg.tusk4j.bean.result;

import net.caspervg.tusk4j.bean.Conversation;

/**
 * Provides the result for a requested conversation
 * @see net.caspervg.tusk4j.route.ConvoRoute#getConvo(String)
 */
public class GetConvoResult extends ApiResult {

    private Conversation conversation;

    /**
     * Retrieves the requested conversation
     * @return Conversation
     */
    public Conversation getConversation() {
        return conversation;
    }

}
