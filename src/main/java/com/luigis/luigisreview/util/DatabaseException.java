package com.luigis.luigisreview.util;

public class DatabaseException extends RuntimeException {

    /**
     * The serial version ID of the Database Exception
     */
    private static final long serialVersionUID = 1L;

    /**
     * An instance of the custom unchecked exception: DatabaseException
     * 
     * @param e the original throwable exception
     */
    public DatabaseException(Throwable e) {
        super(e);
    }

}
