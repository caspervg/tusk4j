package net.caspervg.tusk4j.bean.result;

/**
 * Provides a generic Tusk API result, containing an error and info message
 */
public class ApiResult {

    private String info;
    private String error;

    /**
     * Retrieves the information. Will be null if the request did not complete
     * successfully
     * @return Success information
     */
    public String getInfo() {
        return info;
    }

    /**
     * Retrieves the error that was encountered.
     * <p>
     * Refer to the <a href='https://www.pielambr.be/swagger/'>Tusk Swagger API documentation</a> for
     * more information about possible error messages
     *
     * @return Error information
     */
    public String getError() {
        return error;
    }
}
