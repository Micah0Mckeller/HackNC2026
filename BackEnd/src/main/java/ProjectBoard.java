package BackEnd.src.main.java;

import java.util.HashSet;
import java.util.UUID;

public class ProjectBoard {
    private final String projectName;
    private final UUID projectUUID;
    private HashSet<String> Administrators = new HashSet<String>();
    /**
     * initializes board class data
     * @param projectName the name of the board
     */
    public ProjectBoard(String projectName, String administrator)
    {
        this.projectUUID = UUID.randomUUID(); // creates a new uuid and adds it to the class.
        this.projectName = projectName;

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
}
