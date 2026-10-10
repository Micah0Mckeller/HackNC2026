package BackEnd.src.main.java.com.example.demo;

import java.sql.Time;
import java.time.ZonedDateTime;

import java.util.*;

public class ProjectBoard {
    private final String projectName;
    private final UUID projectUUID;
    private final HashSet<String> Administrators = new HashSet<String>();

    private String Description;
    private HashMap<String,ProjectEvent> events = new HashMap<String, ProjectEvent>();


    /**
     * initializes board class data
     * @param projectName the name of the board
     */
    public ProjectBoard(String projectName, String administrator, String description)
    {
        this.projectUUID = UUID.randomUUID(); // creates a new uuid and adds it to the class.
        this.projectName = projectName;

        this.Description = description;
        this.Administrators.add(administrator);
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


    /**
     * adds an administrator to the board
     * @param adminName the username of the admin doing this operation
     * @param username the username of the new admin
     * @return returns if the admin was added or not
     */
    public boolean addAdministrator(String adminName, String username){
        if (canChangeProjectData(adminName))
        {
            Administrators.add(username);
            return true;

        }
        return false;
    }

    /**
     * returns a hashset containing the administrator usernames
     * @return a hashset containing the administrator usernames
     */
    public HashSet<String> getAdministrators()
    {
        return Administrators;
    }

    public void setProjectDescription(String newDescription)
    {
        Description  = newDescription;
    }

    /**
     * creates a new event under this board.
     * @param username the user who is creating the event
     * @param eventName the name of the event
     * @param eventDescription what is happening at the event
     * @param timestamp the start time of the event.
     */
    public void newEvent(String username, String eventName, String eventDescription, ZonedDateTime timestamp)
    {
        if (canChangeProjectData(username)) {
            ProjectEvent newEvent = new ProjectEvent(eventName, eventDescription, timestamp);
            events.put(eventName, newEvent);
        }
    }

    /**
     * checks if a user can edit a project
     * @param username the username of the user attempting to edit
     * @return true if an admin, false otherwise.
     */
    private boolean canChangeProjectData(String username){
        return Objects.equals(username, getProjectName());
    }
}
