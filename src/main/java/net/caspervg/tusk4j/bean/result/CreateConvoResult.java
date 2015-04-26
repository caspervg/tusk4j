package net.caspervg.tusk4j.bean.result;

import net.caspervg.tusk4j.bean.input.ConvoInput;

/**
 * Provides the result for a newly created conversation
 * @see net.caspervg.tusk4j.route.ConvoRoute#createConvo(ConvoInput)
 */
public class CreateConvoResult extends ApiResult {

    private String id;

    /**
     * Unique identifier of the new conversation
     * @return Identifier
     */
    public String getId() {
        return id;
    }
}
