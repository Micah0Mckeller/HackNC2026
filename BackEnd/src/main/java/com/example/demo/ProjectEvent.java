package BackEnd.src.main.java.com.example.demo;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.HashSet;

public class ProjectEvent {
    String projectName;
    String description;
    ZonedDateTime timestamp; //when the event will occur.

    private final HashSet<String> rsvps = new HashSet<String>();

    public ProjectEvent(String projectName, String description, ZonedDateTime timestamp)
    {
        this.projectName = projectName;
        this.description = description;
        this.timestamp = timestamp;
    }

    /**
     * gets the name of the event
     * @return return the event name
     */
    public String getEventName() {
        return projectName;
    }

    /**
     * Renames the event
     * @param newName the new name of the event.
     */
    public void setEventName(String newName)
    {
        projectName = newName;
    }


    /**
     * gets the description of the event
     * @return return the event description
     */
    public String getEventDescription() {
        return description;
    }

    /**
     * sets a new description
     * @param newDescription the new description
     */
    public void setEventDescription(String newDescription)
    {
        description = newDescription;
    }

    public ZonedDateTime getEventTimestamp(){
        return timestamp;
    }

    public void setEventTimestamp(ZonedDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public void addRSVP(String username)
    {
        rsvps.add(username);
    }

    public HashSet<String> getRsvps()
    {
        return rsvps;
    }
}
