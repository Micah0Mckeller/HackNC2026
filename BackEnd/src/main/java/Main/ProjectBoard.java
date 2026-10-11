package Main;

import java.time.LocalDateTime;
import java.util.*;

public class ProjectBoard {
    private final String projectName;
    private final UUID projectUUID;
    private final String location;
    private final LocalDateTime scheduledTime;
    private int RSVPs;

    private String description;


    /**
     * initializes board class data
     * @param projectName the name of the board
     */
    public ProjectBoard(
            String projectName,
            String description,
            String location,
            LocalDateTime scheduledTime)
    {
        this.projectUUID = UUID.randomUUID(); // creates a new uuid and adds it to the class.
        this.projectName = projectName;
        this.description = description;
        this.location = location;
        this.scheduledTime = scheduledTime;
        RSVPs = 0;
    }

    /**
     * project name
     * @return the name of the project
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * project uuid
     * @return the uuid of the project.
     */
    public UUID getProjectUUID(){
        return projectUUID;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    /**
     * adds an administrator to the board
      * @return returns if the admin was added or not
     */

    public void setProjectDescription(String newDescription)
    {
        description = newDescription;
    }

    public void RSVP()
    {
        RSVPs++;
    }

    public int getRSVPs() {
        return RSVPs;
    }
}
