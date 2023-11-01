// Copyright 2023 Cocky 4 

import java.util.Date;


/**
 * Represents a historical change record.
 */
public class History {

    private Date date;
    private String newChange;

    /**
     * Constructs a history record with a date and description of the change.
     *
     * @param date      The date of the change.
     * @param newChange The description of the new change.
     */
    public History(Date date, String newChange) {
        // Initialize the history record with the provided date and change description
    }

    /**
     * Retrieves the date of the historical change.
     *
     * @return The date of the change.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the description of the historical change.
     *
     * @return The description of the change.
     */
    public String getChange() {
        return newChange;
    }
}
