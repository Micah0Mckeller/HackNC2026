package Main;

import java.time.LocalDateTime;

/** Request body used to create a project board. */
public class ProjectRequest {
    private String projectName;
    private String description;
    private String location;
    private LocalDateTime scheduledTime;

    public ProjectRequest() {
        // Required by Jackson for JSON request deserialization.
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
