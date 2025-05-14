package org.json;

/**
 * JSONException is thrown by the JSON classes when things go wrong.
 */
public class JSONException extends Exception {
    private static final long serialVersionUID = 0;

    /**
     * Constructs a JSONException with a message.
     *
     * @param message Detail about the reason for the exception.
     */
    public JSONException(String message) {
        super(message);
    }

    /**
     * Constructs a JSONException with a message and cause.
     *
     * @param message Detail about the reason for the exception.
     * @param cause The cause of the exception.
     */
    public JSONException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new JSONException with the specified cause.
     *
     * @param cause The cause of the exception.
     */
    public JSONException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
}