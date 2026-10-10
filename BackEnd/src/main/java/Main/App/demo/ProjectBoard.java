package BackEnd.src.main.java.Main.App.demo;

import java.util.UUID;

public class ProjectBoard {
    private final String projectName;
    private final UUID projectUUID;

    /**
     * initializes board class data
     * @param projectName the name of the board
     */
    public ProjectBoard(String projectName)
    {
        this.projectUUID = UUID.randomUUID(); // creates a new uuid and adds it to the class.
        this.projectName = projectName;
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
