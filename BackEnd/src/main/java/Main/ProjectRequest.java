package Main;

public class ProjectRequest {
    private String projectName;
    private double timeTillCompletion;
    private String description;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getTimeTillCompletion() {
        return timeTillCompletion;
    }

    public void setTimeTillCompletion(double timeTillCompletion) {
        this.timeTillCompletion = timeTillCompletion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
